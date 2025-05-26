package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.GeneralUtilities;

public class CategoryPage {
	 FileUploadUtility fileupload=new  FileUploadUtility();
	 GeneralUtilities generalUtility=new GeneralUtilities();
	public WebDriver driver;
	public CategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(xpath="//input[@placeholder='Username']")WebElement userNameField;
@FindBy(xpath="//input[@placeholder='Password']")WebElement passwordField;
@FindBy(xpath="//button[@type='submit']")WebElement signinButton;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")WebElement newButton;
@FindBy(xpath="//input[@name='category']")WebElement enterTheCategory;
@FindBy(xpath="//li[@id='134-selectable']")WebElement discount;
@FindBy(xpath="//input[@id='main_img']")WebElement chooseFile;
@FindBy(xpath="//input[@name='top_menu'and @value='yes']")WebElement showOnTopWindow;
@FindBy(xpath="//input[@name='show_home'and @value='yes']")WebElement showOnLeftwindow;
@FindBy(xpath="//button[@type='submit']")WebElement SaveButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")WebElement editButton;
@FindBy(xpath="//span[@class='fas fa-trash-alt']")WebElement deleteButton ;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement deleteAlert;
@FindBy(xpath="//button[@name='update']")WebElement updateButton;
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement searchButton;
@FindBy(xpath="//input[@placeholder='Category']")WebElement categoryField;
@FindBy(xpath="//button[@type='submit']")WebElement search;
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr//td[1]")List<WebElement> table;

public void createNewCategory(String categoryname)
{
	newButton.click();
	enterTheCategory.sendKeys(categoryname+generalUtility.generateCurrentDateAndTime());
	discount.click();
	String filepath=Constants.CATEGORY_IMAGEPATH;
	fileupload.fileUploadUsingSendKeys(chooseFile,filepath);
	//generalUtility.scrollJavascriptExecuter(driver);
	//showOnTopWindow.click();
	//showOnLeftwindow.click();
	generalUtility.clickJavaScriptExecutor(SaveButton, driver);
	}
public boolean isAlertMessageDisplayed()
{
	return alert.isDisplayed();
}


public void editCategory()
{
editButton.click();
deleteButton.click();
driver.switchTo().alert().accept();
generalUtility.clickJavaScriptExecutor(updateButton, driver);

}
public boolean isDeleteAlertDisplayed()
{
	return deleteAlert.isDisplayed();
}


public boolean searchCategoryInSearchField(String input)
{
	searchButton.click();
	categoryField.clear();
	categoryField.sendKeys(input);
	generalUtility.clickJavaScriptExecutor(search, driver);
int flag = 0;
	for(WebElement name:table)
	{
		if(name.getText().equalsIgnoreCase(input))
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