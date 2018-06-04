package com.students.loggingexample;

import com.student.base.TestBase;
import com.student.model.Student;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.junit.Test;

import static io.restassured.RestAssured.*;

public class LoggingRequestValues extends TestBase{
	
	@Test
	public void test001() {
		System.out.println("....................Printing Header Info................");
		given()
		.log().headers()
		.when()
		.get("/1")
		.then()
		.statusCode(200);
	
	}
	@Test
	public void test002() {
		System.out.println("....................Printing Parameter Info................");
		given()
		.param("programme", "Law")
		.param("limit", 2)
		.log().params()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
	
	}
	@Test
	public void test003() {
		
		System.out.println("....................Printing Request body response Info................");
		ArrayList<String> courses= new  ArrayList<String>();
		courses.add("JAVA");
		courses.add("API Testing");

		Student student = new Student();
		student.setFirstName("Maple");
		student.setLastName("Rai");
		student.setEmail("API@gmail.com");
		student.setProgramme("Online Learning");
		student.setCourses(courses);

		given()
		.contentType(ContentType.JSON)
		.log().body()
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);

	}
	@Test
public void test004() {
		
		System.out.println("....................Printing All Request details................");
		ArrayList<String> courses= new  ArrayList<String>();
		courses.add("JAVA");
		courses.add("API Testing");

		Student student = new Student();
		student.setFirstName("Sia");
		student.setLastName("Rue");
		student.setEmail("API2021@gmail.com");
		student.setProgramme("Online Learning");
		student.setCourses(courses);

		given()
		.contentType(ContentType.JSON)
		.log().all()
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);

	}
}
