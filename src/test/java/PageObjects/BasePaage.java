package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePaage {
	public WebDriver driver;

	public BasePaage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
