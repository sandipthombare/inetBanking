package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws Exception
	{		
		logger.info("URL is opened");
		
		Login login = new Login();
		login.doLogin();
				
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) 
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");

		}
		else {
			
			logger.info("Login test failed");
			captureScreen(driver,"logintest001");
			Assert.assertTrue(false);

		}
		
	}
}
 