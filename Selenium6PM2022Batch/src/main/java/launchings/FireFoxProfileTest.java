package launchings;

public class FireFoxProfileTest {

	public static void main(String[] args) throws Exception {
		interbasetest obj = new BaseTest();
		obj.init();
		obj.launcher("firefoxbrowser");
		// obj.navigateUrl("certificateurl");
		obj.navigateUrl("iciciurl");
	}
}
