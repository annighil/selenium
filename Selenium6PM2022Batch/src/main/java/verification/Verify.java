package verification;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		//String actuallink=driver.findElement(By.linkText("Customer Service")).getText();
		String actuallink=driver.findElement(By.linkText("Customer Service")).getAttribute("innerHTML");
		
		String expectedlink="Customer Service";
		if(actuallink.equals(expectedlink))
		{
			System.out.println("both links r eqal");
		}
		else
			System.out.println("both links are not eqal");
		
	}

}
