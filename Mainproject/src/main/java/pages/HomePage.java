package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(xpath="//p[text()='Manage Category']")WebElement mangeCategory;
@FindBy(xpath="//body[@class='sidebar-mini layout-fixed sidebar-collapse']")WebElement manageProduct;
@FindBy(xpath="//p[text()='Manage Contact']")WebElement manageContact;
@FindBy(xpath="//p[text()='Manage Footer Text']")WebElement manageFooterText;
@FindBy(xpath="//p[text()='Manage News']")WebElement manageNews;
public void clickOnManageCategoryButton()
{
	mangeCategory.click();	
}
public void clickOnManageProductButton()
{
	manageProduct.click();	
}
public void clickOnManageContactButton()
{
manageContact.click();	
}public void clickOnManageFooterTextButton()
{
	manageFooterText.click();
}
public void clickOnManageNews()
{
	manageNews.click();	
}
}
