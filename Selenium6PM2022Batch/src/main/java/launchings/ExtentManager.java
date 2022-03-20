package launchings;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager extends BaseTest{

	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports report;
	
	public static ExtentReports getInstance()
	{
		if(htmlreport==null)
		{
			htmlreport=new ExtentHtmlReporter(projectPath+"\\htmlreports\\report.html");
			htmlreport.config().setDocumentTitle("Automation Report");
			htmlreport.config().setReportName("Functional Report");
			htmlreport.config().setTheme(Theme.DARK);
			
			report=new ExtentReports();
			report.attachReporter(htmlreport);
			report.setSystemInfo("OS","Windows10");
			report.setSystemInfo("Tester Name","Ankita");
			report.setSystemInfo("Browser", "Chrome");
		}
		return report;
	}

}
