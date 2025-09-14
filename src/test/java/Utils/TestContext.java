package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class TestContext {
	
	public TestSetup ts;
	public PageObjectManager pm;
	public WebDriver driver;
	public Commons common;
	
	public TestContext() throws IOException
	{
		ts = new TestSetup();
		pm = new PageObjectManager(ts.initializeWebDriver());
		common = new Commons(ts.initializeWebDriver());
	}

}
