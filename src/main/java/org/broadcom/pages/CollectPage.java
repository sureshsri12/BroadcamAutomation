package org.broadcom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.windows.WindowsDriver;

public class CollectPage extends BasePage {

	public CollectPage(WindowsDriver dtdriver) {
		super(dtdriver);
	}

	// Naming Convention for private static final fields/variables

	private static final By btnDownload = By.name("Download Data");
	private static final By btnSendReport = By.name("Send Report");
	private static final By iconTech_doc = By.name("tech_doc");
	private static final By iconLog = By.name("log_file");
//	private static final By btnsave = By.name("save");
//	private static final By btnYes = By.name("Yes");
	private static final By txtUsageData = By
			.name("Review and select data to be sent. The data for only the selected instances will be sent.");

	public CollectPage clickOnDownloadData(String txt) {
		holdScript(4);
		Actions action = new Actions(dtdriver);
		try {
			waitAndClick(btnDownload, "Download Data Button");
			action.sendKeys(Keys.chord(Keys.ALT, Keys.TAB)).build().perform();
			dtdriver.findElementByAccessibilityId("1001").sendKeys(txt);
			dtdriver.findElementByAccessibilityId("1").click();
			dtdriver.findElementByAccessibilityId("CommandButton_6").click();
		} catch (Exception e) {
		}
		return this;
	}

	public String gettxtUsageData() {
		return getElementText(txtUsageData);
	}

	public CollectPage clickOnSendReport() {
		waitAndClick(btnSendReport, "Send Report Button");
		holdScript(3);
		return this;
	}

	public CollectPage clickOnIconTechDoc() {
		holdScript(2);
		waitAndClick(iconTech_doc, "Tech Doc");
		return this;
	}

	public CollectPage clickOnIconLog() {
		holdScript(2);
		waitAndClick(iconLog, "Log");
		return this;
	}

}
