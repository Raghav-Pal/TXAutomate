package restutil;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.*;

import org.testng.Assert;

public class RestUtils {
    //Global Setup Variables
    public static String path;
    public static String jsonPathTerm;
    static RequestSpecification rs;
    //public static 

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
    public static void setContentBodyType (ContentType Type,String body){
    	rs = given().contentType(Type).body(body);
    }
    

    //Returns response
    public static Response getResponse() {
        return rs.when().get();   
    }
    
    //Returns response
    public static Response PostResponse(String type) {
        return rs.when().post("");
    }

    //Returns JsonPath object
    public static JsonPath getJsonPath (Response res) {
        String json = res.asString();
       // System.out.print("returned json: " + json +"\n");
        return new JsonPath(json);
    }
    
    //Verify the http response status returned. Check Status Code is 200?
    public static void checkStatusIs200 (Response res) {
        Assert.assertEquals(200, res.getStatusCode(),"Status Check Failed!");
    }
    
    public static Object getValueFromJson(Response res, String path){
        String json = res.asString();
       // System.out.print("returned json: " + json +"\n");
         return new JsonPath(json).getString("user.email");

    }
}