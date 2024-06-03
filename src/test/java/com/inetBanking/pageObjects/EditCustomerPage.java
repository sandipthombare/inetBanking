package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	WebDriver ldriver;
	public EditCustomerPage(WebDriver rdriver) {
		ldriver = rdriver ;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name = "addr")
	WebElement txtaddress;
	@FindBy(name = "city")
	WebElement txtcity;
	@FindBy(name = "state")
	WebElement txtstate;
	@FindBy(name = "pinno")
	WebElement txtpinno;
	@FindBy(name = "telephoneno")
	WebElement txttelephoneno;
	@FindBy(name = "emailid")
	WebElement txtemailid;
	@FindBy(name = "sub")
	WebElement btnSubmit;


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

    public void clickSubmit() {
        btnSubmit.click();
    }

}
