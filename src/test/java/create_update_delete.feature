Feature: Create Update and Delete

Scenario: Create a User	
	Given User is on cafeTownSend Home Page
	When User enters UserName and Password
	Then Message is displayed Hello Luke
	When User clicks on Create button
	Then User enters firstname lastname startdate email address and clicks on add button
	Then User is successfully created
	When User LogOut from the Application
	Then User is navigated to the Home Page
	
	Scenario: Update a User
	Given User is on cafeTownSend Home Page
	When User enters UserName and Password
	Then Message is displayed Hello Luke
	When User clicks on a user
	Then User clicks on Edit button
	Then User enters new details and clicks on update button
	Then User details have been updated succesfully 
	When User LogOut from the Application
	Then User is navigated to the Home Page
	
	Scenario: Delete a User
	Given User is on cafeTownSend Home Page
	When User enters UserName and Password
	Then Message is displayed Hello Luke
	When User selects a user and clicks on Delete button
	Then User clicks on OK button in alert window
	Then User gets deleted successfully
	When User LogOut from the Application
	Then User is navigated to the Home Page