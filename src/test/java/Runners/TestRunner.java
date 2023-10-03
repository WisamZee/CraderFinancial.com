package Runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		 plugin = {"pretty",
		 		"html:Cucumber_Report/Cucumber_Report/cucumber.html",
				 "json:Cucumber_Report/Cucumber_Report/cucumber.json"},
	features = "./src/test/resources/features",
	glue="Tests",
	tags="@CustomerManagement"
		)
		 

public class TestRunner {

}
