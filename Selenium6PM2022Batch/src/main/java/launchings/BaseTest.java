package launchings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements interbasetest {
	public static WebDriver driver = null;
	public static String projectPath = System.getProperty("user.dir");
	public static FileInputStream fis = null;
	public static Properties p = null;
	public static Properties mainprop = null;
	public static Properties childProp = null;
	public static Properties locatorProp = null;
	public static ExtentReports rep;
	public static ExtentTest test;

	public void init() throws IOException {
		// setting all the property files
		
		fis = new FileInputStream(projectPath + "/src/main/resources/data.properties");
		p = new Properties();
		p.load(fis);
		
		fis = new FileInputStream(projectPath + "/src/main/resources/environment.properties");
		mainprop = new Properties();
		mainprop.load(fis);

		String e = mainprop.getProperty("env");
		fis = new FileInputStream(projectPath + "/src/main/resources/" + e + ".properties");
		childProp = new Properties();
		childProp.load(fis);

		fis = new FileInputStream(projectPath + "/src/main/resources/locator.properties");
		locatorProp = new Properties();
		locatorProp.load(fis);

		fis = new FileInputStream(projectPath + "/src/main/resources/log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		rep=ExtentManager.getInstance();
	}

	public void launcher(String browser) {
		if (p.getProperty(browser).equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments(
					"user-data-dir=C:\\Users\\ankita\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");
			option.addArguments("--disable-notifications");
			option.addArguments("--start-maximized");
			option.addArguments("--ignore-certificate-errors-spki-list");
			driver = new ChromeDriver(option);
		} else if (p.getProperty(browser).equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			ProfilesIni p = new ProfilesIni();
			FirefoxProfile profile = p.getProfile("Ankita");
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);

			// Handling Browser Notification
			profile.setPreference("dom.webnotifications.enabled", false);

			// Handling certificate error
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(false);

			// How to work with Proxy Settings
			profile.setPreference("network.proxy.type", 1);
			profile.setPreference("network.proxy.socks", "170.158.10.1");
			profile.setPreference("network.proxy.socks_port", 6644);
			driver = new FirefoxDriver(option);

		}
	}

	public void navigateUrl(String url) {
		driver.navigate().to(childProp.getProperty(url));
	}

	public void clickElement(String locatorKey) {
		getElement(locatorKey).click();
	}

	public void typeText(String locatorKey, String text) {
		getElement(locatorKey).sendKeys(text);
	}

	public void selectOption(String locatorKey, String option) {
		// System.out.println("sssss..."+getElement(locatorKey));
		// .sendKeys(option);
		getElement(locatorKey).sendKeys(option);
	}

	public WebElement getElement(String locatorKey) {
		WebElement element = null;
		if (!isElementpresent(locatorKey)) {
			System.out.println("Web Element is not present  :" + locatorKey);
		}
		element = driver.findElement(getLocator(locatorKey));
		System.out.println("aaaaaa    " + element);
		return element;
	}

	public By getLocator(String locatorKey) {
		By by = null;
		if (locatorKey.endsWith("_id")) {
			by = By.id(locatorProp.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_name")) {
			by = By.name(locatorProp.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_classname")) {
			by = By.className(locatorProp.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_xpath")) {
			by = By.xpath(locatorProp.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_css")) {
			by = By.cssSelector(locatorProp.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_linktext")) {
			by = By.linkText(locatorProp.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_partiallinktext")) {
			by = By.partialLinkText(locatorProp.getProperty(locatorKey));
		}
		return by;
	}

	public boolean isElementpresent(String locatorKey) {
		System.out.println("Checking if element is present");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static boolean isLinkequal(String expectedlink)
	{
		
		String actuallink=driver.findElement(By.linkText("Customer Service")).getText();
		if(actuallink.equals(expectedlink))
			return true;
		else
		return false;
	}
}