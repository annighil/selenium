package verification;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import launchings.BaseTest;
import launchings.interbasetest;

public class DynamicVerification extends Base {

	public static void main(String[] args) throws Exception {
		init();
		test = rep.createTest("DynamicVerification");
		test.log(Status.INFO, "Init the properties files....");
		System.out.println("first");
		launcher("chromebrowser");
		test.log(Status.INFO, "Opening the browser :-" + p.getProperty("chromebrowser"));
		System.out.println("second");
		navigateUrl("amazonurl");
		test.log(Status.PASS, "Navigate to url : " + childProp.getProperty("amazonurl"));
		System.out.println("third");
		String expectedLink = "Customer Servi";
		if (!isLinkequal(expectedLink))
			reportFailure("Both links are not equal....");
		// System.out.println("Both links are not eual....");
		else
			reportSuccess("Both links are equal...");
		// System.out.println("Both links are equal...");
		rep.flush();
	}

}
