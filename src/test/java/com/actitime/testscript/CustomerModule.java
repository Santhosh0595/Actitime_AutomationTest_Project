package com.actitime.testscript;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;
import com.actitime.pom.TaskListPage;
import com.actitme.generic.BaseClass;
import com.actitme.generic.FileLib;

import dev.failsafe.internal.util.Assert;


@Listeners(com.actitme.generic.ListnerImplementation.class)


public class CustomerModule  extends BaseClass{
	
	@Test(retryAnalyzer=com.actitme.generic.IRetryAnalyser.class)
	public void createCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		
		Reporter.log("createcustomer",true);
		FileLib f=new FileLib();
		 String cutomername = f.getExcelData("newcustomer", 1, 6);
		 String custDes = f.getExcelData("newcustomer", 1, 7);
		 System.out.println(cutomername);
		 System.out.println(custDes);
		 Thread.sleep(2000);
		 HomePage p=new HomePage(driver);
		 p.setTaskbar();
		 TaskListPage tkpage=new TaskListPage(driver);
		 tkpage.getAddnewbtn().click();
		 tkpage.getNewcustomer().click();
		 tkpage.getCustomername().click();
		 tkpage.getCustomername().sendKeys(cutomername);
		 tkpage.getCustdescription();
		 tkpage.getCustdescription().sendKeys(custDes);
		// tkpage.getCompanylist().click();
		 tkpage.getDrpbtn().click();
		 tkpage.getBigbangcompany().click();
		 tkpage.getCreatebtn(driver).click();
		   
	     
	        }
	}


