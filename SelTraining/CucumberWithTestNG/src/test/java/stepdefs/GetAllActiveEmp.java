package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class GetAllActiveEmp {

	String URL ="http://vos-qa-central1.altidev.net:8080/vos-central/api/v1/vendor/222237677/employees";
	private RequestSpecification request;
	//private ResponseBody response;
	int statusCode;
	String records;
	Header header1 = new Header("Content-Type","applicaion/json");
	Header header2 = new Header("uid", "Bhoumen.Subudhi@altisource.com");
	
	@Given("^A Vendor has existing employee$")
	public void a_Vendor_has_existing_employee()  {
		request=RestAssured.given().header(header1).header(header2);
		System.out.println("Given Keyword + 222237677 has 5 emp");
	
	}

	@When("^Send Get call$")
	public void send_Get_call()  {
	   request=RestAssured.given().header(header1).header(header2);
			System.out.println(request);
	  
	}

	@Then("^Validate the total is greater than (\\d+)$")
	public void validate_the_total_is_greater_than(int arg1)  {
	    records = request.when().get(URL).then().extract().jsonPath().getString("total");
	    //response.getBody().jsonPath().getString("total")
			System.out.println(records); 
	  
	}
}
