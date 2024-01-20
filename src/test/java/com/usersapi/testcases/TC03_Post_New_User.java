package com.usersapi.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.usersapi.base.TestBaserequsers;
import com.usersapi.utilities.RestUtils;

import io.restassured.http.Method;
public class TC03_Post_New_User extends TestBaserequsers{

	
	String userName = RestUtils.userName();
	String userJob = RestUtils.userJob();	
	
     
	@BeforeClass
	void postnewuser() throws InterruptedException
	{
	  logger.info("********Started TC03_Post_New_User*********"+"\n");
	  
	  JSONObject requestParams = new JSONObject();
	  requestParams.put("name", userName);
	  requestParams.put("job", userJob);	
	 
	  httpRequest.body(requestParams.toJSONString());
	  response = httpRequest.request(Method.POST,"users");  
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
		TestBaserequsers.checkstatuscode201();		    
	}
	  
	@Test
	void statuslinecheck()
	{	        			
		TestBaserequsers.checkstatuslinepost();		    
	}
	  
	@Test
	void contenttypecheck()
	{
		TestBaserequsers.checkContentType();
	}
	    
	@Test
	void responsebodypostcheck()
	{
	       	String responsebody = response.getBody().asString();
			Assert.assertEquals(responsebody.contains(userName), true);
			Assert.assertEquals(responsebody.contains(userJob), true);
						
	}

	
	@AfterClass
	void tearDown()
	{
		logger.info("********Finished TC03_Post_New_User*********"+"\n");
	}
	
}
