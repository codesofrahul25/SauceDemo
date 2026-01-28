package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePaage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='user-name']")
	WebElement txt_username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement txt_password;
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement btn_login;
	@FindBy(xpath = "//div[@class='error-message-container error']/h3")
	WebElement txt_errorMsg;

	public void sendUserName(String username) {
		txt_username.sendKeys(username);
	}

	public void sendPassword(String password) {
		txt_password.sendKeys(password);
	}

	public void clickLogin() {
		btn_login.click();
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public String getErrorMessage() {
		return txt_errorMsg.getText();
	}

}
