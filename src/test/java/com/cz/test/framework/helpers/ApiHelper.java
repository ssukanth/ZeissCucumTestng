package com.cz.test.framework.helpers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.cz.contexts.TestContexts;
import com.cz.test.enumsandglobals.RunContext;

/**
 * Every Api Step definition class should extend this class
 */

public class ApiHelper extends TestContexts {
    private static Gson gson;
    private TestContexts tCon;
   

	/*
	 * static { // RestAssured.baseURI = UrlBuilder.getBasePathURI().toString();
	 * RestAssured.baseURI="https://vhdemoservices.zeiss.com"; }
	 */

    public static RequestSpecification givenConfig() {
    	RestAssured.baseURI="https://vhdemoservices.zeiss.com";
    	RestAssured.proxy("defra99wsa03.cznet.zeiss.org", 8080);
    	RestAssured.useRelaxedHTTPSValidation();
        return given()
        		.when()
    			.log()
    			.all().contentType("application/json");
               
       }

    //Specify all one time default Gson config
    public static Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gson(gsonBuilder);
        return gson;
    }

    //Custom Gson config to override Default Gson  configuration
    public static Gson gson(GsonBuilder gsonBuilder) {
        gson = gsonBuilder.create();
        return gson;
    }
    
	/*
	 * public String authenticateWithIdToken() throws FileNotFoundException,
	 * IOException { String idPath="/AuthorisationServiceAPI/api/token"; //For
	 * generating Auth token Properties prop= new Properties(); prop.load(new
	 * FileInputStream(new File(new
	 * File(".")+"/src/test/resources/TestConfigs/credentials.properties"))); String
	 * aToken=prop.getProperty("appToken");
	 * System.out.println("The app toekn is :"+aToken);
	 * tCon.getScenarioContext().setContext(RunContext.REQSPEC,givenConfig());
	 * String authtoken=((RequestSpecification)tCon.getScenarioContext().getContext(
	 * RunContext.REQSPEC)) .header("Authorization","bearer "+aToken) .get(idPath)
	 * .jsonPath() .getString("access_token") .toString();
	 * System.out.println("The authtoken is:"+authtoken);
	 * //givenConfig().auth().oauth2(aToken);
	 * //System.out.println("The request is Authorized"); return aToken;
	 * 
	 * }
	 */


}