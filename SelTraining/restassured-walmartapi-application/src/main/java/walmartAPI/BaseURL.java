package walmartAPI;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseURL {
	//static RequestSpecification spec;
	//static final String APIKEY="pmptpp3gyka29jpd6bxqvvqt";
	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://api.walmartlabs.com";
		RestAssured.basePath="/v1";
		
				
	}

}
