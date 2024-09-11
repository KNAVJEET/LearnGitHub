package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends TestBase{
	
	/*private WebDriver driver;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}*/
	
	
	By textbox_username=By.xpath("//input[@id='loginId']");
	
	By textbox_password=By.xpath("//input[@id='password']");
	
	By button_login=By.xpath("//button[@class=' button CV91_btnLogin_bg']");
	
	
	public void enterUserName(String userName)
	{
		driver.findElement(textbox_username).sendKeys(userName);
	}
	
	
	public void enterPassword(String Password)
	{
		driver.findElement(textbox_password).sendKeys(Password);
	}
	
	
	public void submitButton()
	{
		driver.findElement(button_login).click();
	}
	
	

}
