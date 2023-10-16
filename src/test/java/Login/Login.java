package Login;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Base.Base;

public class Login extends Base {
	By username = By.xpath("//input[@name='username']");
	By password = By.xpath("//input[@name='password']");
	By loginbtn = By.xpath("//input[@value='Log In']");
	By error = By.xpath("//p[@class='error']");
	By amount = By.xpath("//b[@class='ng-binding']");

	@Test(priority=0)
	public void invalid() {

		driver.findElement(username).sendKeys(config.getProperty("Invalidusername"));
		driver.findElement(password).sendKeys(config.getProperty("password"));
		driver.findElement(loginbtn).click();

		String errmesage = "The username and password could not be verified.";
		String er = driver.findElement(error).getText();

		if (errmesage.equals(er)) {
			System.out.println("Validation is displayed and it is " + er);
		} else {
			System.out.println("Validation is not displayed");
		}

	} 

	@Test(priority=1)
	public void valid() throws InterruptedException {
		driver.findElement(username).clear();
		driver.findElement(password).clear();
		driver.findElement(username).sendKeys(config.getProperty("validusername"));
		driver.findElement(password).sendKeys(config.getProperty("password"));

		boolean log = driver.findElement(loginbtn).isDisplayed();
		if (log == true) {
			driver.findElement(loginbtn).click();
			
		} else {
			System.out.println("Unable to click on login");
		}
		Thread.sleep(2000);
		String amounts = driver.findElement(amount).getText();
		System.out.println("Log in successfully and the total amount is "+amounts);
	}
}
