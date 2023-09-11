package org.broadcom.utils;

public final class DesktopOSInfoUtils {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private DesktopOSInfoUtils() {
	}
	public static String getOS_Browser_BrowserVersionInfo() {
		return System.getProperty("driver.version") + " & " + System.getProperty("os.name") + " - "
				+ System.getProperty("os.arch")+ " & " + System.getProperty("ip");

	}
}
