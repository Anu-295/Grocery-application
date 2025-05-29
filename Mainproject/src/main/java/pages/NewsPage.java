package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class NewsPage {
	 GeneralUtilities generalUtility=new GeneralUtilities();
	 WebDriver driver;
    public NewsPage(WebDriver driver)
	{
    	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newButton;
@FindBy(xpath="//textarea[@name='news']")WebElement newsField;
@FindBy(xpath="//button[@name='create']")WebElement saveButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertText;
@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")WebElement editButton;
@FindBy(xpath="//textarea[@id='news']")WebElement editNewsField;
@FindBy(xpath="//button[@type='submit']")WebElement updateButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement editedAlert;
@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")WebElement deleteButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement deleteAlert;
@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement searchButton;
@FindBy(xpath="//input[@placeholder='Title']")WebElement titleField;
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr//td[1]")List<WebElement> table;
@FindBy(xpath="//button[@value='sr']")WebElement search;
public  NewsPage  createNews(String news)
{
newButton.click();	
newsField.sendKeys(news);
saveButton.click();
return this;
}
public boolean isAlertText()
{
	return alertText.isDisplayed();
}


public  NewsPage  editNews(String newNews)
{
	editButton.click();
	editNewsField.clear();
	editNewsField.sendKeys(newNews);
	updateButton.click();
	return this;
}
public boolean isEditAlertPresent()
{
	return editedAlert.isDisplayed();
}


public  NewsPage  deleteNews()
{
deleteButton.click();
driver.switchTo().alert().accept();
return this;
}
public boolean isDeleteAlertPresent()
{
	return deleteAlert.isDisplayed();
}

public boolean searchNews(String title)
{
searchButton.click();
titleField.clear();
titleField.sendKeys(title);
search.click();
int flag = 0;
for(WebElement name:table)
{
	if(name.getText().equalsIgnoreCase(title))
	{
	  flag=1;
	break;
	
}
}
	if(flag==1) 
	{
	return true;
	}

else
{
	return false;
}
}

}
