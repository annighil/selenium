package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropAction {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		Actions action=new Actions(driver);
		 WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
		 WebElement drop=driver.findElement(By.xpath("//div[@id='droppable']"));
		 //action.dragAndDrop(drag,drop).perform();
		 action.clickAndHold(drag).moveToElement(drop).release(drag).build().perform();

	}

}
