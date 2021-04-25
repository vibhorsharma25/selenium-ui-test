package com.uiautomation.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.uiautomation.basetest.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test(priority = 0, testName = "Verify Login page is displayed.")

	public void verifyLoginPageTest() {
		Assert.assertTrue(loginpage.verifyLoginpageIsDisplayed());
	}

	@Test(priority = 1, testName = "Verify invalid login with wrong username and passowrd.")

	public void verifyInValidLoginTest() {
		loginpage.enterUserName("test");
		loginpage.enterPassword("test");
		loginpage.clickSignInBtn();
		Assert.assertTrue(loginpage.statusCheck("Username and/or password invalid"));
	}
	
	@Test(priority = 2, testName = "Verify tooltip text on login page.")

	public void verifyToolTipText() {
		loginpage.hoverOverEyeIcon();
		Assert.assertTrue(loginpage.toolTipIsDisplayed());
		Assert.assertEquals(loginpage.getToolTipText(),"Show/Hide password");
	}
	
	@Test(priority = 3, testName = "Verify hidepassword on login page.")

	public void verifyHidePassword() {
		Assert.assertTrue(loginpage.hidePassword());
		Assert.assertEquals(loginpage.getPasswordAttributeValue("type"),"password");
	}
	
	@Test(priority = 4, testName = "Verify showpassword on login page.")

	public void verifyShowPassword() {
		Assert.assertTrue(loginpage.showPassword());
		Assert.assertEquals(loginpage.getPasswordAttributeValue("type"),"text");
	}

	@Test(priority = 5, testName = "Verify user can do forgot password.")

	public void verifyForgotPasswordPageTest() {
		loginpage.clickForgotPasswordLink();
		Assert.assertTrue(loginpage.verifyForgotPasswordPageIsDisplayed());
	}
	
	@Test(priority = 6, testName = "Verify user cannot do reset password with invalid username.")
	
	public void verifyInvalidForgotPassowrdTest() {
		loginpage.clickSubmitButton();
		Assert.assertTrue(loginpage.statusCheck("Failed to submit reset password request."));
	}
	
@Test(priority = 7, testName = "Verify success is displayed when reset password with valid username.")
	
	public void verifyValidForgotPassowrdTest() {
		loginpage.enterResetUsername("test");
		loginpage.clickSubmitButton();
		Assert.assertTrue(loginpage.statusCheck("Reset password request successfully submitted."));
	}


}
