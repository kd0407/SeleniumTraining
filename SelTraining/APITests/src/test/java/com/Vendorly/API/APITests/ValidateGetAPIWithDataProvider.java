package com.Vendorly.API.APITests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.LoadBaseURL.Test.BaseURI;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ValidateGetAPIWithDataProvider extends BaseURI {
	String currentDir = System.getProperty("user.dir"+File.pathSeparator+"Library\\TestData.xlsx");
/*
 * In Excel we need to create a method that takes Map object as parameter
 */
	@DataProvider(name="PositiveScenario")
	public Object[][] getPositiveTestData() {

		return com.Vendorly.Utilities.Excel.get(currentDir, "PositiveScenario");
	}
	
	@Test(dataProvider="PositiveScenario")
	public void  VerifyInclusiveTypewithPositiveData()
	{
		String applicationjson=null,email=null;
		Header header1 = new Header("Content-Type", applicationjson );
		Header header2 = new Header("uid", email);
		List<Header> list = new ArrayList<Header>();
		list.add(header1);
		list.add(header2);
		Headers header = new Headers(list);
		System.out.println("Newrecord:" +applicationjson +" "+email);

		Response resposne = RestAssured.given().headers(header).log().all().when()
				.get("v1/vendorType/80b8edea-9860-4580-b35e-19dfe637cb4e/inclusiveVendorTypes");
		//.body().toString();

		int statusCode = resposne.getStatusCode();
		Assert.assertEquals(statusCode,200);


	}

}