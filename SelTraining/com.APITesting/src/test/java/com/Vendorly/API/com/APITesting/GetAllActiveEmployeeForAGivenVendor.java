package com.Vendorly.API.com.APITesting;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.employeeload.base.GetEmpDetailsMethod;

public class GetAllActiveEmployeeForAGivenVendor extends GetEmpDetailsMethod {
	String empID,empNo,iAMID;
	ExtentReports report;

	@Test
	public  void getActiveEmp()
	{
		Header header1 = new Header("Content-Type", "application/json");
		Header header2 = new Header("uid", "Bhoumen.Subudhi@altisource.com");
		List<Header> list = new ArrayList<Header>();
		list.add(header1);
		list.add(header2);
		Headers header = new Headers(list);
		Response response = (Response) RestAssured.given().headers(header).when().get("/v1/vendor/222237677/activeEmployees").getBody();
		System.out.println("response time:="+response.getTime());
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode,200);
		System.out.println("Response Body is =>  " + response.asString());

	}
	@Test
	public  void getEmpIDForAVendor() {
		Header header1 = new Header("Content-Type", "application/json");
		Header header2 = new Header("uid", "Bhoumen.Subudhi@altisource.com");
		List<Header> list = new ArrayList<Header>();
		list.add(header1);
		list.add(header2);
		Headers header = new Headers(list);
		empID = RestAssured.given().headers(header).when().get("/v1/vendor/222237677/activeEmployees").then().extract().jsonPath().getString("records[0].id");
		System.out.println("Emp Id :" + empID);
		//return empID;
		// Add DB details to validate
	}
	@Test
	public void validateEmpNoAndIAMIDIsSame()
	{
		Header header1 = new Header("Content-Type", "application/json");
		Header header2 = new Header("uid", "Bhoumen.Subudhi@altisource.com");
		List<Header> list = new ArrayList<Header>();
		list.add(header1);
		list.add(header2);
		Headers header = new Headers(list);
		String empID = RestAssured.given().headers(header).when().get("/v1/vendor/222237677/activeEmployees").then().extract().jsonPath().getString("records[0].id");
		empNo = RestAssured.given().headers(header).when().get("/v1/vendor/222237677/employee/".concat(empID)).then().extract().jsonPath().getString("resultObj.employeeNumber");
		iAMID = RestAssured.given().headers(header).when().get("/v1/vendor/222237677/employee/".concat(empID)).then().extract().jsonPath().getString("resultObj.iamUserId");
		System.out.println("Emp No and IAMUserId :" + empNo +"," +iAMID);
		Assert.assertEquals(empNo,iAMID);

	}
	@Test
	public void GetInclusiveVendorTypes()
	{
		Header header1 = new Header("Content-Type", "application/json");
		Header header2 = new Header("uid", "Bhoumen.Subudhi@altisource.com");
		List<Header> list = new ArrayList<Header>();
		list.add(header1);
		list.add(header2);
		Headers header = new Headers(list);

		Response resposne = (Response) RestAssured.given().headers(header).when().get("v1/vendorType/5cf5b35c-94ee-4d1f-afb3-132e0efe7e59/inclusiveVendorTypes").getBody();
		int statusCode = resposne.getStatusCode();
	    Assert.assertEquals(statusCode,200);

	}


}
