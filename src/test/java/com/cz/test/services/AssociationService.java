package com.cz.test.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.cz.contexts.TestContexts;
import com.cz.test.framework.helpers.ApiHelper;
import com.cz.test.models.api.CreateAssociation;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AssociationService extends ApiHelper{
	
	//CreateAssociation
	
	 public static Response postAssociation(String ascDetails,RequestSpecification req) {      
		 
		 String path="/UserServiceAPI/api/Association/CreateAssociation";		
		  return req. body(ascDetails). when(). post(path);
		 
	    }

	 
	 public CreateAssociation create_AssociationPayload(String option)
	 {
		 CreateAssociation ca=null;
		 String name =null;
		 switch(option.toLowerCase())
		 {
		 case "valid":	name="zeissapitest"+
				 		new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").
				 		format(new Date()).replace("-", 	"")
				 		.replace(":", "")
				 		.replace(" ", "_");
		 		ca= new CreateAssociation(0,name,"Please Ignore",true);
		 case "duplicate":	ca= new CreateAssociation(0,"zeissapitest","Please Ignore",true);	
		 case "idNull":		ca= new CreateAssociation(120,name,"Please Ignore",true);
		 case "namenull":	ca= new CreateAssociation(0,name,"Please Ignore",true);
		 }
		 
		return ca;
		 
	 }

}
