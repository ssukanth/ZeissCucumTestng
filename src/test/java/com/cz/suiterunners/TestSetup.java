package com.cz.suiterunners;
import com.cz.extents.ExtentReps;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestSetup  extends ExtentReps{

	
	  @Before() public void startScenario(Scenario sc) {
	  System.out.println("Before Running".toUpperCase());
	  }
	  
	  @After() public void endScenario(Scenario sc)
	  {
		  System.out.println("The After Running".toUpperCase());
	  }
	 
	
	
}
