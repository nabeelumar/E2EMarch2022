package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsTest {
	static ExtentReports extent;

	public static ExtentReports getRep() {

		String path = System.getProperty("user.dir") + "/reports/index.html";
		ExtentSparkReporter rep = new ExtentSparkReporter(path);
		rep.config().setReportName("Automation Test Results");
		rep.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(rep);
		extent.setSystemInfo("Tester", "NBL");
		return extent;
	}

}
