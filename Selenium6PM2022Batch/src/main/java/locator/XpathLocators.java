package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathLocators {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/gainers");
		//static xpath locator
		//String s = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[15]/td[4]")).getText();
		//dynamic xpath locator
		String s=driver.findElement(By.xpath("//a[contains(text(),'Black Box')]/parent::*/following-sibling::td[3]")).getText();
		System.out.println(s);

	}

}
