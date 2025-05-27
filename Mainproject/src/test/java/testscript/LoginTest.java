package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;

public class LoginTest extends Base{
  @Test
	  public void verifyUserLoginWithValidCredential() throws IOException {
		  LoginPage login=new LoginPage(driver); 
		  login.loginByUsingUtility();
		  boolean isHomePageOpened=login.isHomePageLoaded();
		  Assert.assertTrue(isHomePageOpened,Constants.LOGIN_VERIFYWITHVALIDCREDENTIAL);
	 
  }
  
  @Test
  public void verifySigninWithValidUsernameAndInvalidPassword() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUserNameOnUsernameField("admin");
	  loginpage.enterPasswordOnPasswordField("aaamin");
	  loginpage.clickOnSigninButton();
	  boolean alertpresent=loginpage.isAlertPresent();
	  Assert.assertTrue(alertpresent,"Alert not presented");
}
  
  @Test
  public void verifySigninWithInvalidUsernameAndValidPassword() {
	  LoginPage loginpage=new LoginPage(driver);
	  
	  loginpage.enterUserNameOnUsernameField("aaain");
	  loginpage.enterPasswordOnPasswordField("admin");
	  loginpage.clickOnSigninButton();
	  boolean alertpresent=loginpage.isAlertPresent();
	  Assert.assertTrue(alertpresent,"Alert not presented");
  }
  
  @Test
  public void verifySigninWithInvalidCredentials() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUserNameOnUsernameField("ain");
	  loginpage.enterPasswordOnPasswordField("ain");
	  loginpage.clickOnSigninButton();
	 boolean alertpresent= loginpage.isAlertPresent();
	  Assert.assertTrue(alertpresent,"Alert not presented");
  }
}