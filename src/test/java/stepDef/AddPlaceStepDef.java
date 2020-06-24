package stepDef;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.automation.enums.APIResources;
import com.automation.payload.TestDataBuild;
import com.automation.utils.TestUtility;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class AddPlaceStepDef extends TestUtility {

	RequestSpecification req;
	ResponseSpecification res;
	Response response;
	TestDataBuild data = new TestDataBuild();
	
	
	@Given("^Add place payload with {String}$")
    public void add_place_payload(String name) throws IOException{
	      
		
		req = given().spec(requestBuilder()).body(data.addPlacePayload(name));
    }

    @When("^user call \"([^\"]*)\" with \"([^\"]*\" http request$")
    public void user_call_something_with_post_http_request(String resource,String httpMethod) {
    	APIResources resourceAPI = APIResources.valueOf(resource);
     	res = new ResponseSpecBuilder().expectStatusCode(200).build();
     	if(httpMethod.equalsIgnoreCase("POST")) {
     		response = req.when().post( resourceAPI.getResource()).then().spec(res).extract().response();
     	}
     	else if(httpMethod.equalsIgnoreCase("GET")) {
     		response = req.when().get( resourceAPI.getResource()).then().spec(res).extract().response();
     	}
        
    }

    @Then("^the api call got success with status code \"([^\"]*)\"$")
    public void the_api_call_got_success_with_status_code(int statusCode) {
    	assertEquals(response.getStatusCode(), statusCode);
    }

    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void something_in_response_body_is_something(String key, String value) {
    	String jsonResponse = response.asString();
    	JsonPath jp = new JsonPath(jsonResponse);
    	assertEquals(jp.get(key).toString(),value);
    }
}
