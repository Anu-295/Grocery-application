package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.FooterTextPage;
import pages.HomePage;
import pages.LoginPage;

public class FooterTextTest extends Base {
  @Test
  public void managefooterText() throws IOException {
	  LoginPage login=new LoginPage(driver);
	  login.loginByUsingUtility();
	  HomePage homepage=new HomePage(driver);
	  homepage.clickOnManageFooterTextButton();
	  FooterTextPage footertextpage=new FooterTextPage(driver);
	  footertextpage.manageFooterText("SN nagar,Kochi", "minu@gmail.com", "0486543");
	  boolean alert=footertextpage.isAlertDisplayed();
	  Assert.assertTrue(alert,Constants.FOOTERTEXT_MANAGEFOOTERTEXT);
  }
}
