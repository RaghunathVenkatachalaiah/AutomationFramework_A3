package ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	WebDriver driver;
	
	
	//initilization
	public ContactsPage(WebDriver driver)
	{
			
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement CreateContactLookupImage;

	//Utilization
	public WebElement getCreateContactLookupImge() {
		return CreateContactLookupImage;
	}
	
	//Business Library
	/**
	 * This method will click on create contact look up Image
	 */
	public void ClickOnCreateContactLookUpimg()
	{
		CreateContactLookupImage.click();
	}
}