package com.AssertionsExamples;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import walmartAPI.BaseURL;

public class AssertionsExamples extends BaseURL {
	static final String APIKEY="pmptpp3gyka29jpd6bxqvvqt";
	@Test
	public void validateNoOfItems() {

		given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apikey", APIKEY)
		.when()
		.get("/search")
		.then().body("numItems",equalTo(10));

	}
	//verify query
	@Test
	public void validateQueryValue() {
		given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apikey", APIKEY)
		.when()
		.get("/search")
		.then().body("query",equalToIgnoringCase("Ipod"));

	}
	@Test
	public void validateNameFromArrayList() {
		given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apikey", APIKEY)
		.when()
		.get("/search")
		.then()
		.body("items.name",hasItem("Apple iPod Touch 6th Generation 16GB Refurbished"));

	}
	@Test
	public void validateNamesFromArryList() {
		given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apikey", APIKEY)
		.when()
		.get("/search")
		.then()
		.body("items.name", hasItems())
		.body("items.name",hasItems("Apple iPod touch 16GB","Apple iPod touch 32GB"));

	}
	//Checking hasKey value
	@Test
	public void validateValueInsideMap() {
		given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apikey", APIKEY)
		.when()
		.get("/search")
		.then()
		.body("items[0].giftOptions", hasKey("allowGiftMessage"));

	}
	//Check HashMap values in List
	@SuppressWarnings("unchecked")
	@Test
	public void validateHashMapValueInList() {
		given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apikey", APIKEY)
		.when()
		.get("/search")
		.then()
		.body("items.findAll{it.name=='Apple iPod touch 128GB'}", hasItems(hasEntry("name","Apple iPod touch 128GB")));

	}
	//Multiple asserstions in a single test
	@SuppressWarnings("unchecked")
	@Test
	public void validateMultipleAssertionsinsingleTest() {
		given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apikey", APIKEY)
		.when()
		.get("/search")
		.then().assertThat()
		.statusCode(200)
		.and().contentType(ContentType.JSON)
		.body("items.findAll{it.name=='Apple iPod touch 128GB'}", hasItems(hasEntry("name","Apple iPod touch 128GB")))
		.body("items.name",hasItems("Apple iPod touch 16GB","Apple iPod touch 32GB"))
		.body("query",equalToIgnoringCase("Ipod"));
		
	}
	//logical assertions
	@Test
	public void validateAssertionsLogically() {
		given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apikey", APIKEY)
		.when()
		.get("/search")
		.then()
		.body("numItems",greaterThanOrEqualTo(10));
	}
	@SuppressWarnings("unchecked")
	@Test
	public void softAssertions() {
		given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apikey", APIKEY)
		.when()
		.get("/search")
		.then()
		.body("items.findAll{it.name=='Apple iPod touch 128GB'}", hasItems(hasEntry("name","Apple iPod touch 128GB")),
				"query",equalToIgnoringCase("Ipod"),
				"items.name",hasItems("Apple iPod touch 32GB","Apple iPod Touch 6th Generation 32GB Refurbished"),
				"items[0].giftOptions", hasKey("allowGiftMessage"));





	}
}
