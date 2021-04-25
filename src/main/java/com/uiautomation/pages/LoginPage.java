/**
 * 
 */
package com.uiautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiautomation.base.BaseClass;

/**
 * @author vibhor
 *
 */
public class LoginPage extends BaseClass {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private By loginpag = By.id("loginPage");
	private By username = By.id("loginEmail");
	private By password = By.id("password");
	private By signinbutton = By.id("loginSubmitButton");
	private By toastmsg = By.cssSelector("span.ng-scope");
	private By forgotpassword = By.linkText("Forgot Password?");
	private By resetpassword = By.id("resetPassword_username");
	private By submitbutton = By.id("resetPasswordSaveButton");
	private By backbutton = By.id("resetPasswordBackButton");
	private By toastclosebutton = By.cssSelector("button.cg-notify-close");
	private By eyeiconmousehover = By.cssSelector("span.input-group-addon.cursor-pointer");
	private By tooltip = By.cssSelector("div.tooltip-inner.ng-binding");
	private By hidepassword = By.cssSelector("i.fa.fa-eye");
	private By showpassword = By.cssSelector("i.fa.fa-eye-slash");
	
	
	public boolean verifyLoginpageIsDisplayed() {
		return getElement(loginpag).isDisplayed();
	}

	public void enterUserName(String name) {
		sendText(username, name);
	}

	public void enterPassword(String pasword) {
		sendText(password, pasword);
	}

	public void clickSignInBtn() {
		elementClick(signinbutton);
	}

	public void clickForgotPasswordLink() {
		elementClick(forgotpassword);
	}
	
	public boolean verifyForgotPasswordPageIsDisplayed() {
		return waitForElementToBeVisible(resetpassword).isDisplayed();
	}

	public boolean statusCheck(String expectedresult) {
		String loginstatus = waitForElementToBeVisible(toastmsg).getText();
		if (loginstatus.contains(expectedresult))
		{
			elementClick(toastclosebutton);
			return true;
		}
		else
			return false;
	}

	public boolean loginBtnIsClickable() {

		return getElement(signinbutton).isEnabled();

	}

	public void clickBackButton() {
		elementClick(backbutton);
	}

	public void clickSubmitButton() {
		elementClick(submitbutton);
	}

	public void enterResetUsername(String usernme) {
		sendText(resetpassword, usernme);
	}
	
	public void hoverOverEyeIcon() {
		mouseHover(eyeiconmousehover);
	}
	
	public String getToolTipText() {
		return getElement(tooltip).getText();
	
	}
	public boolean toolTipIsDisplayed() {
		return getElement(tooltip).isDisplayed();
	}
	
	public boolean showPassword() {
		getElement(hidepassword).click();
		return getElement(showpassword).isDisplayed();
	}
	
	public boolean hidePassword() {
	return	getElement(hidepassword).isDisplayed();
	}
	
	public String getPasswordAttributeValue(String attribute) {
		return getAttribute(password, attribute);
	}

}
