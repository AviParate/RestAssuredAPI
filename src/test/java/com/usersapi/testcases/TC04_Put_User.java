package com.usersapi.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.usersapi.base.TestBaserequsers;
import com.usersapi.utilities.RestUtils;

import io.restassured.http.Method;
public class TC04_Put_User extends TestBaserequsers{

	
	String userName = RestUtils.userName();
	String userJob = RestUtils.userJob();	
     
	@BeforeClass
	void updateuser() throws InterruptedException
	{
	  logger.info("********Started TC04_Put_User*********"+"\n");
	  	  
	  JSONObject requestParams = new JSONObject();
	  requestParams.put("name", userName);
	  requestParams.put("job", userJob);	
	  
	  httpRequest.body(requestParams.toJSONString());
	  response = httpRequest.request(Method.PUT,"users/2");	  
	  Thread.sleep(3000);
	
	}
	

	@Test
	void responsebodycheck()
	{       
		TestBaserequsers.checkresponsebody();		    
	}
	   	 
	@Test
	void statuscodecheck()
	{		        
		TestBaserequsers.checkstatuscode200();		    
	}
	  
	@Test
	void statuslinecheck()
	{	        			
		TestBaserequsers.checkstatusline();		    
	}
	  
	@Test
	void contenttypecheck()
	{
		TestBaserequsers.checkContentType();
	}
	    

	@Test
	void responsebodyputcheck()
	{
	       	String responsebody = response.getBody().asString();
			Assert.assertEquals(responsebody.contains(userName), true);
			Assert.assertEquals(responsebody.contains(userJob), true);
						
	}

	
	@AfterClass
	void tearDown()
	{
		logger.info("********Finished TC04_Put_User*********"+"\n");
	}
	
}
