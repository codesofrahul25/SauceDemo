package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage {
	
public WebDriver driver;
public Select select;
public WebDriverWait wait;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By txt_hpName = By.xpath("//div[@class='header_label']/div");
	By btn_sort = By.xpath("//select[@class='product_sort_container']");
	By get_all_price = By.xpath("//div[@class='inventory_item_price']");
	By get_all_pdt_name = By.xpath("//div[@class='inventory_item_label']/a");
	By btn_cartLogo = By.xpath("//div[@id='shopping_cart_container']/a");
	
	
	public String getHomePageText()
	{
		return driver.findElement(txt_hpName).getText();
	}
	
	public void clickSortButton()
	{
		driver.findElement(btn_sort).click();
	}
	
	public void selectSortValue(String sortOrder)
	{
		select = new Select(driver.findElement(btn_sort));
		
		if(sortOrder.equalsIgnoreCase("a to z"))
		{
			select.selectByIndex(0);
		}
		if(sortOrder.equalsIgnoreCase("z to a"))
		{
			select.selectByIndex(1);
		}
		if(sortOrder.equalsIgnoreCase("low to high"))
		{
			select.selectByIndex(2);
		}
		if(sortOrder.equalsIgnoreCase("high to low"))
		{
			select.selectByIndex(3);
		}
		
	}
	
	
	
	public List<WebElement> getTotalProducts()
	{
		return driver.findElements(get_all_price);
	}
	
	public void addSinglePdtToCart(String pdt)
	{
		String xpath = String.format("//div[text()='%s']/ancestor::div[@class='inventory_item']//button",pdt);
		    WebElement addToCartBtn = driver.findElement(By.xpath(xpath));
		    addToCartBtn.click();
	}
	
	public void addMultiplePdtToCart(List<String> lists)
	{
		List<WebElement> pdt_names = driver.findElements(get_all_pdt_name);
		for(WebElement pdt_name: pdt_names)
		{
			for(int i=0; i<lists.size(); i++)
			{
				if(pdt_name.getText().equals(lists.get(i)))
				{
					String xpath = String.format("//div[text()='%s']/ancestor::div[@class='inventory_item']//button",pdt_name.getText());
					driver.findElement(By.xpath(xpath)).click();
				}
			}
		}
	}
	
	public void clicCartLogo()
	{
		driver.findElement(btn_cartLogo).click();
	}
	

}
