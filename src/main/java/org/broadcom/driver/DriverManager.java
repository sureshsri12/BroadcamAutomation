package org.broadcom.driver;


import io.appium.java_client.windows.WindowsDriver;

public class DriverManager {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private DriverManager() {}

	@SuppressWarnings("rawtypes")
	private static ThreadLocal<WindowsDriver> desktopdriver = new ThreadLocal<WindowsDriver>();

	@SuppressWarnings("rawtypes")
	public static WindowsDriver getDriver() {
		return desktopdriver.get();
	}

	@SuppressWarnings("rawtypes")
	public static void setDriver(WindowsDriver driverref) {
		desktopdriver.set(driverref);
	}

	public static void unload() {
		desktopdriver.remove();
	}
}
