package pages;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h5[text()='Add Contact']")
	WebElement ADD_CONTACT_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	WebElement COMPANY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='country']")
	WebElement COUNTRY_ELEMENT;

	public void verifyAddCustomerPage(String addCustomerHeaderText) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ADD_CONTACT_HEADER_ELEMENT));
		Assert.assertEquals(ADD_CONTACT_HEADER_ELEMENT.getText(), addCustomerHeaderText, "Wrong Page!");
	}

	public void insertFullName(String fullName) {

		FULL_NAME_ELEMENT.sendKeys(fullName + generateRandomNum(9999));
	}
	

	public void selectCompany(String company) {
		selectFromDropDown(COMPANY_ELEMENT, company);
	}

	public void insertEmail(String email) {
		EMAIL_ELEMENT.sendKeys(generateRandomNum(999) + email);
	}
	
	public void insertPhone(String phoneNum) {
		PHONE_ELEMENT.sendKeys(phoneNum + generateRandomNum(999));
	}
	
	public void selectCountry(String country) {
		selectFromDropDown(COUNTRY_ELEMENT, country);
	}

}
