package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation IRetryAnalyse of TestNG
 * @author Raghunath
 */
public class RetryAnalyserImplementaation implements IRetryAnalyzer{
	
	int count=0;
	int retryCount=3;//Manual analysis
	public boolean retry(ITestResult result) {
		
		//0<3 / 1<3 /2<3/ 3<3=NO
		while(count<retryCount)
		{
			count++;//1/ 2/3/ 
			return true;//retry /retry/retry/3<3 condititon not satisfied it will stop retry
		}
		return false;//stop retry
	}

}
