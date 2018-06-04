package stepdefs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class GetActiveEmpDef {
	
	private String url = "http://vos-qa-central1.altidev.net:8080/vos-central/api/v1/vendor/222238102/activeEmployees";
	private RequestSpecification request;
	private ResponseBody response;
	int statusCode;
	String records;
	Header header1 = new Header("Content-Type","applicaion/json");
	Header header2 = new Header("uid", "Bhoumen.Subudhi@altisource.com");
//	List<Header> list1 = new ArrayList<Header>();
//	list.add(header1);
//	list.add(header2);
//	Headers header = new Headers(list);
	
	@Given("^A Vendor has existing employee$")  
	public void a_Vendor_has_existing_employee() {
		System.out.println("Emp exists for this Vendor:222238102");
		 throw new PendingException();
	}
	
	@When("^Get method Rest call$")  
	public void Get_method_Rest_call() {
		request = RestAssured.given().header(header1).header(header2);
		 throw new PendingException();
		
	}
	@Then("^validate the total>=1$") 
	public void validate_the_total_is_greater_or_equal_to_1(){
		records = request.when().get(url).then().extract().jsonPath().getString("records[0].id");
		response = request.when().get(url).body();
		//System.out.println("response: " + response.prettyPrint());
		 throw new PendingException();
		
	}
	/*@And("^Response code=200$") 
	
	public void response_code_is_equal_to_200(){
		int statusCode = response.
		Assert.assertEquals(statusCode,200);
		 throw new PendingException();
		
	}*/

}
