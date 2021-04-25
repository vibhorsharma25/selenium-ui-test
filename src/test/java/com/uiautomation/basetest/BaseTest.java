package com.uiautomation.basetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.uiautomation.base.Constants;
import com.uiautomation.pages.LoginPage;


public class BaseTest {
	
	public WebDriver driver;
	protected LoginPage loginpage;
	
	@BeforeClass
	@Parameters({ "browser" })
	public void commonSetUp(String browser) {
		driver = WebDriverFactory.getInstance().getDriver(browser);
		driver.get(Constants.BASE_URL);
		loginpage = new LoginPage(driver);
		

		
	}

	@AfterClass
	public void commonTearDown() {
		WebDriverFactory.getInstance().quitDriver();
	}

}
