package com.actitime.pom;

import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	@ FindBy(xpath="//*[@id=\"topnav\"]/tbody/tr/td[4]/a/div[2]")
	private WebElement Taskbar;
	@FindBy(xpath="//td[@class='logoutCell preventPanelsHiding']/a[text()='Logout']")
	private WebElement Logout;
	  
	
	public  HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void setLogout(WebDriver driver) {
		
		try {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Logout);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Logout));
		Logout.click();
		}
		catch(ElementClickInterceptedException e) {
			
		}
	}
	public void setTaskbar() {
		Taskbar.click();
	}

}
