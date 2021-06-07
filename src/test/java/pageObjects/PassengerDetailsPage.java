package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PassengerDetailsPage extends UIBasePage{
	
	public PassengerDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public Select select;
	
	@FindBy(id = "inputName")
	private WebElement passengerName;
	
	@FindBy(id = "address")
	private WebElement passengerAddress;
	
	@FindBy(id = "city")
	private WebElement passengerCity;
	
	@FindBy(id = "state")
	private WebElement passengerState;
	
	@FindBy(id = "zipCode")
	private WebElement passengerZipCode;
	
	@FindBy(id = "cardType")
	private WebElement passengerCardType;
	
	@FindBy(id = "creditCardNumber")
	private WebElement passengerCreditCardNumber;
	
	@FindBy(id = "creditCardMonth")
	private WebElement passengerCreditCardMonth;
	
	@FindBy(id = "creditCardYear")
	private WebElement passengerCreditCardYear;
	
	@FindBy(id = "nameOnCard")
	private WebElement passengerNameOnCard;
	
	@FindBy(xpath = "//input[@value='Purchase Flight']")
	private WebElement purchaseFlightButton;
	
	
	public void enterPassengerDetails(String name, String address, String city, String state,
			String zipcode, String cardType, String creditCardNumber,
			String creditCardMonth, String creditCardYear, String nameOnCard) {
		passengerName.sendKeys(name);
		passengerAddress.sendKeys(address);
		passengerCity.sendKeys(city);
		passengerState.sendKeys(state);
		passengerZipCode.sendKeys(zipcode);
		scrollToElement(passengerCardType);
		select = new Select(passengerCardType);
		select.selectByVisibleText(cardType);
		passengerCreditCardNumber.sendKeys(creditCardNumber);
		passengerCreditCardMonth.sendKeys(creditCardMonth);
		passengerCreditCardYear.sendKeys(creditCardYear);
		passengerNameOnCard.sendKeys(nameOnCard);
		purchaseFlightButton.click();		
	}
	
}
