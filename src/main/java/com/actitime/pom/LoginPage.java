package com.actitime.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class LoginPage{
	@FindBy(xpath="//*[@id=\"username\"]")
	private WebElement usernametextfield;
	@FindBy(xpath = "//*[@id=\"loginFormContainer\"]/tbody/tr[1]/td/table/tbody/tr[2]/td/input")
	private WebElement passwordtextfield;
	@FindBy(xpath="//*[@id=\"loginButton\"]/div")
	private WebElement LoginButton;
	

	public void setLogin(String username,String password) {
				usernametextfield.sendKeys(username);
				passwordtextfield.sendKeys(password);
				LoginButton.click();
	}	
	public  LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
}
