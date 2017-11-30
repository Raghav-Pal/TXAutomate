package utilities;
/**
 * This CommonSetting class help in generate results
 *
 */
public class CommonSettings {

	private String appType;
	private String appEnviornment;
	private String projectName;
	private String emailOutput;
	private String emailId;
	private String htmlReport;
	private String xlsReport;
	private String testLogs;
	private String executionEnv;
	private String cloudProvider;
	private String hostName;
	private String key;
	private String remoteOS;
	private String BuildNumber;
	private String Browser;
	private String Url;
	private String ManageToolName;
	private String testlinkTool;
	private String testLinkHostName;
	private String testlinkAPIKey;
	private String testlinkProjectName;
	private String testlinkPlanName;
	private String jiraTestManagement;
	private String jiraCycleID;
	private String jiraProjectID;
	private String bugToolName;
	private String bugTool;
	private String bugToolHostName;
	private String bugToolUserName;
	private String bugToolPassword;
	private String bugToolProjectName;
	private String restURL;
	private String androidVersion;
	private String androidName;
	private String androidID;
	private String androidBrowser;
	


	/**
	 * @param projectName
	 * @param appType
	 * @param appEnviornment
	 * @param emailOutput
	 * @param emailId
	 * @param htmlReport
	 * @param xlsReport
	 * @param testLogs
	 * @param defectMgmt
	 * @param testMgmt
	 */
	public CommonSettings(String projectName, String appType, String appEnviornment, String emailOutput, String emailId,
			String htmlReport, String xlsReport, String testLogs, String defectMgmt, String testMgmt) {
		super();
		this.projectName = projectName;
		this.appType = appType;
		this.appEnviornment = appEnviornment;
		this.emailOutput = emailOutput;
		this.emailId = emailId;
		this.htmlReport = htmlReport;
		this.xlsReport = xlsReport;
		this.testLogs = testLogs;
	}

	/**
	 * 
	 */
	public CommonSettings() {
		super();
	}

	/**
	 * @param projectName
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @return
	 */
	public String getAppType() {
		return appType;
	}

	/**
	 * @param appType
	 */
	public void setAppType(String appType) {
		this.appType = appType;
	}

	/**
	 * @return
	 */
	public String getAppEnviornment() {
		return appEnviornment;
	}

	/**
	 * @param appEnviornment
	 */
	public void setAppEnviornment(String appEnviornment) {
		this.appEnviornment = appEnviornment;
	}

	/**
	 * @return
	 */
	public String getEmailOutput() {
		return emailOutput;
	}

	/**
	 * @param emailOutput
	 */
	public void setEmailOutput(String emailOutput) {
		this.emailOutput = emailOutput;
	}

	/**
	 * @return
	 */
	public String getEmailIds() {
		return emailId;
	}

	/**
	 * @param emailId
	 */
	public void setEmailIds(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return
	 */
	public String getHtmlReport() {
		return htmlReport;
	}

	/**
	 * @param htmlReport
	 */
	public void setHtmlReport(String htmlReport) {
		this.htmlReport = htmlReport;
	}

	/**
	 * @return
	 */
	public String getXlsReport() {
		return xlsReport;
	}

	/**
	 * @param xlsReport
	 */
	public void setXlsReport(String xlsReport) {
		this.xlsReport = xlsReport;
	}

	/**
	 * @return
	 */
	public String getTestLogs() {
		return testLogs;
	}

	/**
	 * @param testLogs
	 */
	public void setTestLogs(String testLogs) {
		this.testLogs = testLogs;
	}

	public String getExecutionEnv() {
		return executionEnv;
	}

	public void setExecutionEnv(String executionEnv) {
		this.executionEnv = executionEnv;
	}

	public String getCloudProvider() {
		return cloudProvider;
	}

	public void setCloudProvider(String cloudProvider) {
		this.cloudProvider = cloudProvider;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getRemoteOS() {
		return remoteOS;
	}

	public void setRemoteOS(String remoteOS) {
		this.remoteOS = remoteOS;
	}

	public String getBuildNumber() {
		return BuildNumber;
	}

	public void setBuildNumber(String buildNumber) {
		BuildNumber = buildNumber;
	}

	public String getBrowser() {
		return Browser;
	}

	public void setBrowser(String browser) {
		Browser = browser;
	}
	
	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getTestlinkTool() {
		return testlinkTool;
	}

	public void setTestlinkTool(String testlinkTool) {
		this.testlinkTool = testlinkTool;
	}

	public String getTestLinkHostName() {
		return testLinkHostName;
	}

	public void setTestLinkHostName(String testLinkHostName) {
		this.testLinkHostName = testLinkHostName;
	}

	public String getTestlinkAPIKey() {
		return testlinkAPIKey;
	}

	public void setTestlinkAPIKey(String testlinkAPIKey) {
		this.testlinkAPIKey = testlinkAPIKey;
	}

	public String getTestlinkProjectName() {
		return testlinkProjectName;
	}

	public void setTestlinkProjectName(String testlinkProjectName) {
		this.testlinkProjectName = testlinkProjectName;
	}

	public String getTestlinkPlanName() {
		return testlinkPlanName;
	}

	public void setTestlinkPlanName(String testlinkPlanName) {
		this.testlinkPlanName = testlinkPlanName;
	}
	
	public String getBugToolName() {
		return bugToolName;
	}

	public void setBugToolName(String bugToolName) {
		this.bugToolName = bugToolName;
	}

	public String getbugTool() {
		return bugTool;
	}

	public void setbugTool(String bugTool) {
		this.bugTool = bugTool;
	}

	public String getbugToolHostName() {
		return bugToolHostName;
	}

	public void setbugToolHostName(String bugToolHostName) {
		this.bugToolHostName = bugToolHostName;
	}

	public String getbugToolUserName() {
		return bugToolUserName;
	}

	public void setbugToolUserName(String bugToolUserName) {
		this.bugToolUserName = bugToolUserName;
	}

	public String getbugToolPassword() {
		return bugToolPassword;
	}

	public void setbugToolPassword(String bugToolPassword) {
		this.bugToolPassword = bugToolPassword;
	}

	public String getbugToolProjectName() {
		return bugToolProjectName;
	}

	public void setbugToolProjectName(String bugToolProjectName) {
		this.bugToolProjectName = bugToolProjectName;
	}

	public String getJiraCycleID() {
		return jiraCycleID;
	}

	public void setJiraCycleID(String jiraCycleID) {
		this.jiraCycleID = jiraCycleID;
	}

	public String getJiraProjectID() {
		return jiraProjectID;
	}

	public void setJiraProjectID(String jiraProjectID) {
		this.jiraProjectID = jiraProjectID;
	}

	public String getJiraTestManagement() {
		return jiraTestManagement;
	}

	public void setJiraTestManagement(String jiraTestManagement) {
		this.jiraTestManagement = jiraTestManagement;
	}

	public String getManageToolName() {
		return ManageToolName;
	}

	public void setManageToolName(String manageToolName) {
		this.ManageToolName = manageToolName;
	}

	public String getRestURL() {
		return restURL;
	}

	public void setRestURL(String restURL) {
		this.restURL = restURL;
	}

	public String getAndroidVersion() {
		return androidVersion;
	}

	public void setAndroidVersion(String androidVersion) {
		this.androidVersion = androidVersion;
	}

	public String getAndroidName() {
		return androidName;
	}

	public void setAndroidName(String androidName) {
		this.androidName = androidName;
	}

	public String getAndroidID() {
		return androidID;
	}

	public void setAndroidID(String androidID) {
		this.androidID = androidID;
	}

	public String getAndroidBrowser() {
		return androidBrowser;
	}

	public void setAndroidBrowser(String androidBrowser) {
		this.androidBrowser = androidBrowser;
	}

}
