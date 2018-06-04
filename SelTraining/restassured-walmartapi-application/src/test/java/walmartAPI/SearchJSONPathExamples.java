package walmartAPI;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;


import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SearchJSONPathExamples extends BaseURL {

	static final String APIKEY="pmptpp3gyka29jpd6bxqvvqt";
	
	@Test
	public void getNoOfItems() {

		int numItems = given()
				.queryParam("query", "ipod")
				.queryParam("format", "json")
				.queryParam("apikey", APIKEY)
				.when()
				.get("/search")
				.then().extract().path("numItems");		

		System.out.println("...........Starting test.................");
		System.out.println("No of items:" + numItems);
		System.out.println("...........End of test.................");
        Reporter.log("Test case has passed-getNoOfTimes");
	}
	@Test
	public void validateNoOfItems() {

		given()
				.queryParam("query", "ipod")
				.queryParam("format", "json")
				.queryParam("apikey", APIKEY)
				.when()
				.get("/search")
				.then().body("numItems",equalTo(10));
		Reporter.log("Test case has passed-ValidateNo)fItems");
	}
	@Test
	public void getItemName() {
		String itemName = given()
				.queryParam("query", "ipod")
				.queryParam("format", "json")
				.queryParam("apikey", APIKEY)
				.when()
				.get("/search")
				.then().extract().path("items[0].name");		

		System.out.println("...........Starting test.................");
		System.out.println("Item name:" + itemName);
		System.out.println("...........End of test.................");

	}
	@Test
	public void getItemGiftOptions() {
		HashMap <String,String> giftOptions= given()
				.queryParam("query", "ipod")
				.queryParam("format", "json")
				.queryParam("apikey", APIKEY)
				.when()
				.get("/search")
				.then().extract().path("items[0].giftOptions");		

		System.out.println("...........Starting test.................");
		System.out.println("The gift option under first item:" + giftOptions);
		System.out.println("...........End of test.................");


	}
	@Test
	public void itemSize() {
		int itemsSize= given()
				.queryParam("query", "ipod")
				.queryParam("format", "json")
				.queryParam("apikey", APIKEY)
				.when()
				.get("/search")
				.then().extract().path("items.size()");		

		System.out.println("...........Starting test.................");
		System.out.println("Item Size:" + itemsSize);
		System.out.println("...........End of test.................");


	}
	@Test
	public void allNamesInItems() {
		List <String> namesInItems= given()
				.queryParam("query", "ipod")
				.queryParam("format", "json")
				.queryParam("apikey", APIKEY)
				.when()
				.get("/search")
				.then().extract().path("items.name");		

		System.out.println("...........Starting test.................");
		System.out.println("Names in Items List:" + namesInItems);
		System.out.println("...........End of test.................");


	}
	@Test
	public void allValuesInAParticularNode() {
		List <HashMap<String,Object>> values= given()
				.queryParam("query", "ipod")
				.queryParam("format", "json")
				.queryParam("apikey", APIKEY)
				.when()
				.get("/search")
				.then().extract().path("items.findAll{it.name=='Apple iPod touch 128GB'}");		

		System.out.println("...........Starting test.................");
		System.out.println("Values in Items name:" + values);
		System.out.println("...........End of test.................");


	}
	@Test
	public void getSalePriceOfItem() {
		List <Float> salePriceOfItem= given()
				.queryParam("query", "ipod")
				.queryParam("format", "json")
				.queryParam("apikey", APIKEY)
				.when()
				.get("/search")
				.then().extract().path("items.findAll{it.name=='Apple iPod touch 128GB'}.salePrice");		

		System.out.println("...........Starting test.................");
		System.out.println("SalePrice in Items name:" + salePriceOfItem);
		System.out.println("...........End of test.................");


	}
	@Test
	public void getResponseTime() {
		long responseTime= given()
				.queryParam("query", "ipod")
				.queryParam("format", "json")
				.queryParam("apikey", APIKEY)
				.when()
				.get("/search")
				.timeIn(TimeUnit.MILLISECONDS);
				
				//.then().extract().path("items.findAll{it.name=='Apple iPod touch 128GB'}.salePrice");		

		System.out.println("...........Starting test.................");
		System.out.println("Response time:" + responseTime + "seconds");
		System.out.println("...........End of test.................");


	}

    

}
