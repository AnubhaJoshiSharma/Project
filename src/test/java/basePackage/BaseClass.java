package basePackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageFactory.HomePage;
import utilities.ConfigReader;

public class BaseClass {
	protected HomePage homepage;
	private static ThreadLocal<WebDriver> driver =new ThreadLocal<>();
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public enum SupportedBrowsers {
		CHROME,
		FIREFOX;
	}
	@BeforeSuite
	public void globalSetUps() {
	
	}
	@Parameters({"browserName"})
	@BeforeMethod
	public void setUp(String browserName) {
		SupportedBrowsers browser=SupportedBrowsers.valueOf(browserName.toUpperCase());
		try {
		switch(browser) {
		
		case CHROME:
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--headless");
			options.setExperimentalOption("excludeSwitches", new String [] {"enable-Automation"});
			driver.set(new ChromeDriver(options));
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions foptions = new FirefoxOptions();
			foptions.addArguments("dom.webdriver.enabled");
			driver.set(new FirefoxDriver(foptions));
			break;
		
		default:
			System.out.println("Invalid Browser name provided. We support only firefox and chrome");
			throw new IllegalArgumentException();  
		}
		getDriver().get(ConfigReader.readAppUrl());
		homepage = new HomePage(getDriver());
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		getDriver().manage().window().maximize();
		}
		catch(Exception e) {
			Reporter.log("Invalid browser provided."+e.getMessage());
		}
	}
	
	@AfterMethod
	public void cleanUp() {
		if(getDriver()!=null) {
			getDriver().quit();
			driver.remove();
		}
	}
	

}
