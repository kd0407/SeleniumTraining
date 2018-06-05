package com.Vendorly.API.APITests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import com.LoadBaseURL.Test.*;
import static org.hamcrest.Matchers.*;

public class ValidateVendorTypes extends BaseURI{
	//ExtentReports extent;
	@Test
	public void GetInclusiveVendorTypes()
	{
		Header header1 = new Header("Content-Type", "application/json");
		Header header2 = new Header("uid", "Bhoumen.Subudhi@altisource.com");
		List<Header> list = new ArrayList<Header>();
		list.add(header1);
		list.add(header2);
		Headers header = new Headers(list);

		//Response resposne = (Response) RestAssured.given().headers(header).when().get("v1/vendorType/5cf5b35c-94ee-4d1f-afb3-132e0efe7e59/inclusiveVendorTypes").getBody();
		Response resposne = (Response) RestAssured.given().header("Content-Type", "application/json","uid", "Bhoumen.Subudhi@altisource.com").when().get("v1/vendorType/5cf5b35c-94ee-4d1f-afb3-132e0efe7e59/inclusiveVendorTypes").getBody();
		int statusCode = resposne.getStatusCode();
		Assert.assertEquals(statusCode,200);
		
		
	}
	@Test
	public void ValidateInclusiveVendorTypes()
	{
		Header header1 = new Header("Content-Type", "application/json");
		Header header2 = new Header("uid", "Bhoumen.Subudhi@altisource.com");
		List<Header> list = new ArrayList<Header>();
		list.add(header1);
		list.add(header2);
		Headers header = new Headers(list);

	    RestAssured.given().headers(header).when().get("v1/vendorType/5cf5b35c-94ee-4d1f-afb3-132e0efe7e59/inclusiveVendorTypes").then().body("total", greaterThanOrEqualTo(1));
	   
	}
	/**
	 * Verify the inclusive list by first creating and comparing the total of records
	 */
	@Test
	public void retrieveInclusiveVendorTypes()
	{
		Header header1 = new Header("Content-Type", "application/json");
		Header header2 = new Header("uid", "Bhoumen.Subudhi@altisource.com");
		List<Header> list = new ArrayList<Header>();
		list.add(header1);
		list.add(header2);
		Headers header = new Headers(list);

		String response = RestAssured.given()
	    		.headers(header)
	    		.when()
	    		.get("v1/vendorType/5cf5b35c-94ee-4d1f-afb3-132e0efe7e59/inclusiveVendorTypes").getBody().asString();
		System.out.println(response);
		
	    
	    
	   
	}
	
	
		
	


}
