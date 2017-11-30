package modules;


import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import pageobjects.AutomationHomePage;
import pageobjects.LoginPage;


public class SignInAction {

	public static void Execute(ArrayList<String> map) throws Exception{

		AutomationHomePage.sign_in.click();
		//Log.info("Click action is perfromed on My Account link" );
		//getClass()

		LoginPage.email.sendKeys(map.get(1));

		//Log.info(" is entered in UserName text box" );

		LoginPage.password.sendKeys(map.get(2));
		//Log.info(" is entered in Password text box" );

		Thread.sleep(2000);
		LoginPage.signin_button.click();
		//Log.info("Click action is performed on Submit button");

	}


	public static void search(WebDriver driver,HashMap<String,String> map) throws Exception{
		AutomationHomePage.search_box.sendKeys(map.get("search"));
		AutomationHomePage.search_icon.click();
	}



	public static void verifySearchResult(WebDriver driver,HashMap<String,String> map) {


		if(AutomationHomePage.search_icon.isDisplayed())
		{


		}

		else
		{



		}
	}
}



