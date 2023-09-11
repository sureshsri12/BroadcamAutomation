package org.broadcom.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentManager() {
	}

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	static ExtentTest getExtentTest() { //default --> it can be only accessed within the package --. private packages
		return extentTest.get();
	}

	static void setExtentTest(ExtentTest test) {
		extentTest.set(test);
	}

	static void unload() {
		extentTest.remove();
	}

}
