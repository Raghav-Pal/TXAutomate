package mobileutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.GlobalUtil;
import utilities.LogUtil;


public class MobileKeywords {
	public static Class thisClass=MobileKeywords.class;
	public static Dimension size;
	public static int fail = 0;
	static WebElement webElement;
	public static String URL = "";
	public static boolean flag1=false;
	public static String logging_step;
	static int row = 1;
	static Logger errorLogger;
	static Logger normalLogger;
	static FileAppender normalFileApp;
	static FileAppender errorFileApp;
	static ConsoleAppender conApp;
	public static boolean isInit=false;
	public static ExtentTest test=null; 
	private static ExtentTest testHist=null;
	static PatternLayout patternLayout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p - %m%n");
	static PatternLayout consolePatternLayout = new PatternLayout("\tLOG-: [%m -  %d{yyyy-MM-dd HH:mm:ss a}] %n");
	public static AndroidDriver<AndroidElement> driver1 = GlobalUtil.getMDriver();
/*	//public static Appiumdriver1<MobileElement> driver1=null;
	public static Appiumdriver1<MobileElement> driver1 = (Appiumdriver1<MobileElement>) GlobalUtil.getdriver1();
	public static Appiumdriver1<MobileElement> driver1 = (Appiumdriver1<MobileElement>) GlobalUtil.getMdriver1();*/
	public static DesiredCapabilities capabilities = new DesiredCapabilities();


	public static String GetValue(String key)
	{
		File file = new File(System.getProperty("user.dir")+"/src/main/resources/Config/config.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		try {
			prop.load(fileInput);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		String strbaseURL = prop.getProperty(key);
		return strbaseURL;
	}

	public static int GetIntValue(String key)
	{
		File file = new File(System.getProperty("user.dir")+"/src/main/resources/Config/config.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		try {
			prop.load(fileInput);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String strbaseURL = prop.getProperty(key);
		return Integer.parseInt(strbaseURL);
	}
	/*public static boolean navigate() {

		driver1.navigate().to(GetValue("BASE_URL"));
		return true;
	}*/


	public static By locatortype(String type, String value) {

		By locName = null;
		if (type.equalsIgnoreCase("xPath")) {
			locName = By.xpath(value);
		} else if (type.equalsIgnoreCase("id")) {
			locName = By.id(value);
		} else if (type.equalsIgnoreCase("linkText")) {
			locName = By.linkText(value);
		} else if (type.equalsIgnoreCase("classname")) {
			locName = By.className(value);
		} else if (type.equalsIgnoreCase("name")) {
			locName = By.name(value);
		} else
			locName = By.partialLinkText(value);
		return locName;

	}


	public static boolean isWebElementPresent(String path, String type) {
		Boolean flag=false;
		
		if(GlobalUtil.getMDriver().findElements(MobileBy.xpath(path)).size()>0)
		{	
			flag=true;
			//LogUtil.infoLog(thisClass, "Element Present");
		}
		return flag;
	}

	public static boolean isWebElementVisible(String path, String type) {
		Boolean flag=false;
		if(GlobalUtil.getMDriver().findElements(locatortype(type, path)).size()>0)
		{	
			flag=true;
			//LogUtil.infoLog(thisClass, "Element Visible");
		}

		return flag;

	}



	public static boolean isWebElementNotPresent(String path, String type) {

		List<AndroidElement> elements = GlobalUtil.getMDriver().findElements(locatortype(type, path));

		if (elements.size() > 0) {
			System.out.println("Element Present");
			LogUtil.infoLog(thisClass,"Element present");
			return false;
		} else {
			System.out.println("Element is not Present");
			LogUtil.infoLog(thisClass, "Element Not present");

			return true;
		}
	}



	public static boolean writeInInput(String path, String type, String data) {
		//driver1=(Appiumdriver1<MobileElement>) GlobalUtil.getMdriver1();
		WebElement element = GlobalUtil.getMDriver().findElement(locatortype(type, path));

		//element.clear();
		element.sendKeys(data);

		System.out.println("Value Entered");
		LogUtil.infoLog(thisClass, "Test Data entered successfully");
		return true;

	}


	public static boolean setValue(String path, String type, String data) {
		MobileElement element = (MobileElement) GlobalUtil.getMDriver().findElement(locatortype(type, path));
		element.sendKeys(data);
		System.out.println("Value Entered");
		return true;

	}

	public static boolean enter() throws IOException
	{
		Runtime.getRuntime().exec("adb shell input keyevent 66");
		return true;	

	}


	public static boolean clearAppData() throws IOException
	{
		Runtime.getRuntime().exec("adb shell pm clear com.cloudfmgroup.cloudFMApp");
		return true;	

	}


	public static boolean swipeIOS(String path, String type, String data) {
		MobileElement element = (MobileElement) GlobalUtil.getMDriver().findElement(locatortype(type, path));
		element.setValue(data);

		System.out.println("Value Entered");
		return true;

	}



	public static boolean enterInput(String path, String type, String data) {
		WebElement element = GlobalUtil.getMDriver().findElement(locatortype(type, path));

		((JavascriptExecutor)GlobalUtil.getMDriver()).executeScript("arguments[0].value = arguments[1]", element, data);

		System.out.println("Value Entered");
		return true;

	}

	public static WebElement explicitWaitForElement(String path, String type) {
		WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), GetIntValue("explicit_timeout"));

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locatortype(type, path)));

		return element;

	}
	
	public static WebElement explicitWaitForElementfor20(String path, String type) {
		WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 15);

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locatortype(type, path)));

		return element;

	}

	public static boolean click(String path, String type) {
		//Thread.sleep(1500);
		//pause
		//driver1=(Appiumdriver1<MobileElement>) GlobalUtil.getMdriver();
		executionDelay(1500);
		//WebElement element = (explicitWaitForElement(path, type));
		WebElement element =  GlobalUtil.getMDriver().findElement(locatortype(type, path));
		element.click();
		//LogUtil.infoLog(thisClass, "Click on element successfully");
		return true;
	}



	/*public static boolean tap(String path,String type)
	{
		WebElement element = (explicitWaitForElement(path, type));
		TouchAction action = new TouchAction((IOSdriver1)driver1);
		action.tap(element).perform();
		return true;
	}*/
	/*public static void init(Class clazz){
		 if(!isInit){

		 normalLogger = Logger.getLogger(clazz+",NormalLogger");
		 normalLogger.setLevel(Level.INFO);

		 normalFileApp= new FileAppender();
		 normalFileApp.setLayout(patternLayout);
		 normalFileApp.setFile(System.getProperty("user.dir")+GetValue("logInfoFilePath"));

		 normalFileApp.setImmediateFlush(true);
		 normalLogger.addAppender(normalFileApp);
		 normalFileApp.activateOptions();

		 errorLogger = Logger.getLogger(clazz+",ErrorLogger");
		 errorLogger.setLevel(Level.ERROR);
		 errorFileApp= new FileAppender();
		 errorFileApp.setLayout(patternLayout);
		 errorFileApp.setFile(System.getProperty("user.dir")+GetValue("logErrorFilePath"));

		 errorFileApp.setImmediateFlush(true);
		 errorLogger.addAppender(errorFileApp);
		 errorFileApp.activateOptions();


		 conApp = new ConsoleAppender();
		 conApp.setLayout(consolePatternLayout);
		 conApp.setTarget("System.out");
		 conApp.activateOptions();

		 normalLogger.addAppender(conApp);


		 isInit=true;
		 }
	 }*/
	/* public static void infoLog(Class clazz,String message){
		 init(clazz); 
		 normalLogger.info(message);



	 }*/
	public static void stepInfo(String stepName){
		test.log(LogStatus.PASS, stepName);
		testHist.log(LogStatus.PASS, stepName);

	}
	/*public static void executeStep(Boolean check, Class className, String logstep) {

		try
		{

			if (check) {
				infoLog(className, logstep + "-PASS ");
				stepInfo(logstep + "-PASS");
			}
			else
			{
				infoLog(className, logstep + "-FAIL ");
				stepInfo(logstep + "-FAIL");
			}
		}catch(Exception e)
		{
			throw e;
		}
	}*/



	public static void executionDelay(long time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean verifyAllVauesOfDropDown(String path, String type, String data) {

		boolean flag = false;
		WebElement element = explicitWaitForElement(path, type);
		List<WebElement> options = element.findElements(By.tagName("option"));
		String temp = data;
		String allElements[] = temp.split(",");
		String actual;
		for (int i = 0; i < allElements.length; i++) {

			System.out.println("Actual : " + options.get(i).getText());


			System.out.println("Expected: " + allElements[i].trim());
			actual = options.get(i).getText().trim();
			if (actual.equals(allElements[i].trim())) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}

		return flag;

	}

	public boolean verifyCurrentDateInput(String path, String type) {
		boolean flag = false;
		WebElement element = explicitWaitForElement(path, type);
		String actual = element.getAttribute("value").trim();
		DateFormat DtFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		DtFormat.setTimeZone(TimeZone.getTimeZone("US/Central"));
		String expected = DtFormat.format(date).toString().trim();
		if (actual.trim().contains(expected)) {
			flag = true;

		}
		return flag;

	}

	public static Boolean validateNotesInput(String path, String type, String errorMessage) {
		Boolean flag = false;

		WebElement element = explicitWaitForElement(path, type);
		String pattern[] = { "<", ">", "(", ")", "'", "\\" };
		for (int i = 0; i < pattern.length; i++) {
			element.clear();
			element.sendKeys(pattern[i]);
			flag = isWebElementPresent(errorMessage, type);

			if (!flag) {
				break;
			}

		}

		return flag;

	}

	public boolean selectList(final String path, String type, String data) {

		Boolean flag = false;

		WebElement select = explicitWaitForElement(path, type);

		List<WebElement> options = select.findElements(By.tagName("option"));
		String expected = data.trim();
		System.out.println("Expected: " + expected);
		for (WebElement option : options) {

			String actual = option.getText().trim();
			System.out.println("Actual: " + actual);
			if (actual.equals(expected)) {

				option.click();
				flag = true;
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return flag;
			}
		}

		return flag;
	}

	public boolean verifyDropdownSelectedValue(String path, String type, String data) {

		Boolean flag = false;
		WebElement select = explicitWaitForElement(path, type);

		Select sel = new Select(select);
		String defSelectedVal = sel.getFirstSelectedOption().getText();

		if (defSelectedVal.trim().equals(data.trim())) {
			flag = true;

			return flag;
		} else {
			return flag;
		}
	}


	public static boolean verifyElementSize(String path, String type, int size) {

		List<AndroidElement> elements = GlobalUtil.getMDriver().findElements(locatortype(type, path));

		if (elements.size() == size) {
			System.out.println("Element is Present " + size + "times");
			return true;
		} else {
			System.out.println("Element is not Present with required size");

			return false;
		}
	}

	public static boolean uploadFilesUsingSendKeys(String path, String type, String data) throws InterruptedException {
		WebElement element = GlobalUtil.getMDriver().findElement(locatortype(type, path));
		element.clear();
		element.sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\uploadFiles\\" + data);
		System.out.println("Value Entered");
		return true;

	}

	public static boolean writeInInputCharByChar(String path, String type, String data) throws InterruptedException {
		WebElement element = GlobalUtil.getMDriver().findElement(locatortype(type, path));
		element.clear();
		String b[] = data.split("");

		for (int i = 0; i < b.length; i++) {

			element.sendKeys(b[i]);
			Thread.sleep(1000);

		}
		System.out.println("Value Entered");
		return true;

	}

	public static boolean isRadioSelected(String path, String type) {

		WebElement element = (explicitWaitForElement(path, type));
		if (element.isSelected()) {
			return true;
		} else {

			return false;
		}
	}

	public static boolean isRadioNotSelected(String path, String type) {

		WebElement element = (explicitWaitForElement(path, type));
		if (element.isSelected()) {
			return false;
		} else {

			return true;
		}
	}
	public static void stepPass(String stepName){
		String html= "<span style='color:green'><b>"+stepName+ "-PASS</b></span>";
		test.log(LogStatus.PASS, html);
		testHist.log(LogStatus.PASS, html);

	}
	public static void stepFail(String stepName){
		String html= "<span style='color:red'><b>"+stepName+ "-FAIL</b></span>";
		test.log(LogStatus.INFO, html);
		testHist.log(LogStatus.INFO, html);

	}
	/*public static void logResult(boolean status, String logStep ){
		if (status) {
			infoLog(MobileKeywords.class, logStep + "-PASS ");
			stepPass(logStep);
		} else {
			infoLog(MobileKeywords.class, logStep + "-FAIL ");
			stepFail(logStep);

		}


		}
	 */

	/*public static boolean selectByIndex(String path, String type, Integer index){

		boolean status = false;
		boolean elemPresent = isWebElementPresent(path, type);
		if(elemPresent){
			WebElement elem = driver1.findElement(locatortype(type, path));
			Select select = new Select(elem);
			select.selectByIndex(index);
			status = true;
			logResult(status, "Select action is performed !!!" );
			return status;
		}else{
			status = false;
			logResult(status, "No Select action performed !!!");
			return status;
		}

	}*/


	public static boolean clearInput(String path, String type) {
		WebElement element = GlobalUtil.getMDriver().findElement(locatortype(type, path));

		element.clear();

		System.out.println("input field cleared");
		return true;

	}



	public boolean delDirectory() {
		File delDestination=new File(System.getProperty("user.dir")+ "\\src\\test\\resources\\downloadFile");
		if( delDestination.exists() ) {
			File[] files = delDestination.listFiles();
			for(int i=0; i<files.length; i++) {
				if(files[i].isDirectory()) {
					delDirectory();
				}
				else {
					files[i].delete();
				}
			}
		}
		return( delDestination.delete() );
	}




	public boolean verifyCssProperty(String path, String type,String data) {

		String property[] = data.split(":",2);
		String exp_prop = property[0];
		String exp_value = property[1];
		boolean flag = false;
		String prop = (explicitWaitForElement(path, type)).getCssValue(exp_prop);
		System.out.println(prop);


		if (prop.trim().equals(exp_value.trim())) 
		{
			flag = true;
			return flag;
		}

		else
		{
			return flag;

		}



	}

	public static boolean switchContext()
	{
		boolean colFlag1=false;
		//driver1= GlobalUtil.getMDriver();
		Set<String> contextNames = GlobalUtil.getMDriver().getContextHandles();
		for (String contextName : contextNames) {
			if (contextName.contains("WEBVIEW")){
				GlobalUtil.getMDriver().context(contextName);
				//	System.out.println("switched to webview");
				colFlag1=true;
				break;
			}

		}
		return colFlag1;

	}


	public static boolean switchContext1()
	{
		boolean colFlag1=false;
		Set<String> contextNames = GlobalUtil.getMDriver().getContextHandles();
		for (String contextName : contextNames) {
			if (contextName.contains("NATIVE")){
				GlobalUtil.getMDriver().context(contextName);
				//	System.out.println("switched to native");
				colFlag1=true;
				break;
			}

		}
		return colFlag1;

	}

	public static boolean changeContext(String data)
	{
		while(!flag1)
		{
			try{
				if(data.contains("WEBVIEW"))
				{
					flag1=switchContext();
				}

				else
				{
					flag1=switchContext1();
				}
			}catch(Exception e)
			{
				if(e.getMessage().contains("NoSuchContextException"))
				{
					flag1=false;
				}
			}

		}
		flag1=false;
		return true;
	}

	public static String GetTextOfElement(By value)
	{

		WebElement element =  GlobalUtil.getMDriver().findElement(value);

		return element.getText();
	}

	public static String verifyCurrentDate() {

		DateFormat DtFormat = new SimpleDateFormat("MMM dd yyyy");
		Date date = new Date();
		DtFormat.setTimeZone(TimeZone.getTimeZone("BST"));
		String expected = DtFormat.format(date).toString().trim();
		return expected;
	}




	public static String currentdateWithDay() throws ParseException
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date1 = new Date();
		String expected=dateFormat.format(date1).toString().trim();

		String[] dateArray= expected.split("/");

		int year=Integer.parseInt(dateArray[0]);
		int month = Integer.parseInt(dateArray[1]);
		int day = Integer.parseInt(dateArray[2]);

		String dateString = String.format("%d-%d-%d", year, month, day);
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);

		return dayOfWeek;
	}

	public static String TimesheetDayAspercloudfm(String actual)
	{
		String DayaccordingtoCloudFm;
		String[] date= actual.split(" ");

		if(date[2].contains("th")||date[2].contains("st")||date[2].contains("nd")||date[2].contains("rd"))
		{
			if(date[2].length()==3)
			{String str=date[2];
			date[2]=0+str.substring(0, 1);
			//System.out.println(date[2]);
			}
			if(date[2].length()==4)
			{String str=date[2];
			date[2]=str.substring(0, 2);
			//System.out.println(date[2]);
			}
			if(date[0].length()>3)
			{String str=date[0];
			date[0]=str.substring(0, 3);
			//System.out.println(date[2]);
			date[3]=date[3].substring(0, 4);
			}
		}
		DayaccordingtoCloudFm=date[0]+" "+date[1]+" "+date[2]+" "+date[3];
		return DayaccordingtoCloudFm;
	}
	public static String TimesheetPage1()
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		String expecteddate=c.getTime().toString().trim();
		String[] expecteddateArray= expecteddate.split(" ");
		expecteddate=expecteddateArray[0]+" "+expecteddateArray[1]+" "+expecteddateArray[2]+" "+expecteddateArray[5];
		System.out.println(expecteddate);
		return expecteddate;
	}
	public static String TimesheetPage2()
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		String expecteddate=c.getTime().toString().trim();
		String[] expecteddateArray= expecteddate.split(" ");
		expecteddate=expecteddateArray[0]+" "+expecteddateArray[1]+" "+expecteddateArray[2]+" "+expecteddateArray[5];
		System.out.println(expecteddate);
		return expecteddate;
	}
	public static String TimesheetPage3()
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		String expecteddate=c.getTime().toString().trim();
		String[] expecteddateArray= expecteddate.split(" ");
		expecteddate=expecteddateArray[0]+" "+expecteddateArray[1]+" "+expecteddateArray[2]+" "+expecteddateArray[5];
		System.out.println(expecteddate);
		return expecteddate;
	}
	public static String TimesheetPage4()
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		String expecteddate=c.getTime().toString().trim();
		String[] expecteddateArray= expecteddate.split(" ");
		expecteddate=expecteddateArray[0]+" "+expecteddateArray[1]+" "+expecteddateArray[2]+" "+expecteddateArray[5];
		System.out.println(expecteddate);
		return expecteddate;
	}
	public static String TimesheetPage5()
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		String expecteddate=c.getTime().toString().trim();
		String[] expecteddateArray= expecteddate.split(" ");
		expecteddate=expecteddateArray[0]+" "+expecteddateArray[1]+" "+expecteddateArray[2]+" "+expecteddateArray[5];
		System.out.println(expecteddate);
		return expecteddate;
	}
	public static String TimesheetPage6()
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		String expecteddate=c.getTime().toString().trim();
		String[] expecteddateArray= expecteddate.split(" ");
		expecteddate=expecteddateArray[0]+" "+expecteddateArray[1]+" "+expecteddateArray[2]+" "+expecteddateArray[5];
		System.out.println(expecteddate);
		return expecteddate;
	}
	public static String TimesheetPage7()
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		String expecteddate=c.getTime().toString().trim();
		String[] expecteddateArray= expecteddate.split(" ");
		int dt= (Integer.parseInt(expecteddateArray[2]))+01;
		expecteddateArray[2]=Integer.toString(dt);
		if(expecteddateArray[2].length()<=1)
		{
			expecteddateArray[2]="0"+expecteddateArray[2];
		}
		expecteddateArray[0]="Sun";
		expecteddate=expecteddateArray[0]+" "+expecteddateArray[1]+" "+expecteddateArray[2]+" "+expecteddateArray[5];
		System.out.println(expecteddate);
		return expecteddate;
	}

	//******************************************************************New Implimention**********************************************************************
	public String GetCurrentDate(String path, String type) {
		SimpleDateFormat sdf=new SimpleDateFormat("MMM d YYYY");
		Date d=new Date();
		String Currentdate=sdf.format(d);
		return Currentdate;
	}
	public static String Gettext(String path, String type) throws InterruptedException  {
		Thread.sleep(1500);
		WebElement element =  GlobalUtil.getMDriver().findElement(locatortype(type, path));
		String s=element.getText();
		System.out.println("Text has copyed in clipboard");
		return s;
	}
	public static String GetAttribute(String path, String type) throws InterruptedException  {
		Thread.sleep(1500);
		WebElement element =  GlobalUtil.getMDriver().findElement(locatortype(type, path));
		String s=element.getAttribute("name");
		//System.out.println("Text has copyed in clipboard: "+s);
		return s;
	}


	public static String GetMondayOfCurrentWeek()
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		String expecteddate=c.getTime().toString().trim();
		String[] expecteddateArray= expecteddate.split(" ");
		expecteddate=expecteddateArray[0]+" "+expecteddateArray[1]+" "+expecteddateArray[2]+" "+expecteddateArray[5];
		System.out.println("Current Monday of the week: "+expecteddate);
		return expecteddate;
	}
	public static String GetTuesdayOfCurrentWeek()
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		String expecteddate=c.getTime().toString().trim();
		String[] expecteddateArray= expecteddate.split(" ");
		expecteddate=expecteddateArray[0]+" "+expecteddateArray[1]+" "+expecteddateArray[2]+" "+expecteddateArray[5];
		System.out.println("Current Tuesday of the week: "+expecteddate);
		return expecteddate;
	}
	public static String GetWednesdayOfCurrentWeek()
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		String expecteddate=c.getTime().toString().trim();
		String[] expecteddateArray= expecteddate.split(" ");
		expecteddate=expecteddateArray[0]+" "+expecteddateArray[1]+" "+expecteddateArray[2]+" "+expecteddateArray[5];
		System.out.println("Current Wednesday of the week: "+expecteddate);
		return expecteddate;
	}
	public static String GetThursdayOfCurrentWeek()
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		String expecteddate=c.getTime().toString().trim();
		String[] expecteddateArray= expecteddate.split(" ");
		expecteddate=expecteddateArray[0]+" "+expecteddateArray[1]+" "+expecteddateArray[2]+" "+expecteddateArray[5];
		System.out.println("Current Thrusday of the week: "+expecteddate);
		return expecteddate;
	}
	public static String GetFridayOfCurrentWeek()
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		String expecteddate=c.getTime().toString().trim();
		String[] expecteddateArray= expecteddate.split(" ");
		expecteddate=expecteddateArray[0]+" "+expecteddateArray[1]+" "+expecteddateArray[2]+" "+expecteddateArray[5];
		System.out.println("Current Friday date of the week: "+expecteddate);
		return expecteddate;
	}
	public static String GetSaturdayOfCurrentWeek()
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		String expecteddate=c.getTime().toString().trim();
		String[] expecteddateArray= expecteddate.split(" ");
		expecteddate=expecteddateArray[0]+" "+expecteddateArray[1]+" "+expecteddateArray[2]+" "+expecteddateArray[5];
		System.out.println("Current Saturday of the week: "+expecteddate);
		return expecteddate;
	}
	public static String GetSundayOfCurrentWeek()
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		String expecteddate=c.getTime().toString().trim();
		String[] expecteddateArray= expecteddate.split(" ");
		expecteddate=expecteddateArray[0]+" "+expecteddateArray[1]+" "+expecteddateArray[2]+" "+expecteddateArray[5];
		System.out.println("Current Sunday of the week: "+expecteddate);
		return expecteddate;
	}
	public static void verifyPastDate(String pastdate)
	{
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		String currentDate=verifyCurrentDate();
		System.out.println(currentDate);
		//Date date = format.parse(currentDate);
		//c1.setTime(currentDate.);
		//c2.setTime(someOtherDate);

		int yearDiff = c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
		int monthDiff = c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
		int dayDiff = c1.get(Calendar.DAY_OF_MONTH) - c2.get(Calendar.DAY_OF_MONTH);
	}
	
	public static Boolean swipeVerticalBottom() throws InterruptedException {
		Boolean flag = false;

		size = GlobalUtil.getMDriver().manage().window().getSize();
		int starty = (int) (size.height * 0.50);
		int endy = (int) (size.height * 0.10);
		int startx = size.width / 2;
		GlobalUtil.getMDriver().swipe(startx, starty, startx, endy, 3000);
		Thread.sleep(2000);
		flag = true;

		if (flag)
			return true;
		else
			return false;
	}
	
	public static boolean VerifyDetailsDescription(String path, String type,String value,String Despath,String Destype) throws InterruptedException{
		boolean flag= false;
		List<AndroidElement> alldetailsbuttons=GlobalUtil.getMDriver().findElements(locatortype(type, path));
		int buttonCount=-1;
		for( MobileElement link: alldetailsbuttons){  
			if(link.getText().equals(value)){
				buttonCount++;
				MobileElement x= GlobalUtil.getMDriver().findElements(locatortype(type, path)).get(buttonCount);
				LogUtil.infoLog(thisClass, "Verify and click on Details button");
				x.click();
				executionDelay(3000);
				LogUtil.infoLog(thisClass, "Verify Details Description label");
				isWebElementVisible(Despath,Destype);
				LogUtil.infoLog(thisClass, "Verify and click on Details button");
				x.click();
				executionDelay(3000);
				switchContext1();
				swipeVerticalBottom();
				switchContext();
				flag= true;
			}        
		} 
		return flag;
	}
	
	/*public static Boolean swipevertical() throws InterruptedException{
		Boolean flag = false;
		Dimension size = driver1.manage().window().getSize(); 
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.5);
		int startx = size.width / 2;
		//driver1.
		// driver1.swipe(startx, starty, startx, endy, 3000);
		Thread.sleep(2000);
		flag = true;

		if(flag)
			return true;
		else
			return false;
	}
*/
}	