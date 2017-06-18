package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class deletePage extends basePage{

	@FindBy(xpath="//*[@id='bDelete']")
	WebElement deleteButton;
	
	public deletePage(WebDriver driver) {
		super(driver);		
	}
	
	public userPage doDeleteUser(){		
		deleteButton.click();		
		return new userPage(driver);
	}
	
	public userPage clickOKButton(){		
		driver.switchTo().alert().accept();
		return new userPage(driver);
	}
}
