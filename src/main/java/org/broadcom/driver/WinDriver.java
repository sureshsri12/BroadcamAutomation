package org.broadcom.driver;

import java.awt.Desktop;
import java.io.File;

import org.broadcom.constants.FrameworkConstants;

public final class WinDriver {

	public static void start() throws Exception {
		Desktop desktop = Desktop.getDesktop();
		File file = new File(FrameworkConstants.getWinAppLocation());

		/* Check if there is support for Desktop or not */
		if (!Desktop.isDesktopSupported()) {
			return;
		}

		if (file.exists()) {
			desktop.open(file);
		}
	}
	
	public static void stop() throws  Exception {
		ProcessBuilder processBuilder = new ProcessBuilder("taskkill ", "/f", "/IM", "WinAppDriver.exe");
		processBuilder.start();
		Thread.sleep(2000);

	}
}
