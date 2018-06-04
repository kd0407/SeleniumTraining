package com.students.tests;

import org.junit.BeforeClass;
import org.junit.Test;

import com.student.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class StudentGetTest extends TestBase {


	@Test
	public void getAllStudentsInformation() {


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
	}

	@Test
	public void getStudentInfo() {
		Response response= given()
				.when()
				.get("/2");

		System.out.println(response.body().prettyPrint());

	}
	@Test
	public void getStudentsFromLaw() {
		/**Response response= given()
				.when()
				.get("/list?programme=Law");

		//System.out.println(response.body().prettyPeek());**/
		Response response= given()
				.param("programme", "Law")
				.param("limit",3)
				.when()
				.get("/list");
		System.out.println(response.body().prettyPeek());


	}

}

