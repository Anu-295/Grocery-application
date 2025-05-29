package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadUtility;

public class LoginPage {
	 public WebDriver driver;
	 
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@placeholder='Username']")WebElement userNameField;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']")WebElement signinButton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alertMessage;
    @FindBy(xpath="//a[@class='active nav-link' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement managenews;
    
    public void enterUserNameOnUsernameField(String username)
    {
    	userNameField.sendKeys(username);
    }
    
    public void enterPasswordOnPasswordField(String password)
    {
    	passwordField.sendKeys(password);
    }
    
    public HomePage clickOnSigninButton()
    {
    	signinButton.click();
    	return new HomePage(driver);
    }
    
    public boolean isHomePageLoaded()
    {
    	return managenews.isDisplayed();
    }
    
    public boolean isAlertPresent()
    {
    	return alertMessage.isDisplayed();
    }
    public HomePage loginByUsingUtility() throws IOException
    {
    	String userName=ExcelReadUtility.readStringData(1, 0,"Login page");
    	String password=ExcelReadUtility.readStringData(1, 1, "Login page");
    	userNameField.sendKeys(userName);
    	passwordField.sendKeys(password);
    	signinButton.click();
    	return new HomePage(driver);
    	}
}