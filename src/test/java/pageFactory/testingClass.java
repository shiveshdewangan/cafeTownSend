package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testingClass {

	public static WebDriver driver;
	
	public static userPage up;
	public static loginPage lp;
	public static createPage cp;
	public static editPage ep;
	public static deletePage dp;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Softies/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://cafetownsend-angular-rails.herokuapp.com/login");
		
		Thread.sleep(5000L);
		
		loginPage lp = new loginPage(driver);
		lp.LogInWithValidCredentials("Luke", "Skywalker");
		up = new userPage(driver);
		Thread.sleep(10000L);
		up.clickCreateButton();
		Thread.sleep(10000L);
		cp = new createPage(driver);
		Thread.sleep(5000L);
		cp.doCreateUser("Shivesh", "Dewangan", "22016-01-01", "shivesh.dewangan@gmail.com");
		Thread.sleep(10000L);
		up = new userPage(driver);
		Thread.sleep(5000L);
		up.doValidateThatUserHasBeenCreated("Shivesh Dewangan");		
		
		driver.quit();
		
	}

}
