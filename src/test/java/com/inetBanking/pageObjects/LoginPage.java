package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	WebDriver ldriver;
	 
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name = "uid")
	@CacheLookup
	public WebElement txtUserName;
	
	@FindBy(name = "password")
	@CacheLookup
	public WebElement txtPassword;
	
	@FindBy(name = "btnLogin")
	@CacheLookup
	public WebElement btnLogin;
	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	public WebElement linkLogout;
	
	
	public void setUserName(String username) 
	{ 
		txtUserName.sendKeys(username);
	}
	
	public void setPassword(String password) 
	{
		txtPassword.sendKeys("egutEzE");
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		linkLogout.click();
	}
	
	
}