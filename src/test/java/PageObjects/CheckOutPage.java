package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

public class CheckOutPage {
	
	public WebDriver driver;
	public Faker fake = new Faker();
	
	public CheckOutPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By txt_fname = By.xpath("//input[@id='first-name']");
	By txt_lname = By.xpath("//input[@id='last-name']");
	By txt_zipcode = By.xpath("//input[@id='postal-code']");
	By btn_continue = By.xpath("//input[@id='continue']");
	
	public void getFName()
	{
		driver.findElement(txt_fname).sendKeys(fake.name().firstName());
	}
	
	public void getLName()
	{
		driver.findElement(txt_lname).sendKeys(fake.name().lastName());
	}
	
	public void getZipCode()
	{
		driver.findElement(txt_zipcode).sendKeys(fake.address().zipCode());
	}
	
	public void clickContinue()
	{
		driver.findElement(btn_continue).click();
	}

}
