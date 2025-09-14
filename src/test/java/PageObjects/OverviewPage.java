package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage 
{
	public WebDriver driver;
	
	public OverviewPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By txt_total_price = By.xpath("//div[@class='summary_subtotal_label']");
	By btn_finish = By.xpath("//button[@id='finish']");
	By txt_thankyou = By.xpath("//h2[@class='complete-header']");
	
	public double getTotalPrice()
	{
		double totalprice = Double.parseDouble(driver.findElement(txt_total_price).getText().split(":")[1].trim().replace("$", ""));
		return totalprice;
	}
	
	public double getSumOfTotals()
	{
		List<WebElement> totals = driver.findElements(By.xpath("//div//ancestor::div[@class='cart_item']//div[@class='inventory_item_price']"));
		double value = 0;
		for(int i=0; i<totals.size(); i++)
		{
			value = value + Double.parseDouble(totals.get(i).getText().replace("$", ""));
		}
		return value;
	}
	
	public void clickFinish()
	{
		driver.findElement(btn_finish).click();
	}
	
	public String getThankYouResp()
	{
		return driver.findElement(txt_thankyou).getText();
	}

}
