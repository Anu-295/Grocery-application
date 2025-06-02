package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;

public class ContactTest extends Base {
	LoginPage login;
	HomePage homepage;
	ContactPage contactpage;

	@Test
	public void editContactDetails() throws IOException {
		login = new LoginPage(driver);
		homepage = login.loginByUsingUtility();
		contactpage = homepage.clickOnManageContactButton().clickOnEditContact().phonenumberUsingFakerutility()
				.emailIdUsingFakerutility().addressUsingFakerutility().enterDeliverTimeAndcharge("3 days", "100");
		boolean alert = contactpage.isAlertPresent();
		Assert.assertTrue(alert, Constants.CONTACT_EDITCONTACT);
	}
}
