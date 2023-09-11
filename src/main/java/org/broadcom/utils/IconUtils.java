package org.broadcom.utils;

import static org.broadcom.constants.FrameworkConstants.ICON_OS_MAC;
import static org.broadcom.constants.FrameworkConstants.ICON_OS_WINDOWS;
public final class IconUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private IconUtils() {
	}

	public static String getOSIcon() {

		String operSys = OSInfoUtils.getOSInfo().toLowerCase();
		if (operSys.contains("win")) {
			return ICON_OS_WINDOWS;
		} else if (operSys.contains("mac")) {
			return ICON_OS_MAC;
		}
		return operSys;
	}
}
