package TestRunner;
	
	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(features= {"C:\\Users\\navze\\eclipse-workspace\\Corsearch\\Features\\Screening.feature"},dryRun=false,
	glue={"StepDefinition"},
	tags=("@QueryViews"),
	plugin= {"pretty","html:target/htmlreport.html"},
	monochrome=true)

	public class CucumberTestRunner extends AbstractTestNGCucumberTests{


	}


