package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.PassengerDetailsPage;
import pageObjects.BookFlightPage;
import pageObjects.BookingSuccesPage;
import utils.ExcelSheetUtils;

public class BookFlightTest extends BaseTest {

	HomePage homePage;
	BookFlightPage bookFlightPage;
	PassengerDetailsPage passengerDetails;
	BookingSuccesPage bookingSuccessPage;

	@BeforeClass
	public void setup() {
		homePage = new HomePage();
		bookFlightPage = new BookFlightPage();
		passengerDetails = new PassengerDetailsPage();
		bookingSuccessPage = new BookingSuccesPage();
	}

	@DataProvider(name = "getFlightData")
	public Object[][] findFlights() {
		Object[][] data = ExcelSheetUtils.getTestData("bookingDetails");
		return data;
	}

	@DataProvider(name = "passengerData")
	public Object[][] chooseFlights() {//
		Object[][] data = ExcelSheetUtils.getTestData("passengerDetails");
		return data;
	}

	@DataProvider(name = "confirmationData")
	public Object[][] confirmationPage() {//
		Object[][] data = ExcelSheetUtils.getTestData("bookingSuccess");
		return data;
	}

	@Test(dataProvider = "getFlightData", enabled = true,priority=0)
	public void selectCities(String departureCity, String destinationCity) {
		homePage.bookflight(departureCity, destinationCity);
		Assert.assertTrue(bookFlightPage.isTablePresent(), "User is not taken to search page");
	}

	@Test(dataProvider = "passengerData", enabled = true,priority=1)
	public void bookFlight(String passengerName, String passengerAddress, String passengerCity, String passengerState,
			String passengerZipCode, String passengerCardType, String passengerCreditCardNumber,
			String passengerCreditCardMonth, String passengerCreditCardYear, String passengerNameOnCard,
			String successMsg) {	
		bookFlightPage.clickOnFirstRow();
		// add assert to verify if user is taken to the Flight purchase page
		Assert.assertTrue(bookFlightPage.verifyBookingTitle(), "Reservation heading is present");
		passengerDetails.enterPassengerDetails(passengerName, passengerAddress, passengerCity, passengerState,
				passengerZipCode, passengerCardType, passengerCreditCardNumber, passengerCreditCardMonth,
				passengerCreditCardYear, passengerNameOnCard);
		Assert.assertTrue(bookingSuccessPage.verifyBookingSuccess(successMsg), "Flight booking is not successfull");
	}

	@Test(dataProvider = "confirmationData", enabled = true,priority=2)
	public void verifyBooking(String status) {
		Assert.assertTrue(bookingSuccessPage.verifyBookingConfirmation(status), "Booking is not confirmed");
	}

	// Other TCs
	/*
	 * Negative TCs - 1. Click on Purchase Flight button without entering mandatory
	 * details 2. Entering invalid values in the passenger details page 3. Selecting
	 * same city in departure & destination dropdowns Happy path other verifications
	 * :- 1. if the amount displayed in the select flights page is same as the one
	 * shown in Passenger details page 2. if final fare in Passenger details page &
	 * Booking confirmation page is same
	 */

}
