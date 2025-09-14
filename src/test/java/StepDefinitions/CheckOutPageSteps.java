package StepDefinitions;

import PageObjects.CheckOutPage;
import Utils.TestContext;
import io.cucumber.java.en.Then;

public class CheckOutPageSteps 
{
	public TestContext testcontext;
	public CheckOutPage cop;
	
	public CheckOutPageSteps(TestContext testcontext)
	{
		this.testcontext = testcontext;
	}
	
	@Then("user enters firstname, lastname and zipcode")
	public void user_enters_firstname_lastname_and_zipcode() 
	{
	    cop = testcontext.pm.getChkOutObject();
	    cop.getFName();
	    cop.getLName();
	    cop.getZipCode();
	}
	@Then("clicks on continue and navigated to overview page")
	public void clicks_on_continue_and_navigated_to_overview_page() {
	    cop.clickContinue();
	}

}
