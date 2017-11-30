package utilities;

import testlink.api.java.client.TestLinkAPIResults;

public class TestMail {

	public static void main(String[] args) throws Exception {
		TestLinkUtil.DEV_KEY = "25f088e7761641aa0be797d22e97d9a6";
		TestLinkUtil.SERVER_URL = "http://localhost/testlink-1.9.16/lib/api/xmlrpc/v1/xmlrpc.php";
		TestLinkUtil.projectName = "TestAutomation_Project";
		TestLinkUtil.testPlanName = "TestAutomation_Plan";
		TestLinkUtil.buildName = "TestAutomation_Build";
		TestLinkUtil.needUpdate = "Yes";
		TestLinkUtil util = new TestLinkUtil();
		util.updateTestLinkResult("TP-1", "this is exception",  TestLinkAPIResults.TEST_FAILED);
		//util.

	}

}
