package pratice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	////****Test annotation****////*** interview perpuse - not use in regular process
	
	//****using dependsOnMethods how to run scripts****////
	
	@Test
	public void createContact()
	{
		Assert.fail();//**perpusly failing method**//
		System.out.println("create");
	}

	
	@Test (dependsOnMethods = "createContact")
	public void modifyContact()
	{
		System.out.println("modify");
	}
	
	@Test 
	public void deleteContact()
	{
		System.out.println("delete");
	}
	
	
	
	
	
	
	//****useing "enabled" to skip any script ****//
//		@Test(enabled = false)
//		public void createContact()
//		{
//			System.out.println("create");
//		}
//
//		
//		@Test 
//		public void modifyContact()
//		{
//			System.out.println("modify");
//		}
//		
//		@Test 
//		public void deleteContact()
//		{
//			System.out.println("delete");
//		}
	
	
	
//	//****useing "invocationCount" to skip or run twice any script ****//
//	@Test(invocationCount = 0)
//	public void createContact()
//	{
//		System.out.println("create");
//	}
//
//	
//	@Test (priority = 1, invocationCount = 4)
//	public void modifyContact()
//	{
//		System.out.println("modify");
//	}
//	
//	@Test (invocationCount = 3)
//	public void deleteContact()
//	{
//		System.out.println("delete");
//	}
	
	
	//****Priority Flag (how to add)****//
	
//	@Test(priority = 1)
//	public void createContact()
//	{
//		System.out.println("create");
//	}
//
//	
//	@Test (priority = -2)
//	public void modifyContact()
//	{
//		System.out.println("modify");
//	}
//	
//	@Test (priority = -3)
//	public void deleteContact()
//	{
//		System.out.println("delete");
//	}
}
