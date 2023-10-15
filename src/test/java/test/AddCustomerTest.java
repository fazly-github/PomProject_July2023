package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.AddCustomerPage;
import pages.DashboardPage;
import pages.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {
	
	WebDriver driver;
	
	@Test
	public void validCustomerShouldBeAbleToCreateCustomer() throws InterruptedException {
		
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login("demo@techfios.com", "abc123");
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage("Dashboard");
		dashboardPage.clickOnCustomer();
		dashboardPage.clickOnAddCustomer();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);

		addCustomerPage.verifyAddCustomerPage("Add Contact");
		addCustomerPage.insertFullName("Selenium");
		addCustomerPage.selectCompany("Techfios");
		addCustomerPage.insertEmail("abc@techfios.com");
		addCustomerPage.insertPhone("1234567");
		addCustomerPage.selectCountry("Albania");
		
		//BrowserFactory.tearDown();
	}
}
