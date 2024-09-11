package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import constants.FrameworkConstant;

public class ReadPropertyFile {
	
	Properties properties;
	
	String path=FrameworkConstant.getPropertyfilepath();
	
	public ReadPropertyFile()
	{
		properties=new Properties();
		
		try {
			FileInputStream fis=new FileInputStream(path);
			try {
				properties.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getValue(String key)
	{
		String value=properties.getProperty(key);
		
		if(key!=null)
		{
			return value;
		}
		else
		{
			throw new RuntimeException(key + " is not specified in confilg file");
		}
	}

}
