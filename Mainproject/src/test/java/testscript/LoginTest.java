package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;

public class LoginTest extends Base {
	@Test(groups = "smoke")
	public void verifyUserLoginWithValidCredential() throws IOException {
		LoginPage login = new LoginPage(driver);
		login.loginByUsingUtility();
		boolean isHomePageOpened = login.isHomePageLoaded();
		Assert.assertTrue(isHomePageOpened, Constants.LOGIN_VERIFYWITHVALIDCREDENTIAL);// using hard assertion

	}

	@Test
	public void verifySigninWithValidUsernameAndInvalidPassword() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUsernameField("admin");
		loginpage.enterPasswordOnPasswordField("cuamb");
		loginpage.clickOnSigninButton();
		boolean alertpresent = loginpage.isAlertPresent();
		Assert.assertTrue(alertpresent, "Alert not presented");
	}

	@Test(groups = "smoke")
	public void verifySigninWithInvalidUsernameAndValidPassword() {
		LoginPage loginpage = new LoginPage(driver);

		loginpage.enterUserNameOnUsernameField("abhhin");
		loginpage.enterPasswordOnPasswordField("admin");
		loginpage.clickOnSigninButton();
		boolean alertpresent = loginpage.isAlertPresent();
		Assert.assertTrue(alertpresent, "Alert not presented");
	}

	@Test(dataProvider = "dpMethod")
	public void verifyLoginWithInvalidUsernameInvalidPassword(String username, String password) {

		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninButton();
		boolean alertpresent = login.isAlertPresent();
		Assert.assertTrue(alertpresent, "Login failed for invalid credentials");
	}

	@DataProvider
	public Object[][] dpMethod() {
		return new Object[][]

		{ { "karl", "asdfg" }, { "dfrt", "frttts" }, { "mjhnbg", "hgytr" } };
	}

}