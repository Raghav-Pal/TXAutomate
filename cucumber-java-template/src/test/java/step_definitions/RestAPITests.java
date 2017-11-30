package step_definitions;

import java.io.File;
import java.util.HashMap;

import org.testng.Assert;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import restutil.RestUtils;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;

public class RestAPITests {

	public static HashMap<String, String> datamap = null;
	public static String jsonObjectString = null;
	public static Response response = null;

	@Given("^Read \"([^\"]*)\" from Testdata file required to create a user$")
	public void read_from_Testdata_file_and_convert_to_json_Object(String arg1) {
		try{
			datamap = ExcelDataUtil.getTestDataWithTestCaseID("RestAPITestData",arg1);
			jsonObjectString = Files.toString(new File("src/test/resources/testData/CreateUserRestAPITemp.txt"), Charsets.UTF_8);
			jsonObjectString = jsonObjectString.replace("ReplaceFN", datamap.get("ReplaceFN"));
			jsonObjectString = jsonObjectString.replace("ReplaceLN", datamap.get("ReplaceLN"));
			jsonObjectString = jsonObjectString.replace("ReplaceEmail", datamap.get("ReplaceEmail"));
			jsonObjectString = jsonObjectString.replace("ReplacePassword", datamap.get("ReplacePassword"));
		}
		catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Given("^I set the content type and body$")
	public void i_set_the_content_type_and_body(){
		try{
			//System.out.println(jsonObjectString);
			RestUtils.setBaseURI(GlobalUtil.getCommonSettings().getRestURL()+"/v3/users/");
			RestUtils.setContentBodyType(ContentType.JSON,jsonObjectString);
		}
		catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("^I post the create user data to the api$")
	public void i_post_the_json() {
		try{
			response = RestUtils.PostResponse(""); 
			//System.out.println(response.getBody().asString());
		}
		catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Then("^I verify the status as \"([^\"]*)\"$")
	public void i_verify_the_status_as(String arg1){
		try{
			Assert.assertEquals(arg1, ""+response.getStatusCode(),"Status Check Failed!");
		}
		catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Then("^I verify the json response$")
	public void i_verify_the_json_response(){
		Assert.assertEquals(datamap.get("ReplaceEmail"), RestUtils.getValueFromJson(response,"user.email"),"Email id verification failed!");
	}


}
