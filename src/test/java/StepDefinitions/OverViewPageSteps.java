package StepDefinitions;

import org.testng.Assert;

import PageObjects.OverviewPage;
import Utils.TestContext;
import io.cucumber.java.en.Then;

public class OverViewPageSteps {
	
	public TestContext testcontext;
	public OverviewPage op;
	
	public OverViewPageSteps(TestContext testcontext)
	{
		this.testcontext = testcontext;
	}
	
	@Then("user validates whether the price total and total product price are equal")
	public void validateTotal()
	{
		op = testcontext.pm.getOverviewObject();
		Assert.assertEquals(op.getSumOfTotals(), op.getTotalPrice());
	}
	
	@Then("user clicks on finish button")
	public void user_clicks_on_finish_button() {
	    op.clickFinish();
	    String thankresp = op.getThankYouResp();
	    Assert.assertEquals("Thank you for your order!", thankresp);
	}

}
