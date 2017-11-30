package step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import mantisutil.MantisReport;
import testlink.api.java.client.TestLinkAPIResults;
import utilities.ConfigReader;
import utilities.DriverUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;
import utilities.LogUtil;


public class Hooks{
	
	@Before("@MaxBupaWebTest")
	public void beforeMethodMaxBupaWebTest(Scenario scenario){   			
		LogUtil.infoLog(getClass(),
				"\n+----------------------------------------------------------------------------------------------------------------------------+");
		LogUtil.infoLog(getClass(), "Test Started: " + scenario.getName());

		LogUtil.infoLog("Test Environment", "Test is executed in Environment: "+ GlobalUtil.getCommonSettings().getExecutionEnv());

		LogUtil.infoLog("TestStarted", "Test is started with browser: "+ GlobalUtil.getCommonSettings().getBrowser());
		GlobalUtil.setDriver(DriverUtil.getBrowser(GlobalUtil.getCommonSettings().getExecutionEnv(),GlobalUtil.getCommonSettings().getBrowser()));
	}
	
	@Before("@BarneysWebTest")
	public void beforeMethodBarneysWebTest(Scenario scenario){   			
		LogUtil.infoLog(getClass(),
				"\n+----------------------------------------------------------------------------------------------------------------------------+");
		LogUtil.infoLog(getClass(), "Test Started: " + scenario.getName());

		LogUtil.infoLog("Test Environment", "Test is executed in Environment: "+ GlobalUtil.getCommonSettings().getExecutionEnv());

		LogUtil.infoLog("TestStarted", "Test is started with browser: "+ GlobalUtil.getCommonSettings().getBrowser());
		GlobalUtil.setDriver(DriverUtil.getBrowser(GlobalUtil.getCommonSettings().getExecutionEnv(),GlobalUtil.getCommonSettings().getBrowser()));
	}

	@Before("@Webtest")
	public void beforeMethod(Scenario scenario){   			
		LogUtil.infoLog(getClass(),
				"\n+----------------------------------------------------------------------------------------------------------------------------+");
		LogUtil.infoLog(getClass(), "Test Started: " + scenario.getName());

		LogUtil.infoLog("Test Environment", "Test is executed in Environment: "+ GlobalUtil.getCommonSettings().getExecutionEnv());

		LogUtil.infoLog("TestStarted", "Test is started with browser: "+ GlobalUtil.getCommonSettings().getBrowser());
		GlobalUtil.setDriver(DriverUtil.getBrowser(GlobalUtil.getCommonSettings().getExecutionEnv(),GlobalUtil.getCommonSettings().getBrowser()));
	}
	
	@Before("@WebtestAcceptance")
	public void beforeMethodAcceptance(Scenario scenario){   			
		LogUtil.infoLog(getClass(),
				"\n+----------------------------------------------------------------------------------------------------------------------------+");
		LogUtil.infoLog(getClass(), "Test Started: " + scenario.getName());

		LogUtil.infoLog("Test Environment", "Test is executed in Environment: "+ GlobalUtil.getCommonSettings().getExecutionEnv());

		LogUtil.infoLog("TestStarted", "Test is started with browser: "+ GlobalUtil.getCommonSettings().getBrowser());
		GlobalUtil.setDriver(DriverUtil.getBrowser(GlobalUtil.getCommonSettings().getExecutionEnv(),GlobalUtil.getCommonSettings().getBrowser()));
	}
	
	@Before("@WebtestSmoke")
	public void beforeMethodSmoke(Scenario scenario){   			
		LogUtil.infoLog(getClass(),
				"\n+----------------------------------------------------------------------------------------------------------------------------+");
		LogUtil.infoLog(getClass(), "Test Started: " + scenario.getName());

		LogUtil.infoLog("Test Environment", "Test is executed in Environment: "+ GlobalUtil.getCommonSettings().getExecutionEnv());

		LogUtil.infoLog("TestStarted", "Test is started with browser: "+ GlobalUtil.getCommonSettings().getBrowser());
		GlobalUtil.setDriver(DriverUtil.getBrowser(GlobalUtil.getCommonSettings().getExecutionEnv(),GlobalUtil.getCommonSettings().getBrowser()));
	}

	@Before("@APItests")
	public void beforeAPIMethod(Scenario scenario){   			
		LogUtil.infoLog(getClass(),
				"\n+----------------------------------------------------------------------------------------------------------------------------+");
		LogUtil.infoLog(getClass(), "API Test Started: " + scenario.getName());
		LogUtil.infoLog("Test Started", "Test is started using base URL: "+ GlobalUtil.getCommonSettings().getRestURL());
	}
	
	@Before("@APItestsAcceptance")
	public void beforeAPIMethodAcceptance(Scenario scenario){   			
		LogUtil.infoLog(getClass(),
				"\n+----------------------------------------------------------------------------------------------------------------------------+");
		LogUtil.infoLog(getClass(), "API Test Started: " + scenario.getName());
		LogUtil.infoLog("Test Started", "Test is started using base URL: "+ GlobalUtil.getCommonSettings().getRestURL());
	}
	
	@Before("@APItestsSmoke")
	public void beforeAPIMethodSmoke(Scenario scenario){   			
		LogUtil.infoLog(getClass(),
				"\n+----------------------------------------------------------------------------------------------------------------------------+");
		LogUtil.infoLog(getClass(), "API Test Started: " + scenario.getName());
		LogUtil.infoLog("Test Started", "Test is started using base URL: "+ GlobalUtil.getCommonSettings().getRestURL());
	}

	@Before("@MobileTest")
	public void beforeMobileMethod(Scenario scenario){
		LogUtil.infoLog(getClass(),
				"\n+----------------------------------------------------------------------------------------------------------------------------+");
		LogUtil.infoLog(getClass(), "Mobile Tests Started: " + scenario.getName());

		LogUtil.infoLog("Mobile Test Environment", "Mobile Test is executed in OS: "+ GlobalUtil.getCommonSettings().getAndroidName());

		GlobalUtil.setMDriver(DriverUtil.getMobileApp());
	}
	
	@Before("@MobileTestAcceptance")
	public void beforeMobileMethodAcceptance(Scenario scenario){
		LogUtil.infoLog(getClass(),
				"\n+----------------------------------------------------------------------------------------------------------------------------+");
		LogUtil.infoLog(getClass(), "Mobile Tests Started: " + scenario.getName());

		LogUtil.infoLog("Mobile Test Environment", "Mobile Test is executed in OS: "+ GlobalUtil.getCommonSettings().getAndroidName());

		GlobalUtil.setMDriver(DriverUtil.getMobileApp());
	}
	
	@Before("@MobileTestSmoke")
	public void beforeMobileMethodSmoke(Scenario scenario){
		LogUtil.infoLog(getClass(),
				"\n+----------------------------------------------------------------------------------------------------------------------------+");
		LogUtil.infoLog(getClass(), "Mobile Tests Started: " + scenario.getName());

		LogUtil.infoLog("Mobile Test Environment", "Mobile Test is executed in OS: "+ GlobalUtil.getCommonSettings().getAndroidName());

		GlobalUtil.setMDriver(DriverUtil.getMobileApp());
	}


	@After("@Webtest")
	public void afterMethod(Scenario scenario) {
		String testName = scenario.getName().split("_")[0].trim();
		if(scenario.isFailed()) {
			try {
				String scFileName = "ScreenShot_"+System.currentTimeMillis();
				String screenshotFilePath = ConfigReader.getValue("screenshotPath")+"\\"+scFileName+".png";
				scenario.write("Current Page URL is " + GlobalUtil.getDriver().getCurrentUrl());

				byte[] screenshot = KeywordUtil.takeScreenshot(screenshotFilePath);
				scenario.embed(screenshot, "image/png");

				//report the bug
				String bugID = "Please check the Bug tool Configuration";
				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Mantis")){
					bugID = MantisReport.reporIssue(scenario.getName(), GlobalUtil.ErrorMsg, "General", "Automated on Browser: "+GlobalUtil.getCommonSettings().getBrowser()+" and Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber(), screenshotFilePath);
				}

				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Jira")){
					//getting the os name to report the bug
					String osName = System.getProperty("os.name"); 
					if(GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Remote")){
						osName = GlobalUtil.getCommonSettings().getRemoteOS();
					}
					bugID = GlobalUtil.jiraapi.reporIssue(scenario.getName(), "Automated on OS: "+osName+",\n Automated on Browser: "+GlobalUtil.getCommonSettings().getBrowser()+",\n Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber()+". \n\n\n\n"+GlobalUtil.ErrorMsg, screenshotFilePath);
				}

				//updating the results in Testmangement tool
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
					GlobalUtil.testlinkapi.updateTestLinkResult(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, TestLinkAPIResults.TEST_PASSED);
				}
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
					GlobalUtil.jiraapi.updateJiraTestResults(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, "Fail");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		else{

			LogUtil.infoLog("TestEnded", "Test has ended closing browser: "+ GlobalUtil.getCommonSettings().getBrowser());
			//updating the results in Testmangement tool
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
				GlobalUtil.testlinkapi.updateTestLinkResult(testName, "This test is passed", TestLinkAPIResults.TEST_PASSED);
			}
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
				GlobalUtil.jiraapi.updateJiraTestResults(testName, "This test is passed", "Pass");
			}
		}

		//close the browsers
		DriverUtil.closeAllDriver();
	}
	
	@After("@WebtestAcceptance")
	public void afterMethodAcceptance(Scenario scenario) {
		String testName = scenario.getName().split("_")[0].trim();
		if(scenario.isFailed()) {
			try {
				String scFileName = "ScreenShot_"+System.currentTimeMillis();
				String screenshotFilePath = ConfigReader.getValue("screenshotPath")+"\\"+scFileName+".png";
				scenario.write("Current Page URL is " + GlobalUtil.getDriver().getCurrentUrl());

				byte[] screenshot = KeywordUtil.takeScreenshot(screenshotFilePath);
				scenario.embed(screenshot, "image/png");

				//report the bug
				String bugID = "Please check the Bug tool Configuration";
				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Mantis")){
					bugID = MantisReport.reporIssue(scenario.getName(), GlobalUtil.ErrorMsg, "General", "Automated on Browser: "+GlobalUtil.getCommonSettings().getBrowser()+" and Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber(), screenshotFilePath);
				}

				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Jira")){
					//getting the os name to report the bug
					String osName = System.getProperty("os.name"); 
					if(GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Remote")){
						osName = GlobalUtil.getCommonSettings().getRemoteOS();
					}
					bugID = GlobalUtil.jiraapi.reporIssue(scenario.getName(), "Automated on OS: "+osName+",\n Automated on Browser: "+GlobalUtil.getCommonSettings().getBrowser()+",\n Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber()+". \n\n\n\n"+GlobalUtil.ErrorMsg, screenshotFilePath);
				}

				//updating the results in Testmangement tool
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
					GlobalUtil.testlinkapi.updateTestLinkResult(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, TestLinkAPIResults.TEST_PASSED);
				}
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
					GlobalUtil.jiraapi.updateJiraTestResults(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, "Fail");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		else{

			LogUtil.infoLog("TestEnded", "Test has ended closing browser: "+ GlobalUtil.getCommonSettings().getBrowser());
			//updating the results in Testmangement tool
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
				GlobalUtil.testlinkapi.updateTestLinkResult(testName, "This test is passed", TestLinkAPIResults.TEST_PASSED);
			}
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
				GlobalUtil.jiraapi.updateJiraTestResults(testName, "This test is passed", "Pass");
			}
		}

		//close the browsers
		DriverUtil.closeAllDriver();
	}
	
	@After("@WebtestSmoke")
	public void afterMethodSmoke(Scenario scenario) {
		String testName = scenario.getName().split("_")[0].trim();
		if(scenario.isFailed()) {
			try {
				String scFileName = "ScreenShot_"+System.currentTimeMillis();
				String screenshotFilePath = ConfigReader.getValue("screenshotPath")+"\\"+scFileName+".png";
				scenario.write("Current Page URL is " + GlobalUtil.getDriver().getCurrentUrl());

				byte[] screenshot = KeywordUtil.takeScreenshot(screenshotFilePath);
				scenario.embed(screenshot, "image/png");

				//report the bug
				String bugID = "Please check the Bug tool Configuration";
				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Mantis")){
					bugID = MantisReport.reporIssue(scenario.getName(), GlobalUtil.ErrorMsg, "General", "Automated on Browser: "+GlobalUtil.getCommonSettings().getBrowser()+" and Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber(), screenshotFilePath);
				}

				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Jira")){
					//getting the os name to report the bug
					String osName = System.getProperty("os.name"); 
					if(GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Remote")){
						osName = GlobalUtil.getCommonSettings().getRemoteOS();
					}
					bugID = GlobalUtil.jiraapi.reporIssue(scenario.getName(), "Automated on OS: "+osName+",\n Automated on Browser: "+GlobalUtil.getCommonSettings().getBrowser()+",\n Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber()+". \n\n\n\n"+GlobalUtil.ErrorMsg, screenshotFilePath);
				}

				//updating the results in Testmangement tool
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
					GlobalUtil.testlinkapi.updateTestLinkResult(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, TestLinkAPIResults.TEST_PASSED);
				}
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
					GlobalUtil.jiraapi.updateJiraTestResults(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, "Fail");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		else{

			LogUtil.infoLog("TestEnded", "Test has ended closing browser: "+ GlobalUtil.getCommonSettings().getBrowser());
			//updating the results in Testmangement tool
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
				GlobalUtil.testlinkapi.updateTestLinkResult(testName, "This test is passed", TestLinkAPIResults.TEST_PASSED);
			}
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
				GlobalUtil.jiraapi.updateJiraTestResults(testName, "This test is passed", "Pass");
			}
		}

		//close the browsers
		DriverUtil.closeAllDriver();
	}

	@After("@APItests")
	public void afterAPIMethod(Scenario scenario) {
		String testName = scenario.getName().split("_")[0].trim();
		if(scenario.isFailed()) {
			try {

				//report the bug
				String bugID = "Please check the Bug tool Configuration";
				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Mantis")){
					bugID = MantisReport.reporIssue(scenario.getName(), GlobalUtil.ErrorMsg, "General", " Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber(), "RestAPI");
				}

				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Jira")){
					//getting the os name to report the bug
					String osName = System.getProperty("os.name"); 
					if(GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Remote")){
						osName = GlobalUtil.getCommonSettings().getRemoteOS();
					}
					bugID = GlobalUtil.jiraapi.reporIssue(scenario.getName(), "Automated on OS: "+osName+"on Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber()+". \n\n\n\n"+GlobalUtil.ErrorMsg, "RestAPI");
				}

				//updating the results in Testmangement tool
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
					GlobalUtil.testlinkapi.updateTestLinkResult(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, TestLinkAPIResults.TEST_PASSED);
				}
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
					GlobalUtil.jiraapi.updateJiraTestResults(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, "Fail");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		else{

			LogUtil.infoLog("TestEnded", "API Test has ended ");
			//updating the results in Testmangement tool
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
				GlobalUtil.testlinkapi.updateTestLinkResult(testName, "This test is passed", TestLinkAPIResults.TEST_PASSED);
			}
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
				GlobalUtil.jiraapi.updateJiraTestResults(testName, "This test is passed", "Pass");
			}
		}

		//close the browsers
		DriverUtil.closeAllDriver();
	}
	
	@After("@APItestsAcceptance")
	public void afterAPIMethodAcceptance(Scenario scenario) {
		String testName = scenario.getName().split("_")[0].trim();
		if(scenario.isFailed()) {
			try {

				//report the bug
				String bugID = "Please check the Bug tool Configuration";
				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Mantis")){
					bugID = MantisReport.reporIssue(scenario.getName(), GlobalUtil.ErrorMsg, "General", " Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber(), "RestAPI");
				}

				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Jira")){
					//getting the os name to report the bug
					String osName = System.getProperty("os.name"); 
					if(GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Remote")){
						osName = GlobalUtil.getCommonSettings().getRemoteOS();
					}
					bugID = GlobalUtil.jiraapi.reporIssue(scenario.getName(), "Automated on OS: "+osName+"on Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber()+". \n\n\n\n"+GlobalUtil.ErrorMsg, "RestAPI");
				}

				//updating the results in Testmangement tool
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
					GlobalUtil.testlinkapi.updateTestLinkResult(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, TestLinkAPIResults.TEST_PASSED);
				}
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
					GlobalUtil.jiraapi.updateJiraTestResults(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, "Fail");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		else{

			LogUtil.infoLog("TestEnded", "API Test has ended ");
			//updating the results in Testmangement tool
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
				GlobalUtil.testlinkapi.updateTestLinkResult(testName, "This test is passed", TestLinkAPIResults.TEST_PASSED);
			}
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
				GlobalUtil.jiraapi.updateJiraTestResults(testName, "This test is passed", "Pass");
			}
		}

		//close the browsers
		DriverUtil.closeAllDriver();
	}
	
	@After("@APItestsSmoke")
	public void afterAPIMethodSmoke(Scenario scenario) {
		String testName = scenario.getName().split("_")[0].trim();
		if(scenario.isFailed()) {
			try {

				//report the bug
				String bugID = "Please check the Bug tool Configuration";
				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Mantis")){
					bugID = MantisReport.reporIssue(scenario.getName(), GlobalUtil.ErrorMsg, "General", " Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber(), "RestAPI");
				}

				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Jira")){
					//getting the os name to report the bug
					String osName = System.getProperty("os.name"); 
					if(GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Remote")){
						osName = GlobalUtil.getCommonSettings().getRemoteOS();
					}
					bugID = GlobalUtil.jiraapi.reporIssue(scenario.getName(), "Automated on OS: "+osName+"on Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber()+". \n\n\n\n"+GlobalUtil.ErrorMsg, "RestAPI");
				}

				//updating the results in Testmangement tool
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
					GlobalUtil.testlinkapi.updateTestLinkResult(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, TestLinkAPIResults.TEST_PASSED);
				}
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
					GlobalUtil.jiraapi.updateJiraTestResults(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, "Fail");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		else{

			LogUtil.infoLog("TestEnded", "API Test has ended ");
			//updating the results in Testmangement tool
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
				GlobalUtil.testlinkapi.updateTestLinkResult(testName, "This test is passed", TestLinkAPIResults.TEST_PASSED);
			}
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
				GlobalUtil.jiraapi.updateJiraTestResults(testName, "This test is passed", "Pass");
			}
		}

		//close the browsers
		DriverUtil.closeAllDriver();
	}

	@After("@MobileTest")
	public void afterMobileMethod(Scenario scenario){
		String testName = scenario.getName().split("_")[0].trim();
		if(scenario.isFailed()) {
			try {
				String scFileName = "ScreenShot_"+System.currentTimeMillis();
				String screenshotFilePath = ConfigReader.getValue("screenshotPath")+"\\"+scFileName+".png";

				byte[] screenshot = KeywordUtil.takeMobileScreenshot(screenshotFilePath);
				scenario.embed(screenshot, "image/png");

				//report the bug
				String bugID = "Please check the Bug tool Configuration";
				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Mantis")){
					bugID = MantisReport.reporIssue(scenario.getName(), GlobalUtil.ErrorMsg, "General", "Automated on Android Device Version: "+GlobalUtil.getCommonSettings().getAndroidVersion()+" and Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber(), screenshotFilePath);
				}

				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Jira")){
					bugID = GlobalUtil.jiraapi.reporIssue(scenario.getName(), "Automated on Android Device Version: "+GlobalUtil.getCommonSettings().getAndroidVersion()+",\n Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber()+". \n\n\n\n"+GlobalUtil.ErrorMsg, screenshotFilePath);
				}

				//updating the results in Testmangement tool
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
					GlobalUtil.testlinkapi.updateTestLinkResult(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, TestLinkAPIResults.TEST_PASSED);
				}
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
					GlobalUtil.jiraapi.updateJiraTestResults(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, "Fail");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		else{

			LogUtil.infoLog("TestEnded", "Test has ended closing Application: "+ GlobalUtil.getCommonSettings().getAndroidName());
			//updating the results in Testmangement tool
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
				GlobalUtil.testlinkapi.updateTestLinkResult(testName, "This test is passed", TestLinkAPIResults.TEST_PASSED);
			}
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
				GlobalUtil.jiraapi.updateJiraTestResults(testName, "This test is passed", "Pass");
			}
		}

		//close the browsers
		GlobalUtil.getMDriver().quit();
	}
	
	@After("@MobileTestAcceptance")
	public void afterMobileMethodAcceptance(Scenario scenario){
		String testName = scenario.getName().split("_")[0].trim();
		if(scenario.isFailed()) {
			try {
				String scFileName = "ScreenShot_"+System.currentTimeMillis();
				String screenshotFilePath = ConfigReader.getValue("screenshotPath")+"\\"+scFileName+".png";

				byte[] screenshot = KeywordUtil.takeMobileScreenshot(screenshotFilePath);
				scenario.embed(screenshot, "image/png");

				//report the bug
				String bugID = "Please check the Bug tool Configuration";
				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Mantis")){
					bugID = MantisReport.reporIssue(scenario.getName(), GlobalUtil.ErrorMsg, "General", "Automated on Android Device Version: "+GlobalUtil.getCommonSettings().getAndroidVersion()+" and Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber(), screenshotFilePath);
				}

				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Jira")){
					bugID = GlobalUtil.jiraapi.reporIssue(scenario.getName(), "Automated on Android Device Version: "+GlobalUtil.getCommonSettings().getAndroidVersion()+",\n Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber()+". \n\n\n\n"+GlobalUtil.ErrorMsg, screenshotFilePath);
				}

				//updating the results in Testmangement tool
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
					GlobalUtil.testlinkapi.updateTestLinkResult(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, TestLinkAPIResults.TEST_PASSED);
				}
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
					GlobalUtil.jiraapi.updateJiraTestResults(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, "Fail");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		else{

			LogUtil.infoLog("TestEnded", "Test has ended closing Application: "+ GlobalUtil.getCommonSettings().getAndroidName());
			//updating the results in Testmangement tool
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
				GlobalUtil.testlinkapi.updateTestLinkResult(testName, "This test is passed", TestLinkAPIResults.TEST_PASSED);
			}
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
				GlobalUtil.jiraapi.updateJiraTestResults(testName, "This test is passed", "Pass");
			}
		}

		//close the browsers
		GlobalUtil.getMDriver().quit();
	}
	
	@After("@MobileTestSmoke")
	public void afterMobileMethodSmoke(Scenario scenario){
		String testName = scenario.getName().split("_")[0].trim();
		if(scenario.isFailed()) {
			try {
				String scFileName = "ScreenShot_"+System.currentTimeMillis();
				String screenshotFilePath = ConfigReader.getValue("screenshotPath")+"\\"+scFileName+".png";

				byte[] screenshot = KeywordUtil.takeMobileScreenshot(screenshotFilePath);
				scenario.embed(screenshot, "image/png");

				//report the bug
				String bugID = "Please check the Bug tool Configuration";
				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Mantis")){
					bugID = MantisReport.reporIssue(scenario.getName(), GlobalUtil.ErrorMsg, "General", "Automated on Android Device Version: "+GlobalUtil.getCommonSettings().getAndroidVersion()+" and Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber(), screenshotFilePath);
				}

				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Jira")){
					bugID = GlobalUtil.jiraapi.reporIssue(scenario.getName(), "Automated on Android Device Version: "+GlobalUtil.getCommonSettings().getAndroidVersion()+",\n Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber()+". \n\n\n\n"+GlobalUtil.ErrorMsg, screenshotFilePath);
				}

				//updating the results in Testmangement tool
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
					GlobalUtil.testlinkapi.updateTestLinkResult(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, TestLinkAPIResults.TEST_PASSED);
				}
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
					GlobalUtil.jiraapi.updateJiraTestResults(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, "Fail");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		else{

			LogUtil.infoLog("TestEnded", "Test has ended closing Application: "+ GlobalUtil.getCommonSettings().getAndroidName());
			//updating the results in Testmangement tool
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
				GlobalUtil.testlinkapi.updateTestLinkResult(testName, "This test is passed", TestLinkAPIResults.TEST_PASSED);
			}
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
				GlobalUtil.jiraapi.updateJiraTestResults(testName, "This test is passed", "Pass");
			}
		}

		//close the browsers
		GlobalUtil.getMDriver().quit();
	}
	
	@After("@BarneysWebTest")
	public void afterMethodBarneysWebTest(Scenario scenario) {
		String testName = scenario.getName().split("_")[0].trim();
		if(scenario.isFailed()) {
			try {
				String scFileName = "ScreenShot_"+System.currentTimeMillis();
				String screenshotFilePath = ConfigReader.getValue("screenshotPath")+"\\"+scFileName+".png";
				scenario.write("Current Page URL is " + GlobalUtil.getDriver().getCurrentUrl());

				byte[] screenshot = KeywordUtil.takeScreenshot(screenshotFilePath);
				scenario.embed(screenshot, "image/png");

				//report the bug
				String bugID = "Please check the Bug tool Configuration";
				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Mantis")){
					bugID = MantisReport.reporIssue(scenario.getName(), GlobalUtil.ErrorMsg, "General", "Automated on Browser: "+GlobalUtil.getCommonSettings().getBrowser()+" and Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber(), screenshotFilePath);
				}

				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Jira")){
					//getting the os name to report the bug
					String osName = System.getProperty("os.name"); 
					if(GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Remote")){
						osName = GlobalUtil.getCommonSettings().getRemoteOS();
					}
					bugID = GlobalUtil.jiraapi.reporIssue(scenario.getName(), "Automated on OS: "+osName+",\n Automated on Browser: "+GlobalUtil.getCommonSettings().getBrowser()+",\n Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber()+". \n\n\n\n"+GlobalUtil.ErrorMsg, screenshotFilePath);
				}

				//updating the results in Testmangement tool
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
					GlobalUtil.testlinkapi.updateTestLinkResult(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, TestLinkAPIResults.TEST_PASSED);
				}
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
					GlobalUtil.jiraapi.updateJiraTestResults(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, "Fail");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		else{

			LogUtil.infoLog("TestEnded", "Test has ended closing browser: "+ GlobalUtil.getCommonSettings().getBrowser());
			//updating the results in Testmangement tool
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
				GlobalUtil.testlinkapi.updateTestLinkResult(testName, "This test is passed", TestLinkAPIResults.TEST_PASSED);
			}
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
				GlobalUtil.jiraapi.updateJiraTestResults(testName, "This test is passed", "Pass");
			}
		}

		//close the browsers
		DriverUtil.closeAllDriver();
	}
	
	@After("@MaxBupaWebTest")
	public void afterMethodMaxBupaWebTest(Scenario scenario) {
		String testName = scenario.getName().split("_")[0].trim();
		if(scenario.isFailed()) {
			try {
				String scFileName = "ScreenShot_"+System.currentTimeMillis();
				String screenshotFilePath = ConfigReader.getValue("screenshotPath")+"\\"+scFileName+".png";
				scenario.write("Current Page URL is " + GlobalUtil.getDriver().getCurrentUrl());

				byte[] screenshot = KeywordUtil.takeScreenshot(screenshotFilePath);
				scenario.embed(screenshot, "image/png");

				//report the bug
				String bugID = "Please check the Bug tool Configuration";
				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Mantis")){
					bugID = MantisReport.reporIssue(scenario.getName(), GlobalUtil.ErrorMsg, "General", "Automated on Browser: "+GlobalUtil.getCommonSettings().getBrowser()+" and Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber(), screenshotFilePath);
				}

				if(GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Jira")){
					//getting the os name to report the bug
					String osName = System.getProperty("os.name"); 
					if(GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Remote")){
						osName = GlobalUtil.getCommonSettings().getRemoteOS();
					}
					bugID = GlobalUtil.jiraapi.reporIssue(scenario.getName(), "Automated on OS: "+osName+",\n Automated on Browser: "+GlobalUtil.getCommonSettings().getBrowser()+",\n Build Name: "+GlobalUtil.getCommonSettings().getBuildNumber()+". \n\n\n\n"+GlobalUtil.ErrorMsg, screenshotFilePath);
				}

				//updating the results in Testmangement tool
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
					GlobalUtil.testlinkapi.updateTestLinkResult(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, TestLinkAPIResults.TEST_PASSED);
				}
				if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
					GlobalUtil.jiraapi.updateJiraTestResults(testName, "Please find the BUGID in "+GlobalUtil.getCommonSettings().getBugToolName()+" : "+bugID, "Fail");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		else{

			LogUtil.infoLog("TestEnded", "Test has ended closing browser: "+ GlobalUtil.getCommonSettings().getBrowser());
			//updating the results in Testmangement tool
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")){
				GlobalUtil.testlinkapi.updateTestLinkResult(testName, "This test is passed", TestLinkAPIResults.TEST_PASSED);
			}
			if(GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")){
				GlobalUtil.jiraapi.updateJiraTestResults(testName, "This test is passed", "Pass");
			}
		}

		//close the browsers
		DriverUtil.closeAllDriver();
	}

}