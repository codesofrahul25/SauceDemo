package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePaage {

	public Select select;
	public WebDriverWait wait;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='header_label']/div")
	WebElement txt_hpName;
	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement btn_sort;
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	List<WebElement> get_all_price;
	@FindBy(xpath = "//div[@class='inventory_item_label']/a")
	List<WebElement> get_all_pdt_name;
	@FindBy(xpath = "//div[@id='shopping_cart_container']/a")
	WebElement btn_cartLogo;

	public String getHomePageText() {
		return txt_hpName.getText();
	}

	public void clickSortButton() {
		btn_sort.click();
	}

	public void selectSortValue(String sortOrder) {
		select = new Select(btn_sort);

		if (sortOrder.equalsIgnoreCase("a to z")) {
			select.selectByIndex(0);
		}
		if (sortOrder.equalsIgnoreCase("z to a")) {
			select.selectByIndex(1);
		}
		if (sortOrder.equalsIgnoreCase("low to high")) {
			select.selectByIndex(2);
		}
		if (sortOrder.equalsIgnoreCase("high to low")) {
			select.selectByIndex(3);
		}

	}

	public List<WebElement> getTotalProducts() {
		return get_all_price;
	}

	public void addSinglePdtToCart(String pdt) {
		String xpath = String.format("//div[text()='%s']/ancestor::div[@class='inventory_item']//button", pdt);
		WebElement addToCartBtn = driver.findElement(By.xpath(xpath));
		addToCartBtn.click();
	}

	public void addMultiplePdtToCart(List<String> lists) {
		List<WebElement> pdt_names = get_all_pdt_name;
		for (WebElement pdt_name : pdt_names) {
			for (int i = 0; i < lists.size(); i++) {
				if (pdt_name.getText().equals(lists.get(i))) {
					String xpath = String.format("//div[text()='%s']/ancestor::div[@class='inventory_item']//button",
							pdt_name.getText());
					driver.findElement(By.xpath(xpath)).click();
				}
			}
		}
	}

	public void clicCartLogo() {
		btn_cartLogo.click();
	}

}
