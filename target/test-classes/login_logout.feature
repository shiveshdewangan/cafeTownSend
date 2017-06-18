Feature: Login and Logout Action

Scenario: Successful Login and Logout with Valid Credentials	
	Given User is on cafeTownSend Home Page
	When User enters UserName and Password
	Then Message is displayed Hello Luke
	When User LogOut from the Application
	Then User is navigated to the Home Page