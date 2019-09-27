package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class basePage {

	public WebDriver driver;
	
	public basePage(WebDriver driver){		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// Testing Merge Conflicts
		// Page Factory
		// Pade Object Model
		//Maven
	}
	
}
