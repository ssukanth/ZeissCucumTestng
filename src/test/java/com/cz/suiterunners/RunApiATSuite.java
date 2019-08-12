package com.cz.suiterunners;

import org.junit.runner.RunWith;
//import com.vimalselvam.cucumber.listener.ExtentProperties;
//import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "target/test-classes",
		//features= {"src\\test\\resources\\features"},
		tags = {"@api"},
		monochrome = true,
		plugin =
		{
        "pretty", "html:target/cucumber-report/runapiat",
        "json:target/cucumber-report/runapiat/cucumber.json",
        "rerun:target/cucumber-report/runapiat/rerun.txt",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        glue = {"com.cz.test.step_definitions"})

public class RunApiATSuite extends AbstractTestNGCucumberTests
{ 
		
} 


 

