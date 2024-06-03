package com.inetBanking.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.utilities.ReadCustomerData;

public class TC_NewAccount_006 extends BaseClass {
	String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetBanking\\testData\\Customer.json";
	String customerId = ReadCustomerData.getCustomerId(filePath);
	
	@Test
	public void newAccount(WebDriver driver)throws Exception {
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[5]/a")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.name("cusid")).sendKeys(customerId);
		
		driver.findElement(By.name("inideposit")).sendKeys("5000");
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("button2")).click();

		String accountId = driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[4]/td[2]")).getText();
		
		String txt = driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[1]/td/p")).getText();
		String expectedTxt = "Account Generated Successfully!!!";
		if(txt == expectedTxt) {
			Assert.assertTrue(true);
			logger.info("Test Passed");
			ReadCustomerData.addAccountID(accountId);
			
		}else {
			Assert.assertTrue(false);
			logger.info("Test Failed");
		}
		
	}
}
