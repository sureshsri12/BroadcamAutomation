package org.broadcom.pages;

import org.openqa.selenium.By;

import io.appium.java_client.windows.WindowsDriver;

public class ProfilePage extends BasePage {

	public ProfilePage(WindowsDriver dtdriver) {
		super(dtdriver);
	}

	public static final String VersionNuber = "1.0.21";
	private static final By txtAppVersion = By.name(VersionNuber);

	public String getTxtHeading() {
		return getElementText(txtAppVersion);
	}

}
