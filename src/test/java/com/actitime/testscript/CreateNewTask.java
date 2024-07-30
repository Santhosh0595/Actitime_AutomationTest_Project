package com.actitime.testscript;

import java.io.IOException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;
import com.actitme.generic.BaseClass;
import com.actitme.generic.FileLib;

@Listeners(com.actitme.generic.ListnerImplementation.class)
public class CreateNewTask extends BaseClass{
	@Test(retryAnalyzer=com.actitme.generic.IRetryAnalyser.class)
	public void newTask() throws IOException {
		
		
		
		try {
		FileLib f=new FileLib();
		String taskname = f.getExcelDataScript3("CreateTask", 4, 5);
		HomePage h=new HomePage(driver);
		h.setTaskbar();
		TaskListPage tkpage=new TaskListPage(driver);
		tkpage.addnewbtn.click();
		tkpage.newtaskbtn.click();
		tkpage.taskcompaydropdown.click();
		tkpage.tskBigBangoption.click();
		tkpage.taskname.click();
		tkpage.taskname.sendKeys(taskname);
		tkpage.createtaskbtn.click();
		}
		catch(IOException e) {
		
	}
 }
}
	


