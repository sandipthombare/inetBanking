package com.inetBanking.testCases;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.inetBanking.utilities.ReadCustomerData;

public class TC_EditCustomer_004 extends BaseClass{
	
	@Test
	public void EditCustomer() throws Exception {
//		WebElement edit = driver.findElement(By.xpath("//p[@class=\"heading3\"]"));

		String filepath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\inetBanking\\testData\\Customer.json";
		JSONObject userObject = ReadCustomerData.loadJSONFile(filepath);
		
		Login login = new Login();
		login.doLogin();		
		
		WebElement EditBtn = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]/a"));
		ReadCustomerData.waitForElement(driver,EditBtn,10);
		String address = userObject.get("Address").toString();
		String city = userObject.get("City").toString();
		String pin = userObject.get("PIN").toString();
		String state = userObject.get("State").toString();
		String mobilenumber = userObject.get("MobileNumber").toString();
		String email = userObject.get("E-mail").toString();
		String password = userObject.get("Password").toString();
		String customerid = userObject.get("CustomerId").toString();

		
		EditBtn.click();
		
		
		
	}
}
