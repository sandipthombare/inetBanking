 package com.inetBanking.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username provided");

		lp.setPassword(password);
		logger.info("password provided");

		lp.clickSubmit();
		
		logger.info("Login Successful");
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		logger.info("providing customer details....");
		
		Thread.sleep(5000);
		
		
		addcust.setCustomerName("Aman");
		addcust.selectGender("male");
		addcust.setDob("2", "05", "1990");
		
		Thread.sleep(3000);
		
		addcust.setAddress("India");
		addcust.setCity("PUNE");
		Thread.sleep(3000);
		addcust.setState("MAHARASHTRA");
		addcust.setPinNo(411001);
		addcust.setTelephoneNo("8745624975");
		
		addcust.setEmailId(randomString()+"@gmail.com");
		addcust.setPassword("User@123");
		Thread.sleep(3000);

		addcust.clickSubmit();
		
		Thread.sleep(5000);
		
		logger.info("validation started....");

		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (res == true)
		{
			Assert.assertTrue(true);
			logger.info("test passed");

		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			logger.info("test failed");

			Assert.assertTrue(false);
		}
		
	}
	

}

