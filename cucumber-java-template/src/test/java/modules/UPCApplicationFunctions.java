package modules;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utilities.GlobalUtil;
import utilities.KeywordUtil;
import utilities.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class UPCApplicationFunctions.
 */
public class UPCApplicationFunctions {

	/** The this class. */
	static Class thisClass = UPCApplicationFunctions.class;
	
	/** The web elements list. */
	static List<WebElement> webElementsList;
	
	/** The refernce number. */
	static String refernceNumber;
	
	/** The status of authorization. */
	static String statusOfAuthorization;

	/** The please wait. */
	static By pleaseWait = By.id("f1:__busyStatusDialogHeader");

	/** The user name. */
	static By userName = By.xpath(".//*[@id='j_username']");
	
	/** The password. */
	static By password = By.xpath(".//div[@class='loginuserfield']/input[@name='j_password']");
	
	/** The login button. */
	static By loginButton = By.xpath(".//div[@class='loginbtn']/input[@value='Login']");

	/** The yes button. */
	static By yesButton = By.xpath(".//a[@id='FCRAConsentForm:j_id20']/span[text()='Yes']");

	/** The search button. */
	static By searchButton = By.xpath(".//a[@id='f0:CB_0_4']/span[contains(text(),'Search')]");
	
	/** The start A new quote button. */
	static By startANewQuoteButton = By.xpath(".//a[@id='f0:CB_0_4']/span[contains(text(),'Start a New Quote')]");

	/** The address. */
	static By address = By.xpath(".//*[@id='c452_Addrmp_f:_rowRepeat:0:_cellRepeat:1:_adl1']");
	
	/** The city. */
	static By city = By.xpath(".//*[@id='c452_Addrmp_f:_rowRepeat:1:_cellRepeat:1:_city']");
	
	/** The zip code. */
	static By zipCode = By.xpath(".//*[@id='c452_Addrmp_f:_rowRepeat:2:_cellRepeat:1:_zip']");
	
	/** The state drop down. */
	static By stateDropDown = By.xpath(".//*[@id='c452_Addrmp_f:_rowRepeat:1:_cellRepeat:3:_st']");
	
	/** The ok button. */
	static By okButton = By.xpath(".//*[@id='c452_Addrmp_f:_OKButton']/span[@class='btnSpn']");

	/** The policyform drop down. */
	static By policyformDropDown = By.xpath(".//*[@id='f1:c184_1186']");
	
	/** The radio button is this A new home no. */
	static By radioButtonIsThisANewHomeNo = By.xpath(".//*[@id='f1:c213_913:1']");
	
	/** The radio button within 1000 feet of A fire hydrant yes. */
	static By radioButtonWithin1000FeetOfAFireHydrantYes = By.xpath(".//*[@id='f1:c213_894:0']");
	
	/** The no of months occupied per year. */
	static By noOfMonthsOccupiedPerYear = By.xpath(".//*[@id='f1:c213_1041']");
	
	/** The no of months rented per year. */
	static By noOfMonthsRentedPerYear = By.id("f1:c213_1258");
	
	/** The first name. */
	static By firstName = By.xpath(".//*[@id='f1:c219_825']");
	
	/** The last name. */
	static By lastName = By.xpath(".//*[@id='f1:c219_953']");
	
	/** The dob MM. */
	static By dobMM = By.xpath(".//*[@id='f1:c219_7371m']");
	
	/** The dob DD. */
	static By dobDD = By.xpath(".//*[@id='f1:c219_7372d']");
	
	/** The dob YYYY. */
	static By dobYYYY = By.xpath(".//*[@id='f1:c219_7373y']");
	
	/** The marital status. */
	static By maritalStatus = By.xpath(".//*[@id='f1:c219_982']");
	
	/** The estimated credit rating. */
	static By estimatedCreditRating = By.xpath(".//select[@id='f1:c219_712']");
	
	/** The next button house hold. */
	static By nextButtonHouseHold = By.xpath(".//a[@id='f1:bHouseholdCB__294']/span[@class='tskBtnSpn']");

	/** The roof age. */
	static By roofAge = By.xpath(".//*[@id='f1:c213_1283']");
	
	/** The prior liability. */
	static By priorLiability = By.xpath(".//*[@id='f1:c219_1172']");
	
	/** The does swelling have aluminium siding no. */
	static By doesSwellingHaveAluminiumSidingNo = By.xpath(".//*[@id='f1:c213_841:1']");
	
	/** The no of family dwelling drop down. */
	static By noOfFamilyDwellingDropDown = By.xpath(".//*[@id='f1:c213_1030']");
	
	/** The no of paid claims in the last 3 years drop down. */
	static By noOfPaidClaimsInTheLast3YearsDropDown = By.xpath(".//*[@id='f1:c465_tr:c465__adp:0::c465_DL_c209_596']");
	
	/** The calculate replacement cost yes. */
	static By calculateReplacementCostYes = By.xpath(".//*[@id='f1:c213_898:0']");
	
	/** The total living area. */
	static By totalLivingArea = By.xpath(".//*[@id='f1:c213_1322']");
	
	/** The calculate replacement cost button. */
	static By calculateReplacementCostButton = By.xpath(".//*[@id='f1:CB_478_179']/span[@class='btnSpn']");
	
	/** The next button property page. */
	static By nextButtonPropertyPage = By.xpath(".//a[@id='f1:tPropertyCB__294']/span[@class='tskBtnSpn']");

	/** The coverage A dwelling. */
	static By coverageADwelling = By
			.xpath(".//*[@id='f1:c398_pi:0:c490_tr:c490__adp:0:c490__adp:0::c490_TB_c399_686']");
	
	/** The payment type discount drop down. */
	static By paymentTypeDiscountDropDown = By
			.xpath(".//*[@id='f1:c398_pi:0:c490_tr:c490__adp:5:c490__adp:0::c490_DL_c399_686']");
	
	/** The get rate button coverage page. */
	static By getRateButtonCoveragePage = By.xpath(".//*[@id='f1:_1CB_162_176']/span[@class='btnSpn']");
	
	/** The next button coverage page. */
	static By nextButtonCoveragePage = By.xpath(".//*[@id='f1:bCoverageCB__294']/span[@class='tskBtnSpn']");

	/** The radio button ever been rejected no. */
	static By radioButtonEverBeenRejectedNo = By.xpath(".//*[@id='f1:c526_tr:c526__adp:0::c526_R_c205_596:1']");
	
	/** The radio button certify that the dwelling yes. */
	static By radioButtonCertifyThatTheDwellingYes = By.xpath(".//*[@id='f1:c516_tr:c516__adp:0::c516_R_c209_596:0']");
	
	/** The radio button 5 or more acres yes. */
	static By radioButton5OrMoreAcresYes = By.xpath(".//*[@id='f1:c516_tr:c516__adp:1::c516_R_c209_596:0']");
	
	/** The radio button property management firm no. */
	static By radioButtonPropertyManagementFirmNo = By.xpath(".//*[@id='f1:c516_tr:c516__adp:2::c516_R_c209_596:1']");
	
	/** The radio button tree house in premises no. */
	static By radioButtonTreeHouseInPremisesNo = By.xpath(".//*[@id='f1:c516_tr:c516__adp:3::c516_R_c209_596:1']");
	
	/** The radio button I certify that I yes. */
	static By radioButtonICertifyThatIYes = By.xpath(".//*[@id='f1:c517_tr:c517__adp:0::c517_R_c203_596:0']");
	
	/** The next button xpath point of sale page one. */
	static By nextButtonXpathPointOfSalePageOne = By
			.xpath(".//*[@id='f1:bUnderwritingCB__294']/span[@class='tskBtnSpn']");

	/** The year heating renovated. */
	static By yearHeatingRenovated = By.xpath(".//*[@id='f1:c213_1468']");
	
	/** The radio button same mailing address yes. */
	static By radioButtonSameMailingAddressYes = By.xpath(".//*[@id='f1:c184_911:0']");
	
	/** The radio button property with city limits no. */
	static By radioButtonPropertyWithCityLimitsNo = By.xpath(".//*[@id='f1:c353_tr:c353__adp:0::c353_R_c209_596:1'] ");
	
	/** The radio button gender male. */
	static By radioButtonGenderMale = By.xpath(".//*[@id='f1:c368_dt:0:c368_st:0:c219_835:0']");
	
	/** The email address. */
	static By emailAddress = By.xpath(".//*[@id='f1:c368_dt:0:c368_st:0:c219_788']");
	
	/** The ssn. */
	static By ssn = By.xpath(".//*[@id='f1:c368_dt:0:c368_st:0:c219_1316']");
	
	/** The home phone 1. */
	static By homePhone1 = By.xpath(".//*[@id='f1:c368_dt:0:c368_st:0:c356_PhArea']");
	
	/** The home phone 2. */
	static By homePhone2 = By.xpath(".//*[@id='f1:c368_dt:0:c368_st:0:c356_PhPrefix']");
	
	/** The home phone 3. */
	static By homePhone3 = By.xpath(".//*[@id='f1:c368_dt:0:c368_st:0:c356_PhSuffix']");
	
	/** The radio button how long living at the address 5 years or more. */
	static By radioButtonHowLongLivingAtTheAddress5YearsOrMore = By
			.xpath(".//*[@id='f1:c368_dt:0:c368_st:0:c219_1472:1']");
	
	/** The radio button reports ordered for the primary insured yes. */
	static By radioButtonReportsOrderedForThePrimaryInsuredYes = By
			.xpath(".//*[@id='f1:c368_dt:0:c368_st:0:c362_tr:c362__adp:0::c362_R_c205_596:0']");
	
	/** The order credit report button. */
	static By orderCreditReportButton = By
			.xpath(".//a[@id='f1:CB_368_328']/span[contains(text(),'Order Credit Report')]");
	
	/** The order clue report button. */
	static By orderClueReportButton = By.xpath(".//*[@id='f1:CB_366_327']/span[@class='btnSpn']");
	
	/** The get rate button ponit of sale after clicking next first time. */
	static By getRateButtonPonitOfSaleAfterClickingNextFirstTime = By
			.xpath(".//*[@id='f1:_2CB_372_177']/span[contains(text(),'Get Rate')]");
	
	/** The next button xpath point of sale page two. */
	static By nextButtonXpathPointOfSalePageTwo = By
			.xpath(".//*[@id='f1:bPointOfSaleCB__294']/span[@class='tskBtnSpn']");

	/** The submit for authorization button. */
	static By submitForAuthorizationButton = By
			.xpath(".//a[@id='f1:CB_6_506']/span[contains(text(),'Submit for Authorization')]");
	
	/** The okay button. */
	static By okayButton = By.xpath(".//*[@id='f2:c0_9']");
	
	/** The table row for verification. */
	static By tableRowForVerification = By.xpath(".//tbody[@id='f0:c27_dt:tb']/tr/td");

	/** The username details in header. */
	static By usernameDetailsInHeader = By.xpath("//span[contains(text(),'Welcome')]");
	
	/** The logout button. */
	static By logoutButton = By.xpath("//span[text()='Logout']");

	/**
	 * Login.
	 *
	 * @param sUsername the s username
	 * @param sPassword the s password
	 */
	public static void login(String sUsername, String sPassword) {
		KeywordUtil.inputText(userName, sUsername);
		KeywordUtil.inputText(password, sPassword);
		KeywordUtil.waitForClickable(loginButton);
		KeywordUtil.click(loginButton);
		KeywordUtil.waitForClickable(yesButton);
		LogUtil.infoLog(thisClass, "Login is Successfull with :" + sUsername);
	}

	/**
	 * Start A new quote.
	 */
	public static void startANewQuote() {
		KeywordUtil.click(yesButton);
		KeywordUtil.waitForInVisibile(yesButton);
		KeywordUtil.waitForInVisibile(pleaseWait);
		KeywordUtil.click(searchButton);
		/*KeywordUtil.waitForClickable(startANewQuoteButton);
		KeywordUtil.click(startANewQuoteButton);
		KeywordUtil.waitForClickable(address);*/
		LogUtil.infoLog(thisClass, "A New Quote page opened.");
	}

	/**
	 * Fill address.
	 *
	 * @param dataMap the data map
	 */
	public static void fillAddress(HashMap<String, String> dataMap) {
		/*KeywordUtil.waitForInVisibile(pleaseWait);
		KeywordUtil.inputText(address, dataMap.get("Address"));
		KeywordUtil.inputText(city, dataMap.get("City"));
		KeywordUtil.inputText(zipCode, dataMap.get("ZipCode"));
		KeywordUtil.selectByVisibleText(stateDropDown, dataMap.get("State"));
		KeywordUtil.click(okButton);
		KeywordUtil.waitForInVisibile(okButton);
		LogUtil.infoLog(thisClass, "Address has been filled.");*/
	}

	/**
	 * House hold page.
	 *
	 * @param dataMap the data map
	 * @throws InterruptedException the interrupted exception
	 */
	public static void houseHoldPage(HashMap<String, String> dataMap) throws InterruptedException {
		/*KeywordUtil.waitForInVisibile(pleaseWait);
		KeywordUtil.waitForClickable(policyformDropDown);
		KeywordUtil.selectByVisibleText(policyformDropDown, dataMap.get("PolicyForm"));
		KeywordUtil.waitForInVisibile(pleaseWait);
		KeywordUtil.click(radioButtonIsThisANewHomeNo);
		KeywordUtil.click(radioButtonWithin1000FeetOfAFireHydrantYes);
		KeywordUtil.selectByVisibleText(noOfMonthsOccupiedPerYear, dataMap.get("NoOfMonthsOccupiedPerYear"));
		KeywordUtil.selectByVisibleText(noOfMonthsRentedPerYear, dataMap.get("NoOfMonthsRentedPerYear"));
		KeywordUtil.inputText(firstName, dataMap.get("FirstName"));
		KeywordUtil.inputText(lastName, dataMap.get("LastName"));
		// For Excel file data read for months with single digit like 08 add a zero on
		// your own
		KeywordUtil.inputText(dobMM, dataMap.get("MM"));
		KeywordUtil.inputText(dobDD, dataMap.get("DD"));
		KeywordUtil.inputText(dobYYYY, dataMap.get("YYYY"));
		KeywordUtil.selectByVisibleText(maritalStatus, dataMap.get("MaritalStatus"));
		KeywordUtil.waitForClickable(estimatedCreditRating);
		KeywordUtil.selectByVisibleText(estimatedCreditRating, dataMap.get("EstimatedCreditRating"));
		KeywordUtil.click(nextButtonHouseHold);
		LogUtil.infoLog(thisClass, "All details on Household page filled.");*/
		
		if(dataMap.get("MaritalStatus").isEmpty()){
			Assert.fail();
		}
	}

	/**
	 * Property page.
	 *
	 * @param dataMap the data map
	 * @throws InterruptedException the interrupted exception
	 */
	public static void propertyPage(HashMap<String, String> dataMap) throws InterruptedException {
	/*	KeywordUtil.waitForInVisibile(pleaseWait);
		KeywordUtil.waitForClickable(roofAge);
		// KeywordUtil.clearInput(roofAge);
		KeywordUtil.inputText(roofAge, dataMap.get("RoofAge"));
		KeywordUtil.selectByVisibleText(priorLiability, dataMap.get("PriorLiability"));
		// Thread.sleep(3000);
		// KeywordUtil.waitForClickable(doesSwellingHaveAluminiumSidingNo);
		// KeywordUtil.click(doesSwellingHaveAluminiumSidingNo);

		KeywordUtil.selectByVisibleText(noOfFamilyDwellingDropDown, dataMap.get("NoOfFamilyDwelling"));
		KeywordUtil.click(doesSwellingHaveAluminiumSidingNo);
		KeywordUtil.selectByVisibleText(noOfPaidClaimsInTheLast3YearsDropDown, dataMap.get("NoOfClaimsPaid"));
		KeywordUtil.click(calculateReplacementCostYes);
		KeywordUtil.waitForClickable(totalLivingArea);
		KeywordUtil.clearInput(totalLivingArea);
		KeywordUtil.inputText(totalLivingArea, dataMap.get("TotalLivingArea"));
		KeywordUtil.click(calculateReplacementCostButton);
		KeywordUtil.waitForInVisibile(pleaseWait);
		// Thread.sleep(5000);
		// KeywordUtil.waitForClickable(nextButtonPropertyPage);
		KeywordUtil.click(nextButtonPropertyPage);
		LogUtil.infoLog(thisClass, "All details on Property page filled.");*/
	}

	/**
	 * Coverage page.
	 *
	 * @param dataMap the data map
	 * @throws InterruptedException the interrupted exception
	 */
	public static void coveragePage(HashMap<String, String> dataMap) throws InterruptedException {
		/*KeywordUtil.waitForInVisibile(pleaseWait);
		KeywordUtil.waitForClickable(coverageADwelling);
		Thread.sleep(2000);
		KeywordUtil.clearInput(coverageADwelling);
		Thread.sleep(2000);
		KeywordUtil.inputText(coverageADwelling, dataMap.get("CoverageADwelling"));
		Thread.sleep(3000);
		KeywordUtil.selectByVisibleText(paymentTypeDiscountDropDown, dataMap.get("PaymentTypeDiscount"));
		KeywordUtil.click(getRateButtonCoveragePage);
		KeywordUtil.waitForInVisibile(By.id("f1:__busyStatusDialogHeader"));
		KeywordUtil.click(nextButtonCoveragePage);
		LogUtil.infoLog(thisClass, "All details on Coverage page filled.");*/
	}

	/**
	 * Point of sale page.
	 *
	 * @param dataMap the data map
	 * @throws InterruptedException the interrupted exception
	 */
	public static void pointOfSalePage(HashMap<String, String> dataMap) throws InterruptedException {
		// initial
/*		KeywordUtil.waitForClickable(radioButtonEverBeenRejectedNo);
		KeywordUtil.click(radioButtonEverBeenRejectedNo);
		KeywordUtil.waitForClickable(radioButtonCertifyThatTheDwellingYes);
		KeywordUtil.click(radioButtonCertifyThatTheDwellingYes);
		KeywordUtil.waitForClickable(radioButtonTreeHouseInPremisesNo);
		KeywordUtil.click(radioButtonTreeHouseInPremisesNo);
		KeywordUtil.click(radioButton5OrMoreAcresYes);
		KeywordUtil.waitForClickable(radioButtonPropertyManagementFirmNo);
		KeywordUtil.click(radioButtonPropertyManagementFirmNo);
		KeywordUtil.waitForClickable(radioButtonICertifyThatIYes);
		KeywordUtil.click(radioButtonICertifyThatIYes);
		KeywordUtil.click(nextButtonXpathPointOfSalePageOne);
		LogUtil.infoLog(thisClass, "Next button on Point of Sale page clicked once.");

		// after clicking next first time
		KeywordUtil.waitForClickable(yearHeatingRenovated);
		KeywordUtil.clearInput(yearHeatingRenovated);
		KeywordUtil.inputText(yearHeatingRenovated, dataMap.get("YearHeatingRenovated"));
		KeywordUtil.click(radioButtonSameMailingAddressYes);
		KeywordUtil.click(radioButtonPropertyWithCityLimitsNo);
		KeywordUtil.click(radioButtonGenderMale);
		KeywordUtil.inputText(ssn, dataMap.get("SSN"));
		KeywordUtil.inputText(emailAddress, dataMap.get("Email"));
		KeywordUtil.inputText(homePhone1, dataMap.get("Phone1"));
		KeywordUtil.inputText(homePhone2, dataMap.get("Phone2"));
		KeywordUtil.inputText(homePhone3, dataMap.get("Phone3"));
		KeywordUtil.click(radioButtonHowLongLivingAtTheAddress5YearsOrMore);
		KeywordUtil.click(radioButtonReportsOrderedForThePrimaryInsuredYes);
		Thread.sleep(5000);
		// KeywordUtil.waitForInVisibile(By.id("f1:__busyStatusDialogHeader"));
		KeywordUtil.waitForClickable(orderCreditReportButton);
		KeywordUtil.click(orderCreditReportButton);
		KeywordUtil.waitForInVisibile(pleaseWait);
		KeywordUtil.click(orderClueReportButton);
		KeywordUtil.waitForInVisibile(pleaseWait);
		KeywordUtil.click(getRateButtonPonitOfSaleAfterClickingNextFirstTime);
		KeywordUtil.waitForInVisibile(pleaseWait);
		KeywordUtil.waitForClickable(nextButtonXpathPointOfSalePageTwo);
		KeywordUtil.click(nextButtonXpathPointOfSalePageTwo);
		LogUtil.infoLog(thisClass, "Next button on Point of Sale page clicked second time.");*/
	}

	/**
	 * Click authorize.
	 */
	public static void clickAuthorize() {
		/*// After Clicking Next Button Third Time
		KeywordUtil.waitForClickable(submitForAuthorizationButton);
		KeywordUtil.click(submitForAuthorizationButton);
		KeywordUtil.waitForClickable(okayButton);
		KeywordUtil.click(okayButton);
		LogUtil.infoLog(thisClass, "Application for Insurance submitted.");*/
	}

	/**
	 * Verify theresult.
	 */
	public static void verifyTheresult() {
		/*KeywordUtil.waitForClickable(tableRowForVerification);
		List<WebElement> webElementsList = GlobalUtil.getDriver().findElements(tableRowForVerification);
		statusOfAuthorization = webElementsList.get(4).getText();
		assertEquals(statusOfAuthorization, "Pending Authorization", "Authorization is Pending from Admin");
		LogUtil.infoLog(thisClass, "Verification Completed.");*/
	}

	/**
	 * Logout.
	 * @throws InterruptedException 
	 */
	public static void logout() throws InterruptedException {
		Thread.sleep(4000);
		KeywordUtil.click(usernameDetailsInHeader);
		KeywordUtil.click(logoutButton);
	}

}
