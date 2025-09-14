package PageObjects;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By txt_username = By.xpath("//input[@id='user-name']");
	By txt_password = By.xpath("//input[@id='password']");
	By btn_login = By.xpath("//input[@id='login-button']");
	By txt_errorMsg = By.xpath("//div[@class='error-message-container error']/h3");
	
	public void sendUserName(String username)
	{
		driver.findElement(txt_username).sendKeys(username);
	}
	
	public void sendPassword(String password)
	{
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public void clickLogin()
	{
		driver.findElement(btn_login).click();
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getErrorMessage()
	{
		return driver.findElement(txt_errorMsg).getText();
	}

}
