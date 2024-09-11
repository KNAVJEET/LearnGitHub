package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utilities.ReadPropertyFile;

public class SingletonDriver {
	
	private static WebDriver driver=null;
	
	private static ReadPropertyFile readPropertyFile=null;
	
	private SingletonDriver()
	{
		
	}
	
	
	public static WebDriver getDriverInstnce()
	{
		if(driver==null)
		{
			ChromeOptions co=new ChromeOptions();

			co.setBrowserVersion("119");

			driver=new ChromeDriver(co);
		}
		else
		{
			System.out.println("Driver already Intialized");
		}
		
		return driver;
	}
	
	public static ReadPropertyFile getPropertyFileInstnce()
	{
		if(readPropertyFile==null)
		{
			readPropertyFile=new ReadPropertyFile();
		}
		
		
		return readPropertyFile;
	}

}
