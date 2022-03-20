package locator;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebdriverlocatorTest extends BaseTest {
	private static final Logger log=Logger.getLogger(WebdriverlocatorTest.class);
	public static void main(String[] args) {
		interbasetest obj = new BaseTest();
		log.info("Init the property files....");
		obj.init();
		
		obj.launcher("chromebrowser");
		log.info("Opening browser..."+p.getProperty("chromebrowser"));
		
		obj.navigateUrl("amazonurl");
		log.info("Navigating to browser..."+childProp.getProperty("amazonurl"));
		
		obj.selectOption("amazondropbox_id", "Books");
		log.info("Selecting the book from options..."+locatorProp.getProperty("amazondropbox_id"));
		
		obj.typeText("amazonsearchtext_id", "Wings of Fire");
		log.info("Enter the book name...."+locatorProp.getProperty("amazonsearchtext_id"));
		
		obj.clickElement("amazonsearchbutton_xpath");
		log.info("Clicked the web element by using locator..."+locatorProp.getProperty("amazonsearchbutton_xpath"));
	}
}
