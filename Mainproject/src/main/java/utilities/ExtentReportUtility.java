package utilities;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	public class ExtentReportUtility {//to generate report
		public static final ExtentReports extentReports = new ExtentReports();   
		public synchronized static ExtentReports createExtentReports() { //synchronized used for thread safety   
//path reporter
			ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); //folder to create file extent report
	 		reporter.config().setReportName("Grocery Application"); //to give name for report  
			extentReports.attachReporter(reporter); // repoter is instance of path reporter which is attatched to  extentreport
			extentReports.setSystemInfo("Organization", "Obsqura");  
			extentReports.setSystemInfo("Name", "Anu ");
			return extentReports;   //calling from Listeners
		}


}
