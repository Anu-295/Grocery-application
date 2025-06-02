package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;

public class NewsTest extends Base {
	LoginPage login;
	HomePage homepage;
	NewsPage newspage;

	@Test
	public void generateNews() throws IOException {
		login = new LoginPage(driver);
		homepage = login.loginByUsingUtility();
		newspage = homepage.clickOnManageNews().createNews("Sunny day");
		boolean alertnews = newspage.isAlertText();
		Assert.assertTrue(alertnews, Constants.NEWS_GENERATENEWS);
	}

	@Test
	public void editNews() throws IOException {
		login = new LoginPage(driver);
		homepage = login.loginByUsingUtility();
		newspage = homepage.clickOnManageNews().editNews("HEAVY RAIN IN IDUKKI");
		boolean alert = newspage.isEditAlertPresent();
		Assert.assertTrue(alert, Constants.NEWS_EDITNEWS);
	}

	@Test
	public void deleteNews() throws IOException {
		login = new LoginPage(driver);
		homepage = login.loginByUsingUtility();
		newspage = homepage.clickOnManageNews().deleteNews();
		boolean deleteAlertText = newspage.isDeleteAlertPresent();
		Assert.assertTrue(deleteAlertText, Constants.NEWS_DELETENEWS);
	}

	@Test
	public void searchNewsInTitleField() throws IOException {
		login = new LoginPage(driver);
		homepage = login.loginByUsingUtility();
		newspage = homepage.clickOnManageNews();
		boolean searchelement = newspage.searchNews("HEAVY RAIN IN IDUKKI");
		Assert.assertTrue(searchelement, Constants.NEWS_SEARCHNEWS);
	}
}
