package com.students.tests;

import org.junit.BeforeClass;
import org.junit.Test;

import com.student.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import extentreports.ExtentFactory;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class TestExtentRpt extends TestBase {

	@Test
	public  void getAllStudentsInformation() {
		
		

		Response response= given()
				.when()
				.get("/list");

		System.out.println(response.body().asString());

		//Validate status code test
		given()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
		test.log(LogStatus.INFO,"Get All Student info started"+response.body().asString());
	}
	
	
}



