package utilities;
import testlink.api.java.client.TestLinkAPIClient;


public class TestLinkUtil {

	static  TestLinkAPIClient testlinkAPIClient;
	public static String projectName;
	public static String testPlanName;
	public static String testCaseNameOrVisibleID;
	public static String buildName;
	public static String DEV_KEY;
	public static String SERVER_URL;
	public static String needUpdate;

	public TestLinkUtil(){
		testlinkAPIClient =  new TestLinkAPIClient(DEV_KEY, SERVER_URL);
	}

	public void updateTestLinkResult(String testCase, String exception, String result){
		try{
			if(needUpdate.equalsIgnoreCase("Yes")){
				testlinkAPIClient.reportTestCaseResult(projectName, testPlanName, testCase, buildName, exception, result);
				LogUtil.infoLog(TestLinkUtil.class, "Updated Results to Testlink");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			LogUtil.errorLog(TestLinkUtil.class,"Not able to update the Testlink. Please check the Exception",e);
		}
	}


}
