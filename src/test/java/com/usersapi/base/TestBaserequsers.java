package com.usersapi.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBaserequsers {
	
	
	public static RequestSpecification httpRequest;
	public static Response response;
	//public String empID="5"; //Hard coded - Input for Get details of Single Employee & update employee
	
	public static Logger logger;
	public String baseURI;
	
	
		
	@BeforeClass
	public void setup(){
		
			logger=Logger.getLogger("ReqRestAPI");//added Logger
			PropertyConfigurator.configure("Log4j.properties"); //added logger
			logger.setLevel(Level.DEBUG);	
			RestAssured.baseURI = "https://reqres.in/api/";
			httpRequest = RestAssured.given().contentType(ContentType.JSON);
	}
	
	
	
	//Response Validations
	public static void checkresponsebody()
	{
	        logger.info("Checking Response Body");
			String responsebody = response.getBody().asString();
			logger.info("Response Body==>"+ "\n"+responsebody+"\n");
			Assert.assertTrue(responsebody!=null);
				
	}



	public static void checkstatuscode200()
	{
	        logger.info("Checking Status Code");
			int statusCode = response.getStatusCode();
			logger.info("Status Code is==>"+statusCode+"\n");
			Assert.assertEquals(statusCode, 200);
			
	}

	
	public static void checkstatuscode201()
	{
		    logger.info("Checking Status Code");
		    int statusCode = response.getStatusCode();
		    logger.info("Status Code is==>"+statusCode+"\n");
		    Assert.assertEquals(statusCode,  201);
	}
	
	
	public static void checkstatuscode204()
	{
		    logger.info("Checking Status Code");
		    int statusCode = response.getStatusCode();
		    logger.info("Status Code is==>"+statusCode+"\n");
		    Assert.assertEquals(statusCode,  204);
	}
	
	
	public static void checkstatusline()
	{
	        logger.info("Checking Status Line");
			String statusline = response.getStatusLine();
			logger.info("Status Line is==>"+statusline+"\n");
			Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}
	
	
	public static void checkstatuslinepost()
	{
	        logger.info("Checking Status Line");
			String statusline = response.getStatusLine();
			logger.info("Status Line is==>"+statusline+"\n");
			Assert.assertEquals(statusline, "HTTP/1.1 201 Created");
	}
	
	
	public static void checkstatuslinedelete()
	{
	        logger.info("Checking Status Line");
			String statusline = response.getStatusLine();
			logger.info("Status Line is==>"+statusline+"\n");
			Assert.assertEquals(statusline, "HTTP/1.1 204 No Content");
	}
	
	
	public static void checkContentType()
	{
		logger.info("Checking Content Type");
		
		String contentType = response.header("Content-Type");
		logger.info("Content type is ==>" +contentType+"\n");
		Assert.assertEquals(contentType.contains("application/json"),true );
	}
	
	
}