package CucumberWithTestNG.CucumberWithTestNG;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features  = "src/main/java/CucumberWithTestNG/CucumberWithTestNG",
		glue =      "stepdefs",
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport.html"}
		)
public class CucumberRunner extends AbstractTestNGCucumberTests{
	

}
