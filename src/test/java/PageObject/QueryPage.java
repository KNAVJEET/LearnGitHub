package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QueryPage {
	
	private WebDriver driver;
	
	public QueryPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By button_submitquery=By.xpath("//span[@title='Submit Query']");
	
	By block_result=By.xpath("//ul[contains(@class,'Result_ulRes')]");
	
	By button_clearquery=By.xpath("//span[@title='Clear Query Fields']");
	
	By button_vantage=By.xpath("//button[contains(@class,'grayBtnVantage')]");
	
	By button_standard=By.xpath("//span[text()='Standard Mode']");
	
	By button_combinequery=By.xpath("//span[text()='Combine']");
	
	By popup_warning=By.xpath("//div[contains(@class,'ModalPopup_modalbody')]");
	
	By button_warningok=By.xpath("//button[@title='OK']");
	
	By viewDrodown=By.xpath("//div[contains(@class,'ViewPopup_viewDv')]");
	
	By querypage_costpopup=By.xpath("//div[@id='CV4_TransAlertMessageWithDoNotShow']");
	
	//WebElement submitQuery=driver.findElement(button_submitquery);
	
	
	public boolean queryPageLoaded()
	{
		boolean status=CommonFunction.explicitWait(button_submitquery, 60);
		
		return status;
	}
	
	
	public void selectFirstDropDown(int dropDownNumber,String dropDownOption)
	{
		List<WebElement> dropDown=driver.findElements(By.xpath("(//select[contains(@class,'SearchFieldRow_SFSelect')])["+dropDownNumber+"]//option"));
		
		System.out.println(dropDown.size());
		
		for(int i=0;i<dropDown.size();i++)
		{
			System.out.println(dropDown.get(i).getText());
			
			if(dropDown.get(i).getText().contains(dropDownOption))
			{
				dropDown.get(i).click();
				
				break;
			}
		}
	}
	
	
	public void enterTextBox(int TextBox,String value)
	{
		driver.findElement(By.xpath("(//input[@class='Input_input__csui'])["+TextBox+"]")).sendKeys(value);
	}
	
	
	public void clickTabButton()
	{
		driver.findElement(By.xpath("(//input[@class='Input_input__csui'])[1]")).sendKeys(Keys.TAB);
	}
	
	
	public void clickSubmitQuery()
	{
		driver.findElement(button_submitquery).click();
	}
	
	public boolean queryProcessingStatus()
	{
		int counter=0;
		
		List<WebElement> query=driver.findElements(block_result);
		
		System.out.println(query.size());
		
		counter=counter+query.size();
		
		int counter1=counter+1;
		
		System.out.println("Query Number => " + counter1);
		
		try
		{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@title='Corsearch FOCUS'])["+counter1+"]")));
		
		System.out.println("Query Processed Successfully");
		}
		catch(Exception e)
		{
			System.out.println("Query Processed Not Successfully");
			return false;
		}
		
		return true;
		
	}
	
	
	public boolean checkWarningPopup()
	{
		try
		{
			boolean status=driver.findElement(popup_warning).isDisplayed();
			
			if(status==true)
			{
				String warningtext=driver.findElement(popup_warning).getText();
				
				System.out.println(warningtext);
			}
		}
		catch(Exception e)
		{
			System.out.println("No Warning Popup is displayed");
			
			return false;
		}
		
		return true;
	}
	
	
	public void clearQuery()
	{
		driver.findElement(button_clearquery).click();
	}
	
	public void clickVantage()
	{
		driver.findElement(button_vantage).click();
		
		CommonFunction.explicitWait(button_standard, 20);
	}
	
	public void submitQueryJavaExecutor()
	{
		WebElement submitQuery=driver.findElement(button_submitquery);
		
		CommonFunction.clickMethodJavaScriptExecutor(submitQuery);
	}
	
	public void switchToStandardMaode()
	{
		driver.findElement(button_standard).click();
	}
	
	
	public void combineQueries(int Q1,int Q2)
	{
		driver.findElement(By.xpath("(//span[contains(@class,'csui Result_qryChk')])["+Q1+"]")).click();
		
		driver.findElement(By.xpath("(//span[contains(@class,'csui Result_qryChk')])["+Q2+"]")).click();
		
		driver.findElement(button_combinequery).click();
	}
	
	
	public void queryViewButtonStatus()
	{
		List<WebElement> view=driver.findElements(By.xpath("(//ul[contains(@class,'Result_ulRes')])[1]//span[@title='View']"));
		
		if(view.size()>0)
		{
			System.out.println("View Button is enabled");
			
			driver.findElement(By.xpath("(//ul[contains(@class,'Result_ulRes')])[1]//span[@title='View']")).click();
		}
		else
		{
			System.out.println("View Button is not enabled");
		}
	}
	
	
	public void clickDownArrowSelectView(String view)
	{
       
		List<WebElement> views=driver.findElements(By.xpath("(//span[contains(@class,'Result_displayBlock')]//img)[1]"));
		
		if(views.size()>0)
		{
			System.out.println("View Button is enabled");
			
			driver.findElement(By.xpath("(//span[contains(@class,'Result_displayBlock')]//img)[1]")).click();
			
			CommonFunction.explicitWait(viewDrodown, 60);
			
			List<WebElement> viewDropDown=driver.findElements(By.xpath("//ul[contains(@class,'ViewPopup_ulLst')]//li"));
			
			System.out.println(viewDropDown.size());
			
			for(int i=1;i<=viewDropDown.size();i++)
			{
				String viewName=driver.findElement(By.xpath("//ul[contains(@class,'ViewPopup_ulLst')]//li["+i+"]//span[2]")).getText();
				
				System.out.println(viewName);
				
				if(viewName.equalsIgnoreCase(view))
				{
					driver.findElement(By.xpath("//ul[contains(@class,'ViewPopup_ulLst')]//li["+i+"]")).click();
					
					break;
				}
			}
			
			
			CommonFunction.explicitWait(querypage_costpopup, 60);
			
			driver.findElement(By.xpath("//input[@id='CV4_Yes_TransAlertBox']")).click();
			
		}
		else
		{
			System.out.println("View Button is not enabled");
		}
	}

}
