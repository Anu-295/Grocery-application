package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.FooterTextPage;
import pages.HomePage;
import pages.LoginPage;

public class FooterTextTest extends Base {
	LoginPage login;
	HomePage homepage;
	FooterTextPage footertextpage;

	@Test
	public void managefooterText() throws IOException {
		login = new LoginPage(driver);
		homepage = login.loginByUsingUtility();
		footertextpage = homepage.clickOnManageFooterTextButton().manageFooterText("SN nagar,Kochi", "minu@gmail.com",
				"0486543");
		boolean alert = footertextpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constants.FOOTERTEXT_MANAGEFOOTERTEXT);
	}
}
