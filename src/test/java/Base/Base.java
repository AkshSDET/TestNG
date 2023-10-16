package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties Object_repo = new Properties();
	public static FileInputStream fis;
	public static WebDriver wait;

	@BeforeSuite
	public void Setup() {

		if(driver==null) {

			try {
				fis = new FileInputStream((System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties"));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				config.load(fis);

			} catch (IOException e) {
				e.printStackTrace();
			}

			
			if(config.getProperty("browser").equals("firefox")) {
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver(firefoxOptions);

			}else if(config.getProperty("browser").equals("chrome")) {

				ChromeOptions chromeOptions = new ChromeOptions();
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(chromeOptions);
			}
			driver.get(config.getProperty("URL"));
			driver.manage().window().maximize();
			//driver.switchTo().alert().dismiss();
			//driver.navigate().refresh();
			//driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		}
	}

	@AfterSuite
	public void TearDown() {


		if (driver!= null) {
			//driver.quit();

		}
	}
}
