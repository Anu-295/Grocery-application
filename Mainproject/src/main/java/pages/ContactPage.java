package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.GeneralUtilities;

public class ContactPage {
	WebDriver driver;
	FakerUtility fakerutility=new FakerUtility();
	GeneralUtilities generalUtility=new GeneralUtilities();
	public ContactPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
@FindBy(xpath="//a[@role='button']")WebElement EditButton;
@FindBy(xpath="//input[@name='phone']")WebElement PhoneField;
@FindBy(xpath="//input[@name='email']")WebElement Emailfield;
@FindBy(xpath="//textarea[@name='address']")WebElement addressField;
@FindBy(xpath="//textarea[@name='del_time']")WebElement deliveryTimeField;
@FindBy(xpath="//input[@name='del_limit']")WebElement deliveryChargeField;
@FindBy(xpath="//button[@type='submit']")WebElement updateButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertText;

public ContactPage clickOnEditContact()
{
	EditButton.click();
	return this;
}
public ContactPage phonenumberUsingFakerutility()
{
PhoneField.clear();
	String phonenumber=fakerutility.generatephoneNumber();
	PhoneField.sendKeys(phonenumber);
	return this;
}
public ContactPage emailIdUsingFakerutility()
{
	Emailfield.clear();
	String emailid=fakerutility.generateEmailID();
	Emailfield.sendKeys(emailid);
	return this;
}
public ContactPage addressUsingFakerutility()
{
	addressField.clear();
	String address=fakerutility.generateAdress();
	addressField.sendKeys(address);
	return this;
}
public ContactPage enterDeliverTimeAndcharge(String deliveryTime,String deliveryCharge)
{
	deliveryTimeField.clear();
	deliveryTimeField.sendKeys(deliveryTime+generalUtility.generateCurrentDateAndTime());
	deliveryChargeField.clear();
	deliveryChargeField.sendKeys(deliveryCharge);
	generalUtility.clickJavaScriptExecutor(updateButton, driver);
	return this;
	}
public boolean isAlertPresent()
{
	return alertText.isDisplayed();
}
}
