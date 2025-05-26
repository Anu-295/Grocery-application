package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;

public class NewsTest extends Base {
  @Test
  public void generateNews() throws IOException {
	  LoginPage login=new LoginPage(driver);
	  login.loginByUsingUtility();
	  HomePage homepage=new HomePage(driver);
	  homepage.clickOnManageNews();
	  NewsPage newspage=new NewsPage(driver);
	  newspage.createNews("Sunny Day");
	  boolean alertnews=newspage.isAlertText();
	  Assert.assertTrue(alertnews,Constants.NEWS_GENERATENEWS);
  }
  @Test
  public void editNews() throws IOException
  {
	  LoginPage login=new LoginPage(driver);
	  login.loginByUsingUtility();
	  HomePage homepage=new HomePage(driver);
	  homepage.clickOnManageNews();
	  NewsPage newspage=new NewsPage(driver);
	  newspage.editNews("HEAVY RAIN IN IDUKKI");
	  boolean alert=newspage.isEditAlertPresent();
	  Assert.assertTrue(alert,Constants.NEWS_EDITNEWS);
  }
  @Test
  public void deleteNews() throws IOException
  {
	  LoginPage login=new LoginPage(driver);
	  login.loginByUsingUtility();
	  HomePage homepage=new HomePage(driver);
	  homepage.clickOnManageNews();
	  NewsPage newspage=new NewsPage(driver);
	  newspage.deleteNews();
	  boolean deleteAlertText=newspage.isDeleteAlertPresent();
	  Assert.assertTrue(deleteAlertText,Constants.NEWS_DELETENEWS);
  }
  @Test
  public void searchNewsInTitleField() throws IOException
  {
	  LoginPage login=new LoginPage(driver);
	  login.loginByUsingUtility();
	  HomePage homepage=new HomePage(driver);
	  homepage.clickOnManageNews();
	  NewsPage newspage=new NewsPage(driver);
	  boolean searchelement=newspage.searchNews("HEAVY RAIN IN IDUKKI");
	 Assert.assertTrue(searchelement,Constants.NEWS_SEARCHNEWS );
  }
}
