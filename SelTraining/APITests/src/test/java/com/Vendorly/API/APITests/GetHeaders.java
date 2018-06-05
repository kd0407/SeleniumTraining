package com.Vendorly.API.APITests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.LoadBaseURL.Test.BaseURI;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class GetHeaders extends BaseURI {
	

	@Test(dataProvider="getData")
	public void getData(String applicationjson,String email) {

		System.out.println("New record:" +applicationjson +email);

		Header header1 = new Header("Content-Type", applicationjson );
		Header header2 = new Header("uid", email);
		ArrayList<Header> list = new ArrayList<Header>();
		list.add(header1);
		list.add(header2);
		Headers header = new Headers(list);

		String response = RestAssured.given()
				.headers(header)
				.when()
				.get("v1/vendorType/80b8edea-9860-4580-b35e-19dfe637cb4e/inclusiveVendorTypes").getBody().asString();
		System.out.println(response);
		test.getTest();
		//System.out.println(test.getTest(););
		test.log(LogStatus.INFO,"Response body:---------------"+response);

	}
	@DataProvider
	public Object[][] getData() {
		return com.Vendorly.Utilities.Excel.get("D:\\SelTraining\\APITests\\headers.xls", "HeaderTestData");

	}
}
