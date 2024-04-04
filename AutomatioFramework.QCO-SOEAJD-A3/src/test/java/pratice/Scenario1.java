package pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1 {

	public static void main(String[] args) throws InterruptedException {
		
		//step : launch the browser
		WebDriver driver = new EdgeDriver();
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888");
		
		//Step 2: login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.name("user_password")).sendKeys("admin");
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
		driver.findElement(By.name("lastname")).sendKeys("Raghunath");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(1000);
		
		//step 6: validate for contact
		String ContactHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Thread.sleep(1000);
		System.out.println(ContactHeader);
		
		if(ContactHeader.contains("Raghunath"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
			
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
		
	
		
	}

}
