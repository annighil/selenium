package switchwindow;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchWindow {

	public static void main(String[] args) {
		WebDriverManager.chromiumdriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.icicibank.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));//giving page load timeout as it is taking time for the page to load
		System.out.println(driver.getTitle());
		String parentwindowhandleid = driver.getWindowHandle();
		System.out.println(parentwindowhandleid);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		while (!wait
				.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//img[@alt='personal loan'][@class='lazy loaded']")))
				.isDisplayed()) {
			driver.findElement(By.xpath(
					"//div[@class='banner-slider i-home-banner desktop slick-initialized slick-slider slick-dotted']/button[text()='Next']"))
					.click();

		}
		driver.findElement(By.xpath("//img[@alt='personal loan'][@class='lazy loaded']")).click();
		Set<String> windows=driver.getWindowHandles();
		List<String> nwinds=new ArrayList<String>(windows);
		for(String i:nwinds)
		{
			System.out.println(i);
			
		}
		
		
		System.out.println(driver.getTitle()+"............"+driver.getWindowHandle());//getting window handle for parent window
		driver.switchTo().window(nwinds.get(1));//
		System.out.println(driver.getTitle()+".............."+driver.getWindowHandle());//getting window handle for the child window

	}

}
