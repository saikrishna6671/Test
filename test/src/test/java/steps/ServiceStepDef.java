package steps;
import java.util.HashMap;

import org.junit.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
public class ServiceStepDef {
	
	public RequestSpecification request;
	public Response response;
	public String requestHeaders;
	public String requestURL;
	
	
	

@Given("I make a Get request to a webservice \"([^\"]*)\"$")
public void i_make_a_get_request_to_a_webservice(String Url) {
	HashMap<String, String> headers = new HashMap();
	requestURL = Url;
	request=given().headers(headers).log().all();
	response=request.when().get(Url);
	response.getBody().prettyPrint();
	
	
   
}
@Then("response status code is \"([^\"]*)\"$")
public void response_status_code_is(String code) {
   Assert.assertEquals(response.getStatusCode(), Integer.parseInt(code));
    
}
@Then("response jsonBody contains xpath {string} equal to {string}")
public void response_json_body_contains_xpath_equal_to(String key, String expectedValue) {
	
	String actualValue = response.jsonPath().getString(key).replace("\\n", " ");
	Assert.assertEquals(expectedValue,actualValue);
	
    
}


}
