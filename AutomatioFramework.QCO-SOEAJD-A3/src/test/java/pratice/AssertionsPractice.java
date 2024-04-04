package pratice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {

	@Test
	public void sample()
	{
		//***Hard Assertion***//
		String a = "Hi";
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		Assert.assertEquals(0,1);
		
		Assert.assertTrue(a.contains("i"));
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("Step 6");
	}
	
	

		@Test
		public void sample1()
		{
			//****Soft Assertion****//
			
			SoftAssert sa = new SoftAssert();
			String a = "Hi";
			
			System.out.println("Step 1");
			System.out.println("Step 2");
			System.out.println("Step 3");
			
			sa.assertEquals(0,1);
			
			sa.assertTrue(a.contains("i"));
			
			System.out.println("Step 4");
			System.out.println("Step 5");
			System.out.println("Step 6");
			
			sa.assertAll();
		}
	
}
