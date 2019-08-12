package com.cz.test.step_definitions.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/*import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.GherkinKeyword;
import com.cz.contexts.TestContexts;
import com.cz.test.enumsandglobals.RunContext;
import com.cz.test.framework.helpers.ApiHelper;
import com.cz.test.services.AssociationService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class AssociationServiceSteps extends ApiHelper
{
	private TestContexts tCon;
	public AssociationService asc;
	
	public AssociationServiceSteps(TestContexts cont)
	{
		tCon=cont;	
		asc= new AssociationService();
	}
	
	@Given("^Service Authorized With The App token$")
	public void service_Authorized_With_The_App_token() throws Throwable {
		String auth=getAuthToken();
		System.out.println("The authtoken is:"+auth);
		tCon.getScenarioContext().setContext(RunContext.REQSPEC,givenConfig().headers("Authorization","Bearer "+auth))		;
	}

	@Given("^Valid Association Payload Created$")
	public void valid_Association_Payload_Created() throws Throwable {
	    tCon.getScenarioContext().setContext(RunContext.PAYLOAD,asc.create_AssociationPayload("valid"));
	}

	@When("^Association Posted$")
	public void association_Posted() throws Throwable {
		String pa=gson().toJson(tCon.getScenarioContext().getContext(RunContext.PAYLOAD));
		System.out.println("The Converted String is ".toUpperCase());
		System.out.println(pa);
	   tCon.getScenarioContext().setContext(RunContext.RESPONSE,
			   asc.postAssociation(pa,(RequestSpecification)tCon.getScenarioContext().getContext(RunContext.REQSPEC)));
	}

	@Then("^Verify The Status Code for (\\d+)$")
	public void verify_The_Status_Code_for(int arg1) throws Throwable {
		Response res=(Response) tCon.getScenarioContext().getContext(RunContext.RESPONSE);
		System.out.println("The reposne is :".toUpperCase());
		System.out.println(res.body().asString());
		assertEquals(res.getStatusCode(), 200);
	}

	@Then("^Assciation Id Not Null$")
	public void assciation_Id_Not_Null() throws Throwable {
		int id=((Response)tCon.getScenarioContext().getContext(RunContext.RESPONSE))
				.jsonPath().getInt("Id");
		System.out.println("The Id is ".toUpperCase());
		System.out.println(id);
		assertNotNull("The car should not be null", id);
	}
	
	

	

}
