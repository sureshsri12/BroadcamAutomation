package org.broadcom.tests;

import org.broadcom.base.BaseTest;
import org.broadcom.pages.DashboardPage;
import org.broadcom.pages.LoginPage;
import org.broadcom.utils.zerocell.TestData;
import org.testng.annotations.Test;

public class Add_Product_Test extends BaseTest {

	@Test(priority = 1, enabled = true, dataProvider = "getData", description = "Adding Basic Authentication Product")
	public void testcase01(TestData data) throws Exception {
		setUp();
		new LoginPage(dtdriver).loginAuthentication(data.getUsername(), data.getPassword())
				.moveToAddProduct(data.getProductcount())
				.searchProductAddInstance(data.getSearch(), data.getSearch())
				.clickOnInstanceUrlFld(data.getInstanceurl()).clickOnInstanceFld(data.getInstance())
				.EnvironmentAndSelect(data.getEnvironment())
				//.AuthenticationAndSelect("Basic Authentication")
				.clickOnBasicConfigureDetails(data.getEmail(), data.getPwd(), data.getCmpwd()).clickOnTestConnection()
				.clickOnSaveDetails();
		new DashboardPage(dtdriver).clickOnProfileName().navigateToSignout();
		killDesktop();
	}

	@Test(priority = 2, enabled = false, dataProvider = "getData", description = "Adding Bearer Authentication Product")
	public void testcase02(TestData data) throws Exception {
		setUp();
		new LoginPage(dtdriver).loginAuthentication(data.getUsername(), data.getPassword())
				.moveToAddProduct(data.getProductcount())
				// .clickOnSearchFld(data.getSearch()).moveToProductname(data.getSearch()).clickOnAddInstance()
				.searchProductAddInstance(data.getSearch(), data.getSearch())
				.clickOnInstanceUrlFld(data.getInstanceurl()).clickOnInstanceFld(data.getInstance())
				.EnvironmentAndSelect(data.getEnvironment())
				//.AuthenticationAndSelect("Bearer Authentication")
				.clickOnBearerConfigureDetails(data.getToken())
				.clickOnTestConnection().clickOnSaveDetails();
		new DashboardPage(dtdriver).clickOnProfileName().navigateToSignout();
		killDesktop();
	}

	@Test(priority = 3, enabled = false, dataProvider = "getData", description = "Adding APIKEY Authentication Product")
	public void testcase03(TestData data) throws Exception {
		setUp();
		new LoginPage(dtdriver).loginAuthentication(data.getUsername(), data.getPassword())
				.moveToAddProduct(data.getProductcount())
				// .clickOnSearchFld(data.getSearch()).moveToProductname(data.getSearch()).clickOnAddInstance()
				.searchProductAddInstance(data.getSearch(), data.getSearch())
				.clickOnInstanceUrlFld(data.getInstanceurl()).clickOnInstanceFld(data.getInstance())
				.EnvironmentAndSelect(data.getEnvironment())
				//.AuthenticationAndSelect("APIKey Authentication")
				.EnterApiKeyConfigureDetails(data.getKey(), data.getValue())
				.clickOnTestConnection().clickOnSaveDetails();
		new DashboardPage(dtdriver).clickOnProfileName().navigateToSignout();
		killDesktop();
	}

}
