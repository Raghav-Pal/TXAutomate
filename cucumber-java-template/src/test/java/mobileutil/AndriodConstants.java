package mobileutil;

import org.openqa.selenium.By;

public class AndriodConstants {
	public class Common {
		public static final String type_xpath = "xPath";
		public static final String type_name = "name";
		public static final String type_id = "id";
		public static final String type_class = "classname";
	}

	public static class Cloudfm {

		public static By msg_resendpaswd1 = By.xpath("//div[@id='resdivAttempt']");
		public static By msg_incorrectmobile = By.id("divBadLogin");
		public static By engineerName = By.xpath("//tr[contains(th,'Engineer:')]/td[1]");
		public static By Startdate = By.xpath("//li[contains(text(),'Day start')]/span");
		public static By Enddate = By.xpath("//li[contains(text(),'Day end')]/span");
		public static By msg_DayText = By.xpath("//*[@id='myDavid']/div/div[1]/div/div/div[2]/ul/li[4]");
		public static By dayNDate_timesheet = By.className("panel-title");
		public static By date_headings = By.xpath("//h3[@class='panel-title']");
		public static By Agenda_taskdate = By.xpath("//li[@class='list-group-item taskHeader']/strong");
		public static By Agenda_pasttasknumber = By.xpath("//li[normalize-space(text())= 'Past']/span");
		public static By Agenda_Todaytasknumber = By.xpath("//li[normalize-space(text())= 'Today']/span");
		public static By Agenda_Tomorrowtasknumber = By.xpath("//li[normalize-space(text())= 'Tomorrow']/span");
		public static By Agenda_Futuretasknumber = By.xpath("//li[normalize-space(text())= 'Future']/span");
		public static By txt_buildingScanedmsg = By.xpath("//*[@id='nebulousContainer']/div/div/p[1]");
		public static By msg_avtar_page = By.xpath("//*[@id='promptContainer']/div/div/div/text()");
		public static By msg_error_log = By.xpath("//div[@id='divAlertBox']");
		public static By btn_oddoJobs_agendaPage = By.xpath("//button[contains(text(),'Odd jobs')]");
		public static By txt_minutes = By.id("txtTravelTime");
		public static By txt_miles = By.id("txtMileageToSite");

		public static final String input_vechileodd = "endOdm";
		public static final String badlogin_msg = "divBadLogin";
		public static final String btn_Forgotpassword = ".//*[@content-desc='Forgot Password?']";
		public static final String btn_resendpasswrd = ".//*[@content-desc='Resend Password']";
		public static final String input_mobileAtResend = ".//android.widget.EditText[@resource-id='exampleInputEmail1']";
		public static final String Resend_message = ".//*[@resource-id='resdivAttempt']";
		public static final String input_mobileNo = "//android.widget.EditText[@text='Mobile Number Mobile']";
		public static final String btn_signin = "//android.view.View[@content-desc='Sign in']";
		public static final String msg_resendpaswd = "//div[@id='resdivAttempt']";
		public static final String message_alphanumeric = "//android.view.View[@content-desc='Your Mobile number Is Not Recognised']";
		public static final String message_pinnumbersent = "//div[@id='resdivAttempt']";
		public static final String img_cloudfmLogo = "//android.view.View[@content-desc='index']";
		public static final String btn_Agenda = "//android.view.View[contains(@content-desc,'Agenda')]";
		public static final String btn_version = "//*[@class='badge pull-right spanCurrentVersion']";
		public static final String page_updated = "//*[@id='nebulousContainer']/div/div/h3";
		public static final String btn_downloadUpdate = "//div[normalize-space(text())= 'Download update']";
		public static final String input_buildingname = "//*[@id='txtFilterBuilding']";
		public static final String btn_avtar = "//img[@class='avatar-btn']";
		public static final String msg_avtar = "//android.view.View[@content-desc='"
				+ MobileKeywords.GetValue("avtar_messg") + "'] ";
		// public static final String
		// txt_engineerName=""+Utility.GetValue("Engineername")+"";
		public static final String btn_QRscanner = "//img[@src='images/engineerApp/SVG/scanqr.svg']";
		public static final String btn_proceedatHome = "//*[@id='btnListQR']/div/span";
		public static final String btn_phoneSymbolatHome = "//img[@src='images/engineerApp/SVG/checkin.svg']";
		public static final String btn_client = "//android.view.View[contains(@content-desc,'Clients')]";
		public static final String btn_avtarBack = "//div[text()='Back']";
		public static final String btn_ExitAtClient = "//android.view.View[contains(@content-desc,'Exit')]";
		public static final String btn_Refresh = "//android.view.View[@resource-id='btnUpdateClients']";
		public static final String msg_Qrcodedwnload = "//android.view.View[@content-desc='Downloading QR Codes']";
		public static final String img_demo = "//android.widget.Image[@resource-id='demo123']";
		public static final String page_BeginOrEnd = "//android.view.View[@content-desc='Begin / End Day']";
		public static final String txt_engineerName = "//*[contains(@content-desc,''";
		public static final String avtar_Agenda = "//android.widget.Image[@clickable='false']";
		public static final String input_vechileodo = "//input[@type='tel']";
		public static final String btn_Beginday = "//*[@content-desc='Begin Day']";
		public static final String btn_Endday = "//div[text()='End Day']";
		// android.view.View[text()[normalize-space() = 'sheet']]
		public static final String btn_Timesheet = "//android.view.View[@instance='22']";
		public static final String symbol_next = "//android.view.View[@instance='41']";
		public static final String msg_Beginday = "//android.view.View[@content-desc='Starting day']";
		public static final String msg_Endday = "//android.view.View[@content-desc='Ending day']";
		public static final String Date_daystart = "//android.view.View[starts-with(@content-desc,'Day start')]";
		public static final String Date_dayEnd = "//android.view.View[starts-with(@content-desc,'Day end')]";
		public static final String btn_startNewDay = "//div[contains(text(),'Start a new')]";
		public static final String Mnday_timesheet = "//td[contains(text(),'Monday')]";
		public static final String Begin_odo = "//*[contains(text(),'Begin')]";
		public static final String End_odo = "//*[contains(text(),'End')]";
		public static final String btn_TimesheetatAgenda = "//a[contains(.,'Timesheet')]";
		public static final String btn_ExitAtTimehSheet = "//*[contains(text(),'Exit')]";
		public static final String Table_timesheet = "//*[contains(@id,'00:00:00.000Z')]/table";
		public static final String btn_nextatTimesheet = "//*[@id='mainFooter']/div/div[3]/span";
		public static final String btn_Sync = "//li[@class='list-group-item ']/div";
		public static final String Agenda_past = "//li[normalize-space(text())= 'Past']";
		public static final String Agenda_today = "//li[normalize-space(text())='Today']";
		public static final String Agenda_tomorw = "//li[normalize-space(text())='Tomorrow']";
		public static final String Agenda_future = "//li[normalize-space(text())='Future']";
		public static final String Agenda_Exit = "//*[normalize-space(text())='Exit']";
		public static final String btn_beforeAtAgenda = "//*[@id='mainFooter']/div/div[1]/span";
		public static final String Past_tasks = "//li[@class='list-group-item taskHeader']/strong";
		public static final String Agenda_past_number = "//li[normalize-space(text())= 'Past']/span";
		public static final String Agenda_Today_number = "//li[normalize-space(text())= 'Today']/span";
		public static final String Agenda_Tomorrow_number = "//li[normalize-space(text())= 'Tomorrow']/span";
		public static final String Agenda_Future_number = "//li[normalize-space(text())= 'Future']/span";
		public static final String MyAgenda_page = "//*[normalize-space(text())= 'My Agenda']";
		public static final String Supervisors_page = "//*[normalize-space(text())= 'Supervisors']";
		public static final String Agenda_pasttasks = "//li[@class='list-group-item taskHeader']/strong";
		public static final String page_Grouptasks_previous = "//*[@id='myDavid']/div/div[2]/div/div[2]/div/div/div/div[1]/span";
		public static final String page_Grouptasks_task = "//li[normalize-space(text())= 'Task:']";
		public static final String page_Grouptasks_status = "//li[normalize-space(text())= 'Status:']";
		public static final String page_Grouptasks_details = "//*[normalize-space(text())= 'Details']";
		public static final String page_Grouptasks_task_description = "//*[normalize-space(text())= 'Task Description']";
		public static final String page_Grouptasks_disipline = "//li[normalize-space(text())= 'Discipline:']";
		public static final String page_Grouptasks_client = "//li[normalize-space(text())= 'Client:']";
		public static final String page_Grouptasks_building = "//li[normalize-space(text())= 'Building:']";
		public static final String page_Grouptasks_oddjobs = "//div[contains(text(),'Odd jobs')]";
		public static final String page_Grouptasks_emailsiteReport = "//a[normalize-space(text())= 'Email site report']";
		public static final String page_past_heading = "//li[normalize-space(text())= 'Past']";
		public static final String page_today_heading = "//li[normalize-space(text())= 'Today']";
		public static final String page_tommorrow_heading = "//li[normalize-space(text())= 'Tomorrow']";
		public static final String page_future_heading = "//li[normalize-space(text())= 'Future']";
		public static final String Building_link = "//*[contains(@content-desc,'"
				+ MobileKeywords.GetValue("BuildingName") + "')]";
		public static final String Building_name = "//*[contains(text(),'" + MobileKeywords.GetValue("BuildingName")
				+ "')]";
		public static final String Distance_details = "//*[@id='alerts']/div";
		public static final String btn_Continue_wv = "//*[contains(text(),'Continue')]";
		public static final String input_minutes = "//*[@id='txtTravelTime']";
		public static final String input_miles = "//*[@id='txtMileageToSite']";
		public static final String page_BuildingCheckin = "//*[text()='Building Check in']";
		public static final String page_confirmCheckin = "//*[text()='Confirm Check in']";
		public static final String btn_checkout = "//*[@id='btnCheckOut']";
		public static final String proceed = "//*[@id='btnProceedAfterTaskList']";
		public static final String Exit_confirmCheckin = "//*[@id='mainFooter']/div/a";
		public static final String img_Phone = "//*[@id='btnTelCheckIn']";
		public static final String pge_Phonecheckin = "//ul[contains(li,'Phone')]";
		public static final String msg_checkin = "//li[contains(a,'check-in')]";
		public static final String msg_helpdesk = "//li[contains(a,'helpdesk')]";
		public static final String btn_settings_options = "//div[@id='btnSettings']";
		public static final String btn_pmvVideos_options = "//div[@id='btnPMV']";
		public static final String btn_Help_options = "//div[@id='NbtnHelp']";
		public static final String btn_Logout_options = "//div[@id='btnLogout']";
		public static final String btn_refresh_options = "//div[@id='btnRefreshApp']";
		public static final String btn_reset_options = "//div[@id='btnDataReset']";
		public static final String btn_sendlog_options = "//div[@class='btnSendErrorLog btn btn-info']";
		public static final String msg_alter_option = "//android.widget.TextView[@text='Data storage cleared - restarting']";
		public static final String btn_ok = "//android.widget.Button[@text='OK']";
		public static final String btn_options_home = "//div[text()='Options']";
		public static final String btn_Agenda_home = "//div[text()='Agenda']";
		public static final String btn_Clients_home = "//div[text()='Clients']";
		public static final String btn_oddoJobs_agendaPage1 = "//button[contains(text(),'Odd jobs')]";
		public static final String btn_Remote_scaneout = "//span[text()='Remote Scan Out']";
		public static final String RemoteScanout_reason_id = "remoteCheckoutReason";
		public static final String btn_check_out_id = "btnCheckOut";
		public static final String btn_settings_version = "//*[@id='mainFooter']/div/div[2]";
		public static final String btn_msg_buildng_3rdpage = "//*[@id='nebulousContainer']/div/div[2]";

		public static final String pop_up_allow = "//android.widget.Button[@text='Allow']";

		public static final String input_password = "//android.widget.EditText[@text='Password']";
		public static final String input_uname_webview_name = "signInMobile";
		public static final String input_pwd_webview_name = "signInPassCode";
		// public static final String btn_signIn="//div[contains(@id,'loginBtn')]";
		public static final String btn_signIn = "//div[@id='loginBtn']";
		public static final String btn_signIn1 = "//android.widget.Button[@index='15']";
		public static final String btn_ListQR = "//button[contains(@id,'btnListQR')]";
		public static final String btn_Clients = "//div[contains(@class,'btnChangeClient')][contains(.,'Clients')]";

		public static final String btn_agree = "//android.view.View[@content-desc='I Agree']";
		// android.view.View[@content-desc='I Agree']
		// public static final String btn_agree="//div[@id='btnAgreeTerms']";
		public static final String btn_options = "//android.view.View[contains(@content-desc,'Options')]";
		public static final String btn_logout = "//android.widget.Button[@resource-id='btnLogout']";
		public static final String btn_settings = "//android.widget.Button[@resource-id='btnSettings']";
		public static final String btn_PMV = "//android.widget.Button[@resource-id='btnPMV']";
		public static final String hdr_signIn = "//android.view.View[@content-desc='Sign in']";
		public static final String btn_sendlog = "//android.widget.Button[contains(@content-desc,'Send log')]";
		public static final String a1 = "//android.view.View[@resource-id='mainFooter']//android.view.View[@index='0']//android.view.View[contains(@content-desc,'I Agree')]";
		public static final String testingxpertbuilding = "//android.view.View[contains(@content-desc,'Testing Xperts Building(Xperts)')]";
		public static final String btn_Continue = "//android.view.View[contains(@content-desc,'Continue')]";
		public static final String btn_proceed = "//android.widget.Button[contains(@resource-id,'btnProceedAfterTaskList')]";
		public static final String btn_view_task = "//android.widget.Button[contains(@content-desc,'View Task')][@index='2']";
		public static final String btn_begin = "//android.view.View[contains(@content-desc,'Begin')]";
		public static final String btn_Complete = "//div[contains(@data-status,'Complete')][contains(.,'Complete')]";
		public static final String btn_Complete1 = "//div[contains(@data-status,'Com1plete')][contains(.,'Complete')]";
		public static final String btn_confirmComplete = "//div[@id='btnCheckInConfirm'][contains(.,'Continue')]";
		public static final String input1 = "//android.widget.EditText[contains(.,'Type task closure notes here')]";
		public static final String input_txtNotes = "//textarea[@id='txtWorkNotes']";
		public static final String txtarea_materials = "//textarea[contains(@id,'txtMaterialsUsed')]";
		public static final String btn_material_no = "//button[contains(@id,'btnMatsUsedN')][contains(.,'No')]";
		public static final String btn_material_yes = "//button[@id='btnMatsUsedY'][contains(.,'Yes')]";
		public static final String btn_getSignature = "//div[contains(@class,'btnGetSignature')][contains(.,'Get Signature')]";
		public static final String right_arrow = "//android.view.View[@index='2']";
		public static final String input_filter = "//input[@id='txtFilterBuilding']";
		public static final String btn_building = "//android.view.View[contains(@content-desc,'Testing Xperts')]";
		public static final String tab_Complete = "//android.view.View[contains(@content-desc,'Complete')][contains(@index,'0')]";
		public static final String input_representativeName = "//input[@id='txtSignatory']";
		public static final String btn_sigSave = "//div[contains(@class,'btnSaveSignature')][contains(.,'Save')]";
		public static final String btn_taskFinish = "//div[contains(@id,'btnSubmitFinishTaskValidate')][contains(.,'Finish Task')]";
		public static final String btn_delegateAssets = "//android.view.View[contains(@content-desc,'Delegate All Assets')]";
		public static final String btn_delDelegateConfirm = "//android.view.View[contains(@content-desc,'Confirm')]";
		public static final String btn_submit = "//div[contains(@id,'btnSubmitFinishTask')][contains(.,'Submit')]";
		public static final String btn_tickMark = "//button[contains(@class,'btn btn-default btn-sm iCertify')]";
		public static final String btn_exit = "//a[contains(.,'Exit')]";
		public static final String btn_remote_scan_out = "//div[contains(@class,'btnRemoteScanOut')][contains(.,'Remote Scan Out')]";

		public static final String arrow_right = "//span[contains(@class,'pull-right')]";
		public static final String ing_cloudfm = "//div[@id='imgLogo'][@alt='CloudFM']";
		public static final String btn_current_task = "//div[contains(@class,'btnViewTask')][contains(.,'Current Task')]";
		public static final String btn_abandon_task = "//div[contains(@class,'btnAbandonTask')][contains(.,'Abandon')]";
		public static final String btn_abandon_yes_btn = "//button[contains(@class,'btnAbandonTaskYes')][contains(.,'Yes')]";
		public static final String btn_closure_not_complete = "//li[contains(@class,'danger')][contains(.,'Closure notes not completed')]";
		public static final String hdr_closure_notes = "//div[contains(@id,'ClosureNotesSlide')]";

	}

}
