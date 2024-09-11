package PageObject;

import org.openqa.selenium.WebDriver;

import utilities.ReadPropertyFile;

public class TestBase {
	
	protected static WebDriver driver;
	
	protected static ReadPropertyFile readPropertyFile;
	
	protected TestBase()
	{
		driver=SingletonDriver.getDriverInstnce();
		
		readPropertyFile=SingletonDriver.getPropertyFileInstnce();
		
		driver.manage().window().maximize();
		
		System.out.println(readPropertyFile.getValue("URL"));
		
		driver.get(readPropertyFile.getValue("URL"));
			
		
	}

}
