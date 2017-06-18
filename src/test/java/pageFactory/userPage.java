package pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class userPage extends basePage{

	public WebDriver driver;
	int allUsersSize;
	public boolean foundUser;
	
	@FindBy(xpath="//*[@id='greetings']")
	WebElement userGreetings;
	
	@FindBy(xpath="//*[@id='bAdd']")
	WebElement createButton;
		
	@FindBy(xpath="//*[@id='bEdit']")
	WebElement editButton;
	
	@FindBy(xpath="//*[@id='bDelete']")
	WebElement deleteButton;
	
	@FindBy(xpath="//*[@id='employee-list']/li")
	List<WebElement> allUsers;
	
	@FindBy(xpath="html/body/div[1]/header/div/p[1]")
	WebElement logoutButton;
	
	public userPage(WebDriver driver){
		super(driver);		
	}
	
	//Validate "Hello Luke"
	public userPage userGreetingsValidation(String expectedGreetingMessage){		
		
		if(userGreetings.getText().equalsIgnoreCase(expectedGreetingMessage)){
			System.out.println("Successful Login");			
		} else 		{
			System.out.println("Unsuccessful Login");
		}		
		
		return new userPage(driver);
	}
	
	public loginPage doLogOut(){
		logoutButton.click();
		return new loginPage(driver);
	}
	
	//Do Create
	public createPage clickCreateButton(){		
		createButton.click();		
		return new createPage(driver);
	}
	
	//Do Edit
	public editPage clickEditButton(){		
		editButton.click();		
		return new editPage(driver);
	}
	
	//Do Delete
	public deletePage clickDeleteButton(){		
		deleteButton.click();		
		return new deletePage(driver);
	}
	
	public userPage doValidateThatUserHasBeenCreated(String expectedUserCreated){
				
		allUsersSize = allUsers.size(); 
		System.out.println("Size is " + allUsersSize);
	
		for(int i=0; i<allUsersSize-1; i++){			
			
			if(allUsers.get(i).getText().contains(expectedUserCreated)){
				System.out.println("Found the record !!" + allUsers.get(i).getText());				
			}
		}	
		
		return new userPage(driver);
	}	
	
	public userPage doCheckThatUserExistsAndClickOnIt(String userToBeChecked){
		
		allUsersSize = allUsers.size();		
		
		for(int i=0; i<allUsersSize-1; i++){
			
			if(allUsers.get(i).getText().contains(userToBeChecked)){
				System.out.println("Found the record !!" + allUsers.get(i).getText());
				allUsers.get(i).click();
				break;
			}
			
		}
		
		return new userPage(driver);
	}
	
}
