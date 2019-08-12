package com.cz.extents;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cz.test.enumsandglobals.Globals;

import cucumber.api.Scenario;

public class ExtentReps extends Globals {
	
	public void ExtentReport() throws IOException
	{		
		/*
		 * String repLoc=new File(".").getCanonicalPath()+reportLocation+"Extents.html";
		 * System.out.println("Saving the report at the location at :");
		 * System.out.println(repLoc); ExtentHtmlReporter htm= new
		 * ExtentHtmlReporter(repLoc); htm.config().setTheme(Theme.DARK);
		 * htm.config().setDocumentTitle("APITest RunReport");
		 * htm.config().setEncoding("utf-8"); getExtRep().attachReporter(htm);
		 * System.out.println("The reporter attached");
		 */
	}

	
	public void saveRep() throws IOException
	{
		getExtRep().flush();
		System.out.println("The report has been saved");
	}
	
	public void setScenario(Scenario sc)
	{
		System.out.println("Setting the Scenario name for the fature");
		setFeatureDefs(featureDefs.createNode(sc.getName(), "For testing the scenario"));
		
	}
	
	public void setStepName(GherkinKeyword gh, String stepName)
	{
		scenarioDefs.createNode(gh,stepName);
	}
}
