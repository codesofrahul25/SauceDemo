package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class TestContext {
	
	public TestSetup ts;
	public Commons common;
	
	public TestContext() throws IOException
	{
		ts = new TestSetup();
		common = new Commons(ts.initializeWebDriver());
	}

}
