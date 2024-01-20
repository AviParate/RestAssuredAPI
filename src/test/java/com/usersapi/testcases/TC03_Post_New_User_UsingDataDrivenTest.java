package com.usersapi.testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.usersapi.base.TestBaserequsers;
import com.usersapi.utilities.RestUtils;
import com.usersapi.utilities.XLUtils;

import io.restassured.http.Method;
public class TC03_Post_New_User_UsingDataDrivenTest extends TestBaserequsers{

		    
	@Test(dataProvider="userdataprovider")
	void postnewuser(String userName, String userJob) throws InterruptedException
	{
	  logger.info("********Started TC03_Post_New_User*********"+"\n");
	  
	  JSONObject requestParams = new JSONObject();
	  requestParams.put("name", userName);
	  requestParams.put("job", userJob);	
	 
	  httpRequest.body(requestParams.toJSONString());
	  response = httpRequest.request(Method.POST,"users");  
	  Thread.sleep(3000);
	  
	  
	    logger.info("Checking Response Body");
		String responsebody = response.getBody().asString();
		logger.info("Response Body==>"+ "\n"+responsebody+"\n");
		Assert.assertTrue(responsebody!=null);
		
		
		logger.info("Checking Status Code");
	    int statusCode = response.getStatusCode();
	    logger.info("Status Code is==>"+statusCode+"\n");
	    Assert.assertEquals(statusCode,  201);
	    
	    logger.info("Checking Status Line");
		String statusline = response.getStatusLine();
		logger.info("Status Line is==>"+statusline+"\n");
		Assert.assertEquals(statusline, "HTTP/1.1 201 Created");
		
		
		logger.info("Checking Content Type");	
		String contentType = response.header("Content-Type");
		logger.info("Content type is ==>" +contentType+"\n");
		Assert.assertEquals(contentType.contains("application/json"),true );
	
	}
	
	

	@DataProvider(name="userdataprovider")
	String [][] getuserdata() throws IOException
	{
		//Read data from Excel
		String path =  System.getProperty("user.dir")+"/src/test/java/com/usersapi/utilities/userapidata.xlsx";
		
		int rownum = XLUtils.getRowCount(path,"Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String userapidata[][]= new String[rownum][colcount];
		
		for(int i=1; i<=rownum; i++) {
			for(int j=0; j<colcount; j++) {
				userapidata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return(userapidata);
	}
	
	
	
	@AfterClass
	void tearDown()
	{
		logger.info("********Finished TC03_Post_New_User*********"+"\n");
	}
	
}
