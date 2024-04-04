package ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility{

	WebDriver driver;
	
	public CreateNewContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	SeleniumUtility selUtil=new SeleniumUtility();
	
	@FindBy(name = "lastname")
	private WebElement lastNameTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//Business Library
	/**
	 * This method will create new user entering last name
	 * @param lastName
	 */
	public void createNewContactWithLastName(String lastName)
	{
		lastNameTextField.sendKeys(lastName);
		saveButton.click();
	}
	
	public void createNewContactWithLastNameAndLeadSource(String lastName,String leadSource)
	{
		lastNameTextField.sendKeys(lastName);
		handleDropeDown(leadSourceDropDown, leadSource);
		//selUtil.selectByValue(leadSourceDropDown, leadSource);
		saveButton.click();
	}
}