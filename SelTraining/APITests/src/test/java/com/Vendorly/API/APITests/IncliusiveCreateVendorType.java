package com.Vendorly.API.APITests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import com.LoadBaseURL.*;
import com.LoadBaseURL.Test.BaseURI;
import com.Vendorly.CreateVendorType.CreateVendorType;
import com.Vendorly.CreateVendorType.InclusiveVendorType;


public class IncliusiveCreateVendorType extends BaseURI{

	@Test
	public static void CreateInclusiveVendorTypes()
	{
		Header header1 = new Header("Content-Type", "application/json");
		Header header2 = new Header("uid", "Bhoumen.Subudhi@altisource.com");
		List<Header> list = new ArrayList<Header>();
		list.add(header1);
		list.add(header2);
		Headers header = new Headers(list);

		//Date object to get date
		Date date= new Date();

		// creating Inclusive vendor type object
		InclusiveVendorType in = new InclusiveVendorType();
		in.setId("8760210c-7c68-4e6e-9f58-e291e8dca545");
		in.setType("StatePark");
		//Creating and passing inclusive vendor type list	
		List<InclusiveVendorType> ivt = new ArrayList<InclusiveVendorType>();
		ivt.add(in);

		CreateVendorType vendorType1 = new CreateVendorType();



		vendorType1.setType("BTR retreat"+date.toGMTString());  
		vendorType1.setDescription( "BTR");
		vendorType1.setInactive("false");
		vendorType1.setInclusiveVendorTypes(ivt);

		given()
		.when()
		.headers(header)
		.body(vendorType1).log().all()
		.post("http://vos-qa-central1.altidev.net:8080/vos-central/api/v1/vendorType")
		.then().statusCode(201)
		.log().body()
		.extract().path("msg", "Vendor Type is created successfully");

	}

}

