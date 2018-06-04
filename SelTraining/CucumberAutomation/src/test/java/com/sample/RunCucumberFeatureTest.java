package com.sample;


import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features = {"src/test/resources/Features"},
        glue = {"src/test/java/stepdefs"}
		)
public class RunCucumberFeatureTest extends AbstractTestNGCucumberTests{
	
	

}
