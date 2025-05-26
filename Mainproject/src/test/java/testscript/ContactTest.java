package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;

public class ContactTest extends Base {
  @Test
  public void editContactDetails() throws IOException {
	  LoginPage login=new LoginPage(driver);
	  login.loginByUsingUtility();
	  HomePage homepage=new HomePage(driver);
	  homepage.clickOnManageContactButton();
	  ContactPage contactpage=new ContactPage(driver);
	 contactpage.clickOnEditContact();
	 contactpage.phonenumberUsingFakerutility();
	 contactpage.emailIdUsingFakerutility();
	 contactpage.addressUsingFakerutility();
	 contactpage.enterDeliverTimeAndcharge("3 days", "100");
	 boolean alert=contactpage.isAlertPresent();
	 Assert.assertTrue(alert,Constants.CONTACT_EDITCONTACT);
	 
	  
 }
}
