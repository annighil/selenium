package launchings;

public class TC_001 {

	public static void main(String[] args) throws Exception {
		interbasetest obj = new BaseTest();
		obj.init();
		obj.launcher("chromebrowser");
		obj.navigateUrl("amazonurl");
	}

}
