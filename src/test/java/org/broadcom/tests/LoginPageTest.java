package org.broadcom.tests;

import org.broadcom.base.BaseTest;
import org.broadcom.pages.LoginPage;
import org.broadcom.utils.zerocell.TestData;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

	@Test(priority = 14, enabled = false , dataProvider = "getData", description = "Without Passing username and Password")
	public void testcase14(TestData data) throws Exception {
		setUp();
		new LoginPage(dtdriver).navigateTobtnBroadcomAccount().navigateTobtnAutomationAccount();
		killDesktop();
	}

	@Test(priority =15, enabled = false , dataProvider = "getData", description = "Passing username and Password with Invalid Credentials")
	public void testcase15(TestData data) throws Exception {
		setUp();
		new LoginPage(dtdriver).navigateTobtnBroadcomAccount().EnterUsername(data.getUsername())
				.EnterPassword(data.getPassword()).navigateTobtnAutomationAccount();
		killDesktop();
	}

	@Test(priority =16, enabled = false , dataProvider = "getData", description = "Passing username and Password with valid Credentials and Logout")
	public void testcase16(TestData data) throws Exception {
		setUp();
		new LoginPage(dtdriver).navigateTobtnBroadcomAccount().EnterUsername(data.getUsername())
				.EnterPassword(data.getPassword()).navigateTobtnAutomationAccount().clickOnProfileName().navigateToSignout();
		killDesktop();
	}
}
