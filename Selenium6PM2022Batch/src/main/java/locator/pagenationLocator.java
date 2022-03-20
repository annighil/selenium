package locator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pagenationLocator {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://datatables.net/");
		int pagecount=driver.findElements(By.cssSelector("div#example_paginate>span>a")).size();
		for(int i=1;i<=pagecount;i++)
		{
			String pageselector="div#example_paginate>span>a:nth-child("+i+")";
			driver.findElement(By.cssSelector(pageselector)).click();
			List<WebElement> element=driver.findElements(By.cssSelector("table#example>tbody>tr>td:nth-child(1)"));
			for(WebElement webe:element)
			{
				System.out.println(webe.getText());
			}
			Thread.sleep(1000);
		}
	}

}
