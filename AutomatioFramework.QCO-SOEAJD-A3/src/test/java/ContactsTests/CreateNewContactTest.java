package ContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.ContactInformationPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.ListenersImplementation;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateNewContactTest extends BaseClass{
	
	@Test(groups = "SmokeSuite")
	public void createNewContactWithMandatoryfields() throws IOException, InterruptedException
	
	 {
		// Createing object and reading data from property file not needed because its extended from baseclass
//		//Create Object of All Utility Classes
//				PropertyFileUtility pUtil = new PropertyFileUtility();
//				ExcelFileUtility eUtil = new ExcelFileUtility();
//				SeleniumUtility sUtil =  new SeleniumUtility();
//						
//				//Read all the data
//				/*Read data from property file*/
//				String URL = pUtil.readDataFromPropertyFile("url");
//				String USERNAME= pUtil.readDataFromPropertyFile("username");
//				String PASSWORD = pUtil.readDataFromPropertyFile("password");
//						
				/*Read Data from excel file */
				String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2);
					
				//step1 and Step 2 not required because its extended
//				//step1 : launch the browser
//				WebDriver driver = new EdgeDriver();
//				sUtil.maximizeWindow(driver);
//				sUtil.addImplicitlyWait(driver);
//									
//				driver.get(URL);
//								
//				//Step 2: login to application
//				LoginPage lp = new LoginPage(driver);
//				lp.logiToApp(USERNAME, PASSWORD);
								
				
				//step 3: navigate to contacts link
				HomePage hp=new HomePage(driver);
				hp.clickOnContactLnk();
//				driver.findElement(By.linkText("Contacts")).click();
				
								
				//step 4: click on create contact lookup image
				ContactsPage cp = new ContactsPage(driver);
				cp.ClickOnCreateContactLookUpimg();
				
//				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
								
								
				//step 5: create contact with mandatory fields and save
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.createNewContactWithLastName(LASTNAME);
				
			//	Assert.fail();
				
//				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
//				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					
								
				//step 6: validate for contact
				ContactInformationPage cip = new ContactInformationPage(driver);
				String contactHeader = cip.captureHeaderText();
				
				Assert.assertTrue(contactHeader.contains(LASTNAME));
				
				System.out.println(contactHeader);
	 }
	

				
//	***			String ContactHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//	***			System.out.println(ContactHeader);
//	***			if(contactHeader.contains(LASTNAME))
//	***			{
//	***			System.out.println("PASS");
//	***			}
//	***			else
//	***			{
//	***			System.out.println("FAIL");
//	***								
//	***			}
					
				
				// logout is not needed because it is extended from baseclass
//	***			//step 7 : logout of application
//	***			WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//	***			
//	***			sUtil.mouseHoverAction(driver, ele);
//	***			
//	***			Thread.sleep(1000);
//	***			
//	***			driver.findElement(By.linkText("Sign Out")).click();
//	***							
//	***							
//	***			//step 8 : close the browser
//	***			driver.quit();
//	***			}
	
	@Test
public void sample()
	{
		System.out.println("demo");
	}
	 
}
	


