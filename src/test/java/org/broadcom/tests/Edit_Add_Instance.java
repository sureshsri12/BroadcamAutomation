package org.broadcom.tests;

import java.lang.reflect.Method;

import org.broadcom.base.BaseTest;
import org.broadcom.pages.AddInstancePage;
import org.broadcom.pages.AddProductsPage;
import org.broadcom.pages.DashboardPage;
import org.broadcom.pages.LoginPage;
import org.broadcom.utils.zerocell.TestData;
import org.testng.annotations.Test;

public class Edit_Add_Instance extends BaseTest {

	@Test(priority = 7, enabled = false, dataProvider = "getData", description = "Edit Added Product Details")
	public void testcase07(TestData data, Method name) throws Exception {
		setUp();
		new LoginPage(dtdriver).loginAuthentication(data.getUsername(), data.getPassword()).moveToSetting()
				.moveToSetting().moveToImport().importfile(data.getFilename()).clickOnRunTest()
				.clickOnSearchFld(data.getSearch());
		new AddProductsPage(dtdriver).moveToProductname(data.getSearch());
		new DashboardPage(dtdriver).selectIcon(data.getIcon());
		new AddInstancePage(dtdriver).clickOnInstanceUrlFld(data.getInstanceurl())
				.clickOnInstanceFld(data.getInstance()).clickOnTestConnection().clickOnSaveChangesDetails();
		new DashboardPage(dtdriver).moveToSetting().moveToClearProduct(data.getDelete()).clickOnProfileName()
				.navigateToSignout();
		killDesktop();
	}
}
