package org.broadcom.pages;

import org.openqa.selenium.By;

import io.appium.java_client.windows.WindowsDriver;

public final class AddProductsPage extends BasePage {

	public AddProductsPage(WindowsDriver dtdriver) {
		super(dtdriver);
	}

	// Naming Convention for private static final fields/variables
	private static final By txtSearchfld = By.name("Search products");

	private static final By btnAddInstance = By.name("Add instance");
	private static final By btnGoback = By.name("Go Back");
	public static final String Basic_Auth_Productname = "DX NetOps";

	private static final By txtBasicProduct = By.name("DX NetOps");
	private static final By txtBearerProduct = By.name("Continuous Delivery Director");
	private static final By txtKeyProduct = By.name("CA Workload Automation DE");

	public AddProductsPage clickOnSearchFld(String txt) {
		holdScript(3);
		SendKeysAndEnter(txtSearchfld, txt, "Search Product");
		return this;
	}

	public AddProductsPage clickOnBasicAddProduct() {
		holdScript(2);
		waitAndClick(txtBasicProduct, "Product Name");
		return this;
	}

	private By moveToProduct(String productName) {
		return By.name(productName);
	}

	public AddProductsPage moveToProductname(String productName) {
		By productNameTxt = moveToProduct(productName);
		waitAndClick(productNameTxt, "Product Name");
		return this;
	}

	public AddProductsPage clickOnBearerAddProduct() {
		holdScript(2);
		waitAndClick(txtBearerProduct, "Product Name");
		return this;
	}

	public AddProductsPage clickOnApiKeyAddProduct() {
		holdScript(2);
		waitAndClick(txtKeyProduct, "Product Name");
		return this;
	}

	public AddInstancePage clickOnAddInstance() {
		waitAndClick(btnAddInstance, "Add Instance");
		return new AddInstancePage(dtdriver);
	}

	public DashboardPage clickOnGoBackIcon() {
		waitAndClick(btnGoback, "Add Instance");
		return new DashboardPage(dtdriver);
	}

	public AddInstancePage searchProductAddInstance(String search, String movetosearch ) {
		clickOnSearchFld(search).moveToProductname(movetosearch).clickOnAddInstance();
		return new AddInstancePage(dtdriver);
	}
	
	
	
}
