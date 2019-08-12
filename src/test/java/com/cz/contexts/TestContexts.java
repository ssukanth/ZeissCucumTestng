package com.cz.contexts;

import com.cz.test.enumsandglobals.Globals;

public class TestContexts extends Globals {
	public ScenarioContext scContext;	
	
	public TestContexts()
	{
		scContext= new ScenarioContext();
	}
	
	public ScenarioContext getScenarioContext() {
		 return scContext;
		 }

}
