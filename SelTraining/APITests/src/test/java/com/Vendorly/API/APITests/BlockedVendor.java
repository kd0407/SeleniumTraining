package com.Vendorly.API.APITests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.LoadBaseURL.Test.BaseURI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;


public class BlockedVendor extends BaseURI
{
	String vendorStatus;

	public void updatevendor() 
	{

		Header header1 = new Header("Content-Type", "application/json");
		Header header2 = new Header("uid", "Bhoumen.Subudhi@altisource.com");
		List<Header> list = new ArrayList<Header>();
		list.add(header1);
		list.add(header2);
		Headers header = new Headers(list);
		
		//Created the PUT call with the updated JSON values.
		RestAssured.given()
		.headers(header)
		.contentType(ContentType.JSON)
		.when()
		.body("D:\\SelTraining\\APITests\\src\\ClientBlockedVendor.json")
		.put("/v1/client/clientNumber/vendor/vendorNumber")
		.then()
		.body("msg", equalToIgnoringCase("Vendor status has been successfully updated"));
	
	
		//Retrieve the same updated fields to validate
		vendorStatus = RestAssured.given().headers(header).when().get("/v1/vendor/222237677/....").then().extract().jsonPath().getString("records[0].id");
		//Retrieve the Comments
		//Retrieve the Reason
		//Notifications

	}



}
