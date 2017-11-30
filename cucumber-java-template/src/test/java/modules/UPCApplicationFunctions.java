package modules;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.GlobalUtil;
import utilities.KeywordUtil;
import utilities.LogUtil;

public class UPCApplicationFunctions {

	static Class thisClass = UPCApplicationFunctions.class;
	static List<WebElement> webElementsList;
	static String refernceNumber;
	static String statusOfAuthorization;

	static By pleaseWait = By.id("f1:__busyStatusDialogHeader");

	static By userName = By.xpath(".//*[@id='j_username']");
	static By password = By.xpath(".//div[@class='loginuserfield']/input[@name='j_password']");
	static By loginButton = By.xpath(".//div[@class='loginbtn']/input[@value='Login']");

	//static By yesButton = By.xpath(".//a[@id='FCRAConsentForm:j_id20']/span[text()='Yes']");
	static By yesButton = By.xpath(".//a[@id='FCRAConsentForm:j_id21']/span[text()='Yes']");
	//*[@id='FCRAConsentForm:j_id21']

	static By searchButton = By.xpath(".//a[@id='f0:CB_0_4']/span[contains(text(),'Search')]");
	static By startANewQuoteButton = By.xpath(".//a[@id='f0:CB_0_4']/span[contains(text(),'Start a New Quote')]");

	static By address = By.xpath(".//*[@id='c452_Addrmp_f:_rowRepeat:0:_cellRepeat:1:_adl1']");
	static By city = By.xpath(".//*[@id='c452_Addrmp_f:_rowRepeat:1:_cellRepeat:1:_city']");
	static By zipCode = By.xpath(".//*[@id='c452_Addrmp_f:_rowRepeat:2:_cellRepeat:1:_zip']");
	static By stateDropDown = By.xpath(".//*[@id='c452_Addrmp_f:_rowRepeat:1:_cellRepeat:3:_st']");
	static By okButton = By.xpath(".//*[@id='c452_Addrmp_f:_OKButton']/span[@class='btnSpn']");

	static By policyformDropDown = By.xpath(".//*[@id='f1:c184_1186']");
	static By radioButtonIsThisANewHomeNo = By.xpath(".//*[@id='f1:c213_913:1']");
	static By radioButtonWithin1000FeetOfAFireHydrantYes = By.xpath(".//*[@id='f1:c213_894:0']");
	static By noOfMonthsOccupiedPerYear = By.xpath(".//*[@id='f1:c213_1041']");
	static By noOfMonthsRentedPerYear = By.id("f1:c213_1258");
	static By firstName = By.xpath(".//*[@id='f1:c219_825']");
	static By lastName = By.xpath(".//*[@id='f1:c219_953']");
	static By dobMM = By.xpath(".//*[@id='f1:c219_7371m']");
	static By dobDD = By.xpath(".//*[@id='f1:c219_7372d']");
	static By dobYYYY = By.xpath(".//*[@id='f1:c219_7373y']");
	static By maritalStatus = By.xpath(".//*[@id='f1:c219_982']");
	static By estimatedCreditRating = By.xpath(".//select[@id='f1:c219_712']");
	static By nextButtonHouseHold = By.xpath(".//a[@id='f1:bHouseholdCB__294']/span[@class='tskBtnSpn']");

	static By roofAge = By.xpath(".//*[@id='f1:c213_1283']");
	static By priorLiability = By.xpath(".//*[@id='f1:c219_1172']");
	static By doesSwellingHaveAluminiumSidingNo = By.xpath(".//*[@id='f1:c213_841:1']");
	static By noOfFamilyDwellingDropDown = By.xpath(".//*[@id='f1:c213_1030']");
	static By noOfPaidClaimsInTheLast3YearsDropDown = By.xpath(".//*[@id='f1:c465_tr:c465__adp:0::c465_DL_c209_596']");
	static By calculateReplacementCostYes = By.xpath(".//*[@id='f1:c213_898:0']");
	static By totalLivingArea = By.xpath(".//*[@id='f1:c213_1322']");
	static By calculateReplacementCostButton = By.xpath(".//*[@id='f1:CB_478_179']/span[@class='btnSpn']");
	static By nextButtonPropertyPage = By.xpath(".//a[@id='f1:tPropertyCB__294']/span[@class='tskBtnSpn']");

	static By coverageADwelling = By
			.xpath(".//*[@id='f1:c398_pi:0:c490_tr:c490__adp:0:c490__adp:0::c490_TB_c399_686']");
	static By paymentTypeDiscountDropDown = By
			.xpath(".//*[@id='f1:c398_pi:0:c490_tr:c490__adp:5:c490__adp:0::c490_DL_c399_686']");
	static By getRateButtonCoveragePage = By.xpath(".//*[@id='f1:_1CB_162_176']/span[@class='btnSpn']");
	static By nextButtonCoveragePage = By.xpath(".//*[@id='f1:bCoverageCB__294']/span[@class='tskBtnSpn']");

	static By radioButtonEverBeenRejectedNo = By.xpath(".//*[@id='f1:c526_tr:c526__adp:0::c526_R_c205_596:1']");
	static By radioButtonCertifyThatTheDwellingYes = By.xpath(".//*[@id='f1:c516_tr:c516__adp:0::c516_R_c209_596:0']");
	static By radioButton5OrMoreAcresYes = By.xpath(".//*[@id='f1:c516_tr:c516__adp:1::c516_R_c209_596:0']");
	static By radioButtonPropertyManagementFirmNo = By.xpath(".//*[@id='f1:c516_tr:c516__adp:2::c516_R_c209_596:1']");
	static By radioButtonTreeHouseInPremisesNo = By.xpath(".//*[@id='f1:c516_tr:c516__adp:3::c516_R_c209_596:1']");
	static By radioButtonICertifyThatIYes = By.xpath(".//*[@id='f1:c517_tr:c517__adp:0::c517_R_c203_596:0']");
	static By nextButtonXpathPointOfSalePageOne = By
			.xpath(".//*[@id='f1:bUnderwritingCB__294']/span[@class='tskBtnSpn']");

	static By yearHeatingRenovated = By.xpath(".//*[@id='f1:c213_1468']");
	static By radioButtonSameMailingAddressYes = By.xpath(".//*[@id='f1:c184_911:0']");
	static By radioButtonPropertyWithCityLimitsNo = By.xpath(".//*[@id='f1:c353_tr:c353__adp:0::c353_R_c209_596:1'] ");
	static By radioButtonGenderMale = By.xpath(".//*[@id='f1:c368_dt:0:c368_st:0:c219_835:0']");
	static By emailAddress = By.xpath(".//*[@id='f1:c368_dt:0:c368_st:0:c219_788']");
	static By ssn = By.xpath(".//*[@id='f1:c368_dt:0:c368_st:0:c219_1316']");
	static By homePhone1 = By.xpath(".//*[@id='f1:c368_dt:0:c368_st:0:c356_PhArea']");
	static By homePhone2 = By.xpath(".//*[@id='f1:c368_dt:0:c368_st:0:c356_PhPrefix']");
	static By homePhone3 = By.xpath(".//*[@id='f1:c368_dt:0:c368_st:0:c356_PhSuffix']");
	static By radioButtonHowLongLivingAtTheAddress5YearsOrMore = By
			.xpath(".//*[@id='f1:c368_dt:0:c368_st:0:c219_1472:1']");
	static By radioButtonReportsOrderedForThePrimaryInsuredYes = By
			.xpath(".//*[@id='f1:c368_dt:0:c368_st:0:c362_tr:c362__adp:0::c362_R_c205_596:0']");
	static By orderCreditReportButton = By
			.xpath(".//a[@id='f1:CB_368_328']/span[contains(text(),'Order Credit Report')]");
	static By orderClueReportButton = By.xpath(".//*[@id='f1:CB_366_327']/span[@class='btnSpn']");
	static By getRateButtonPonitOfSaleAfterClickingNextFirstTime = By
			.xpath(".//*[@id='f1:_2CB_372_177']/span[contains(text(),'Get Rate')]");
	static By nextButtonXpathPointOfSalePageTwo = By
			.xpath(".//*[@id='f1:bPointOfSaleCB__294']/span[@class='tskBtnSpn']");

	static By submitForAuthorizationButton = By
			.xpath(".//a[@id='f1:CB_6_506']/span[contains(text(),'Submit for Authorization')]");
	static By okayButton = By.xpath(".//*[@id='f2:c0_9']");
	static By tableRowForVerification = By.xpath(".//tbody[@id='f0:c27_dt:tb']/tr/td");

	static By usernameDetailsInHeader = By.xpath(".//*[@id='Wrapper']//span[contains(text(),'Welcome')]");
	static By logoutButton = By.xpath(".//*[@id='userMore']//span[text()='Logout']");

	public static void login(String sUsername, String sPassword) {
		KeywordUtil.inputText(userName, sUsername);
		KeywordUtil.inputText(password, sPassword);
		KeywordUtil.waitForClickable(loginButton);
		KeywordUtil.click(loginButton);
		KeywordUtil.waitForClickable(yesButton);
		LogUtil.infoLog(thisClass, "Login is Successfull with :" + sUsername);
	}

	public static void startANewQuote() {
		KeywordUtil.click(yesButton);
		KeywordUtil.waitForInVisibile(yesButton);
		KeywordUtil.waitForInVisibile(pleaseWait);
		KeywordUtil.click(searchButton);
		KeywordUtil.waitForClickable(startANewQuoteButton);
		KeywordUtil.click(startANewQuoteButton);
		KeywordUtil.waitForClickable(address);
		LogUtil.infoLog(thisClass, "A New Quote page opened.");
	}

	public static void fillAddress(HashMap<String, String> dataMap) {
		KeywordUtil.waitForInVisibile(pleaseWait);
		KeywordUtil.inputText(address, dataMap.get("Address"));
		KeywordUtil.inputText(city, dataMap.get("City"));
		KeywordUtil.inputText(zipCode, dataMap.get("ZipCode"));
		KeywordUtil.selectByVisibleText(stateDropDown, dataMap.get("State"));
		KeywordUtil.click(okButton);
		KeywordUtil.waitForInVisibile(okButton);
		LogUtil.infoLog(thisClass, "Address has been filled.");
	}

	public static void houseHoldPage(HashMap<String, String> dataMap) throws InterruptedException {
		KeywordUtil.waitForInVisibile(pleaseWait);
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
		LogUtil.infoLog(thisClass, "All details on Household page filled.");
	}

	public static void propertyPage(HashMap<String, String> dataMap) throws InterruptedException {
		KeywordUtil.waitForInVisibile(pleaseWait);
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
		LogUtil.infoLog(thisClass, "All details on Property page filled.");
	}

	public static void coveragePage(HashMap<String, String> dataMap) throws InterruptedException {
		KeywordUtil.waitForInVisibile(pleaseWait);
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
		LogUtil.infoLog(thisClass, "All details on Coverage page filled.");
	}

	public static void pointOfSalePage(HashMap<String, String> dataMap) throws InterruptedException {
		// initial
		KeywordUtil.waitForClickable(radioButtonEverBeenRejectedNo);
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
		LogUtil.infoLog(thisClass, "Next button on Point of Sale page clicked second time.");
	}

	public static void clickAuthorize() {
		// After Clicking Next Button Third Time
		KeywordUtil.waitForClickable(submitForAuthorizationButton);
		KeywordUtil.click(submitForAuthorizationButton);
		KeywordUtil.waitForClickable(okayButton);
		KeywordUtil.click(okayButton);
		LogUtil.infoLog(thisClass, "Application for Insurance submitted.");
	}

	public static void verifyTheresult() {
		KeywordUtil.waitForClickable(tableRowForVerification);
		List<WebElement> webElementsList = GlobalUtil.getDriver().findElements(tableRowForVerification);
		statusOfAuthorization = webElementsList.get(4).getText();
		assertEquals(statusOfAuthorization, "Pending Authorization", "Authorization is Pending from Admin");
		LogUtil.infoLog(thisClass, "Verification Completed.");
	}

	public static void logout() {
		KeywordUtil.click(usernameDetailsInHeader);
		KeywordUtil.click(logoutButton);
	}

}
