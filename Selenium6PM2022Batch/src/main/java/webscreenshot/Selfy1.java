package webscreenshot;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selfy1 {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		List<WebElement> link = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		for (int i = 0; i < link.size(); i++) {
			String linkname = link.get(i).getAttribute("innerHTML");
			link.get(i).click();

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("E:\\selenium\\screenshot\\" + linkname + ".png"));
			link = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));

		}

	}

}
