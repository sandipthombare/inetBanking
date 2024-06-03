 package com.inetBanking.testCases;


import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.utilities.ReadCustomerData;
public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws Exception {
		
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetBanking\\testData\\Customer.json";
		JSONObject userObject = ReadCustomerData.loadJSONFile(filePath);
		
		String customername = userObject.get("CustomerName").toString();
		String gender = userObject.get("Gender").toString();
		
		JSONObject dob =(JSONObject) userObject.get("DateOfBirth");
		String date = (String) dob.get("Date");
		String month = (String) dob.get("Month");
		String year = (String) dob.get("Year");
		
		String address = userObject.get("Address").toString();
		String city = userObject.get("City").toString();
		String pin = userObject.get("PIN").toString();
		String state = userObject.get("State").toString();
		String mobilenumber = userObject.get("MobileNumber").toString();
		String email = userObject.get("E-mail").toString();
		String password = userObject.get("Password").toString();
		String customerid = userObject.get("CustomerId").toString();

		Login login = new Login();
		login.doLogin();
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		logger.info("providing customer details....");
		
		Thread.sleep(5000);
		
		
		addcust.setCustomerName(customername);
		addcust.selectGender(gender);
		addcust.setDob(date,month,year);
		
		Thread.sleep(3000);
		
		addcust.setAddress(address);
		addcust.setCity(city);
		Thread.sleep(3000);
		addcust.setState(state);
		addcust.setPinNo(Integer.parseInt(pin));
		addcust.setTelephoneNo(mobilenumber);
		
		addcust.setEmailId(email);
		addcust.setPassword(password);
		Thread.sleep(3000);

		addcust.clickSubmit();
		
		Thread.sleep(5000);
		
		String customerId = addcust.customerId();
		Thread.sleep(2000);
		
		ReadCustomerData.addCustomerID(customerId);
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

