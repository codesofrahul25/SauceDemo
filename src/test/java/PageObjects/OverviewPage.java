package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePaage {

	public OverviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='summary_subtotal_label']")
	WebElement txt_total_price;
	@FindBy(xpath = "//button[@id='finish']")
	WebElement btn_finish;
	@FindBy(xpath = "//h2[@class='complete-header']")
	WebElement txt_thankyou;

	public double getTotalPrice() {
		double totalprice = Double.parseDouble(txt_total_price.getText().split(":")[1].trim().replace("$", ""));
		return totalprice;
	}

	public double getSumOfTotals() {
		List<WebElement> totals = driver
				.findElements(By.xpath("//div//ancestor::div[@class='cart_item']//div[@class='inventory_item_price']"));
		double value = 0;
		for (int i = 0; i < totals.size(); i++) {
			value = value + Double.parseDouble(totals.get(i).getText().replace("$", ""));
		}
		return value;
	}

	public void clickFinish() {
		btn_finish.click();
	}

	public String getThankYouResp() {
		return txt_thankyou.getText();
	}

}
