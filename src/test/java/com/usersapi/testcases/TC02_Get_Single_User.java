package com.usersapi.testcases;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.usersapi.base.TestBaserequsers;

import io.restassured.http.Method;
public class TC02_Get_Single_User extends TestBaserequsers{
	
     
	@BeforeClass
	void getsingleuser() throws InterruptedException
	{
	  logger.info("********Started TC02_Get_Single_User_Record*********"+"\n");
	  response = httpRequest.request(Method.GET,"users/1");
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
	    	 
	

	@AfterClass
	void tearDown()
	{
		logger.info("********Finished TC02_Get_Single_User_Record*********"+"\n");
	}
	
}
