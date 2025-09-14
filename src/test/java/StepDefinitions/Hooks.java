package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Utils.TestContext;
import io.cucumber.java.*;

public class Hooks {
	
	public TestContext testcontext;
	//public WebDriver driver;
	
	public Hooks(TestContext testcontext)
	{
		this.testcontext = testcontext;
	}
	
	
	@After
	public void teardown() throws IOException
	{
		testcontext.ts.initializeWebDriver().quit();
	}
	
	@After
	public void takeScreenShot(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			TakesScreenshot ts = (TakesScreenshot) testcontext.ts.initializeWebDriver();
			byte[] ss = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(ss, "image/png", "Failed Screenshot");
		}
	}
	
	

}
