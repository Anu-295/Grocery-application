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
	  LoginPage mainloginpage=new LoginPage(driver);
	  mainloginpage.enterUserNameOnUsernameField("admin");
	  mainloginpage.enterPasswordOnPasswordField("aaamin");
	  mainloginpage.clickOnSigninButton();
	  boolean alertpresent=mainloginpage.isAlertPresent();
	  Assert.assertTrue(alertpresent,"Alert not presented");
}
  
  @Test
  public void verifySigninWithInvalidUsernameAndValidPassword() {
	  LoginPage mainloginpage=new LoginPage(driver);
	  
	  mainloginpage.enterUserNameOnUsernameField("aaain");
	  mainloginpage.enterPasswordOnPasswordField("admin");
	  mainloginpage.clickOnSigninButton();
	  boolean alertpresent=mainloginpage.isAlertPresent();
	  Assert.assertTrue(alertpresent,"Alert not presented");
  }
  
  @Test
  public void verifySigninWithInvalidCredentials() {
	  LoginPage mainloginpage=new LoginPage(driver);
	  mainloginpage.enterUserNameOnUsernameField("ain");
	  mainloginpage.enterPasswordOnPasswordField("ain");
	  mainloginpage.clickOnSigninButton();
	 boolean alertpresent= mainloginpage.isAlertPresent();
	  Assert.assertTrue(alertpresent,"Alert not presented");
  }
}