package pratice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1WithDDT {

	public static void main(String[] args) throws IOException, Throwable {
	
		//Read all the data
		/*Read data from property file*/
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
		Properties p = new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String USERNAME= p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		/*Read Data from excel file */
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fise);
		String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
		
		//step1 : launch the browser
				WebDriver driver = new EdgeDriver();
				Thread.sleep(1000);
				driver.manage().window().maximize();
				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				driver.get(URL);
				
				//Step 2: login to application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				Thread.sleep(1000);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				Thread.sleep(1000);
				driver.findElement(By.id("submitButton")).click();
				Thread.sleep(1000);
				
				//step 3: navigate to contacts link
				driver.findElement(By.linkText("Contacts")).click();
				Thread.sleep(1000);
				
				//step 4: click on create contact lookup image
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				Thread.sleep(1000);
				
				//step 5: create contact with mandatory fields and save
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				Thread.sleep(1000);
				
				//step 6: validate for contact
				String ContactHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				Thread.sleep(1000);
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
				Thread.sleep(1000);
				WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Thread.sleep(1000);
				
				Actions act=new Actions(driver);
				act.moveToElement(ele).perform();
				
				Thread.sleep(1000);
				
				driver.findElement(By.linkText("Sign Out")).click();
				Thread.sleep(1000);
				
				//step 8 : close the browser
				driver.quit();
				
			
				//A3 - 2pm to 4pm
				//Qspiders portal - M4 added  - Saturdays  - Misslineus topics - Join Batch  - 7am to 9am - Advanced Xpath
				// 5pm - drop a msg qtalk
				
		
		
}

}
