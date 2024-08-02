package com.actitime.generic;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;


public class BaseClass {
public WebDriver driver =null;;

@BeforeSuite
public void bsConfig() {
	System.out.println("DataBase Connect Sucessfully");
}
@AfterSuite
public void afConfig() {
	System.out.println("DataBase disconnect Sucessfully");
	System.out.println("hi hello");
	
}
	
	//@Parameters("browser")
	//@BeforeTest
@BeforeClass
public void openBrowser(/*String Browser*/) throws IOException {
    Reporter.log("Launch Browser", true);
    System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe"); // Update path to your chromedriver
    FileLib f = new FileLib();
    String Browser=f.getPropertyData("Browser");
    
    if(Browser.equals("chrome")){
    	driver=new ChromeDriver();
    }
    else if(Browser.equals("edge")){
    	driver=new EdgeDriver();
    }
    else if(Browser.equals("firefox")) {
    	driver=new FirefoxDriver();
    }
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
}
//@AfterTest
@AfterClass
public void closeBrowser() {
    Reporter.log("Close Browser", true);
    if (driver != null) {
        driver.quit();
    }
}

@BeforeMethod 
public void login() throws IOException {
    Reporter.log("Login to application", true);
    FileLib f = new FileLib();
    String url = f.getPropertyData("url");
    String username = f.getPropertyData("username");
    String password = f.getPropertyData("password");
    
        driver.get(url);
        LoginPage login = new LoginPage(driver);
        login.setLogin(username, password);
    
}

@AfterMethod
public void logout() {
    Reporter.log("Logout from application", true);
    if (driver != null) {
        HomePage h = new HomePage(driver);
        h.setLogout(driver);
    } else {
        throw new RuntimeException("Driver is not initialized.");
    }
}
 
public void login(WebDriver driver) {
    PageFactory.initElements(driver, this);
}
}
/*public class BaseClass {
	public WebDriver driver;
	@BeforeTest()
	public void openBrowser(){
		Reporter.log("Launch Browser",true);
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\eclipse-workspace\\ActitimeProject\\com.actitime.app\\driver\\chromedriver.exe");
	       // Initialize WebDriver here
        driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	@AfterTest
	public void closeBrowser() {
		Reporter.log("Close Browser",true);
		driver.quit();
		
	}
	@BeforeMethod
	public void login() throws IOException {
		FileLib f=new FileLib();
		String url = f.getPropertyData("url");
		String username = f.getPropertyData("username");
		String password = f.getPropertyData("password");
		driver.get(url);
		LoginPage login=new LoginPage(driver);
		login.setLogin(username, password);
		
	}
	public  void login(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@AfterMethod
	public void logout() {
		Reporter.log("logout",true);
		HomePage h=new HomePage(driver);
		h.setLogout(driver);
	}
	
	}*/
