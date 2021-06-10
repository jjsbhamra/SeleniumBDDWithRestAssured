package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"C:\\projects\\workspace\\seleniumBDDCucumber\\Features\\Login.feature"}, 
	glue = {"stepDefinitions"}
	,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	,monochrome = true
	,publish = true)

public class TestRunner extends AbstractTestNGCucumberTests{
}
