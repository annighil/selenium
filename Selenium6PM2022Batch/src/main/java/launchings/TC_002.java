package launchings;

public class TC_002 {

	public static void main(String[] args) throws Exception {
		interbasetest obj = new BaseTest();
		obj.init();
		obj.launcher("firefoxbrowser");
		obj.navigateUrl("bestbuyurl");
	}
}
