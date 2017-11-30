package jirautil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;

public class FetchExecuteUpdate {
	private static String API_SEARCH_ISSUES = "{SERVER}/rest/api/2/search";
	private static String API_ADD_TESTS = "{SERVER}/public/rest/api/1.0/executions/add/cycle/";
	private static String API_GET_EXECUTIONS = "{SERVER}/public/rest/api/1.0/executions/search/cycle/";
	private static String API_UPDATE_EXECUTION = "{SERVER}/public/rest/api/1.0/execution/";

	/** Declare JIRA,Zephyr URL,access and secret Keys */

	// JIRA Cloud URL of the instance
	private static String jiraBaseURL = "https://testingxperts001.atlassian.net";
	// Replace zephyr baseurl <ZAPI_Cloud_URL> shared with the user for ZAPI Cloud Installation
	private static String zephyrBaseUrl = "https://prod-api.zephyr4jiracloud.com/connect";
	// zephyr accessKey , we can get from Addons >> zapi section
	private static String accessKey = "Njc1NTJjZTItMzVkZC0zYmEwLWI3N2UtZmQ3YWNkZDAwNTM2IGFkbWluIGJpbmR1";
	// zephyr secretKey , we can get from Addons >> zapi section
	private static String secretKey = "0GYaR3cNz-kw8tuQDKNBpirb-u6FnTIqtJDX-YBxCUw";

	/** Declare parameter values here */
	private static String userName = "bindu.poreddy@testingxperts.com";
	private static String password = "Mango@123";
	private static String cycleId = "0001503993710547-242ac112-0001";//after ccreating cycle check for example in inspect element: <li id ="cycle-0001503993710547-242ac112-0001">
	private static String versionId = "-1";
	private static String projectId = "10000"; //mouse hover of the main main menu any tab like Test andn inspect elemnt & check for example: href: /plugins/servlet/ac/com.thed.zephyr.je/general-zephyr-welcome?user.key=admin&project.key=TES01&*******project.id=10000****&user.id=admin

	static ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(zephyrBaseUrl, accessKey, secretKey, userName)
			.build();
	JwtGenerator jwtGenerator = client.getJwtGenerator();

	public static void main(String[] args) throws JSONException, URISyntaxException, ParseException, IOException {
		final String issueSearchUri = API_SEARCH_ISSUES.replace("{SERVER}", jiraBaseURL);
		
//		/**
//		 * Get Test Issues by JQL
//		 * 
//		 */
//
//		//Json object for JQL search
//		JSONObject jqlJsonObj = new JSONObject();
//		jqlJsonObj.put("jql", "project ='Test Automation Project'"); // Replace the value with Valid JQL
//		jqlJsonObj.put("startAt", 0);
//		jqlJsonObj.put("maxResults", 21);		// maxResults to be returned by search
//		jqlJsonObj.put("fieldsByKeys", false);
//
//		String[] IssueIds = getIssuesByJQL(issueSearchUri, userName, password, jqlJsonObj);
//		 System.out.println(ArrayUtils.toString(IssueIds));
//
//		/**
//		 * Add tests to Cycle
//		 * 
//		 */
//
//		final String addTestsUri = API_ADD_TESTS.replace("{SERVER}", zephyrBaseUrl) + cycleId;
//
//		/** Create JSON object by providing input values */
//		//String[] IssueIdz = new String[25];
//		
//		String[] issueIds = {"TES01-7"};
//		JSONObject addTestsObj = new JSONObject();
//		addTestsObj.put("issues", issueIds);
//		addTestsObj.put("method", "1");
//		addTestsObj.put("projectId", projectId);
//		//addTestsObj.put("versionId", versionId);
//
//		StringEntity addTestsJSON = null;
//		try {
//			addTestsJSON = new StringEntity(addTestsObj.toString());
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
//		addTestsToCycle(addTestsUri, client, accessKey, addTestsJSON);

		/**
		 * Get Execution Id's by CycleId and Add them to Ad Hoc cycle of
		 * UnScheduled Version
		 * 
		 */
		Map<String, String> executionIds = new HashMap<String, String>();
		final String getExecutionsUri = API_GET_EXECUTIONS.replace("{SERVER}", zephyrBaseUrl) + cycleId + "?projectId="
				+ projectId + "&versionId=" + versionId;

		executionIds = getExecutionsByCycleId(getExecutionsUri, client, accessKey);

		/**
		 * Bulk Update Executions with Status by Execution Id
		 * 
		 */

		JSONObject statusObj = new JSONObject();
		//id = 1 --> pass
		//id = 2 --> fail
		
		statusObj.put("id", "1");

		JSONObject executeTestsObj = new JSONObject();
		executeTestsObj.put("status", statusObj);
		executeTestsObj.put("cycleId", cycleId);
		executeTestsObj.put("projectId", projectId);
		executeTestsObj.put("versionId", versionId);
		executeTestsObj.put("comment", "Executed by ZAPI Cloud");

		for (String key : executionIds.keySet()) {
			final String updateExecutionUri = API_UPDATE_EXECUTION.replace("{SERVER}", zephyrBaseUrl) + key;
			// System.out.println(updateExecutionUri);
			// System.out.println(executionIds.get(key));
			executeTestsObj.put("issueId", executionIds.get(key));
			// System.out.println(executeTestsObj.toString());
			StringEntity executeTestsJSON = null;
			try {
				executeTestsJSON = new StringEntity(executeTestsObj.toString());
				} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			updateExecutions(updateExecutionUri, client, accessKey, executeTestsJSON);
		}

	}

	private static String[] getIssuesByJQL(String issueSearchURL, String userName, String password,
			JSONObject jqlJsonObj) throws JSONException {

		byte[] bytesEncoded = Base64.encodeBase64((userName + ":" + password).getBytes());
		String authorizationHeader = "Basic " + new String(bytesEncoded);
		Header header = new BasicHeader(HttpHeaders.AUTHORIZATION, authorizationHeader);

		String[] issueIds = new String[jqlJsonObj.getInt("maxResults")];

		StringEntity jqlJSON = null;
		try {
			jqlJSON = new StringEntity(jqlJsonObj.toString());
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		HttpResponse response = null;
		HttpClient restClient = new DefaultHttpClient();
		try {
			// System.out.println(issueSearchURL);
			HttpPost createProjectReq = new HttpPost(issueSearchURL);
			createProjectReq.addHeader(header);
			createProjectReq.addHeader("Content-Type", "application/json");
			createProjectReq.setEntity(jqlJSON);

			response = restClient.execute(createProjectReq);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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

			System.out.println(string1);
			JSONObject allIssues = new JSONObject(string1);
			JSONArray IssuesArray = allIssues.getJSONArray("issues");
//			System.out.println(IssuesArray.length());
			if (IssuesArray.length() == 0) {
				return issueIds;
			}

			for (int j = 0; j < IssuesArray.length() ; j++) {
				JSONObject jobj = IssuesArray.getJSONObject(j);
				String issueId = jobj.getString("id");
				issueIds[j] = issueId;
			}
		}
		return issueIds;
	}

	public static void addTestsToCycle(String uriStr, ZFJCloudRestClient client, String accessKey,
			StringEntity addTestsJSON) throws URISyntaxException, JSONException {

		URI uri = new URI(uriStr);
		int expirationInSec = 360;
		JwtGenerator jwtGenerator = client.getJwtGenerator();
		String jwt = jwtGenerator.generateJWT("POST", uri, expirationInSec);
		// System.out.println(uri.toString());
		// System.out.println(jwt);

		HttpResponse response = null;
		HttpClient restClient = new DefaultHttpClient();

		HttpPost addTestsReq = new HttpPost(uri);
		addTestsReq.addHeader("Content-Type", "application/json");
		addTestsReq.addHeader("Authorization", jwt);
		addTestsReq.addHeader("zapiAccessKey", accessKey);
		addTestsReq.setEntity(addTestsJSON);

		try {
			response = restClient.execute(addTestsReq);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int statusCode = response.getStatusLine().getStatusCode();
		// System.out.println(statusCode);
		// System.out.println(response.toString());
		if (statusCode >= 200 && statusCode < 300) {
			System.out.println("Tests added Successfully");
		} else {
			try {
				throw new ClientProtocolException("Unexpected response status: " + statusCode);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			}
		}
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
				executionIds.put(executionId, String.valueOf(IssueId));
			}
		}
		return executionIds;
	}

	public static String updateExecutions(String uriStr, ZFJCloudRestClient client, String accessKey,
			StringEntity executionJSON) throws URISyntaxException, JSONException, ParseException, IOException {

		URI uri = new URI(uriStr);
		int expirationInSec = 360;
		JwtGenerator jwtGenerator = client.getJwtGenerator();
		String jwt = jwtGenerator.generateJWT("PUT", uri, expirationInSec);
		// System.out.println(uri.toString());
		// System.out.println(jwt);

		HttpResponse response = null;
		HttpClient restClient = new DefaultHttpClient();

		HttpPut executeTest = new HttpPut(uri);
		executeTest.addHeader("Content-Type", "application/json");
		executeTest.addHeader("Authorization", jwt);
		executeTest.addHeader("zapiAccessKey", accessKey);
		executeTest.setEntity(executionJSON);

		try {
			response = restClient.execute(executeTest);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int statusCode = response.getStatusLine().getStatusCode();
		// System.out.println(statusCode);
		String executionStatus = "No Test Executed";
		// System.out.println(response.toString());
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
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {

			try {
				String string = null;
				string = EntityUtils.toString(entity);
				JSONObject executionResponseObj = new JSONObject(string);
				cycleId = executionResponseObj.getString("clientMessage");
				// System.out.println(executionResponseObj.toString());
				throw new ClientProtocolException("Unexpected response status: " + statusCode);

			} catch (ClientProtocolException e) {
				e.printStackTrace();
			}
		}
		return executionStatus;
	}
}