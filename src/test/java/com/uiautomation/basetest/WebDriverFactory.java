package com.uiautomation.basetest;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import com.uiautomation.base.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

	private static ThreadLocal<WebDriver> threadedDriver = new ThreadLocal<WebDriver>();
	private static ThreadLocal<String> threadedBrowser = new ThreadLocal<String>();
	private static final WebDriverFactory instance = new WebDriverFactory();

	private WebDriverFactory() {

	}

	public static WebDriverFactory getInstance() {
		return instance;
	}

	public WebDriver getDriver(String browser) {
		WebDriver driver = null;
		threadedBrowser.set(browser);
		if (threadedDriver.get() == null) {
			try {
				if (browser.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					FirefoxOptions ffOptions = setFFOptions();
					driver = new FirefoxDriver(ffOptions);
					threadedDriver.set(driver);
				}
				if (browser.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					ChromeOptions chromeOptions = setChromeOptions();
					driver = new ChromeDriver(chromeOptions);
					threadedDriver.set(driver);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			threadedDriver.get().manage().window().maximize();
			threadedDriver.get().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
			threadedDriver.get().manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		}
		return threadedDriver.get();
	}

	/***
	 * Set Chrome Options
	 * 
	 * @return options
	 */
	private ChromeOptions setChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--incognito");
	    options.addArguments("--disable-notifications");
		return options;
	}

	/***
	 * Set Firefox Options
	 * 
	 * @return options
	 */
	private FirefoxOptions setFFOptions() {
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);
		return options;
	}
    
    public String getBrowser() {
        return threadedBrowser.get();
    }
	
	/***
     * Quit driver instance
     */
    public void quitDriver() {
        threadedDriver.get().quit();
        threadedDriver.set(null);
    }
}
