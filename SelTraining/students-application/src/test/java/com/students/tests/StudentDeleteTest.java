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

public class StudentDeleteTest extends TestBase {

	
	@Test 
	public void deleteStudent()
	{
		
		given()
		.when()
		.delete("/101")
		.then()
		.statusCode(204);


	}

}

