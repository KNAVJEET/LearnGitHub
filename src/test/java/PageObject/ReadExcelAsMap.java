package PageObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelAsMap {
	
	public static XSSFWorkbook workbook=null;

    public static XSSFSheet sheet=null;
	
	public static List<LinkedHashMap<String,String>> getExcelDtataAsListOfMap() throws IOException
	{
		List<LinkedHashMap<String,String>> dataFromExcel=new ArrayList<>();
		
		//WorkbookFactory.create(new File("C:\\Users\\navze\\Documents\\Airline.xlsx"));
		
		workbook=new XSSFWorkbook("C:\\Users\\navze\\Documents\\QA Credential.xlsx");
		
		sheet=workbook.getSheetAt(0);
		
		
		//Total Number of Rows
		int rowCount=sheet.getPhysicalNumberOfRows();
		
		System.out.println(rowCount);
		
		List<String> allKeys=new ArrayList<>();
		
		DataFormatter dataFormatter=new DataFormatter();
		
		LinkedHashMap<String,String> mapData;
		
		for(int i=0;i<rowCount;i++)
		{
			mapData=new LinkedHashMap<>();
			
			if(i==0)
			{
			int totalCols=sheet.getRow(0).getPhysicalNumberOfCells();
			
			for(int j=0;j<totalCols;j++)
			{
				allKeys.add(sheet.getRow(0).getCell(j).getStringCellValue());
			}
			}
			else
			{
				int totalCols=sheet.getRow(i).getPhysicalNumberOfCells();
				
				for(int j=0;j<totalCols;j++)
				{
					//allKeys.add(sheet.getRow(i).getCell(j).getStringCellValue());
					
					String cellvalue=dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));
					
					mapData.put(allKeys.get(j), cellvalue);
				}
				
				dataFromExcel.add(mapData);
			}
		}
		
		
		return dataFromExcel;
		
	}
}
