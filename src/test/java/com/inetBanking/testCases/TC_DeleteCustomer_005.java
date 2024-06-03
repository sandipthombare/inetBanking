package com.inetBanking.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.inetBanking.utilities.ReadCustomerData;

public class TC_DeleteCustomer_005 extends BaseClass{

	@Test
	public void deleteCustomer() throws Exception {
		
		Login login = new Login();
		login.doLogin();
		
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetBanking\\testData\\Customer.json";
		String customerId = ReadCustomerData.getCustomerId(filePath);
		
		WebElement customerDelBtn = driver.findElement(By.cssSelector("a[href='DeleteCustomerInput.php']")) ;
		WebElement customerIdInput = driver.findElement(By.name("cusid"));
		WebElement submitBtn = driver.findElement(By.name("AccSubmit"));
		
		ReadCustomerData.waitForElement(driver, customerDelBtn, 20);
		
		customerDelBtn.click();
		ReadCustomerData.waitForElement(driver, customerIdInput, 20);
		
		customerIdInput.sendKeys(customerId);
		submitBtn.click();
		
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
	}
}
