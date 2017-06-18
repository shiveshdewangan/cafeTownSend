package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class editPage extends basePage{

	@FindBy(xpath="html/body/div[1]/div/div/form/fieldset/label[1]/input")
	WebElement updatedFirstName;
	
	@FindBy(xpath="html/body/div[1]/div/div/form/fieldset/label[2]/input")
	WebElement updatedLastName;
	
	@FindBy(xpath="html/body/div[1]/div/div/form/fieldset/label[3]/input")
	WebElement updatedStartDate;
	
	@FindBy(xpath="html/body/div[1]/div/div/form/fieldset/label[4]/input")
	WebElement updatedEmailAddress;
	
	@FindBy(xpath="html/body/div[1]/div/div/form/fieldset/div/button[1]")
	WebElement updateButton;
	
	public editPage(WebDriver driver) {
		super(driver);
	}
	
	public userPage doUpdateUserDetails(String newFirstName, String newLastName, String newStartDate, String newEmailAddress){
		
		updatedFirstName.clear();
		updatedFirstName.sendKeys(newFirstName);
		
		updatedLastName.clear();
		updatedLastName.sendKeys(newLastName);
		
		updatedStartDate.clear();
		updatedStartDate.sendKeys(newStartDate);
		
		updatedEmailAddress.clear();
		updatedEmailAddress.sendKeys(newEmailAddress);
		
		updateButton.click();
		
		return new userPage(driver);
	}	

}
