package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;

public class CategoryTest extends Base  {
	LoginPage login;
	HomePage homepage;
	CategoryPage categorypage;

	  @Test
	  public void createNewCategory() throws IOException {
		  login=new LoginPage(driver);
		  homepage=login.loginByUsingUtility();
		  categorypage=homepage.clickOnManageCategoryButton().createNewCategory("Alovera");
		  boolean alertmessage=categorypage.isAlertMessageDisplayed();
		  Assert.assertTrue(alertmessage,Constants.CATEGORY_CREATECATEGORY );
		 }
	  
	  @Test
	  public void editNewCategory() throws IOException
	  {
		  login=new LoginPage(driver);
		  homepage=login.loginByUsingUtility();
		  categorypage=homepage.clickOnManageCategoryButton().editCategory();
		  boolean deletemessage=categorypage.isDeleteAlertDisplayed();
		  Assert.assertTrue(deletemessage,Constants.CATEGORY_EDITCATEGORY );
  }
	  @Test
	  public void searchName() throws IOException
	  {
		  login=new LoginPage(driver);
		  homepage= login.loginByUsingUtility();
		  categorypage=homepage.clickOnManageCategoryButton();
		  boolean namePresent=categorypage.searchCategoryInSearchField("Pizza");
		  Assert.assertTrue(namePresent,Constants.CATEGORY_SEARCHCATEGORY);
	  }
}
