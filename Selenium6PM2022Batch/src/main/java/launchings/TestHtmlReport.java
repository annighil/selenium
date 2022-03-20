package launchings;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;

public class TestHtmlReport extends BaseTest{

//	private static final Logger log = Logger.getLogger(ChromeBrowserProfileTest.class);

	public static void main(String[] args) throws Exception {

		interbasetest obj = new BaseTest();

		obj.init();
		test = BaseTest.rep.createTest("TestHtmlReport");
		BaseTest.test.log(Status.INFO, "Init the property files....");

		obj.launcher("chromebrowser");
		BaseTest.test.log(Status.PASS, "Opening the browser...." + BaseTest.p.getProperty("chromebrowser"));

		obj.navigateUrl("iciciurl");
		BaseTest.test.log(Status.FAIL, "Navigate to url...." + BaseTest.childProp.getProperty("iciciurl"));
		BaseTest.rep.flush();
	}
}
