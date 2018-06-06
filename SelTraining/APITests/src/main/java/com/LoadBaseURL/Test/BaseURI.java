package com.LoadBaseURL.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.Vendorly.Utilities.ExtentFactory;

public class BaseURI {
	static ExtentReports report;
	protected static ExtentTest test; // ExtentTest is used for logging
	public Properties property;
	FileInputStream fs;
	@BeforeClass
	public  void init() throws IOException {
		RestAssured.baseURI = "http://vos-qa-central1.altidev.net:8080/vos-central/api";
		
		fs= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		property=new Properties();
		property.load(fs); 
		//RestAssured.port=8080;
		//RestAssured.basePath="/vos-central/api";
		report=ExtentFactory.getInstance();
		test=report.startTest("Strated the test...");

	}

	@AfterClass
	public static void afterClass() {
		report.endTest(test);
		report.flush();
	}
}

