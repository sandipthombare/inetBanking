package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rGender;
	
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtpinno;
	
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnSubmit;
	
	
    public void clickAddNewCustomer() {
        lnkAddNewCustomer.click();
    }
    

    public void setCustomerName(String cname) {
        txtCustomerName.sendKeys(cname);
    }

    public void selectGender(String gender) {
        rGender.click(); // Assuming there's only one gender radio button and it's selected based on click
    }

    public void setDob(String mm, String dd, String yyyy) {
        txtdob.sendKeys(mm);
        txtdob.sendKeys(dd);
        txtdob.sendKeys(yyyy);
    }

    public void setAddress(String caddress) {
        txtaddress.sendKeys(caddress);
    }

    public void setCity(String ccity) {
        txtcity.sendKeys(ccity);
    }

    public void setState(String cstate) {
        txtstate.sendKeys(cstate);
    }

    public void setPinNo(int cpinno) {
        txtpinno.sendKeys(String.valueOf(cpinno));
    }

    public void setTelephoneNo(String ctelephoneno) {
        txttelephoneno.sendKeys(ctelephoneno);
    }

    public void setEmailId(String cemailid) {
        txtemailid.sendKeys(cemailid);
    }

    public void setPassword(String cpassword) {
        txtpassword.sendKeys(cpassword);
    }

    public void clickSubmit() {
        btnSubmit.click();
    }
}
