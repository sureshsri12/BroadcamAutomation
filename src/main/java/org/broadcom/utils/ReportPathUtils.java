package org.broadcom.utils;

import static org.broadcom.constants.FrameworkConstants.*;

public final class ReportPathUtils {
	/**
	 * Private constructor to avoid external instantiation
	 */
		private ReportPathUtils() {
		}

		public static String createExtentReportPath() {
			ConfigLoader.getInstance();
			if (ConfigLoader.getOverrideReports().equalsIgnoreCase(NO)) {
				return EXTENT_REPORT_FOLDER_PATH + OSInfoUtils.getOSInfo() + "_" + DateUtils.getCurrentDate() + "_"
						+ EXTENT_REPORT_NAME;

			} else {
				return EXTENT_REPORT_FOLDER_PATH + EXTENT_REPORT_NAME;
			}
		}
}
