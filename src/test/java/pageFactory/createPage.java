package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class createPage extends basePage {

	@FindBy(xpath="html/body/div[1]/div/div/form/fieldset/label[1]/input")
	WebElement firstName;
	
	@FindBy(xpath="html/body/div[1]/div/div/form/fieldset/label[2]/input")
	WebElement lastName;
	
	@FindBy(xpath="html/body/div[1]/div/div/form/fieldset/label[3]/input")
	WebElement startDate;
	
	@FindBy(xpath="html/body/div[1]/div/div/form/fieldset/label[4]/input")
	WebElement emailAddress;
	
	@FindBy(xpath="html/body/div[1]/div/div/form/fieldset/div/button[2]")
	WebElement addButton;
	
	public createPage(WebDriver driver) {
		super(driver);		
	}
	
	public userPage doCreateUser(String fName, String lName, String stDate, String emailId){
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		startDate.sendKeys(stDate);
		emailAddress.sendKeys(emailId);
		addButton.click();
		
		return new userPage(driver);
	}
	

}

// this is second comment
