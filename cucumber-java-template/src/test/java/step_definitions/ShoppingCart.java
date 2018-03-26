package step_definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.UPCApplicationFunctions;
import utilities.ConfigReader;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;


public class ShoppingCart extends KeywordUtil{

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

	@Given("^Read \"([^\"]*)\" from Testdata file$")
	public void read_from_Testdata_file(String arg1) throws Throwable {
		try{
			dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WebTestData",arg1);
		}
		catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Given("^I open UPC website$")
	public void i_open_UPC_website() {
		
		System.out.println("see here : "+GlobalUtil.getCommonSettings().getUrl());
		navigateToUrl(GlobalUtil.getCommonSettings().getUrl());
	}

	@Given("^I login into the application$")
	public void i_login_into_the_application() {
		try {
			UPCApplicationFunctions.login(ConfigReader.getValue("username"), ConfigReader.getValue("password"));
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Given("^I select to start a new qoute for policy creation$")
	public void i_create_a_new_quote_with_the_given_details() {
		try {
			UPCApplicationFunctions.startANewQuote();
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^I fill the address details in the prompt$")
	public void i_fill_the_address_details_in_the_prompt() {
/*		HashMap<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("Address", "3 BURRIS CT");
		dataMap.put("City", "AIRMONT");
		dataMap.put("ZipCode", "10952");
		dataMap.put("State", "NY");*/
		try {
			UPCApplicationFunctions.fillAddress(dataMap);
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^I fill the household property information details$")
	public void i_fill_the_household_page_details() {
/*		HashMap<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("PolicyForm", "HO 05");
		dataMap.put("NoOfMonthsOccupiedPerYear", "10");
		dataMap.put("NoOfMonthsRentedPerYear", "None");
		dataMap.put("FirstName", "NA");
		dataMap.put("LastName", "KRAMER");
		dataMap.put("MM", "12");
		dataMap.put("DD", "18");
		dataMap.put("YYYY", "1963");
		dataMap.put("MaritalStatus", "Married");
		dataMap.put("EstimatedCreditRating", "Excellent");*/
		try {
			System.out.println("household page");
			UPCApplicationFunctions.houseHoldPage(dataMap);
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^I fill the property details of the insurer$")
	public void i_fill_the_property_page_details() {
/*		HashMap<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("RoofAge", "20");
		dataMap.put("PriorLiability", "$500,000");
		dataMap.put("NoOfMonthsRentedPerYear", "None");
		dataMap.put("NoOfFamilyDwelling", "2");
		dataMap.put("NoOfClaimsPaid", "2");
		dataMap.put("TotalLivingArea", "100");*/
		try {
			UPCApplicationFunctions.propertyPage(dataMap);
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^I fill the coverage details of the insurer$")
	public void i_fill_the_coverage_page_details() {
		//HashMap<String, String> dataMap = new HashMap<String, String>();
		//dataMap.put("CoverageADwelling", "170000");
		//dataMap.put("PaymentTypeDiscount", "EFT (2, 4, 10 pay plan)");
		try {
			UPCApplicationFunctions.coveragePage(dataMap);
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^I fill the point of sale details$")
	public void i_fill_the_point_of_sale_page_details() throws Throwable {
		//HashMap<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("YearHeatingRenovated", "2017");
		dataMap.put("SSN", "666431667");
		//dataMap.put("Email", "damcotest@yopmail.com");
		dataMap.put("Phone1", "222");
		dataMap.put("Phone2", "222");
		dataMap.put("Phone3", "2222");
		try {
			UPCApplicationFunctions.pointOfSalePage(dataMap);
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^I submit for authorization$")
	public void i_click_on_authorization_button() throws Throwable {
		try {
			UPCApplicationFunctions.clickAuthorize();
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Then("^I verify the status of the created policy$")
	public void i_verify_the_status() throws Throwable {
		try {
			UPCApplicationFunctions.verifyTheresult();
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Then("^I sign out from application$")
	public void i_sign_out_from_UPC() throws Throwable {
		try {
			UPCApplicationFunctions.logout();
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

}
