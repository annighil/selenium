package locator;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathlocatorCalender {
	public static String str="10";

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com");
		//driver.findElement(By.id("departure")).click();
	//	driver.findElement(By.id("departure")).click();
		//driver.findElement(By.className(".fsw_inputField")).click();
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]")).click();

		while(!driver.findElement(By.xpath("//div[@class='fsw_inputBox dates inactiveWidget ']/label/p/span[2]")).getText().contains("Apr"))
		{
			driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).click();
			
		}
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='DayPicker-Body']/div/div[@class='DayPicker-Day']"));
		for(int i=0;i<list.size();i++)
		{
			String Str=list.get(i).getText();
			System.out.println(Str);
			if(Str.equals(str))
			{
				list.get(i).click();
				break;
			}
		}
		

	}

}

