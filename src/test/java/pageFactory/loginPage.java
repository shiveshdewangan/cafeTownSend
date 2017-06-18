package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage {

	@FindBy(xpath="//*[@id='login-form']/fieldset/label[1]/input")
	WebElement username;
	
	@FindBy(xpath="//*[@id='login-form']/fieldset/label[2]/input")
	WebElement password;
	
	@FindBy(xpath="//*[@id='login-form']/fieldset/button")
	WebElement signInButton;
	
	public loginPage(WebDriver driver) {
		super(driver);	
	}
	
	public userPage LogInWithValidCredentials(String validusername, String validpassword){
				
		username.sendKeys(validusername);
		password.sendKeys(validpassword);
		signInButton.click();
		
		return new userPage(driver);		
	}
	
}
