package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterTextPage {
	public WebDriver driver;
	public FooterTextPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")WebElement editButton;
@FindBy(xpath="//textarea[@name='address']")WebElement addressField;
@FindBy(xpath="//input[@name='email']")WebElement emailField;
@FindBy(xpath="//input[@name='phone']")WebElement phoneField; 
@FindBy(xpath="//button[@name='Update']")WebElement updateButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertMessage;
public FooterTextPage manageFooterText(String address,String email,String phone)
{
editButton.click();
addressField.clear();
addressField.sendKeys(address);
emailField.clear();
emailField.sendKeys(email);
phoneField.clear();
phoneField.sendKeys(phone);
updateButton.click();
return this;
}
public boolean isAlertDisplayed()
{
	return alertMessage.isDisplayed();
}
}