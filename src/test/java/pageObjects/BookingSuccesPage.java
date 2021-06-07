package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingSuccesPage extends UIBasePage{
	
	public BookingSuccesPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='container hero-unit']/h1")
	private WebElement succesMessage;
	
	@FindBy(xpath ="//div[@class='container hero-unit']/table//tr[1]/td[text()='Id']/following-sibling::td")
	private WebElement idValue;
	
	@FindBy(xpath ="//div[@class='container hero-unit']/table//tr[2]/td[text()='Status']/following-sibling::td")
	private WebElement bookingStatus;
	
	public boolean verifyBookingSuccess(String msg) {
		boolean successMsg = false;
		if(succesMessage.getText().equals(msg))
			successMsg=true;
		return successMsg;
	}
	
	public boolean verifyBookingConfirmation(String status) {
		boolean confirmationDetails = false;
		if(!idValue.getText().isEmpty())
			confirmationDetails=true;
		if(!bookingStatus.getText().equals(status))
			confirmationDetails=true;
			return confirmationDetails;
			// other details also have to be verified
	}

}
