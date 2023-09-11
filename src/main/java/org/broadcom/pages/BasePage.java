package org.broadcom.pages;

import static org.broadcom.constants.FrameworkConstants.BOLD_END;
import static org.broadcom.constants.FrameworkConstants.BOLD_START;

import org.broadcom.constants.FrameworkConstants;
import org.broadcom.reports.ExtentLogger;
import org.broadcom.reports.ExtentManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;

public class BasePage {

	/* Class level -> Not Thread safe */
	/*
	 * No need to use ThreadLocal, because when we are creating the Object of Page,
	 * those objects are local to test methods.
	 */

	public WindowsDriver dtdriver;
	protected WebDriverWait wait;
	/*
	 * Many waits can also be used in case you want to different time wait for
	 * different web elements
	 */

	public BasePage(WindowsDriver driver) {
		this.dtdriver = driver;
		wait = new WebDriverWait(driver, FrameworkConstants.getExplicitWait());
	}

	protected void waitAndClick(By by, String elementName) {
		Actions action = new Actions(dtdriver);
		WebElement element = waitUntilElementToBeClickable(by);
		action.moveToElement(element).click().build().perform();
}

	protected void clearAndSendKeys(By by, String value, String elementName) {
		WebElement element = waitUntilElementToBeClickable(by);
		element.clear();
		element.sendKeys(value);
	}

	protected void SendKeysAndEnter(By by, String value, String elementName) {
		WebElement element = dtdriver.findElement(by);
		element.clear();
		element.sendKeys(value, Keys.ENTER);
	}

	protected WebElement waitUntilPresenceOfElementLocated(By by) {
		WebDriverWait wait = new WebDriverWait(dtdriver, FrameworkConstants.getExplicitWait());
		return wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	protected WebElement waitUntilElementToBeClickable(By by) {
		WebDriverWait wait = new WebDriverWait(dtdriver, FrameworkConstants.getExplicitWait());
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	protected String getElementText(By by) {
		WebElement element = waitUntilPresenceOfElementLocated(by);
		return element.getText();
	}

	protected static void holdScript(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	
}
