package Signup;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Base.Base;

public class Signup extends Base{
	By Register = By.xpath("//a[normalize-space()='Register']");
	By Firstname = By.xpath("//input[@id='customer.firstName']");
	By Lastname = By.xpath("//input[@id='customer.lastName']");
	By Address = By.xpath("//input[@id='customer.address.street']");
	By City = By.xpath("//input[@id='customer.address.city']");
	By State = By.xpath("//input[@id='customer.address.state']");
	By Zipcode = By.xpath("//input[@id='customer.address.zipCode']");
	By Phonenumber = By.xpath("//input[@id='customer.phoneNumber']");
	By SSN = By.xpath("//input[@id='customer.ssn']");
	By Username = By.xpath("//input[@id='customer.username']");
	By Password = By.xpath("//input[@id='customer.password']");
	By Confirm = By.xpath("//input[@id='repeatedPassword']");
	By Submit = By.xpath("//input[@value='Register']");
	By logout = By.xpath("//a[normalize-space()='Log Out']");

	@Test
	public void signup() {
		System.out.println("============Automation script is started============");

		boolean eml = driver.findElement(Register).isDisplayed();
		if (eml == true) {
			driver.findElement(Register).click();
		} else {
			System.out.println("Unable to click on Register");
		}

		driver.findElement(Firstname).sendKeys(config.getProperty("firtsname"));
		driver.findElement(Lastname).sendKeys(config.getProperty("lastname"));
		driver.findElement(Address).sendKeys(config.getProperty("Address"));
		driver.findElement(City).sendKeys(config.getProperty("City"));
		driver.findElement(State).sendKeys(config.getProperty("State"));
		driver.findElement(Zipcode).sendKeys(config.getProperty("Zipcode"));
		driver.findElement(Phonenumber).sendKeys(config.getProperty("Phonenumber"));
		driver.findElement(SSN).sendKeys(config.getProperty("SSN"));
		driver.findElement(Username).sendKeys(config.getProperty("validusername"));
		driver.findElement(Password).sendKeys(config.getProperty("password"));
		driver.findElement(Confirm).sendKeys(config.getProperty("password"));

		boolean sub = driver.findElement(Submit).isDisplayed();
		if (sub == true) {
			driver.findElement(Submit).click();
		} else {
			System.out.println("Unable to click on Submit");
		}

		boolean log = driver.findElement(logout).isDisplayed();
		if (log == true) {
			driver.findElement(logout).click();
		} else {
			System.out.println("Unable to click on logout");
		}

	}
}
