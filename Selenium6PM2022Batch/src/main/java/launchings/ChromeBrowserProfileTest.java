package launchings;

import org.apache.log4j.Logger;

public class ChromeBrowserProfileTest extends BaseTest{

	private static final Logger log=Logger.getLogger(ChromeBrowserProfileTest.class);
	public static void main(String[] args) throws Exception {
		interbasetest obj = new BaseTest();
		log.info("Init the property files....");
		obj.init();
		obj.launcher("chromebrowser");
		log.info("Opening the browser...."+p.getProperty("chromebrowser"));
		obj.navigateUrl("iciciurl");
		log.info("Navigate to url...."+childProp.getProperty("iciciurl"));
	}
}
