package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class TestSetup {
	
	public WebDriver driver;
	
	public WebDriver initializeWebDriver() throws IOException
	{
		FileInputStream fi = new FileInputStream(".//src//test//resources//Config.properties");
		Properties prop = new Properties();
		prop.load(fi);
		String url = prop.getProperty("url");
		String browser_property = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		String browser = browser_maven != null ? browser_maven : browser_property;
		if(driver==null)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.navigate().to(url);
			}
			else if(browser.equalsIgnoreCase("edge"))
			{
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.navigate().to(url);
			}
		}
		return driver;
	}

}
