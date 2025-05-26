package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;

public class CategoryTest extends Base  {

	  @Test
	  public void createNewCategory() throws IOException {
		  LoginPage login=new LoginPage(driver);
		  login.loginByUsingUtility();
		  HomePage homepage=new HomePage(driver);
		  homepage.clickOnManageCategoryButton();
		  CategoryPage categorypage=new CategoryPage(driver);
		  categorypage.createNewCategory("Alovera");
		  boolean alertmessage=categorypage.isAlertMessageDisplayed();
		  Assert.assertTrue(alertmessage,Constants.CATEGORY_CREATECATEGORY );
		 }
	  
	  @Test
	  public void editNewCategory() throws IOException
	  {
		  LoginPage login=new LoginPage(driver);
		  login.loginByUsingUtility();
		  HomePage homepage=new HomePage(driver);
		  homepage.clickOnManageCategoryButton();
		  CategoryPage categorypage=new CategoryPage(driver);
		  categorypage.editCategory();
		  boolean deletemessage=categorypage.isDeleteAlertDisplayed();
		  Assert.assertTrue(deletemessage,Constants.CATEGORY_EDITCATEGORY );
  }
	  @Test
	  public void searchName() throws IOException
	  {
		  LoginPage login=new LoginPage(driver);
		  login.loginByUsingUtility();
		  HomePage homepage=new HomePage(driver);
		  homepage.clickOnManageCategoryButton();
		  CategoryPage categorypage=new CategoryPage(driver);
		  boolean namePresent=categorypage.searchCategoryInSearchField("Shoes");
		  Assert.assertTrue(namePresent,Constants.CATEGORY_SEARCHCATEGORY);
	  }
}
