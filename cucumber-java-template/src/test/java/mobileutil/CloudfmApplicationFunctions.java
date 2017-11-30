package mobileutil;

import utilities.GlobalUtil;
import utilities.LogUtil;

public class CloudfmApplicationFunctions extends MobileKeywords {

	public static int pasttasknum;
	public static String logging_step;

	//********************************Allow Popup*********************/
	public static void Checkpopup() throws InterruptedException
	{
		executionDelay(5000);

		if (isWebElementPresent(AndriodConstants.Cloudfm.pop_up_allow, AndriodConstants.Common.type_xpath)==true)
		{
			click(AndriodConstants.Cloudfm.pop_up_allow, AndriodConstants.Common.type_xpath);

			if (isWebElementPresent(AndriodConstants.Cloudfm.pop_up_allow, AndriodConstants.Common.type_xpath)==true)
			{
				click(AndriodConstants.Cloudfm.pop_up_allow, AndriodConstants.Common.type_xpath);
				if (isWebElementPresent(AndriodConstants.Cloudfm.pop_up_allow, AndriodConstants.Common.type_xpath)==true)
				{
					click(AndriodConstants.Cloudfm.pop_up_allow, AndriodConstants.Common.type_xpath);
				}
			}
		}
	}	
	//********************************Login to cloudfm application*********************/
	public static Boolean loginToApplication(String mobileNo, String password) throws InterruptedException {

		Boolean flag=false;

		//Checkpopup();
		switchContext();
		explicitWaitForElement(AndriodConstants.Cloudfm.input_uname_webview_name, AndriodConstants.Common.type_name);
		LogUtil.infoLog(thisClass, "Verify and Enter User Name on input text field");
		writeInInput(AndriodConstants.Cloudfm.input_uname_webview_name, AndriodConstants.Common.type_name, mobileNo);

		LogUtil.infoLog(thisClass, "Verify and Enter Password on input text field");
		writeInInput(AndriodConstants.Cloudfm.input_pwd_webview_name, AndriodConstants.Common.type_name, password);

		GlobalUtil.getMDriver().hideKeyboard();
		
		LogUtil.infoLog(thisClass, "Verify and click on SignIn Button");
		click(AndriodConstants.Cloudfm.btn_signIn, AndriodConstants.Common.type_xpath);
		return flag;
	}

	//*************************I agree button (pop up during application launch *******/
	public static void VerifyIagreebutton() throws InterruptedException
	{ 
		switchContext1();
		explicitWaitForElement(AndriodConstants.Cloudfm.btn_agree, AndriodConstants.Common.type_xpath);
		if (isWebElementPresent(AndriodConstants.Cloudfm.btn_agree, AndriodConstants.Common.type_xpath) == true) {
			//System.out.println(isWebElementPresent(AndriodConstants.Cloudfm.btn_agree, AndriodConstants.Common.type_xpath));
			LogUtil.infoLog(thisClass, "Verify and click on Iagree Button");
			click(AndriodConstants.Cloudfm.btn_agree, AndriodConstants.Common.type_xpath);
		}

	}

	//***************verify Agenda button in home page and click on it**********************************************/
	public static boolean verifyAgendaAndClick() {
		switchContext();
		boolean flag=false;
		explicitWaitForElement(AndriodConstants.Cloudfm.btn_Agenda_home, AndriodConstants.Common.type_xpath);
		if(isWebElementPresent(AndriodConstants.Cloudfm.btn_Agenda_home, AndriodConstants.Common.type_xpath))
		{
			LogUtil.infoLog(thisClass, "Verify and click on Agenda Button");
			click(AndriodConstants.Cloudfm.btn_Agenda_home, AndriodConstants.Common.type_xpath);
			
			flag = true;
		}
		switchContext1();
		return flag;
	}

	//***************verify agenda page and check for sync button if visible returns true***************************/ 
	public static boolean MyAgendaPage() throws InterruptedException
	{boolean flag=false;
	//explicitWaitForElement(AndriodConstants.Cloudfm.MyAgenda_page, AndriodConstants.Common.type_xpath);
	if(isWebElementPresent(AndriodConstants.Cloudfm.MyAgenda_page, AndriodConstants.Common.type_xpath))
	{
		LogUtil.infoLog(thisClass, "Verify Sync Button");
		isWebElementPresent(AndriodConstants.Cloudfm.btn_Sync, AndriodConstants.Common.type_xpath);
		flag=true;
	}
	return flag;	
	}

	//***************verify next button in timesheet***************************/ 
	public static boolean nextButtonInTimesheet() throws InterruptedException
	{boolean flag=false;
	switchContext();
	explicitWaitForElement(AndriodConstants.Cloudfm.btn_nextatTimesheet, AndriodConstants.Common.type_xpath);
	LogUtil.infoLog(thisClass, "Verify and click on Next Button");
	click(AndriodConstants.Cloudfm.btn_nextatTimesheet, AndriodConstants.Common.type_xpath);
	//executionDelay(3000);
	flag=MyAgendaPage();
	if(isWebElementPresent(AndriodConstants.Cloudfm.Supervisors_page, AndriodConstants.Common.type_xpath))
	{
		LogUtil.infoLog(thisClass, "Verify Supervisors Header label");
		isWebElementPresent(AndriodConstants.Cloudfm.Supervisors_page, AndriodConstants.Common.type_xpath);
		flag=true;
	}
	return flag;
	}

	//***************verify sync button and check whether the numbers for each of the pages like past, future etc are updated or not*************************/
	public static boolean VerifySyncFunctionality() throws InterruptedException
	{boolean flag=false;switchContext();
	LogUtil.infoLog(thisClass, "Verify and click on Sync Button");
	click(AndriodConstants.Cloudfm.btn_Sync, AndriodConstants.Common.type_xpath);
	explicitWaitForElement(AndriodConstants.Cloudfm.Agenda_past_number, AndriodConstants.Common.type_xpath);
	LogUtil.infoLog(thisClass, "Verify Past Task Header label Present");
	isWebElementPresent(AndriodConstants.Cloudfm.Agenda_past_number, AndriodConstants.Common.type_xpath);
	flag= true;
	//executionDelay(1000);
	switchContext1();
	return flag;
	}

	//***************verify past page elements whether the number updated by applying sync is same as the number of task or not**********************/
	public static boolean verifyPastFuntionality() throws InterruptedException
	{switchContext();
	boolean flag=false; int pasttasks=Integer.parseInt(GetTextOfElement(AndriodConstants.Cloudfm.Agenda_pasttasknumber));
	LogUtil.infoLog(thisClass, "Verify and click on Past task Number Option");
	click(AndriodConstants.Cloudfm.Agenda_past_number, AndriodConstants.Common.type_xpath);
	//executionDelay(1000);
	if(pasttasks>0)
	{
		LogUtil.infoLog(thisClass, "Verify Past Task header label");
		isWebElementPresent(AndriodConstants.Cloudfm.Agenda_pasttasks, AndriodConstants.Common.type_xpath);
		flag=true;
	}
	else{
		LogUtil.infoLog(thisClass, "Verify Past Task header label Not Present");
		isWebElementNotPresent(AndriodConstants.Cloudfm.Agenda_pasttasks, AndriodConstants.Common.type_xpath);
		flag=true;
	}
	switchContext1();
	return flag;
	}

	//***************verify past page elemnts by clicking on it, if the number is greater than zero task related details need to validated**************************/ 
	public static boolean verifyPastPage() throws InterruptedException
	{ boolean flag=false; switchContext();
	for(int i=0;i<=pasttasknum;i++)
	{
		LogUtil.infoLog(thisClass, "Verify Task label");
		isWebElementPresent(AndriodConstants.Cloudfm.page_Grouptasks_task, AndriodConstants.Common.type_xpath);
		LogUtil.infoLog(thisClass, "Verify Status label");
		isWebElementPresent(AndriodConstants.Cloudfm.page_Grouptasks_status, AndriodConstants.Common.type_xpath);
		LogUtil.infoLog(thisClass, "Verify Disipline label");
		isWebElementPresent(AndriodConstants.Cloudfm.page_Grouptasks_disipline, AndriodConstants.Common.type_xpath);
		LogUtil.infoLog(thisClass, "Verify client label");
		isWebElementPresent(AndriodConstants.Cloudfm.page_Grouptasks_client, AndriodConstants.Common.type_xpath);
		LogUtil.infoLog(thisClass, "Verify building label");
		isWebElementPresent(AndriodConstants.Cloudfm.page_Grouptasks_building, AndriodConstants.Common.type_xpath);
		LogUtil.infoLog(thisClass, "Verify Odd Jobs label");
		isWebElementPresent(AndriodConstants.Cloudfm.page_Grouptasks_oddjobs, AndriodConstants.Common.type_xpath);
		LogUtil.infoLog(thisClass, "Verify Email site report label");
		isWebElementPresent(AndriodConstants.Cloudfm.page_Grouptasks_emailsiteReport, AndriodConstants.Common.type_xpath);

		if(pasttasknum==i)
		{
			flag=true;
			break;
		} 
	}
	switchContext1();
	return flag;
	}

	//***************verify description details in each of the tasks present**************************/ 
	public static boolean verifyDetailsDescription() throws InterruptedException{
		boolean flag=false;switchContext();
		flag=VerifyDetailsDescription(AndriodConstants.Cloudfm.page_Grouptasks_details,AndriodConstants.Common.type_xpath,"Details",AndriodConstants.Cloudfm.page_Grouptasks_task_description,AndriodConstants.Common.type_xpath);
		switchContext1();
		return flag;
	}

}