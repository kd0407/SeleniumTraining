package com.Vendorly.API.APITests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import com.LoadBaseURL.Test.*;
import com.relevantcodes.extentreports.ExtentReports;

public class GetVendorEmpdetails extends BaseURI {
	String empID1,empID,empNo,iAMID;
	//Properties property;
	//FileInputStream fs;
	
	ExtentReports report;

	@Test
	public  void getActiveEmp() throws IOException
	{
		//
	
		Header header1 = new Header("Content-Type",property.getProperty("Content-Type"));
		Header header2 = new Header("uid", property.getProperty("uid"));
		List<Header> list = new ArrayList<Header>();
		list.add(header1);
		list.add(header2);
		Headers header = new Headers(list);
		/*fs= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		property=new Properties();
		property.load(fs);*/ 
		//property.getProperty(vendorNumber))
		Response response = (Response) RestAssured.given()
				.headers(header)
				.when()
				.get("/v1/vendor/".concat(property.getProperty("vendorNumber")).concat("/activeEmployees")).getBody();
		System.out.println("response time:="+response.getTime());
		/*System.out.println(property.getProperty("uid"));
		System.out.println(property.getProperty("Content-Type"))*/;
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode,200);
		System.out.println("Response Body is =>  " + response.asString());
		System.out.println(response.getBody().jsonPath().getString("total"));
	}
	@Test
	public  void getEmpIDForAVendor() {
		Header header1 = new Header("Content-Type", property.getProperty("Content-Type"));
		Header header2 = new Header("uid", property.getProperty("uid"));
		List<Header> list = new ArrayList<Header>();
		list.add(header1);
		list.add(header2);
		Headers header = new Headers(list);
		empID1 = RestAssured.given().headers(header).when().get("/v1/vendor/".concat(property.getProperty("vendorNumber")).concat("/activeEmployees")).then().extract().jsonPath().getString("records[0].id");
		System.out.println("Emp Id :" + empID1);
		//return empID;
		// Add DB details to validate
	}
	@Test
	public void validateEmpNoAndIAMIDIsSame()
	{
		Header header1 = new Header("Content-Type", property.getProperty("Content-Type"));
		Header header2 = new Header("uid", property.getProperty("uid"));
		List<Header> list = new ArrayList<Header>();
		list.add(header1);
		list.add(header2);
		Headers header = new Headers(list);
		empID = RestAssured.given().headers(header).when().get("/v1/vendor/222237677/activeEmployees").then().extract().jsonPath().getString("records[0].id");
		System.out.println(("/v1/vendor/222237677/employee/".concat(empID)));
	    //RestAssured.given().headers(header).when().get("/v1/vendor/222237677/employee/".concat(empID));
		empNo = RestAssured.given().headers(header).when().get("/v1/vendor/222237677/employee/".concat(empID)).then().extract().jsonPath().getString("resultObj.employeeNumber");
		iAMID = RestAssured.given().headers(header).when().get("/v1/vendor/222237677/employee/".concat(empID)).then().extract().jsonPath().getString("resultObj.iamUserId");
		System.out.println("This is Kalpana");
		System.out.println("Emp No and IAMUserId :" + empNo +"," +iAMID);
		Assert.assertEquals(empNo,iAMID);

	}
	@Test
	public void GetInclusiveVendorTypes()
	{
		Header header1 = new Header("Content-Type", property.getProperty("Content-Type"));
		Header header2 = new Header("uid", property.getProperty("uid"));
		List<Header> list = new ArrayList<Header>();
		list.add(header1);
		list.add(header2);
		Headers header = new Headers(list);

		Response resposne = (Response) RestAssured.given().headers(header).when().get("v1/vendorType/".concat(property.getProperty("vendorId")).concat("/inclusiveVendorTypes")).getBody();
		int statusCode = resposne.getStatusCode();
	    Assert.assertEquals(statusCode,200);
	    System.out.println(resposne);

	}

	 
}
