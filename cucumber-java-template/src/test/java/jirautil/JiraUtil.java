package jirautil;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;

/*import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;*/

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;
import utilities.GlobalUtil;
import utilities.LogUtil;
import utilities.TestLinkUtil;

/**
 * <h1>JIRAUtility class</h1> <br>
 * Utility Class for JIRA <br>
 * <br>
 * 
 * @version 1.0 <br>
 *          <br>
 * @author Anand Aggarwal
 */
public class JiraUtil{

	public static String USERNAME = null;
	public static String PASSWORD = null;
	public static String JIRA_URL = null;
	public static String JIRA_PROJECT = null;
	public static String JIRA_PROJECT_ID = null;
	public static String JIRA_CYCLE_ID = null;
	public static String ZEPHYR_URL = null;
	// zephyr accessKey , we can get from Addons >> zapi section
	public static String ZAPI_ACCESS_KEY = "Njc1NTJjZTItMzVkZC0zYmEwLWI3N2UtZmQ3YWNkZDAwNTM2IGFkbWluIGJpbmR1";
	// zephyr secretKey , we can get from Addons >> zapi section
	public static String ZAPI_SECRET_KEY = "0GYaR3cNz-kw8tuQDKNBpirb-u6FnTIqtJDX-YBxCUw";


	static BasicCredentials creds = null;
	static JiraClient jira = null;
	static Issue issue;
	static ZFJCloudRestClient ZAPI_CLIENT;
	private static String API_UPDATE_EXECUTION = "{SERVER}/public/rest/api/1.0/execution/";
	private static String API_GET_EXECUTIONS = "{SERVER}/public/rest/api/1.0/executions/search/cycle/";

	public JiraUtil(){
		creds = new BasicCredentials(USERNAME,PASSWORD);
		jira = new JiraClient(JIRA_URL, creds);
		ZAPI_CLIENT = ZFJCloudRestClient.restBuilder(ZEPHYR_URL, ZAPI_ACCESS_KEY, ZAPI_SECRET_KEY, USERNAME)
				.build();
	}

	public static void getIssue(String key) {
		try {
			issue = jira.getIssue(key);
		} catch (JiraException e) {
			System.out.println(e.getMessage());
		}
	}

	// To Do --> In Progress
	public static void changeStatusOfIssueFrom_TODO_to_INPROGRESS() {
		try {
			issue.transition().execute("Start Progress");
		} catch (JiraException e) {
			System.out.println(e.getMessage());
		}
	}

	// In Progress --> Done
	public static void changeStatusOfIssueFrom_INPROGRESS_to_DONE() {
		try {
			issue.transition().execute("Resolved");
		} catch (JiraException e) {
			System.out.println(e.getMessage());
		}
	}

	// In Progress --> To Do
	public static void changeStatusOfIssueFrom_INPROGRESS_to_TODO() {
		try {
			issue.transition().execute("Stop Progress");
		} catch (JiraException e) {
			System.out.println(e.getMessage());
		}
	}

	// Done --> In Progress
	public static void changeStatusOfIssueFrom_DONE_to_INPROGRESS() {
		try {
			issue.transition().execute("Unresolved");
		} catch (JiraException e) {
			System.out.println(e.getMessage());
		}
	}

	// Done --> To Do
	public static void changeStatusOfIssueFrom_DONE_to_TODO() {
		try {
			issue.transition().execute("Reopen");
		} catch (JiraException e) {
			System.out.println(e.getMessage());
		}
	}

	// Change Description
	public static void changeDesc(String description) {
		try {
			issue.update().field(Field.DESCRIPTION, description).execute();
		} catch (JiraException e) {
			System.out.println(e.getMessage());
		}
	}

	// Change summary
	public static void changeSummary(String summary) {
		try {
			issue.update().field(Field.SUMMARY, summary).execute();
		} catch (JiraException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This function sets the WebDriver and launches the URL specified in
	 * Frameowrk.properties file with property key BaseURL. <br>
	 * <br>
	 * 
	 * @param projectKey
	 *            - Specify the project key generated while creating the
	 *            project. <br>
	 *            <br>
	 * @param summary
	 *            - Specify the summary to be added to the new bug. <br>
	 *            <br>
	 * @param description
	 *            - Specify the description to be added to the new bug. <br>
	 *            <br>
	 * @param reporter
	 *            - Specify the reporter to be added to the new bug. See the username from the User Management page.<br>
	 *            <br>
	 * @param assignee
	 *            - Specify the assignee to be added to the new bug. See the username from the User Management page.<br>
	 *            <br>
	 * @param attachmentPath
	 *            - Specify the path of the attachment to be added to the new bug. The name of the attachment is same as the original name of the image.<br>
	 *            <br>
	 * @exception Exception
	 *                If incorrect browser name entered. <br>
	 *                <br>
	 * @version 1.0 <br>
	 *          <br>
	 * @author Anand Aggarwal <br>
	 *         <br>
	 * @category Utility Class for JIRA
	 */
	public String reporIssue(String summary, String description,String attachmentPath) {

		if(GlobalUtil.getCommonSettings().getbugTool().equalsIgnoreCase("NO")){
			LogUtil.infoLog(JiraUtil.class, "Jira Bug tool is Disabled in Control sheet");
			return "Bug tool not configured";
		}
		Issue newIssue;
		String bugID = "No Bug Created. Please check Configuration";
		try {
			//create a issue
			newIssue = jira.createIssue(JIRA_PROJECT, "Bug")
					.field(Field.SUMMARY, summary)
					.field(Field.DESCRIPTION, description)
					.field(Field.PRIORITY,"High")
					.execute();

			// add an attachment to the issue created
			if(!attachmentPath.equalsIgnoreCase("RestAPI")){
				File file = new File(attachmentPath);
				newIssue.addAttachment(file);
			}
			bugID =  newIssue.getId();
			return bugID;

		} catch (JiraException e) {
			e.printStackTrace();
		}
		return bugID;

	}

	/**
	 * 
	 * @param ExecutionID: ID is the number which we get when the testcase is added to a Testcycle and do inspect element and in the html serach for "data-issueid"
	 * @param Comments: String 
	 * @param result : Fail 
	 */
	public void updateJiraTestResults(String ExecutionID,String Comments,String Result){
		try{

			if(GlobalUtil.getCommonSettings().getJiraTestManagement().equalsIgnoreCase("No")){
				LogUtil.infoLog(JiraUtil.class, "Jira tool is Disabled in Control sheet");
				return;
			}

			Map<String, String> executionIds = getExecutionsID();
			//creating the Rest object to pass thriugh REST API for Updating the testcase Result
			JSONObject statusObj = new JSONObject();
			String statusID = "1";
			if(Result.equalsIgnoreCase("Fail"))
				statusID = "2";
			statusObj.put("id", statusID);
			JSONObject executeTestsObj = new JSONObject();
			executeTestsObj.put("status", statusObj);
			executeTestsObj.put("cycleId", JIRA_CYCLE_ID);
			executeTestsObj.put("projectId", JIRA_PROJECT_ID);
			executeTestsObj.put("versionId", "-1");
			executeTestsObj.put("comment", Comments);
			final String updateExecutionUri = API_UPDATE_EXECUTION.replace("{SERVER}", ZEPHYR_URL) + executionIds.get(ExecutionID);
			executeTestsObj.put("issueId", ExecutionID);
			StringEntity executeTestsJSON = null;
			executeTestsJSON = new StringEntity(executeTestsObj.toString());
			//call the function to upda the result
			updateExecutions(updateExecutionUri, ZAPI_CLIENT, ZAPI_ACCESS_KEY, executeTestsJSON);
			LogUtil.infoLog(TestLinkUtil.class, "Updated Results to Jira");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String updateExecutions(String uriStr, ZFJCloudRestClient client, String accessKey,StringEntity executionJSON){
		String executionStatus = "No Test Executed";
		try{


			URI uri = new URI(uriStr);
			int expirationInSec = 360;
			JwtGenerator jwtGenerator = client.getJwtGenerator();
			String jwt = jwtGenerator.generateJWT("PUT", uri, expirationInSec);

			HttpResponse response = null;
			HttpClient restClient = new DefaultHttpClient();

			HttpPut executeTest = new HttpPut(uri);
			executeTest.addHeader("Content-Type", "application/json");
			executeTest.addHeader("Authorization", jwt);
			executeTest.addHeader("zapiAccessKey", accessKey);
			executeTest.setEntity(executionJSON);
			response = restClient.execute(executeTest);

			//get the status of the rest
			int statusCode = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();

			if (statusCode >= 200 && statusCode < 300) {
				String string = null;
				try {
					string = EntityUtils.toString(entity);
					JSONObject executionResponseObj = new JSONObject(string);
					JSONObject descriptionResponseObj = executionResponseObj.getJSONObject("execution");
					JSONObject statusResponseObj = descriptionResponseObj.getJSONObject("status");
					executionStatus = statusResponseObj.getString("description");
					System.out.println(executionResponseObj.get("issueKey") + "--" + executionStatus);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				try {
					throw new ClientProtocolException("Unexpected response status: " + statusCode);
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return executionStatus;
	}

	private static Map<String, String> getExecutionsID(){
		Map<String, String> executionIds = new HashMap<String, String>();
		try{
			final String getExecutionsUri = API_GET_EXECUTIONS.replace("{SERVER}", ZEPHYR_URL) + JIRA_CYCLE_ID + "?projectId="
					+ JIRA_PROJECT_ID + "&versionId=-1";
			executionIds = getExecutionsByCycleId(getExecutionsUri, ZAPI_CLIENT, ZAPI_ACCESS_KEY);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return executionIds;
	}

	private static Map<String, String> getExecutionsByCycleId(String uriStr, ZFJCloudRestClient client,
			String accessKey) throws URISyntaxException, JSONException {
		Map<String, String> executionIds = new HashMap<String, String>();
		URI uri = new URI(uriStr);
		int expirationInSec = 360;
		JwtGenerator jwtGenerator = client.getJwtGenerator();
		String jwt = jwtGenerator.generateJWT("GET", uri, expirationInSec);
		// System.out.println(uri.toString());
		// System.out.println(jwt);

		HttpResponse response = null;
		HttpClient restClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(uri);
		httpGet.setHeader("Authorization", jwt);
		httpGet.setHeader("zapiAccessKey", accessKey);

		try {
			response = restClient.execute(httpGet);
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int statusCode = response.getStatusLine().getStatusCode();
		// System.out.println(statusCode);

		if (statusCode >= 200 && statusCode < 300) {
			HttpEntity entity1 = response.getEntity();
			String string1 = null;
			try {
				string1 = EntityUtils.toString(entity1);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// System.out.println(string1);
			JSONObject allIssues = new JSONObject(string1);
			JSONArray IssuesArray = allIssues.getJSONArray("searchObjectList");
			// System.out.println(IssuesArray.length());
			if (IssuesArray.length() == 0) {
				return executionIds;
			}
			for (int j = 0; j <= IssuesArray.length() - 1; j++) {
				JSONObject jobj = IssuesArray.getJSONObject(j);
				JSONObject jobj2 = jobj.getJSONObject("execution");
				String executionId = jobj2.getString("id");
				long IssueId = jobj2.getLong("issueId");
				//executionIds.put(executionId, String.valueOf(IssueId));

				executionIds.put(String.valueOf(IssueId), executionId);
			}
		}
		return executionIds;
	}

}
