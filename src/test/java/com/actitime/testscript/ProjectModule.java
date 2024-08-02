package com.actitime.testscript;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;
@Listeners(com.actitime.generic.ListnerImplementation.class)
public class ProjectModule extends BaseClass{
	
	@Test(retryAnalyzer=com.actitime.generic.IRetryAnalyser.class)
	public void createNewProject() throws EncryptedDocumentException, IOException {
		 
		FileLib project=new FileLib();
		String projectname =project.getExcelDataScript2("CreateCustomer", 3, 5);
		String projectDescription =project.getExcelDataScript2("CreateCustomer", 3, 6);
		 HomePage p=new HomePage(driver);
		 p.setTaskbar();
		TaskListPage tkPage=new TaskListPage(driver);
		tkPage.getAddnewbtn().click();
		tkPage.getNewProject().click();
		tkPage.getProjectName().click();
		tkPage.getProjectName().sendKeys(projectname);
		tkPage.getProjectDescription().click();
		tkPage.getProjectDescription().sendKeys(projectDescription);
		tkPage.getCustomerDropDown().click();
		tkPage.getBidbangoption().click();
		tkPage.getCreateProjectButton().click();
        	
	}
	}


