package Runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		 plugin = {"pretty",
		 		"html:Cucumber-report/cucumber-report/cucumber.html",
				 "json:Cucumber-report/cucumber-report/cucumber.json"},
	features = "./src/test/resources/features",
	glue="Tests",
	tags="@SmokeTest"
		)
		 

public class TestRunner {

}
