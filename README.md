# BookAFlight
Basic Selenium &amp; testng framework to book a flight 

NOTE -- 
1. I have used chrome driver that runs on mac, if your local is of different OS, please replace the chrome driver accordingly for tests to work
2. To see reportng reports go to target -> surefire reports -> html ->index.html

 Other TCs that has to be automated :-

 Negative TCs - 
 1. Click on Purchase Flight button without entering mandatory details
 2. Entering invalid values in the passenger details page 
 3. Selecting same city in departure & destination dropdowns 
 
 Happy path other verifications:- 
 1. if the amount displayed in the select flights page is same as the one shown in Passenger details page 
 2. if final fare in Passenger details page & Booking confirmation page is same
