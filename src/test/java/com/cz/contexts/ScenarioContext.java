package com.cz.contexts;

import java.util.HashMap;
import java.util.Map;

import com.cz.test.enumsandglobals.RunContext;

public class ScenarioContext {
	
	private  Map<String, Object> scenarioContext;
	 
    public ScenarioContext(){
    	scenarioContext = new HashMap<>();
    }

    public void setContext(RunContext key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(RunContext key){
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(RunContext key){
        return scenarioContext.containsKey(key.toString());
    }

}
