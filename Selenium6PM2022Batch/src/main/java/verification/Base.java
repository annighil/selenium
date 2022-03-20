package verification;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import launchings.ExtentManager;

public class Base {
	public static WebDriver driver=null;
	public static String projectPath = System.getProperty("user.dir");
	public static FileInputStream fis = null;
	public static Properties p = null;
	public static Properties mainprop = null;
	public static Properties childProp = null;
	public static Properties locatorProp = null;
	public static ExtentReports rep;
	public static ExtentTest test;

	public static void init() throws IOException {
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

		rep = ExtentManager.getInstance();
	}

	public static void launcher(String browser) {
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

	public static void navigateUrl(String url) {
		driver.navigate().to(childProp.getProperty(url));
	}

	public static boolean isLinkequal(String expectedlink) {
		String actuallink = driver.findElement(By.linkText("Customer Service")).getText();
		if (actuallink.equals(expectedlink))
			return true;
		else
			return false;
	}

	public static void reportFailure(String failMsg) throws Exception {
		test.log(Status.FAIL, failMsg);
		takesScreenshot();
	}

	public static void reportSuccess(String passMsg) {
		test.log(Status.PASS, passMsg);
	}
	public static void takesScreenshot() throws Exception
		{
			Date dt=new Date();
			//System.out.println(dt);
			String dateFormat=dt.toString().replace(":", "_").replace(" ", "_")+".png";	
			
			File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			System.out.println(scrFile.exists());
			FileHandler.copy(scrFile, new File(projectPath+"//failurescreenshots//"+dateFormat));
			test.log(Status.INFO, "Screenshot --->" +test.addScreenCaptureFromPath(projectPath+"//failurescreenshots//"+dateFormat));
		}
}