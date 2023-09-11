package org.broadcom.tests;

import java.lang.reflect.Method;

import org.broadcom.base.BaseTest;
import org.broadcom.pages.AddInstancePage;
import org.broadcom.pages.DashboardPage;
import org.broadcom.pages.LoginPage;
import org.broadcom.utils.zerocell.TestData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Delete_Add_Instance extends BaseTest {

	@Test(priority = 8, enabled = false, dataProvider = "getData", description = "Delete Added Product Details")
	public void testcase08(TestData data) throws Exception {
		setUp();

		new LoginPage(dtdriver).loginAuthentication(data.getUsername(), data.getPassword()).moveToSetting()
				.moveToSetting().moveToImport().importfile(data.getFilename());
		new DashboardPage(dtdriver).clickOnRunTest().clickOnSearchFld(data.getSearch())
				.MoveTOAuthAddProduct(data.getSearch()).selectIcon(data.getIcon()).selectConformation(data.getDelete())
				.clickOnProfileName().navigateToSignout();
		killDesktop();
	}

	@Test(priority = 9, enabled = false, dataProvider = "getData", description = "BasicAuth_AddProduct_Filling_Random_Data")
	public void testcase09(TestData data, Method name) throws Exception {
		setUp();
		Actions action = new Actions(dtdriver);
		new LoginPage(dtdriver).loginAuthentication(data.getUsername(), data.getPassword()).moveToSetting()
				.moveToAddProduct(data.getProductcount()).clickOnSearchFld(data.getSearch()).clickOnBasicAddProduct()
				.clickOnAddInstance().clickOnInstanceUrlFld("").clickOnInstanceFld("")
				.clickOnBasicConfigureDetails("", "", "").clickOnTestConnection();
		new AddInstancePage(dtdriver).getInstanceURLMessage();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		new AddInstancePage(dtdriver).clickOnSaveDetail();
		new AddInstancePage(dtdriver).getRequired_FieldsMessage();
		action.sendKeys(Keys.PAGE_UP).build().perform();
		new DashboardPage(dtdriver).clickOnProfileName().navigateToSignout();
		killDesktop();
	}
}
