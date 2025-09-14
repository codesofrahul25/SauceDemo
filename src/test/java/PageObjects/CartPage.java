package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	
	public WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By txt_cart_quantity = By.xpath("//div[@class='cart_quantity']");
	By txt_cart_pdt_name = By.xpath("//div[@class='inventory_item_name']");
	By btn_chkOut = By.xpath("//button[text()='Checkout']");
	
	public String getCartQty()
	{
		return driver.findElement(txt_cart_quantity).getText();
	}
	
	public String getCartPdt()
	{
		return driver.findElement(txt_cart_pdt_name).getText();
	}
	
	public void clickRemoveProduct(String pdt)
	{
		String xpath = String.format("//div[text()='%s']/ancestor::div[@class='cart_item']//button", pdt);
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clickChkOut()
	{
		driver.findElement(btn_chkOut).click();
	}
	
	
}
