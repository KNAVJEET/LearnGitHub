package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunction extends TestBase{
	
	
	public static void getClickText(String text,String name)
	{
	driver.findElement(By.xpath(text.replace("%value%", name))).click();
	}
	
	
	public static void waitWhileLoop(By xPath)
	{
		List<WebElement> loop=driver.findElements(xPath);
		
		System.out.println(loop.size());
		
		while(loop.size()==0)
		{
			loop=driver.findElements(xPath);
		}
		
		System.out.println("While Loop Execution Completed");
	}
	
	
	 public static void ajaxLoader(By xPath)
	 {
		 List<WebElement> loader=driver.findElements(xPath);
		 
		 System.out.println(loader.size());
		 
		 while(loader.size()>0)
		 {
			 System.out.println("Inside AjaxLoader");
			 loader=driver.findElements(xPath);
		 }
		 
		 System.out.println("Ajax Load Completed");
	 }
	
	
	public static boolean explicitWait(By xPath,long seconds )
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOfElementLocated(xPath));
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Element is not Visible even after " + seconds + " seconds");
			return false;
		}
	}
	
	
	public static void isElementDisplayed(By xPath,long seconds)
	{
       
		List<WebElement> loop=driver.findElements(xPath);
		
		System.out.println(loop.size());
		
		while(loop.size()==0)
		{
			loop=driver.findElements(xPath);
			
			explicitWait(xPath,seconds);
		}
		
		System.out.println("While Loop Execution Completed");
	}
	
	
	public static void clickMethodJavaScriptExecutor(WebElement element)
	{
		// Create a reference
        JavascriptExecutor js = (JavascriptExecutor)driver;
       
        // Call the JavascriptExecutor methods
        js.executeScript("arguments[0].click();", element);
	}
	
	
	public static void selectCheckBox(By xPath) throws InterruptedException
	{
		WebElement element=driver.findElement(xPath);
		
		element.click();
		
		Thread.sleep(5000);
		
		String checkBoxStatus=driver.findElement(xPath).getAttribute("class");
		
		System.out.println(checkBoxStatus);
		
		if(checkBoxStatus.contains("fill"))
		{
			System.out.println("CheckBox is checked Successfully");
		}
		else
		{
			System.out.println("CheckBox is still not checked");
		}
	}
	
	
	public static void unselectCheckBox(By xPath) throws InterruptedException
	{
		WebElement element=driver.findElement(xPath);
		
		element.click();
		
		Thread.sleep(5000);
		
		String checkBoxStatus=driver.findElement(xPath).getAttribute("class");
		
		System.out.println(checkBoxStatus);
		
		if(checkBoxStatus.contains("static"))
		{
			System.out.println("CheckBox is unchecked Successfully");
		}
		else
		{
			System.out.println("CheckBox is still not unchecked");
		}
	}
	
	
	public static String warningPopup(By xPath)
	{
		String warningText=driver.findElement(xPath).getText();
		
		return warningText;	
	}
	
	
	public static void buttonClick(By xPath)
	{
		driver.findElement(xPath).click();
	}

}
