package launchings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface interbasetest {
	
	public void init() throws FileNotFoundException, IOException;

	public void launcher(String browser);

	public void navigateUrl(String url);

	public void clickElement(String locatorKey);

	public void typeText(String locatorKey, String text);

	public void selectOption(String locatorKey, String option);

	public WebElement getElement(String locatorKey);

	public By getLocator(String locatorKey);

	public boolean isElementpresent(String locatorKey);

}
