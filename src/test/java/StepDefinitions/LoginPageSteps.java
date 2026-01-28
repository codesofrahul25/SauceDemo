package StepDefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import PageObjects.LoginPage;
import Utils.Commons;
import Utils.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	public TestContext testcontext;
	public LoginPage lp;
	public Commons common;
	public List<HashMap<String, String>> mylist;

	public LoginPageSteps(TestContext testcontext) {
		this.testcontext = testcontext;
	}

	@Given("user is on Sauce Demo login page")
	public void loginPage() throws IOException {
		lp = new LoginPage(testcontext.ts.initializeWebDriver());
		Assert.assertEquals(lp.getLoginPageTitle(), "Swag Labs");
	}

	@When("^user enters valid username (.+) and valid password (.+)$")
	public void user_enters_valid_username_and_valid_password(String user, String pwd) {
		lp.sendUserName(user);
		lp.sendPassword(pwd);
	}

	@When("clicks on login")
	public void clicks_on_login() {
		lp.clickLogin();
	}

	@When("user enters valid username {string} and invalid password {string}")
	public void invalidLogin(String user, String pass) {
		lp.sendUserName(user);
		lp.sendPassword(pass);
	}

	@Then("user should get error message")
	public void errorMsg() {
		String errmsg = lp.getErrorMessage();
		Assert.assertEquals(errmsg, "Epic sadface: Username and password do not match any user in this service",
				"expected message is not displayed");
	}

	@Then("^user passes credentials from excel (.+) and clicks on login button$")
	public void getExcel(String rows) throws IOException {
		common = new Commons(testcontext.ts.initializeWebDriver());
		mylist = common.getExcelData(".//TestData//SauceDemo_Credentials.xlsx", "Sheet1");
		int i = Integer.parseInt(rows) - 1;
		lp.sendUserName(mylist.get(i).get("Username"));
		lp.sendPassword(mylist.get(i).get("Password"));
		lp.clickLogin();
	}
}
