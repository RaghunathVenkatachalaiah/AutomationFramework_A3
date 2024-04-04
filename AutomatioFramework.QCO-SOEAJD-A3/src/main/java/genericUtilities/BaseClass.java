package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consists of basic configuration of testng
 * @athor Raghunath
 */
public class BaseClass {
	
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	public WebDriver driver;
	
	//for listeners
	public static WebDriver sDriver;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfirg() {
		System.out.println("====Db Connection Successfull ====");
	}
	
	
	//@Parameters("Browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws IOException 
	{
	String URL = pUtil.readDataFromPropertyFile("url");
	
	//driver = new EdgeDriver();
	
//	if(BROWSER.equals("edge"))
//	{
//		driver=new EdgeDriver();
//	}
//	else if (BROWSER.equals("crome"))
//	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//	}
//	else
//	{
//		driver = new EdgeDriver();
//	}
			
	sUtil.maximizeWindow(driver);
	sUtil.addImplicitlyWait(driver);
	
	driver.get(URL);
	
	//for listeners
	sDriver=driver;
	
	System.out.println("==== Browser Launch Successful ====");
		
	}

	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
	String USERNAME = pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	
	LoginPage lp = new LoginPage(driver);
	lp.logiToApp(USERNAME, PASSWORD);
	
	System.out.println("==== Login to App Successful ====");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("==== Logout of App Successful ====");
	}
	
//	@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("====Browser closure Successful ====");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("==== DB Closure Successful ====");
	}
}
