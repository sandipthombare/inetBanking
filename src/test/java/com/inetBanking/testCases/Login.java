package com.inetBanking.testCases;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.ReadCustomerData;

public class Login extends BaseClass{
	
	LoginPage lp = new LoginPage(driver);
	
	public void doLogin()throws Exception {
		ReadCustomerData.waitForElement(driver, lp.txtUserName, 20);
		
		lp.setUserName(username);
		logger.info("username provided");

		lp.setPassword(password);
		logger.info("password provided");

		lp.clickSubmit();
		Thread.sleep(3000);

		logger.info("Login Successful");
		
		
	}
	public void doLogout()throws Exception{
		lp.clickLogout();
	}
}
