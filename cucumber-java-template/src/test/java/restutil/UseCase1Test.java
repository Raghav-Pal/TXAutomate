 package restutil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //For Ascending order test execution
public class UseCase1Test {

    private Response res = null; //Response
    private JsonPath jp = null; //JsonPath

    //Instantiate a Helper Test Methods (htm) Object
   // HelperTestMethods htm = new HelperTestMethods();

    @Before
    public void setup (){
        //Test Setup
        Utils.setBaseURI("http://api.5min.com"); //Setup Base URI
        Utils.setBasePath("search"); //Setup Base Path
        Utils.setContentType(ContentType.JSON); //Setup Content Type
        Utils.setJsonPathTerm("videos.json"); //Setup Json Path Term
        Utils.createSearchQueryPath("paris hilton", "num_of_videos", "5"); //Set up search term, param and param value
        res = Utils.getResponse(); //Get response
        jp = Utils.getJsonPath(res); //Set JsonPath
    }

    @Test
    public void T01_StatusCodeTest() {
        //Verify the http response status returned. Check Status Code is 200?
    	Utils.checkStatusIs200(res);
    }

    @Test
    public void T02_SearchTermTest() {
        //Verify the title is correct
        Assert.assertEquals("Title is wrong!", ("Search results for \"paris hilton\""), jp.get("api-info.title"));
    }

  
    @After
    public void afterTest (){
        //Reset Values
        Utils.resetBaseURI();
        Utils.resetBasePath();
    }
}