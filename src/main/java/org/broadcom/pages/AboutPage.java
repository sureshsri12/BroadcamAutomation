package org.broadcom.pages;

import org.openqa.selenium.By;

import io.appium.java_client.windows.WindowsDriver;

public class AboutPage extends BasePage {

	public AboutPage(WindowsDriver dtdriver) {
		super(dtdriver);
	}

	public static  String VersionNumber = "1.0.21";
	private static final By txtHeading = By.name("About Product Usage Collector");
	private static final By txtVersionHistory = By.name("Version " + VersionNumber);
	private static final By iconExit = By.name("Exit");

	public String getTxtHeading() {
		return getElementText(txtHeading);
	}

	public String getTxtVersionHistory() {
		return getElementText(txtVersionHistory);
	}

	public DashboardPage clickOnIconExit() throws Exception {
		Thread.sleep(2000);
		waitAndClick(iconExit, "Product Name");
		return new DashboardPage(dtdriver);
	}
	
}
