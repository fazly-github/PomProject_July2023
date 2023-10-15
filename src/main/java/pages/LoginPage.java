package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;
	
	
	
	//with this code we connect drivers for all pages : (LoginPage, BrowserFactory, LoginTest)
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	//Element List
	//When we use POM we are not using WebElement or By class, so we use @FindBy
//	WebElement USER_NAME_ELEMENT1 = driver.findElement(By.xpath("//input[@id='username']"));
	
	@FindBy(how = How.XPATH, using = "//input[@id='username']") WebElement USER_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='password']") WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@name='login']") WebElement SIGNIN_BUTTON_ELEMENT; 
	
	//Corresponding methods
	// We can two approch:single and all together 
	
	public void insertUserName(String username) {
		USER_NAME_ELEMENT.sendKeys(username);
	}
	
	public void insertPassword (String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}
	
	public void clickOnSignInButton() {
		SIGNIN_BUTTON_ELEMENT.click();
	}
	
	//Together
	public void login(String username, String password) {
		USER_NAME_ELEMENT.sendKeys(username);
		PASSWORD_ELEMENT.sendKeys(password);
		SIGNIN_BUTTON_ELEMENT.click();
	}
	
	
	
}
