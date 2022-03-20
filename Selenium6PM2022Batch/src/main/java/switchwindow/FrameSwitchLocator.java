package switchwindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameSwitchLocator {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		/*
		 * driver.get(
		 * "https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/package-summary.html"
		 * ); driver.switchTo().frame(driver.findElement(By.name("packageListFrame")));
		 * //driver.switchTo().frame(0);
		 * driver.findElement(By.linkText("org.openqa.selenium")).click();
		 * driver.switchTo().defaultContent(); Thread.sleep(2000);
		 * driver.switchTo().frame(driver.findElement(By.name("packageFrame")));
		 * driver.findElement(By.linkText("WebDriver")).click();
		 */
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		
		//driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.amazon.com/");
		System.out.println(driver.getTitle());
		
		
	}

}
