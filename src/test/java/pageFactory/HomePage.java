package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		
	}

	@FindBy(xpath="//div[text()='Resources']")
	private WebElement resourcesTab;
	
	@FindBy(xpath="//div[@class='flex-1']//a[text()='ICE Developer Portal']")
	private WebElement developerPortal;

public HomePage openResourcesTab() {
resourcesTab.click();	
return this;
}
public DeveloperPage clickDeveloperPortal() {
	developerPortal.click();
	return new DeveloperPage(this.driver);
}
}