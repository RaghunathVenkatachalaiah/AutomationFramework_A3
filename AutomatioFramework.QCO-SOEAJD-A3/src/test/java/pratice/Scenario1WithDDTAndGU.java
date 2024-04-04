package pratice;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import ObjectRepository.LoginPage;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class Scenario1WithDDTAndGU {
	
	public static void main(String[]args) throws IOException, InterruptedException
	{
		//Create Object of All Utility Classes
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		SeleniumUtility sUtil =  new SeleniumUtility();
				
		//Read all the data
		/*Read data from property file*/
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME= pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
				
		/*Read Data from excel file */
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2);
			
		
		//step1 : launch the browser
		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
							
		driver.get(URL);
						
		//Step 2: login to application
		LoginPage lp = new LoginPage(driver);
		lp.logiToApp(USERNAME, PASSWORD);
		
		
		
//		lp.getUsernameEdt().sendKeys(USERNAME);
//		lp.getPasswordEdt().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
				
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		
		
		//step 3: navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
						
		//step 4: click on create contact lookup image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
						
						
		//step 5: create contact with mandatory fields and save
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
						
		//step 6: validate for contact
		String ContactHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(ContactHeader);
		if(ContactHeader.contains(LASTNAME))
		{
		System.out.println("PASS");
		}
		else
		{
		System.out.println("FAIL");
							
		}
						
		//step 7 : logout of application
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		sUtil.mouseHoverAction(driver, ele);
		
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Sign Out")).click();
						
						
		//step 8 : close the browser
		driver.quit();
		}

}
