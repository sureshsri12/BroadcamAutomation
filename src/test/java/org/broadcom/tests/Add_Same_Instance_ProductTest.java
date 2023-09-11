package org.broadcom.tests;

import java.lang.reflect.Method;

import org.broadcom.base.BaseTest;
import org.broadcom.pages.AddInstancePage;
import org.broadcom.pages.AddProductsPage;
import org.broadcom.pages.DashboardPage;
import org.broadcom.pages.LoginPage;
import org.broadcom.utils.zerocell.TestData;
import org.testng.annotations.Test;

public class Add_Same_Instance_ProductTest extends BaseTest {

	@Test(priority = 4, enabled = false, dataProvider = "getData", description = "Adding Basic Authentication Product 2ndTime Test")
	public void testcase04(TestData data, Method name) throws Exception {
		setUp();
		new LoginPage(dtdriver).loginAuthentication(data.getUsername(), data.getPassword()).moveToSetting()
				.moveToImport().importfile(data.getFilename());
		new DashboardPage(dtdriver).moveToAddProduct(data.getProductcount())
				.searchProductAddInstance(data.getSearch(), data.getSearch())
				.clickOnInstanceUrlFld(data.getInstanceurl()).clickOnInstanceFld(data.getInstance())
				.EnvironmentAndSelect(data.getEnvironment())
				.clickOnBasicConfigureDetails(data.getEmail(), data.getPwd(), data.getCmpwd()).clickOnTestConnection()
				.clickOnSaveDetail();
		new AddInstancePage(dtdriver).ErorMessage(data.getSearch());
		new AddInstancePage(dtdriver).clickOnCancel();
		new AddProductsPage(dtdriver).clickOnGoBackIcon();
		new DashboardPage(dtdriver).moveToSetting().moveToClearProduct(data.getDelete());
		new DashboardPage(dtdriver).clickOnProfileName().navigateToSignout();
		killDesktop();
	}

	@Test(priority = 5, enabled = false, dataProvider = "getData", description = "Adding Bearer Authentication Product 2ndTime Test")
	public void testcase05(TestData data) throws Exception {
		setUp();
		new LoginPage(dtdriver).loginAuthentication(data.getUsername(), data.getPassword()).moveToSetting()
				.moveToImport().importfile(data.getFilename());
		new DashboardPage(dtdriver).moveToAddProduct(data.getProductcount())
				.searchProductAddInstance(data.getSearch(), data.getSearch())
				.clickOnInstanceUrlFld(data.getInstanceurl()).clickOnInstanceFld(data.getInstance())
				.EnvironmentAndSelect(data.getEnvironment()).clickOnBearerConfigureDetails(AddInstancePage.Token)
				.clickOnTestConnection().clickOnSaveDetail();
		new AddInstancePage(dtdriver).ErorMessage(data.getSearch());
		new AddInstancePage(dtdriver).clickOnCancel();
		new AddProductsPage(dtdriver).clickOnGoBackIcon();
		new DashboardPage(dtdriver).moveToSetting().moveToClearProduct(data.getDelete());
		new DashboardPage(dtdriver).clickOnProfileName().navigateToSignout();
		killDesktop();
	}

	@Test(priority = 6, enabled = false, dataProvider = "getData", description = "Adding APIKEY Authentication Product 2ndTime Test")
	public void testcase06(TestData data) throws Exception {
		setUp();
		new LoginPage(dtdriver).navigateTobtnBroadcomAccount().EnterUsername(data.getUsername())
				.EnterPassword(data.getPassword()).navigateTobtnAutomationAccount().moveToSetting().moveToImport()
				.importfile(data.getFilename());
		new DashboardPage(dtdriver).moveToAddProduct(data.getProductcount()).clickOnSearchFld(data.getSearch())
				.moveToProductname(data.getSearch()).clickOnAddInstance().clickOnInstanceUrlFld(data.getInstanceurl())
				.clickOnInstanceFld(data.getInstance()).EnvironmentAndSelect(data.getEnvironment())
				.EnterApiKeyConfigureDetails(data.getKey(), data.getValue()).clickOnTestConnection()
				.clickOnSaveDetail();
		new AddInstancePage(dtdriver).ErorMessage(data.getSearch());
		new AddInstancePage(dtdriver).clickOnCancel();
		new AddProductsPage(dtdriver).clickOnGoBackIcon();
		new DashboardPage(dtdriver).moveToSetting().moveToClearProduct(data.getDelete());
		new DashboardPage(dtdriver).clickOnProfileName().navigateToSignout();
		killDesktop();

	}

}
