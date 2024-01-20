package com.usersapi.testcases;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.usersapi.base.TestBaserequsers;

import io.restassured.http.Method;
public class TC05_Delete_User extends TestBaserequsers{

     
	@BeforeClass
	void deleteuser() throws InterruptedException
	{
	  logger.info("********Started TC05_Delete_User*********"+"\n");
	  //response = httpRequest.request(Method.GET,"/employees");
	  
	//First get the JsonPath object instance from the Response interface
	  //JsonPath jsonPathEvaluator = response.jsonPath();
	  
	  //JSONObject requestParams = new JSONObject();
	  //httpRequest.body(requestParams.toJSONString());
	  
	//Capture id
	//String empID1 = jsonPathEvaluator.get("[0].id");
	response = httpRequest.request(Method.DELETE,"users/2"); //Pass ID to delete record
	
	Thread.sleep(3000);
	
	}

   	 
	@Test
	void statuscodecheck()
	{		        
		TestBaserequsers.checkstatuscode204();		    
	}
	  
	@Test
	void statuslinecheck()
	{	        			
		TestBaserequsers.checkstatuslinedelete();		    
	}
	     	 
	
	@AfterClass
	void tearDown()
	{
		logger.info("********Finished TC05_Delete_User*********");
	}
	
}
