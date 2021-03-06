package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOperations {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Sign In']"))).perform();
		driver.findElement(By.xpath("//a[contains(text(),'Your Orders')]")).click();
		

	}

}
