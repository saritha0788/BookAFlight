package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends UIBasePage{

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public Select select;

	@FindBy(xpath = "//div[@class='container']//form/select[@name='fromPort']")
	private WebElement departureSelectDropdown;

	@FindBy(xpath = "//div[@class='container']//form/select[@name='toPort']")
	private WebElement destinationSelectDropdown;

	@FindBy(xpath = "//div[@class='container']/input[@type='submit']")
	private WebElement submitButton;

	public void bookflight(String departure, String destination) {
		select = new Select(departureSelectDropdown);		
		select.selectByVisibleText(departure);
		select = new Select(destinationSelectDropdown);
		select.selectByVisibleText(destination);
		submitButton.click();
	}

}
