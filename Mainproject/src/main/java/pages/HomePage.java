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
public CategoryPage clickOnManageCategoryButton()//chaining of pages
{
	mangeCategory.click();
	return new CategoryPage(driver);
}
/*public void clickOnManageProductButton()
{
	manageProduct.click();	
}*/
public ContactPage clickOnManageContactButton()
{
manageContact.click();
return new ContactPage(driver);
}
public FooterTextPage clickOnManageFooterTextButton()
{
	manageFooterText.click();
	return new FooterTextPage(driver);
}
public NewsPage  clickOnManageNews()
{
	manageNews.click();	
	return new NewsPage(driver);
}
}
