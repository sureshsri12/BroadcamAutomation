package org.broadcom.utils;

import org.broadcom.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ScreenshotUtils() {
	}

	public static String getBase64Image() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}