package org.broadcom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.windows.WindowsDriver;

/**
 * @author TLSPC-086
 *
 */
public class DashboardPage extends BasePage {

	public DashboardPage(WindowsDriver dtdriver) {
		super(dtdriver);
	}

	// Naming Convention for private static final fields/variables
	private static final String P_desc = "Add products from our list of PUC compliant products. You currently have ";
	private static final String description = " products enabled for automated usage reporting.";
	// Profile Details
	private static final By Profilename = By.name("Hello ");
	private static final By Dashboard = By.name("Dashboard");
	private static final By btnProfile = By.name("Profile");
	private static final By btnAbout = By.name("About");
	private static final By btnSignOut = By.name("Sign Out");
	// Dashboard Menu Details
	private static final By PUCDetails = By.name("Your PUC is up to date");
	private static final By btnCollect = By.name("Collect Now");
	private static final By txtSearchfld = By.name("Search products");

	private static final By btnRunTest = By.name("Run Connection Test");
	// Product Menu Icon Details
	private static final By iconEdit = By.name("edit");
	private static final By iconDelete = By.name("delete");
	// Product Pop Icon Details
	private static final By btnYes = By.name("Yes");
	// Product Details
	private static final By txtBasicProduct = By.name("DX NetOps");
	private static final By txtBearerProduct = By.name("Continuous Delivery Director");
	private static final By txtKeyProduct = By.name("CA Workload Automation DE");
	// Message Details
	private static final By MGS_AddedInstance = By.name("Instance added successfully.");
	private static final By MGS_UpdateInstance = By.name("Instance updated successfully.");
	private static final By MGS_DeleteInstance = By.name("Instance deleted successfully.");

	private static final By setting = By.name("Settings");
	private static final By Import = By.name("Import Configuration");
	private static final By ClearProduct = By.name("Clear Product Configurations");
	private static final By Export = By.name("Export Configuration");

	private static final By Ok = By.name("Ok");
	private static final By Add = By.name("Add");

	/*
	 * ===============================Unused Code ========================
	 */
//	private static final String Number = " 57 "; 
// 	private static final By btnProduct = By.name(P_desc + Number + description);
//	private static final By MGS_SendReport = By.name(
//			"Usage data has been sent successfully for Apr - Jun. It takes up to 24 hours for the data to be viewable on the telemetry portal.");
	/*
	 * ===============================Unused Code ==========================
	 */

	public LoginPage navigateToSignout() {
		waitAndClick(btnSignOut, "SignOut");
		return new LoginPage(dtdriver);
	}

	public DashboardPage clickOnRunTest() {
		waitAndClick(btnRunTest, "Run Connection Test");
		return this;
	}

	public ProfilePage clickOnProfile() {
		try {
			Actions action = new Actions(dtdriver);
			action.sendKeys(Keys.ARROW_UP).build().perform();
		} catch (Exception e) {
			// TODO: handle exception
		}
		waitAndClick(btnProfile, "Product");
		return new ProfilePage(dtdriver);
	}

	public AboutPage clickOnAbout() {
		waitAndClick(btnAbout, "About");
		return new AboutPage(dtdriver);
	}

	public CollectPage clickOnCollect() {
		holdScript(2);
		waitAndClick(btnCollect, "Collect Usage");
		return new CollectPage(dtdriver);
	}

	public DashboardPage clickOnDashboard() {
		waitAndClick(Dashboard, "Product");
		return this;
	}

	public DashboardPage clickOnProfileName() {
		holdScript(2);
		waitAndClick(Profilename, "Profile Name");
		return this;
	}

	public DashboardPage clickOnPucDetails() {
		waitAndClick(PUCDetails, "PUC Details");
		return this;
	}

		public DashboardPage clickOnConformation() {
		waitAndClick(btnYes, "Conformation to Delete Yes");
		getDeleteInstanceMessage();
		return this;
	}

	public DashboardPage clickOnSearchFld(String txt) {
		waitAndClick(txtSearchfld, "Search Product");
		SendKeysAndEnter(txtSearchfld, txt, "Search Product");
		return this;
	}

	public AddInstancePage clickOnEditIcon() {
		waitAndClick(iconEdit, "Edit Icon");
		return new AddInstancePage(dtdriver);
	}

	public DashboardPage clickOnDeleteIcon() {
		waitAndClick(iconDelete, "Delete Icon");
		return this;
	}
	
//Refactor code need to be done 	

	private By name(String txt) {
		return By.name(txt);
	}

	public AddProductsPage moveToAddProduct(String productcounts) {
		By productdescription = name(P_desc + productcounts + description);
		waitAndClick(productdescription, "Product Name");
		return new AddProductsPage(dtdriver);
	}

	public String getSendReportMessage(String month) {
		By ReportMessage = name("Usage data has been sent successfully for " + month
				+ ". It takes up to 24 hours for the data to be viewable on the telemetry portal.");
		return getElementText(ReportMessage);
	}

	public DashboardPage MoveTOAuthAddProduct(String productname) {
		By AuthAddProduct = name(productname);
		waitAndClick(AuthAddProduct, "Auth Product Name");
		return this;
	}

	public DashboardPage selectConformation(String txt) {
		By conformation = name(txt);
		waitAndClick(conformation, "Select from Conformation Option");
		try {
			System.out.println("Select from Conformation Option: " + conformation);
			getDeleteInstanceMessage();
			holdScript(2);
		} catch (Exception e) {
		}
		return this;
	}
	
	public DashboardPage selectIcon(String iconoption) {
		By icon = name(iconoption);
		waitAndClick(icon, "Selected Edit or Delete Icon");
		return this;
	}

	public DashboardPage MoveTOBearerAddProduct() {
		holdScript(2);
		waitAndClick(txtBearerProduct, "Product Name");
		return this;
	}

	public DashboardPage MoveTOApiKeyAddProduct() {
		holdScript(2);
		waitAndClick(txtKeyProduct, "Product Name");
		return this;
	}

	public DashboardPage MoveTOBasicAddProduct() {
		holdScript(2);
		waitAndClick(txtBasicProduct, "Product Name");
		return this;
	}

	public String getAddInstanceMessage() {
		return getElementText(MGS_AddedInstance);
	}

	public String getupdateInstanceMessage() {
		return getElementText(MGS_UpdateInstance);
	}

	public String getDeleteInstanceMessage() {
		return getElementText(MGS_DeleteInstance);
	}

	public DashboardPage moveToSetting() {
		clickOnProfileName();
		waitAndClick(setting, "Settings");
		return new DashboardPage(dtdriver);
	}

	public DashboardPage moveToImport() {
		waitAndClick(Import, "Import");
		return new DashboardPage(dtdriver);
	}

	public DashboardPage moveToClearProduct(String txt) {
		waitAndClick(ClearProduct, "Clear Product Configurations");
		selectConformation(txt);
		return this;
	}

	public DashboardPage moveToExport() {
		waitAndClick(Export, "Import");
		return new DashboardPage(dtdriver);
	}

	public DashboardPage importfile(String txt) {
		holdScript(4);
		dtdriver.findElementByAccessibilityId("1148").click();
		dtdriver.findElementByAccessibilityId("1148").sendKeys(txt);
		dtdriver.findElementByAccessibilityId("1").click();
		waitAndClick(Add, "Profile Name");
		waitAndClick(Ok, "Profile Name");
		//waitAndClick(Profilename, "Profile Name");
		clickOnProfileName();
		//waitAndClick(Dashboard, "Profile Name");
		clickOnDashboard();
		return new DashboardPage(dtdriver);
	}

	public DashboardPage exportfile(String txt) {

		try {
			holdScript(4);
			waitAndClick(btnYes, "Select Yes");
			Actions action = new Actions(dtdriver);
			action.sendKeys(Keys.chord(Keys.ALT, Keys.TAB)).build().perform();
			dtdriver.findElementByAccessibilityId("1001").sendKeys(txt);
			dtdriver.findElementByAccessibilityId("1").click();
			dtdriver.findElementByAccessibilityId("CommandButton_6").click();
			//waitAndClick(Profilename, "Profile Name");
			clickOnProfileName();
			//waitAndClick(Dashboard, "Profile Name");
			clickOnDashboard();
		} catch (Exception e) {
			waitAndClick(Profilename, "Profile Name");
			waitAndClick(Dashboard, "Profile Name");
		}
		return new DashboardPage(dtdriver);
	}

}
