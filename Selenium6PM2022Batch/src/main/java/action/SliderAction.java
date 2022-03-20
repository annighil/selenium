package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderAction {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jqueryui.com/slider/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Actions action = new Actions(driver);

		WebElement drag = driver.findElement(By.id("slider"));
	//	action.dragAndDropBy(drag, 100, 0).perform();
		action.clickAndHold(drag).moveByOffset(100, 0).build().perform();
		
		//right click on web element
		
		driver.switchTo().defaultContent();
		
		WebElement element=driver.findElement(By.linkText("Resizable"));
		action.contextClick(element).perform();
				

	}

}
