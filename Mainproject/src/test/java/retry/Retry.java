package retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


  public class Retry implements IRetryAnalyzer { 
	   
	 	private static final Logger LOG = (Logger) LogManager.getLogger("Retry.class"); //to track and log retry attempts, LogManager class and getLogger method  
	 	private static final int maxTry = 3;  // how many times retry  
	 	private int count = 0; //to track each retry,initial value set to zero   
	  
	 	@Override 
	 	public boolean retry(final ITestResult iTestResult) { 
	 		if (!iTestResult.isSuccess()) { //if test fail, enters into below if    
	 			if (this.count < maxTry) { //if count< than maxtry     
	  
	 				LOG.info("Retrying test " + iTestResult.getName() + " with status " 
	 						+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");  
	 				this.count++; 
	 				return true; //retry happened  
	 			} 
	 		} 
	 		return false; //no more retry   
	 	} 
	 public String getResultStatusName(final int status) { //status is obtained from itest interface
	 		String resultName = null; 
	 		if (status == 1) { 
	 			resultName = "SUCCESS"; 
	 		} 
	 		if (status == 2) { 
	 			resultName = "FAILURE"; 
	 		} 
	 		if (status == 3) { 
	 			resultName = "SKIP"; 
	 		} 
	 		return resultName; 
	 	} 
	 
}
