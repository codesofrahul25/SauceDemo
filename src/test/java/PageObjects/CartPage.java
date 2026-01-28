package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePaage {

	public CartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='cart_quantity']")
	WebElement txt_cart_quantity;
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	WebElement txt_cart_pdt_name;
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement btn_chkOut;

	public String getCartQty() {
		return txt_cart_quantity.getText();
	}

	public String getCartPdt() {
		return txt_cart_pdt_name.getText();
	}

	public void clickRemoveProduct(String pdt) {
		String xpath = String.format("//div[text()='%s']/ancestor::div[@class='cart_item']//button", pdt);
		driver.findElement(By.xpath(xpath)).click();
	}

	public void clickChkOut() {
		btn_chkOut.click();
	}

}
