package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatabaseSelectionPage {
	
	private WebDriver driver;
	
	
    public DatabaseSelectionPage(WebDriver driver)
    {
    	this.driver=driver;
    }
    
    By button_selectdatabase=By.xpath("//div[contains(@class,'DatabasePanel_databsePanelOpenButton')]");
    
    By page_content=By.xpath("//ul[@id='ListDividerUl']");
    
    By button_ok=By.xpath("//span[@id='S8_btnOK']");
    
    By checkbox_mastercheckbox=By.xpath("//div[@id='S8_CheckUncheckAll_Database']");
    
    By tab_database=By.xpath("//div[@class='S8-select-dbselection-tab']//span[contains(@class,'S8-gen-select-database-tab')]");
    
    String jurisdictionHeader1="//div[@data-id='DBSGroupCHK' and @data-alt='%value%']";
    
    String jurisdictionName1="//span[text()='%value%']/parent::span/preceding-sibling::div";
    
  
    
    
    public void clickSelectDatabase()
    {
    	driver.findElement(button_selectdatabase).click();
    }
    
    public void databasePageLoaded()
    {
    	List<WebElement> content=driver.findElements(page_content);
    	
    	System.out.println(content.size());
    	
    	while(content.size()==0)
    	{
    		content=driver.findElements(page_content);
    	}
    	
    	System.out.println("Page Loaded Successfully");
    }
    
    
    public void selectDatabaseTab(String tabname)
    {
    	List<WebElement> databaseTab=driver.findElements(tab_database);
    	
    	System.out.println(databaseTab.size());
    	
    	for(int i=0;i<databaseTab.size();i++)
    	{
    		System.out.println(databaseTab.get(i).getText());
    		
    		if(databaseTab.get(i).getText().contains(tabname))
    		{
    			databaseTab.get(i).click();
    			
    			break;
    		}
    	}
    }
    
    
    public void clickOKButton()
    {
    	driver.findElement(button_ok).click();
    }
    
    
    public void selectJurisdiction()
    {
    	driver.findElement(By.xpath("//span[contains(text(),'Pharma In-Use')]/parent::div/div[1]/div")).click();
    }
    
    
    public void selectJurisdictionHeaderExpand(String JurisdictionHeader)
    {
    	driver.findElement(By.xpath("//span[contains(text(),'"+JurisdictionHeader+"')]/parent::div/div[1]/div")).click();
    }
    
    
    public void selectJurisdictionHeader(String jurisdictionHeader)
    {
    	//driver.findElement(By.xpath("//div[@data-id='DBSGroupCHK' and @data-alt='"+jurisdictionHeader1+"']")).click();
    	
    	CommonFunction.getClickText(jurisdictionHeader1, jurisdictionHeader);
    }
    
    
    public void selectJurisdictionByName(String jurisdictionName)
    {
    	//driver.findElement(By.xpath("//span[text()='"+jurisdictionName+"']/parent::span/preceding-sibling::div")).click();
    	
    	CommonFunction.getClickText(jurisdictionName1, jurisdictionName);
    }
    
    
    public void selectMasterCheckBox() throws InterruptedException
    {
    	CommonFunction.selectCheckBox(checkbox_mastercheckbox);
    }
    
    public void unselectMasterCheckBox() throws InterruptedException
    {
    	CommonFunction.unselectCheckBox(checkbox_mastercheckbox);
    }

}
