package org.broadcom.reports;

import static org.broadcom.constants.FrameworkConstants.YES;

import org.broadcom.utils.ConfigLoader;
import org.broadcom.utils.ScreenshotUtils;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;

/**
 * Used for logging the events in the extent report.
 * Encapsulates the unnecessary methods from users
 * Date -19-Jun-2023
 * @author R GOBINATH
 * @version 1.0
 * @since 1.0
 */
public final class ExtentLogger {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentLogger() {
	}

	/**
	 * Logs pass event in the extent report
	 * @author R GOBINATH
	 * @serialData -19-Jun-2023
	 * @param msg : custom message that needs to be logged
	 */
//	public static void pass(String message) {
//		ExtentManager.getExtentTest().pass(message);
//	}

	/**
	 * Logs fail event in the extent report
	 * @author R GOBINATH
	 * @serialData -19-Jun-2023
	 * @param msg : custom message that needs to be logged
	 */
	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	/**
	 * Logs skip event in the extent report
	 * @author R GOBINATH
	 * @serialData -19-Jun-2023
	 * @param msg : custom message that needs to be logged
	 */
	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}
	/**
	 * Logs info event in the extent report
	 * @author R GOBINATH
	 * @serialData -19-Jun-2023
	 * @param msg : custom message that needs to be logged
	 */
	public static void info(Markup message) {
		ExtentManager.getExtentTest().info(message);
	}

	/**
	 * @author R GOBINATH
	 * @serialData -19-Jun-2023
	 * @param message          : custom message that needs to be logged
	 * @param isScreenshotNeed : appends screenshot when true ,ignore otherwise
	 */
	
	public static void pass(String message, boolean isScreeshotNeeded) {
		if (ConfigLoader.getInstance().getPassedStepsScreenshot().equalsIgnoreCase(YES) && isScreeshotNeeded) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
	}

	public static void fail(String message, boolean isScreeshotNeeded) {
		if (ConfigLoader.getInstance().getFailedStepsScreenshot().equalsIgnoreCase(YES) && isScreeshotNeeded) {
			ExtentManager.getExtentTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		} else {
			fail(message);
		}
	}
	public static void skip(String message, boolean isScreeshotNeeded) {
		if (ConfigLoader.getInstance().getSkippedStepsScreenshot().equalsIgnoreCase(YES) && isScreeshotNeeded) {
			ExtentManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		} else {
			skip(message);
		}
	}

	public static void info(WebElement element) {
		ExtentManager.getExtentTest().pass(YES);
		
	}

///////////////////////////////////////////////////////
//	public static void pass(Markup message) {
//		ExtentManager.getExtentTest().pass(message);
//	}
//
//	public static void fail(Markup message) {
//		ExtentManager.getExtentTest().fail(message);
//	}
//
//	public static void skip(Markup message) {
//		ExtentManager.getExtentTest().skip(message);
//	}
//
//	public static void info(String message) {
//		ExtentManager.getExtentTest().info(message);
//	}
}
