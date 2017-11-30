package step_definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.MaxBupaApplicationFunctions;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

public class MaxBupaFunctions extends KeywordUtil{
	
	protected List<String[]> errLogs= new ArrayList<>();
	static boolean isRun;
	static boolean check=true;
	static boolean status=true;
	static String expected="NA";
	static String actual="NA";
	static String logStep;
	static int rows=0;

	@SuppressWarnings("rawtypes")
	static Class thisClass=ShoppingCart.class;
	static String testCaseID=thisClass.getSimpleName();

	public WebDriver driver;
	public static HashMap<String, String> dataMap = new HashMap<String, String>();
	
	@Given("^Read \"([^\"]*)\" from excel file$")
	public void read_from_excel_file(String arg1) throws Throwable {
		try{
			dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MaxBupaTestData",arg1);
		}
		catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Given("^I open the Website$")
	public void i_open_the_Website() throws Throwable {
		navigateToUrl(GlobalUtil.getCommonSettings().getUrl());
	}

	@Given("^I fill the calculate your premium form$")
	public void i_fill_the_calculate_your_premium_form() throws Throwable {
		try {
			MaxBupaApplicationFunctions.fillTheDetails(dataMap);
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Given("^I buy health companiion plan$")
	public void i_buy_health_companiion_plan() throws Throwable {
		try {
			MaxBupaApplicationFunctions.I_buy_health_companiion_plan(dataMap);
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Given("^I fill in the personal details$")
	public void i_fill_in_the_personal_details() throws Throwable {
		try {
			MaxBupaApplicationFunctions.I_fill_in_the_personal_details(dataMap);
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^I click on continue$")
	public void i_click_on_continue() throws Throwable {
		try {
			MaxBupaApplicationFunctions.I_click_on_continue();
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Verify that the user gets navigated to dashboard page$")
	public void verify_that_the_user_gets_navigated_to_dashboard_page() throws Throwable {
		try {
			MaxBupaApplicationFunctions.verify_that_the_user_gets_navigated_to_dashboard_page();
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

}
