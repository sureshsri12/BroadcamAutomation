package org.broadcom.utils;

import java.util.Date;

public final class DateUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
  private DateUtils() {}

  public static String getCurrentDate() {
      Date date = new Date();
      return date.toString().replace(":", "_").replace(" ", "_");
  }

}