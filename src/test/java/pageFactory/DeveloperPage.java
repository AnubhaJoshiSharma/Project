package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeveloperPage {
	private WebDriver driver;
	public DeveloperPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//a[text()='Login Now']")
	private WebElement loginNowButton;
	
	@FindBy(id="edit-name")
	private WebElement userName;
	
	@FindBy(id="edit-pass")
	private WebElement password;
	
	@FindBy(id="edit-submit")
	private WebElement submitButton;
	
	public DeveloperPage clickLoginNow() {
		loginNowButton.click();
		return this;
	}
	public DeveloperPage enterCredentialsAndSubmit() {
	userName.sendKeys("sdfsfd@gmail.com");
	password.sendKeys("23sf3f");
	submitButton.click();
	return this;
	}

}
