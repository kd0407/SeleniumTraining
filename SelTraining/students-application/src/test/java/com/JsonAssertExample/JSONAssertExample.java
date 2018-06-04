package com.JsonAssertExample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import com.student.base.TestBase;

import io.restassured.RestAssured;

public class JSONAssertExample extends TestBase {
	@Test
	public void getStudentList() throws IOException, JSONException {
		String expectedValue = new String(Files.readAllBytes(Paths.get("D://Restassured//StudentList.txt")));
		System.out.println(expectedValue);
		String actualValue = RestAssured.given().when().get("http://localhost:9095/student/list").body().asString();
		System.out.println(actualValue);
		//JSONAssert.assertEquals(expectedValue, actualValue, false);
		JSONAssert.assertEquals(expectedValue, actualValue, JSONCompareMode.LENIENT);
		
	}

}
