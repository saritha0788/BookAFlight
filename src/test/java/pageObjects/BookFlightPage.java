package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookFlightPage extends UIBasePage{
	
	public BookFlightPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='container']//table")
	private WebElement searchTable;
	
	@FindBy(xpath = "//div[@class='container']//table//tbody/tr[1]/td/input")
	private WebElement chooseFlightBtn1;
	
	@FindBy(xpath = "//div[@class='container']/h2")
	private WebElement reservationTitle;
	


	public boolean isTablePresent() {
		boolean tablePresent = false;
		if (searchTable.isDisplayed())
			tablePresent = true;
		return tablePresent;
	}
	
	public void clickOnFirstRow() {
		chooseFlightBtn1.click();
	}
	
	public boolean verifyBookingTitle() {
		boolean title = false; 
		if(reservationTitle.getText().equals("Your flight from TLV to SFO has been reserved.")) // should be stored in constants
			title=true;
		return title;
	}

}
