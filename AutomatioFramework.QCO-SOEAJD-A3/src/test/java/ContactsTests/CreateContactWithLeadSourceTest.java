package ContactsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository.ContactInformationPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.HomePage;
import genericUtilities.BaseClass;

public class CreateContactWithLeadSourceTest extends BaseClass{

	
	//***iT IS A DUPLICATE TO SHOW BATCHEXCECUTION****
	@Test(groups = "\"RegressionSuite\"")
	public  void createContactWithLead() throws IOException
	{
					
				/*Read Data from excel file */
				String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 4, 2);
				String LEADSOURCE = eUtil.readDataFromExcelFile("Contacts", 4, 3);
						
				
				//step 3: navigate to contacts link
				HomePage hp=new HomePage(driver);
				hp.clickOnContactLnk();
									
				//step 4: click on create contact lookup image
				ContactsPage cp = new ContactsPage(driver);
				cp.ClickOnCreateContactLookUpimg();
					
				//step 5: create contact with mandatory fields and save
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.createNewContactWithLastNameAndLeadSource(LASTNAME, LEADSOURCE );
							
				//step 6: validate for contact
				ContactInformationPage cip = new ContactInformationPage(driver);
				String contactHeader = cip.captureHeaderText();
				
				Assert.assertTrue(contactHeader.contains(LASTNAME));
				
				System.out.println(contactHeader);
	
	 }
	}



