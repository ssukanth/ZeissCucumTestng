package com.cz.suiterunners;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

//@RunWith(Cucumber.class)
@CucumberOptions(
		//features = "target/test-classes",
		features= {"src\\test\\resources\\features"},
		tags = {"@api"},
		monochrome = true,
		plugin =
		{
        "pretty", "html:target/cucumber-report/runapiat",
        "json:target/cucumber-report/runapiat/cucumber.json",
        "rerun:target/cucumber-report/runapiat/rerun.txt",
       // "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        glue = {"com.cz.suiterunners", "com.cz.test.step_definitions"})

public class RunApiATSuite extends AbstractTestNGCucumberTests  { 

} 
/*public class RunApiATSuite {
	
}*/

 

