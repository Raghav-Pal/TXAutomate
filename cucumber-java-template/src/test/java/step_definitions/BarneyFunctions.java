package step_definitions;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.BarneyApplicationFunctions;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

public class BarneyFunctions extends KeywordUtil{

	protected List<String[]> errLogs = new ArrayList<>();
	static boolean isRun;
	static boolean check = true;
	static boolean status = true;
	static String expected = "NA";
	static String actual = "NA";
	static String logStep;
	static int rows = 0;

	@SuppressWarnings("rawtypes")
	static Class thisClass = BarneyFunctions.class;
	static String testCaseID = thisClass.getSimpleName();

	@Given("^I open Barneys Staging website$")
	public void i_open_Barneys_Staging_website() throws Throwable {
		navigateToUrl(GlobalUtil.getCommonSettings().getUrl());
	}

	@Given("^I Login on the Website$")
	public void i_Login_on_the_Website() throws Throwable {
		try {
			BarneyApplicationFunctions.login("schauhan@barneys.com", "India@123");
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Given("^I select the Men Category$")
	public void i_select_the_Men_Category() throws Throwable {
		try {
			BarneyApplicationFunctions.menCategorySelection();
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Given("^I select the Product and Size$")
	public void i_select_the_Product_and_Size() throws Throwable {
		try {
			BarneyApplicationFunctions.productAndSizeSelection();
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Given("^I enter the quantity$")
	public void i_enter_the_quantity() throws Throwable {
		try {
			BarneyApplicationFunctions.quantityAdjustment("1");
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^I click on Add to cart$")
	public void i_click_on_Add_to_cart() throws Throwable {
		try {
			BarneyApplicationFunctions.addToCart();
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());	
		}
	}

	@Then("^I logout from the application$")
	public void i_logout_from_the_application() throws Throwable {
		try {
			BarneyApplicationFunctions.logout();
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

}
