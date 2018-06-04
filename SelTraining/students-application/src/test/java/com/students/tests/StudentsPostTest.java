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
public class StudentsPostTest extends TestBase {


	
	@Test 
	public void postStudent()
	{
		ArrayList<String> courses= new  ArrayList<String>();
		courses.add("JAVA");
		courses.add("API Testing");

		Student student = new Student();
		student.setFirstName("List");
		student.setLastName("Ray");
		student.setEmail("VosTesting2019@gmail.com");
		student.setProgramme("Online Learning");
		student.setCourses(courses);

		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);


	}

}
