package step_definitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mobileutil.CloudfmApplicationFunctions;
import mobileutil.MobileKeywords;
import utilities.GlobalUtil;

public class MobileTests {


	@Given("^I login to application with username \"([^\"]*)\"$")
	public void akjsdi(String mobileNo){
		try{
			CloudfmApplicationFunctions.loginToApplication(mobileNo, MobileKeywords.GetValue("Password"));
			CloudfmApplicationFunctions.VerifyIagreebutton();
		}
		catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Given("^I navigate to My Agenda screen$")
	public void i_navigate_to_My_Agenda_screen() {
		try{
			CloudfmApplicationFunctions.verifyAgendaAndClick();
			CloudfmApplicationFunctions.nextButtonInTimesheet();
			CloudfmApplicationFunctions.MyAgendaPage();
		}
		catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^I sync the tasks on My Agenda screen$")
	public void i_sync_the_tasks_on_My_Agenda_screen() {
		try{
			CloudfmApplicationFunctions.VerifySyncFunctionality();
		}
		catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^I navigate to available past tasks$")
	public void i_navigate_to_available_past_tasks() {
		try{
			CloudfmApplicationFunctions.verifyPastFuntionality();
		}
		catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Then("^I verify all the task details and description available$")
	public void i_verify_all_the_task_details_and_description_available() {
		try{
			CloudfmApplicationFunctions.verifyPastPage();
			CloudfmApplicationFunctions.verifyDetailsDescription();
		}
		catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}
}
