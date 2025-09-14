package StepDefinitions;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;

import PageObjects.CartPage;
import PageObjects.CheckOutPage;
import PageObjects.HomePage;
import Utils.Commons;
import Utils.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
	
	public TestContext testcontext;
	public HomePage hp;
	public Commons common;
	public CheckOutPage cop;
	
	public HomePageSteps(TestContext testcontext)
	{
		this.testcontext = testcontext;
		this.common = testcontext.common;
	}
	
	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() 
	{
	    hp = testcontext.pm.getHomepageObject();
	    Assert.assertEquals(hp.getHomePageText(), "Swag Labs");
	}
	
	@When("user clicks on sorting option and selects low to high option")
	public void user_clicks_on_sorting_option_and_selects_low_to_high_option() 
	{
	    hp.clickSortButton();
	    hp.selectSortValue("low to high");
	}
	@Then("all the products price should be sorted in ascending order")
	public void all_the_products_price_should_be_sorted_in_ascending_order() throws IOException 
	{
	    Assert.assertTrue(common.isPriceSortedAscending());
		//System.out.println(common.checkAscendingSort());
	}
	
	@When("^user finds the product (.+) they are looking for and clicks on add to cart button$")
	public void user_finds_the_product_they_are_looking_for_and_clicks_on_add_to_cart_button(String pdt) 
	{
	    hp.addSinglePdtToCart(pdt);
	    hp.clicCartLogo();
	}
	
	@When("^user adds multiple products <products> to the cart then the products should show up in cart$")
	public void user_adds_multiple_products_products_to_the_cart(io.cucumber.datatable.DataTable dataTable) {
	    List<String> products = dataTable.asList();
	    hp.addMultiplePdtToCart(products);
	    hp.clicCartLogo();
	}	
	
	@When("user clicks on sorting option and selects high to low option")
	public void user_clicks_on_sorting_option_and_selects_high_to_low_option() {
	    hp.clickSortButton();
	    hp.selectSortValue("high to low");
	}
	@Then("all the products price should be sorted in descending order")
	public void all_the_products_price_should_be_sorted_in_descending_order() {
	   Assert.assertTrue(common.isPriceSortedDescending());
	}
	
	@When("user clicks on sorting option and selects Z to A option")
	public void user_clicks_on_sorting_option_and_selects_z_to_a_option() {
	    hp.clickSortButton();
	    hp.selectSortValue("z to a");
	}
	@Then("all the products name should be sorted in descending order")
	public void all_the_products_name_should_be_sorted_in_descending_order() {
	    common.isNameSortedDescending();
	}
	
	@When("user clicks on sorting option and selects A to Z option")
	public void user_clicks_on_sorting_option_and_selects_a_to_z_option() {
	    hp.clickSortButton();
	    hp.selectSortValue("a to z");
	}
	@Then("all the products name should be sorted in ascending order")
	public void all_the_products_name_should_be_sorted_in_ascending_order() {
	    common.isNameSortedAscending();
	}


}
