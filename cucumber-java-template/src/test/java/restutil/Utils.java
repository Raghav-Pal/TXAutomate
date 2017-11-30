package restutil;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

import org.testng.Assert;

public class Utils {
    //Global Setup Variables
    public static String path;
    public static String jsonPathTerm;

    //Sets Base URI
    public static void setBaseURI (String baseURI){
        RestAssured.baseURI = baseURI;
    }

    //Sets base path
    public static void setBasePath(String basePathTerm){
        RestAssured.basePath = basePathTerm;
    }

    //Reset Base URI (after test)
    public static void resetBaseURI (){
        RestAssured.baseURI = null;
    }

    //Reset base path
    public static void resetBasePath(){
        RestAssured.basePath = null;
    }

    //Sets ContentType
    public static void setContentType (ContentType Type){
        given().contentType(Type);
        //given().authentication().basic(userName, password)
    }

    //Sets Json path term
    public static void  setJsonPathTerm(String jsonPath){
        jsonPathTerm = jsonPath;
    }

    //Created search query path
    public static void  createSearchQueryPath(String searchTerm, String param, String paramValue) {
        path = searchTerm + "/" + jsonPathTerm + "?" + param + "=" + paramValue;
    }

    //Returns response
    public static Response getResponse() {
        //System.out.print("path: " + path +"\n");
    	//get
        return get(path);
        
    }

    //Returns JsonPath object
    public static JsonPath getJsonPath (Response res) {
        String json = res.asString();
        //System.out.print("returned json: " + json +"\n");
        return new JsonPath(json);
    }
    
    //Verify the http response status returned. Check Status Code is 200?
    public static void checkStatusIs200 (Response res) {
        Assert.assertEquals(200, res.getStatusCode(),"Status Check Failed!");
    }
}