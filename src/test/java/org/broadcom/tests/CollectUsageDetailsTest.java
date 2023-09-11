package org.broadcom.tests;

import java.lang.reflect.Method;

import org.broadcom.base.BaseTest;
import org.broadcom.pages.CollectPage;
import org.broadcom.pages.DashboardPage;
import org.broadcom.pages.LoginPage;
import org.broadcom.utils.zerocell.TestData;
import org.testng.annotations.Test;

public class CollectUsageDetailsTest extends BaseTest {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private CollectUsageDetailsTest() {
	}

	@Test(priority = 10, enabled = false, dataProvider = "getData", description = "Collect Telemetry Usage Details")
	public void testcase10(TestData data, Method name) throws Exception {
		setUp();
		new LoginPage(dtdriver).navigateTobtnBroadcomAccount().EnterUsername(data.getUsername())
				.EnterPassword(data.getPassword()).navigateTobtnAutomationAccount();
		new DashboardPage(dtdriver).moveToSetting().moveToImport().importfile(data.getFilename()).clickOnRunTest()
				.clickOnCollect();
		new CollectPage(dtdriver).gettxtUsageData();
		new CollectPage(dtdriver).clickOnDownloadData("telemetry-payload").clickOnSendReport();
		new DashboardPage(dtdriver).getSendReportMessage(data.getMonth());
		new DashboardPage(dtdriver).moveToSetting().moveToClearProduct(data.getDelete()).clickOnProfileName()
				.navigateToSignout();
		killDesktop();
	}

}
