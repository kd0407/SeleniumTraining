package com.Vendorly.Utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	
	public static ExtentReports getInstance() {
		ExtentReports extent;
		String path = "D:\\ExtentReports\\APITestResults.html";
		extent=new ExtentReports(path, false);
		extent
		.addSystemInfo("Restassured","3.1");
		
		return extent;
	}

}
