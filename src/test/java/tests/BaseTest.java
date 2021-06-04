package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import pageObjects.UIBasePage;


public class BaseTest {
	
	public static WebDriver driver;

	@BeforeSuite(alwaysRun=true)
	@Parameters({"browserName"})
	public void setup(String browserName) {
		UIBasePage.initialiseBrowser(browserName);
	}

	@BeforeClass
	public void loginToApplication() {
		// this method is left blank because the site provided does not have login
		System.out.println("in login page");
	}
	
	@AfterSuite(alwaysRun=true)
	public void tearDown() {
		UIBasePage.quitDriver();		
	}
	
}
