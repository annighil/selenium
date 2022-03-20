package webscreenshot;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selfy {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (int i = 0; i < links.size(); i++) {

			String str = links.get(i).getText();
			System.out.println(str);

		}
		System.out.println("......................................");
		List<WebElement> link = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		
		for (int j = 0;j<link.size();j++) {
			System.out.println(link.get(j).getAttribute("innerHTML"));
			//String s = link.get(j).getAttribute("innerHTML");
			//System.out.println(s);
			
		}
	}

}
