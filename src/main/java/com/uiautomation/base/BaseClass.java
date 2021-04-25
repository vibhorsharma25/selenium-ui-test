/**
 * 
 */
package com.uiautomation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author vibhor
 *
 */
public class BaseClass {

	private WebDriver driver;
	WebDriverWait wait;

	public BaseClass(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Methods
	 * 
	 * @throws Exception
	 */
	public void elementClick(By by) {
		getElement(by).click();
	}

	public void sendText(By by, String text) {
		WebElement ele = getElement(by);
		ele.clear();
		ele.sendKeys(text);
	}

	public WebDriverWait explicitWait() {
		return wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
	}

	public WebElement getElement(By by) {
		return driver.findElement(by);
	}

	public String getAttribute(By by, String attribute) {
			return getElement(by).getAttribute(attribute);
			}

	public WebElement waitForElementToBeVisible(By by) {
		return explicitWait().until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void mouseHover(By by) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(by)).perform();
		}
}
