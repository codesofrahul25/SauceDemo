package Utils;

import org.openqa.selenium.WebDriver;

import PageObjects.CartPage;
import PageObjects.CheckOutPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.OverviewPage;

public class PageObjectManager {
	
	public WebDriver driver;
	public LoginPage lp;
	public HomePage hp;
	public CartPage cart;
	public CheckOutPage cop;
	public OverviewPage op;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LoginPage getLoginPageObject()
	{
		lp = new LoginPage(driver);
		return lp;
	}
	
	public HomePage getHomepageObject()
	{
		hp = new HomePage(driver);
		return hp;
	}
	
	public CartPage getCartObject()
	{
		cart = new CartPage(driver);
		return cart;
	}
	
	public CheckOutPage getChkOutObject()
	{
		cop = new CheckOutPage(driver);
		return cop;
	}
	
	public OverviewPage getOverviewObject()
	{
		op = new OverviewPage(driver);
		return op;
	}

}
