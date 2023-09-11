package org.broadcom.tests;

import org.broadcom.base.BaseTest;
import org.broadcom.pages.DashboardPage;
import org.broadcom.pages.LoginPage;
import org.broadcom.utils.zerocell.TestData;
import org.testng.annotations.Test;

public class Import_Export_FileTest extends BaseTest {
	@Test(priority = 11, enabled = false, dataProvider = "getData", description = "Import Configuration file From System")
	public void testcase11(TestData data) throws Exception {
		setUp();
		new LoginPage(dtdriver).navigateTobtnBroadcomAccount().EnterUsername(data.getUsername())
				.EnterPassword(data.getPassword()).navigateTobtnAutomationAccount().moveToSetting().moveToImport()
				.importfile(data.getFilename());
		new DashboardPage(dtdriver).clickOnRunTest().clickOnProfileName().navigateToSignout();
		killDesktop();
	}

	@Test(priority = 12, enabled = false, dataProvider = "getData", description = "Export Configuration file To System")
	public void testcase12(TestData data) throws Exception {
		setUp();
		new LoginPage(dtdriver).navigateTobtnBroadcomAccount().EnterUsername(data.getUsername())
				.EnterPassword(data.getPassword()).navigateTobtnAutomationAccount().moveToSetting().moveToExport()
				.exportfile(data.getFilename());
		new DashboardPage(dtdriver).clickOnProfileName().navigateToSignout();
		killDesktop();
	}
	
	@Test(priority = 13, enabled = false, dataProvider = "getData", description = "Clear Configuration Data from Telemetry account")
	public void testcase13(TestData data) throws Exception {
		setUp();
		new LoginPage(dtdriver).navigateTobtnBroadcomAccount().EnterUsername(data.getUsername())
				.EnterPassword(data.getPassword()).navigateTobtnAutomationAccount().moveToSetting().moveToClearProduct(data.getDelete());

		new DashboardPage(dtdriver).clickOnProfileName().navigateToSignout();
		killDesktop();
	}
}
	