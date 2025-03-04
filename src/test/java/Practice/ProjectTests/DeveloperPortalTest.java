package Practice.ProjectTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.BaseClass;

public class DeveloperPortalTest extends BaseClass {
	
	@Test
	public void validateDeveloperPortalLoginFailure() {
		homepage.openResourcesTab().clickDeveloperPortal().clickLoginNow().enterCredentialsAndSubmit();
		Assert.assertTrue(getDriver().findElement(By.cssSelector(".alert")).isDisplayed());
	}

}
