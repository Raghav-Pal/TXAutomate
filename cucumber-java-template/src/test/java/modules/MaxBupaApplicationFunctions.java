package modules;

import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.By;

import utilities.KeywordUtil;
import utilities.LogUtil;

public class MaxBupaApplicationFunctions {
	
	static Class thisClass = MaxBupaApplicationFunctions.class;

	public static final By Adults = By.xpath("//select[contains(@class,'txtinput adults')]");
	public static final By Child = By.xpath(".//*[@id='children']");
	public static final By DOB = By.xpath("//input[contains(@id,'dob')]");
	public static final By Date = By.xpath("//a[text()=1]");

	public static final By City = By.xpath("//select[contains(@id,'ddlCity')]");
	public static final By Mobile = By.xpath(".//*[@id='mobile']");
	public static final By Sum = By.xpath(".//*[@id='sum']");
	public static final By GET = By.xpath("//input[@class='premniumCalculator btnsubmit']");
	public static final By BuyNow = By.xpath("(//input[@value='Buy Now'])[position()=1]");
	public static final By Email = By.xpath("(//div[@class='dialogbox'][@style='display: block;']//input[@name='Email'])[position()=1]");
	public static final By Continue = By.xpath("(//input[@value='Continue'])[position()=1]");
	public static final By Continuea = By.xpath("//input[@value='Continue']");
	public static final By Title = By.xpath("//select[@class='selectbox title']");
	public static final By MiddleName = By.xpath(".//*[@name='mname']");
	public static final By LastName = By.xpath(".//*[@name='lname']");
	public static final By Nationality = By.xpath("//select[@name='nationality']");
	public static final By PaidBy = By.xpath("//input[@name='PremiumPaidBy']");
	public static final By Relation = By.xpath("//input[@name='RelationshipwithProposer']");
	public static final By RadioNo = By.xpath(".//*[@id='RdoIsEia']");
	public static final By Continue2 = By.xpath("//div[@id='persoanlDetails']//input[@class='bj-sbmt-btn show_btn' and @value='Continue']");
	public static final By Save = By.xpath("//a[@data-bind='enable: $data.PremiumComputed()']");

	public static final By Plans = By.xpath("//div[@class='nav-sep']/div[contains(.,'Plans - New Customers')]");
	
	public static void fillTheDetails(HashMap<String, String> dataMap) throws InterruptedException {
		KeywordUtil.selectByIndex(Adults, 1);
		LogUtil.infoLog(thisClass, "Adult selected");
		KeywordUtil.selectByIndex(Child, 3);
		LogUtil.infoLog(thisClass, "Number of children selected");
		KeywordUtil.click(DOB);
		LogUtil.infoLog(thisClass, "Click on drop down menu");
		KeywordUtil.click(Date);
		LogUtil.infoLog(thisClass, "Date selected");
		
		KeywordUtil.selectByIndex(City, 3);		
		//MaxBupaTestData -- sheet name
		KeywordUtil.inputText(Mobile, "9888886262");
		KeywordUtil.selectByIndex(Sum, 2);
		KeywordUtil.click(GET);
		Thread.sleep(10000);
	}
	
	public static void I_buy_health_companiion_plan(HashMap<String, String> dataMap) throws InterruptedException {
		KeywordUtil.click(BuyNow);
		 Random rand = new Random();		 
		KeywordUtil.inputText(Email, "damcotestuser"+ rand.nextInt() + "@gmail.com");
		KeywordUtil.click(Continue);
		Thread.sleep(5000);
		KeywordUtil.click(Continuea); 
		
	}	
		
		
		
		
	public static void I_fill_in_the_personal_details(HashMap<String, String> dataMap) throws InterruptedException {
		KeywordUtil.selectByIndex(Title,2);
		KeywordUtil.inputText(MiddleName, "Parmod");
		KeywordUtil.inputText(LastName, "Singla");
		KeywordUtil.selectByIndex(Nationality,1);
		KeywordUtil.inputText(PaidBy, "Father");
		KeywordUtil.inputText(Relation, "Father");
		
		KeywordUtil.click(RadioNo); 
		KeywordUtil.click(Continue2); 
		
	}
	public static void I_click_on_continue() throws InterruptedException {
		KeywordUtil.click(Save); 
		KeywordUtil.acceptAlert();
		KeywordUtil.isWebElementPresent(Plans); 
		
	}

	
	public static void verify_that_the_user_gets_navigated_to_dashboard_page() throws InterruptedException {
		KeywordUtil.isWebElementPresent(Plans); 
		
	}	

}
