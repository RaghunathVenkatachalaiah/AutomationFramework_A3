package pratice;

import org.testng.Assert;
import org.testng.annotations.Test;



//** retryAnalyzer running in this class using genericutilities
public class RetryAnalyserPractice {

	@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementaation.class)
	public void sample ()
	{
		
		Assert.fail();
		System.out.println("Hi");
	}
}
