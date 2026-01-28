package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.github.javafaker.Faker;

public class CheckOutPage extends BasePaage {
	public Faker fake = new Faker();

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='first-name']")
	WebElement txt_fname;
	@FindBy(xpath = "//input[@id='last-name']")
	WebElement txt_lname;
	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement txt_zipcode;
	@FindBy(xpath = "//input[@id='continue']")
	WebElement btn_continue;

	public void getFName() {
		txt_fname.sendKeys(fake.name().firstName());
	}

	public void getLName() {
		txt_lname.sendKeys(fake.name().lastName());
	}

	public void getZipCode() {
		txt_zipcode.sendKeys(fake.address().zipCode());
	}

	public void clickContinue() {
		btn_continue.click();
	}

}
