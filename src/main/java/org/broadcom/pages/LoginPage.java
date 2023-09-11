package org.broadcom.pages;

import org.openqa.selenium.By;

import io.appium.java_client.windows.WindowsDriver;

public final class LoginPage extends BasePage {

	public LoginPage(WindowsDriver dtdriver) {
		super(dtdriver);
	}

	// Naming Convention for private static final fields/variables
	private static final By btnBroadcomAccount = By.name("Sign in with your Broadcom Account");
	private static final By btnAutomationAccount = By.name("Sign in with your Automation Account");
	private static final By txtusername = By.name("Enter the username");
	private static final By txtpassword = By.name("Enter the password");
	private static final By UsernameError = By.name("Username is required");
	private static final By PasswordError = By.name("Password is required");
	private static final By CredentialsError = By
			.name("Make sure you have entered the Username and Password correctly.");

	public LoginPage navigateTobtnBroadcomAccount() {
		waitAndClick(btnBroadcomAccount, "Sign in with your Broadcom Account");
		return this;
	}

	public DashboardPage navigateTobtnAutomationAccount() {
		waitAndClick(btnAutomationAccount, "Sign in with your Automation Account");
		return new DashboardPage(dtdriver);
	}

	public LoginPage EnterUsername(String txt) {
		clearAndSendKeys(txtusername, txt, "Enter the username");
		return this;
	}

	public LoginPage EnterPassword(String txt) {
		clearAndSendKeys(txtpassword, txt, "Enter the password");
		return this;
	}

	public String emailValidation() {
		return getElementText(UsernameError);

	}

	public String passwordValidation() {
		return getElementText(PasswordError);
	}

	public String getCredentialsError() {
		return getElementText(CredentialsError);
	}

	public DashboardPage loginAuthentication(String username, String Password) {
		navigateTobtnBroadcomAccount().EnterUsername(username).EnterPassword(Password).navigateTobtnAutomationAccount();
		return new DashboardPage(dtdriver);
	}

}
