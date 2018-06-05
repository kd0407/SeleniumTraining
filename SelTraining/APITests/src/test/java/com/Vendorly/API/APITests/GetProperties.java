package com.Vendorly.API.APITests;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.testng.annotations.Test;

public class GetProperties {

	Properties property;
	FileInputStream fs;
	
	@Test
	public void buildHeader() throws IOException {
		
		
		//loading the configuration property file to load the data for printing it later
		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		System.out.println(System.getProperty("user.dir"));
		property=new Properties();
		property.load(fs);
		//get configuration properties values and print it
		System.out.println(property.getProperty("uid"));
		System.out.println(property.getProperty("Content-Type"));
		System.out.println(property.getProperty("vendorId"));
		
		
	}
}
