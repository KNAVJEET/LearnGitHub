package PageObject;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class InboxPage {
	
public WebDriver driver;
	
	
	public InboxPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By img_setcolumn=By.xpath("//span[@class=' gen-Browse-setColumn ']");
	
	By button_newscreening=By.xpath("//a[@id='I3_NewScreening']");
	
	By button_submitquery=By.xpath("//span[@title='Submit Query']");
	
	
	
	
	public boolean inboxPageLoaded()
	{
		
		boolean status=CommonFunction.explicitWait(img_setcolumn, 20);
		
		return status;		
	}
	
	
	public boolean selectSavedScreeningTab(String tabName) throws InterruptedException
	{
		int counter=0;
		
		List<WebElement> tabs=driver.findElements(By.xpath("//ul[@class='Inb_tabs_ul']//li[contains(@id,'I3')]"));
		
		System.out.println(tabs.size());
		
		for(int i=0;i<tabs.size();i++)
		{
			System.out.println(tabs.get(i).getText());
			
			if(tabs.get(i).getText().contains(tabName))
			{
				counter=counter+1;
				
				tabs.get(i).click();
				
				Thread.sleep(5000);
				
				tabs=driver.findElements(By.xpath("//ul[@class='Inb_tabs_ul']//li[contains(@id,'I3')]"));
				
				if(tabs.get(i).getAttribute("Class").contains("Active"))
				{
					System.out.println("Tab Selected");
					
					break;
				    
				}
				else
				{
					System.out.println("Tab is not Selected");
				    return false;
				}
				
			}
			
			
		}
		
		if(counter==0)
		{
			System.out.println("Not able to select " + tabName);
			return false;
		}
		
		return true;
	}
	
	
	public void clickNewScreening()
	{
		driver.findElement(button_newscreening).click();
	}

}
