package com.usersapi.testcases;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.usersapi.base.TestBaserequsers;

import io.restassured.http.Method;
public class TC06_Get_All_Users2 extends TestBaserequsers{
	
     
	@BeforeClass
	void getallusers() throws InterruptedException
	{
	  logger.info("********Started TC01_Get_All_Users*********"+"\n");
	  response = httpRequest.request(Method.GET,"users?page=1");
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
		logger.info("********Finished TC01_Get_All_Users*********"+"\n");
	}
	
}
