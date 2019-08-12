package com.cz.test.enumsandglobals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cz.test.framework.helpers.ApiHelper;

public class Globals {
		static ApiHelper apih= new ApiHelper();
	public static ExtentReports extRep;
	public static ExtentTest featureDefs;
	public static ExtentTest scenarioDefs;
	public static String reportLocation="\\src\\test\\resources\\Reports\\";
	private static String authToken;
	
	public static String getAuthToken() throws FileNotFoundException, IOException
	{
		if(authToken!=null)
		{
			System.out.println("The authToken Already generated");
		}else
		{
			authToken=authenticateWithIdToken();
		}
		return authToken;
	}
	public static void setAuthToken(String authToken) {
		Globals.authToken = authToken;
	}
	public static  ExtentReports getExtRep() throws IOException {
		if(extRep!=null)
		{
			System.out.println("The extent report is already initialized");
		}else
		{
			System.out.println("The extent reports are initialized");
			extRep= new ExtentReports();
			String repLoc=new File(".").getCanonicalPath()+reportLocation+"Extents.html";
			System.out.println("Saving the report at the location at :");
			System.out.println(repLoc);
			ExtentHtmlReporter htm= new ExtentHtmlReporter(repLoc);
			htm.config().setTheme(Theme.DARK);
			htm.config().setDocumentTitle("APITest RunReport");
			htm.config().setEncoding("utf-8");		
			getExtRep().attachReporter(htm);
			System.out.println("The reporter attached");

		}
		
		return extRep;
	}
	public static void setExtRep(ExtentReports extRep) {
		extRep = extRep;
	}
	public static ExtentTest getFeatureDefs() {
		return featureDefs;
	}
	public static void setFeatureDefs(ExtentTest featureDefs) {
		Globals.featureDefs = featureDefs;
	}
	public static ExtentTest getScenarioDefs() {
		return Globals.scenarioDefs;
	}
	public static void setScenarioDefs(ExtentTest scenarioDefs) {
		Globals.scenarioDefs = scenarioDefs;
	}
	
	 public static String authenticateWithIdToken() throws FileNotFoundException, IOException
	    {
	    	String idPath="/AuthorisationServiceAPI/api/token";
	    	//For generating Auth token
	    	Properties prop= new Properties();
			prop.load(new FileInputStream(new File(new File(".")+"/src/test/resources/TestConfigs/credentials.properties")));
			String aToken=prop.getProperty("appToken");
			System.out.println("The app token is :"+aToken);
			String authtoken=apih.givenConfig()
	    			.header("Authorization","Bearer "+aToken)
	    			.header("Content-Type", "application/json")
	    			.get(idPath)
	    			.jsonPath()
	    			.getString("access_token")
	    			.toString();
	    		return authtoken;
	    	
	    }


}
