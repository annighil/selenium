package javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('email').value='an_keta17@yahoo.com'");
		String title = js.executeScript("return document.title").toString();
		System.out.println(title);
		//js.executeScript("window.scrollBy(0,100)");
		
		//scroll till the end
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		//scroll down till particular element is visible
		//js.executeScript("document.getElementById('u_0_h_gF').scrollIntoView");
		
		Thread.sleep(2000);
		
		//going backward page
		js.executeScript("window.history.back");
		
		Thread.sleep(2000);
		//going forward
		js.executeScript("window.history.forward");
		
		Thread.sleep(2000);
		
		//refresh page
		
		js.executeScript("window.history.go(0)");
	}

}
