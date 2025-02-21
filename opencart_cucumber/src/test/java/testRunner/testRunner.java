package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features = {".//Features/"},
		features = {".//Features/login.feature"},
		//features = {".//Features/Registration.feature"},
		//features = {".//Features/LoginDDTExcel.feature"},
		//features = {".//Features/Login.feature",".//Features/Registration.feature"},
		//features = {"@target/rerun.txt"},
		glue = {"stepDefinition", "hooks"},
		plugin = {"pretty", "html:reports/myreports.html",
				   "rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
		
		dryRun = false, //checks mapping between scenario steps and step definition methods
		monochrome=true, //to avoid junk characters in output
		publish=true // to publish report in cucumber server
		//tags = "@sanity" // this will execute scenarios tagged with @sanity
		//tags = "@regression"
		//tags = "@sanity and  @regression" //scenarios tagged with both @sanity and @regression
		//tags = "@sanity and not regression"// scenarios tagged with both @sanity and not @regression
		//tags = "@sanity or @regression" //scenarios tagged with either @sanity or @regression
		
		)



public class testRunner {

}
