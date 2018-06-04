package com.student.base;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import extentreports.ExtentFactory;
import io.restassured.RestAssured;

public class TestBase {
	static ExtentReports report;
	protected static ExtentTest test;

	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://localhost";
		RestAssured.port=9095;
		RestAssured.basePath="/student";
		report=ExtentFactory.getInstance();
		test=report.startTest("Strated the test...");
		
	}
	
	@AfterClass
	public static void afterClass() {
		report.endTest(test);
		report.flush();
	}
}
