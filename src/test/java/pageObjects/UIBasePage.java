package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UIBasePage {

	public static WebDriver driver;
	public static Select select;
	public static WebDriverWait webDriverWait;
	
	private static String driverPath = "/src/test/resources/Driver/chromedriver"; 
	
	public static void initialiseBrowser(String browserName) {

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+driverPath);
			driver = new ChromeDriver();
		} 
		driver.get("https://blazedemo.com/");		// url can be placed in a property file
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("title "+driver.getTitle());
	}
	
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void quitDriver() {
		driver.quit();
	}
	
}
