package org.broadcom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.windows.WindowsDriver;

public final class AddInstancePage extends BasePage {

	public AddInstancePage(WindowsDriver dtdriver) {
		super(dtdriver);
	}

	// Naming Convention for private static final fields/variables
	private static final By txtUrlFld = By.name("URL used to access this product instance");
	private static final By txtInstanceAliasFld = By.name("Unique identifier for this product instance");
	private static final By ddlEnvironment = By.name("Select");

	// Basic Authentication
	private static final By txtUsername = By.name("Enter Username");
	private static final By txtPassword = By.name("Enter Password");
	private static final By txtConfirmPassword = By.name("Re-enter Password");
	// Bearer Authentication
	private static final By txtToken = By.name("Enter Token");
	// API Key Authentication
	public static final By Key = By.name("Enter key");
	public static final By KeyValue = By.name("Enter value");

	private static final By btnTestConnection = By.name("Test Connection");

	private static final By btnSave = By.name("Add instance and save credentials");
	private static final By btnSaveChanges = By.name("Save Changes");

	private static final By btnCancel = By.name("Cancel");

	private static final By MGS_InstanceURL = By.name("Make sure you have entered the URL.");
	private static final By MGS_Required_Fields = By.name("Enter a value for the required fields.");
	private static final By MGS_AuthenticationType = By
			.name("Make sure you have entered the User ID and Password correctly.");
	public static final String Token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MX0.kHZQ03yhLOPC1c7f6CdItQbT2ljvMQLbucdJVkqwEKs";

	public static final By Warning = By.name("Warning!");
	public static final By OkYes = By.name("OK");

	// private static final By ddlAuthentication = By.name("Basic Authentication");
	// private static final By ddlEnvironmentEnvtype = By.name("Test");
	// private static final By MGS_BearerMessage = By
	// .name("The URL has already been used for Continuous Delivery Director");
	// private static final By MGS_BasicMessage = By.name("The URL has already been
	// used for DX NetOps");
	// private static final By MGS_APIKEYMessage = By.name("The URL has already been
	// used for CA Workload Automation DE");

	// public static final By SKUValidation = By.name("The URL has already been used
	// for DX NetOps");

	/**
	 * txtUrlFld : To add URL details in that Text box
	 */
	public AddInstancePage clickOnInstanceUrlFld(String txt) {
		clearAndSendKeys(txtUrlFld, txt, "Add Instance URL");
		return this;
	}

	/**
	 * txtInstanceAliasFld : To add Product Name details in that Text box
	 */
	public AddInstancePage clickOnInstanceFld(String txt) {
		clearAndSendKeys(txtInstanceAliasFld, txt, "Add Instance URL");
		return this;
	}

	/**
	 * name : To get by element name from excel sheet
	 */
	private By name(String txt) {
		return By.name(txt);
	}

	/**
	 * envtype : To get environment detail from excel sheet and pass data
	 */

	public AddInstancePage selectEnvType(String env) {
		By envtype = name(env);
		waitAndClick(envtype, "Select Enviroment Type");
		return new AddInstancePage(dtdriver);
	}

	public AddInstancePage EnvironmentAndSelect(String envtype) {
		waitAndClick(ddlEnvironment, "Environment DropDown List");
		selectEnvType(envtype);
		return this;
	}

	/**
	 * txtInstanceAliasFld : To add Basic authentication details in that Text box
	 */
	public AddInstancePage clickOnBasicConfigureDetails(String uname, String pwd, String repwd) {
		clearAndSendKeys(txtUsername, uname, "Username");
		clearAndSendKeys(txtPassword, pwd, "Password");
		clearAndSendKeys(txtConfirmPassword, repwd, "Confirm Password");
		return this;
	}

	/**
	 * txtInstanceAliasFld : To add Bearer authentication details in that Text box
	 */
	public AddInstancePage clickOnBearerConfigureDetails(String uname) {
		clearAndSendKeys(txtToken, uname, "Token");
		return this;
	}

	/**
	 * txtInstanceAliasFld : To add APIKEY authentication details in that Text box
	 */
	public AddInstancePage EnterApiKeyConfigureDetails(String uname, String pwd) {
		try {
			clearAndSendKeys(Key, uname, "Key");
			clearAndSendKeys(KeyValue, pwd, "Value");
		} catch (Exception e) {
			Actions action = new Actions(dtdriver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			clearAndSendKeys(Key, uname, "Key");
			clearAndSendKeys(KeyValue, pwd, "Value");
		}
		return this;
	}

	/**
	 * btnTestConnection : To test the connection details
	 */

	public AddInstancePage clickOnTestConnection() {
		waitAndClick(btnTestConnection, "Test Connection");
		holdScript(1);
		return this;
	}

	/**
	 * clickOnSaveDetails : Add and Saving file for 1St time only calling function
	 * If SKU Validation is Displayed will run this script in catch Block
	 */
	public DashboardPage clickOnSaveDetails() {
		Actions action = new Actions(dtdriver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		waitAndClick(btnSave, "Add instance and save credentials");
		try {
			new DashboardPage(dtdriver).getAddInstanceMessage();
			holdScript(2);
		} catch (Exception e) {
			getMessage();
			waitAndClick(OkYes, "Select Ok");
			waitAndClick(btnCancel, "Select Cancel Button");
			new AddProductsPage(dtdriver).clickOnGoBackIcon();
		}
		return new DashboardPage(dtdriver);
	}

	/**
	 * clickOnSaveDetail : Add and Saving file for 2St time only calling function
	 */
	public AddInstancePage clickOnSaveDetail() {
		Actions action = new Actions(dtdriver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		waitAndClick(btnSave, "Add instance and save credentials");
		return this;
	}

	public String ErorMessage(String product) {
		By Message = name("The URL has already been used for " + product);
		return getElementText(Message);
	}

	public AddProductsPage clickOnCancel() {
		waitAndClick(btnCancel, "Cancel");
		return new AddProductsPage(dtdriver);
	}

	public DashboardPage clickOnSaveChangesDetails() {
		try {
			Actions action = new Actions(dtdriver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			waitAndClick(btnSaveChanges, "Save Changes");
			getMessage();
			waitAndClick(OkYes, "Select Ok");
			waitAndClick(btnCancel, "Select Cancel Button");
		} catch (Exception e) {
			new DashboardPage(dtdriver).getupdateInstanceMessage();
		}
		return new DashboardPage(dtdriver);
	}

	public String getInstanceURLMessage() {
		holdScript(2);
		return getElementText(MGS_InstanceURL);
	}

	public String getRequired_FieldsMessage() {
		holdScript(2);
		return getElementText(MGS_Required_Fields);
	}

	public String getAuthenticationsMessage() {
		holdScript(2);
		return getElementText(MGS_AuthenticationType);
	}

	public String getMessage() {
		holdScript(2);
		return getElementText(Warning);
	}

	/**
	 * Unused code Method : clickOnEnvironmentAndSelects and AuthenticationAndSelect
	 * Unused code : selectAuthType
	 */

	// Alternative Option for select Enviroment type
//	public AddInstancePage clickOnEnvironmentAndSelect() {
//		waitAndClick(ddlEnvironment, "Environment DropDown List");
//		waitAndClick(ddlEnvironmentEnvtype, "Environment Type as Test");
//		return this;
//	}

	// Alternative Option for select Authentication type
//	public AddInstancePage selectAuthType(String auth) {
//		By authtype = name(auth);
//		waitAndClick(authtype, "Select Authentication Type");
//		return this;
//	}

//	public AddInstancePage AuthenticationAndSelect(String auth) {
//		waitAndClick(ddlAuthentication, "Authentication DropDown List");
//		selectAuthType(auth);
//		return this;
//	}

//	public String getBearerMessage() {
//		return getElementText(MGS_BearerMessage);
//	}
//
//	public String getBasicMessage() {
//		return getElementText(MGS_BasicMessage);
//	}
//
//	public String getApiMessage() {
//		return getElementText(MGS_APIKEYMessage);
//	}

}
