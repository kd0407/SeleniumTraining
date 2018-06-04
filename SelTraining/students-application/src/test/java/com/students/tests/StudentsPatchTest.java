package com.students.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.student.base.TestBase;
import com.student.model.Student;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class StudentsPatchTest extends TestBase {

	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://localhost";
		RestAssured.port=9095;
		RestAssured.basePath="/student";
	}
	@Test 
	public void patchStudent()
	{
		ArrayList<String> courses= new  ArrayList<String>();
		courses.add("JAVA");
		courses.add("API Testing");
		courses.add("SOAP Testing");

		Student student = new Student();
		student.setFirstName("Lisa");
		student.setLastName("Ray");
		student.setEmail("ApiTesting@gmail.com");
		student.setProgramme("Online Learning");
		student.setCourses(courses);

		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.put("/101")
		.then()
		.statusCode(200);


	}

}

