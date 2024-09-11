package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewsPage {
	
	private WebDriver driver;
	
	public ViewsPage(WebDriver driver)
	{
		this.driver=driver;	}
	
	By progressbar=By.xpath("//div[@id='UH_ProgressBarDiv' and contains(@style,'block')]");
	
	By ajaxloader=By.xpath("//div[@id='CV1_Ajax_Loader' and contains(@style,'block')]");
	
	 public void loadView()
	 {
		CommonFunction.isElementDisplayed(ajaxloader, 120);
		 
		 CommonFunction.ajaxLoader(ajaxloader);
	 }
	 
	 
	 
	 
	 
	 public void navigateViews() throws InterruptedException
	 {
		 List<WebElement> tabs=driver.findElements(By.xpath("//div[@id='CV4_Subheader_Views']//span[contains(@id,'cv4_load')]"));
		 
		 System.out.println(tabs.size());
		 
		 while(tabs.size()==0)
		 {
			 tabs=driver.findElements(By.xpath("//div[@id='CV4_Subheader_Views']//span[contains(@id,'cv4_load')]"));
		 }
		 
		 System.out.println(tabs.size());
		 
		 for(int i=1;i<tabs.size();i++)
		 {
			 tabs=driver.findElements(By.xpath("//div[@id='CV4_Subheader_Views']//span[contains(@id,'cv4_load')]"));
			 
			 String tabName=tabs.get(i).getAttribute("data-id");
			 
			 System.out.println(tabName);
			 
			 tabs.get(i).click();
			 
			 CommonFunction.ajaxLoader(ajaxloader);
			 
			 Thread.sleep(5000);
			 
			 
		 }
	 }

}
