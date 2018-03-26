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
import modules.VitaminShoppeApplicationUtil;
import utilities.ConfigReader;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

public class PlaceOrderWithGuestUser extends KeywordUtil {

	/** The err logs. */
	protected List<String[]> errLogs = new ArrayList<>();

	/** The is run. */
	static boolean isRun;

	/** The check. */
	static boolean check = true;

	/** The status. */
	static boolean status = true;

	/** The expected. */
	static String expected = "NA";

	/** The actual. */
	static String actual = "NA";

	/** The log step. */
	static String logStep;

	/** The rows. */
	static int rows = 0;

	/** The this class. */
	@SuppressWarnings("rawtypes")
	static Class thisClass = PlaceOrderWithGuestUser.class;

	/** The test case ID. */
	static String testCaseID = thisClass.getSimpleName();

	/** The driver. */
	public WebDriver driver;

	/** The data map. */
	public static HashMap<String, String> dataMap = new HashMap<String, String>();

	@Given("^Navigate to Home page of Vitamin Shoppe$")
	public void navigate_to_Home_page_of_Vitamin_Shoppe() throws Throwable {
		
		System.out.println("SEE HERE : "+GlobalUtil.getCommonSettings().getUrl());
		navigateToUrl(GlobalUtil.getCommonSettings().getUrl());
		Thread.sleep(10000);
	}

	@When("^Navaigate to the category \"([^\"]*)\"$")
	public void navaigate_to_the_category(String arg1) throws Throwable {
		try {

			VitaminShoppeApplicationUtil.selectCategory();

		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

//	@When("^Select product \"([^\"]*)\"\\$")
//	public void select_product(String arg1) throws Throwable {
//		try {
//			VitaminShoppeApplicationUtil.selectProduct();
//		} catch (Exception e) {
//			GlobalUtil.ErrorMsg = e.getMessage();
//			Assert.fail(e.getMessage());
//		}
//	}

	@When("^Click on \"([^\"]*)\" button and further click on \"([^\"]*)\" button\\.$")
	public void click_on_button_and_further_click_on_button(String arg1, String arg2) throws Throwable {
		try {
			VitaminShoppeApplicationUtil.clickAddToCart();

		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^Click on \"([^\"]*)\" buton on \"([^\"]*)\" page\\.$")
	public void click_on_buton_on_page(String arg1, String arg2) throws Throwable {
		try {
			VitaminShoppeApplicationUtil.checkOutNow();
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^Fill all the details under SIGNIN section on \"([^\"]*)\" page\\.$")
	public void fill_all_the_details_under_SIGNIN_section_on_page(String arg1) throws Throwable {
		try {
			VitaminShoppeApplicationUtil.fillDetailsInSignInSection();
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^Fill all the details under SHIPPING INFORMATION section on \"([^\"]*)\" page\\.$")
	public void fill_all_the_details_under_SHIPPING_INFORMATION_section_on_page(String arg1) throws Throwable {
		try {
			VitaminShoppeApplicationUtil.fillDetailsInShippingInfo();
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^Click on 'USE ADDRESS AS ENTERED' button under 'Verify Your Address Details' popup box$")
	public void click_on_USE_ADDRESS_AS_ENTERED_button_under_Verify_Your_Address_Details_popup_box() throws Throwable {
		try {
			VitaminShoppeApplicationUtil.verifyAddressDetailsPopup();
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^Choose a shipping option under 'Choose a Shipping Option' section$")
	public void choose_a_shipping_option_under_Choose_a_Shipping_Option_section() throws Throwable {
		try {
			VitaminShoppeApplicationUtil.chooseShippingOption();
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter required details under \"([^\"]*)\" section$")
	public void enter_required_details_under_section(String arg1) throws Throwable {
		try {
			VitaminShoppeApplicationUtil.enterCardDetails();
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^Click on 'Submit Order' button under 'Review and Submit' section\\.$")
	public void click_on_Submit_Order_button_under_Review_and_Submit_section() throws Throwable {
		try {
			VitaminShoppeApplicationUtil.submitOrder();
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Wait for and Verify that odere has been placed successfully$")
	public void wait_for_and_Verify_that_odere_has_been_placed_successfully() throws Throwable {
		try {
			VitaminShoppeApplicationUtil.orderPlacedConfirm();
			
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

}
