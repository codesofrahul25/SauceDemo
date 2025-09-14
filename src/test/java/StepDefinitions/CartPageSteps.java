package StepDefinitions;

import org.testng.Assert;

import PageObjects.CartPage;
import Utils.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartPageSteps {
	
	public TestContext testcontext;
	public CartPage cart;
	
	public CartPageSteps(TestContext testcontext)
	{
		this.testcontext = testcontext;
	}
	
	@Then("the products should get added in the cart")
	public void the_products_should_get_added_in_the_cart() 
	{
	    cart = testcontext.pm.getCartObject();
	    String qty = cart.getCartQty();
	    String pdt = cart.getCartPdt();
	    Assert.assertEquals("1", qty);
	    //Assert.assertEquals("Sauce Labs Onesie", pdt);
	}
	
	@When("^user clicks on remove button of the (.+) then the product is removed$")
	public void user_clicks_on_remove_button(String pdt) 
	{
	    cart.clickRemoveProduct(pdt);
	}
	
	@Then("user navigates to Checkout page")
	public void user_navigates_to_checkout_page() 
	{
		cart = testcontext.pm.getCartObject();
	    cart.clickChkOut();
	    
	}
	

}
