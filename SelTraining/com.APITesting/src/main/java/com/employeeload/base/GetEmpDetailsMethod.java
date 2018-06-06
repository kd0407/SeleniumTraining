package com.employeeload.base;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class GetEmpDetailsMethod {

	@BeforeClass
	public  void init() {
		RestAssured.baseURI = "http://vos-qa-central1.altidev.net:8080/vos-central/api";
		//RestAssured.port=8080;
		//RestAssured.basePath="/vos-central/api";
	}
}


