package com.actitime.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
		@FindBy(xpath = "/html/body/div[20]/div[1]")
		public WebElement newcustomer;
		
		@FindBy(xpath="//*[@id=\"taskManagementPage\"]/div[1]/div[1]/div[1]/div[1]/div[3]/div")
		public WebElement addnewbtn;
		
		@FindBy(xpath = "//div[@class='customerNameDiv']/input")
		public WebElement customername;
		
		
		@FindBy(xpath ="//*[@id=\"customerLightBox_content\"]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div[1]/div[1]/textarea")
		public WebElement custdescription;
		
		
		@FindBy(xpath="//*[@id=\"customerLightBox_content\"]/div[3]/div[2]/div[1]/div")
		public WebElement createbtn;
		
		@FindBy(xpath = "//*[@id=\"customerLightBox_content\"]/div[2]/div[1]/div/div[1]/div[3]/div[2]/span/div/div[1]/div[3]")
		public WebElement drpbtn; 
		

		@FindBy(xpath="//*//*[@id=\"customerLightBox_content\"]/div[2]/div[1]/div/div[1]/div[3]/div[2]/span/div/div[2]/div/div[1]/div/div[2]")
		public WebElement bigbangcompany;
		
		public TaskListPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		public WebElement getCustomername() {
			return customername;
		}

		public WebElement getNewcustomer() {
			return newcustomer;
		}

		public WebElement getAddnewbtn() {
			return addnewbtn;
		}

		public WebElement getCustdescription() {
			return custdescription;
		}

		public WebElement getCreatebtn(WebDriver driver) {
			Actions a=new Actions(driver);
			a.scrollToElement(createbtn);
			return createbtn;
		}
		
		public WebElement getDrpbtn() {
			return drpbtn;
		}

		public WebElement getBigbangcompany() {
			return bigbangcompany;
		}
		
		
	/////////////////////////***************New Project**********///////////////////////////////////
		
		@FindBy(xpath="/html/body/div[20]/div[2]")
		public WebElement newProject;
		
		@FindBy(xpath="//input[@class='projectNameField inputFieldWithPlaceholder inputNameField']")
		public WebElement ProjectName;
		
		@FindBy(xpath = "//*[@id=\"createProjectPopup_content\"]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div[2]/div/div[1]/div[3]")
		public WebElement customerDropDown;
		
		@FindBy(xpath="//*[@id=\"createProjectPopup_content\"]/div[2]/div[1]/div/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/textarea")
		public WebElement ProjectDescription;
		
		@FindBy(xpath = "//*[@id=\"createProjectPopup_content\"]/div[3]/div[2]/div[1]/div/div[1]")
		public WebElement createProjectButton;
		
		@FindBy(xpath="//*[@id=\"createProjectPopup_content\"]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div[2]/div/div[2]/div/div[1]/div/div[2]")
		public WebElement bidbangoption;

		public WebElement getCreateProjectButton() {
			return createProjectButton;
		}
		public WebElement getBidbangoption() {
			return bidbangoption;
		}
		public WebElement getNewProject() {
			return newProject;
		}
		public WebElement getProjectName() {
			return ProjectName;
		}
		public WebElement getCustomerDropDown() {
			return customerDropDown;
		}
		public WebElement getProjectDescription() {
			return ProjectDescription;
		}
		//////////////////////////////**********************Create New Task**********************///////////////
		
		
		@FindBy(xpath="/html/body/div[20]/div[3]")
		public WebElement newtaskbtn;
		
		
		@FindBy(xpath="//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[1]/div/div/div[1]/div[3]")
		public WebElement taskcompaydropdown;
		
		@FindBy(xpath="//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[1]/div/div/div[2]/div/div[1]/div/div[3]")
		public WebElement tskBigBangoption;
		
		@FindBy(xpath="//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[1]/td[1]/input")
		public WebElement taskname;
		
		
		@FindBy(xpath="//*[@id=\"createTasksPopup_content\"]/div[2]/div[2]/div[1]/div")
		public WebElement createtaskbtn;
		
		 
		
		
		
		
		
		
		
		
		
		
}
