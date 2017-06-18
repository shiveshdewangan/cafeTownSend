package StepDef;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageFactory.createPage;
import pageFactory.deletePage;
import pageFactory.editPage;
import pageFactory.loginPage;
import pageFactory.userPage;

public class stepDefinition {
	
	public WebDriver driver;
	
	public userPage up;
	public loginPage lp;
	public createPage cp;
	public editPage ep;
	public deletePage dp;
	
	String URL = "http://cafetownsend-angular-rails.herokuapp.com/login";
	
	@Before
	public void setUp() throws InterruptedException{
		System.out.println("Initiliazation");
		System.setProperty("webdriver.chrome.driver", "D:/Softies/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		Thread.sleep(5000L);
	}
	
	@After
	public void cleanUp() throws InterruptedException{
		System.out.println("Cleaning");
		Thread.sleep(5000L);
		up = null;
		lp = null;
		cp = null;
		ep = null;
		dp = null;
		driver.quit();
	}
	
	@Given("^User is on cafeTownSend Home Page$")	
	public void User_is_on_cafeTownSend_Home_Page() throws Throwable {
		Thread.sleep(5000L);
		lp = new loginPage(driver);
	}

	@When("^User enters UserName and Password$")
	public void User_enters_UserName_and_Password() throws Throwable {
		Thread.sleep(5000L);
		lp.LogInWithValidCredentials("Luke", "Skywalker");
	}

	@Then("^Message is displayed Hello Luke$")
	public void Message_is_displayed_Hello_Luke() throws Throwable {
		Thread.sleep(5000L);
		up = new userPage(driver);
		up.userGreetingsValidation("Hello Luke");
	}

	@When("^User LogOut from the Application$")
	public void User_LogOut_from_the_Application() throws Throwable {
		Thread.sleep(5000L);
		up.doLogOut();
	}

	@Then("^User is navigated to the Home Page$")
	public void User_is_navigated_to_the_Home_Page() throws Throwable {
		System.out.println("User_is_navigated_to_the_Home_Page");
	}
	
	@When("^User clicks on Create button$")
	public void User_clicks_on_Create_button() throws Throwable {
		up.clickCreateButton();		
	}

	@Then("^User enters firstname lastname startdate email address and clicks on add button$")
	public void User_enters_firstname_lastname_startdate_and_email_address() throws Throwable {
		Thread.sleep(5000L);
		cp = new createPage(driver);
		cp.doCreateUser("Shivesh", "Dewangan", "2016-01-01", "shiveshdew@gmail.com");
	}

	@Then("^User is successfully created$")
	public void User_is_successfully_created() throws Throwable {
		Thread.sleep(5000L);
		up.doValidateThatUserHasBeenCreated("Shivesh Dewangan");
	}

	@When("^User clicks on a user$")
	public void User_clicks_on_a_user() throws Throwable {
		Thread.sleep(5000L);
		up.doCheckThatUserExistsAndClickOnIt("Shivesh Dewangan");
	}

	@Then("^User clicks on Edit button$")
	public void User_clicks_on_Edit_button() throws Throwable {
		up.clickEditButton();		
	}

	@Then("^User enters new details and clicks on update button$")
	public void User_enters_new_details() throws Throwable {
		Thread.sleep(5000L);
		ep = new editPage(driver);
		ep.doUpdateUserDetails("Shivesh", "Dewangan", "2016-01-01", "shivesh.dewangan@fmail.com");
	}

	@Then("^User details have been updated succesfully$")
	public void User_details_have_been_updated_succesfully() throws Throwable {
		up.doCheckThatUserExistsAndClickOnIt("Shivesh Dewangan");
	}

	@When("^User selects a user and clicks on Delete button$")
	public void User_clicks_on_Delete_button() throws Throwable {
		Thread.sleep(5000L);
		up.doCheckThatUserExistsAndClickOnIt("Shivesh Dewangan");
		dp = new deletePage(driver);
		dp.doDeleteUser();
	}

	@Then("^User clicks on OK button in alert window$")
	public void User_clicks_on_OK_button_in_alert_window() throws Throwable {
		dp.clickOKButton();
	}

	@Then("^User gets deleted successfully$")
	public void User_gets_deleted_successfully() throws Throwable {
		Thread.sleep(5000L);
		System.out.println("User Deleted !!");
	}

	
}
