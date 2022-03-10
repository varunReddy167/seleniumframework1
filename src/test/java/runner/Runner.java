package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features="src/test/java/features",
		glue="stepdefinitations",
		dryRun=false,
		monochrome=true,
				
		plugin = {"pretty",
				"html:target/html/",
				"json:target/json/file.json"}
		)
public class Runner  extends AbstractTestNGCucumberTests{

}
