package com.hellofresh.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.hellofresh.base.BaseClass;
import com.hellofresh.util.ExtentReportLog;

public class HomePage extends BaseClass {

	@FindBy(how = How.CLASS_NAME, using = "login")
	public WebElement signInLinkWebElement;

	@FindBy(how = How.CLASS_NAME, using = "page-heading")
	public WebElement pageHeadingWebElement;

	@FindBy(how = How.CLASS_NAME, using = "account")
	public WebElement accountNameWebElement;

	@FindBy(how = How.CLASS_NAME, using = "info-account")
	public WebElement infoAccountWebElement;

	@FindBy(how = How.CLASS_NAME, using = "logout")
	public WebElement logoutWebElement;

	@FindBy(how = How.LINK_TEXT, using = "Women")
	public WebElement womenWebElement;

	@FindBy(how = How.NAME, using = "Submit")
	public WebElement addToCartWebElement;

	@FindBy(how = How.XPATH, using = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
	public WebElement proceedToCheckoutButtonOnProductPageWebElement;

	@FindBy(how = How.XPATH, using = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
	public WebElement proceedToCheckoutButtonOnShoppingCartPageWebElement;

	@FindBy(how = How.NAME, using = "processAddress")
	public WebElement proceedToCheckoutButtonOnAddressTabPageWebElement;

	@FindBy(how = How.ID, using = "uniform-cgv")
	public WebElement acceptTermsAndConditionsWebElement;

	@FindBy(how = How.NAME, using = "processCarrier")
	public WebElement proceedToCheckoutButtonOnShippingTabPageWebElement;

	@FindBy(how = How.CLASS_NAME, using = "bankwire")
	public WebElement payByBankWireWebElement;

	@FindBy(how = How.XPATH, using = "//*[@id='cart_navigation']/button")
	public WebElement iConfirmMyOrderButtonWebElement;

	@FindBy(how = How.XPATH, using = "//li[@class='step_done step_done_last four']")
	public WebElement stepDoneLastFourWebElement;

	@FindBy(how = How.XPATH, using = "//li[@id='step_end' and @class='step_current last']")
	public WebElement stepLastWebElement;

	@FindBy(how = How.XPATH, using = "//*[@class='cheque-indent']/strong")
	public WebElement orderCompleteHeadingWebElement;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickSignLink() {
		signInLinkWebElement.click();
		ExtentReportLog.testCaseInfo("SignIn Link clicked.");
	}

	public void clickOnWomenTab() {
		womenWebElement.click();
		ExtentReportLog.testCaseInfo("Clicked on Women Tab.");
	}

	public void selectProduct(String productName) {
		driver.findElement(By.linkText(productName)).click();
		ExtentReportLog.testCaseInfo("Clicked on item" + productName);
	}

	public void addToCart() {
		addToCartWebElement.click();
		ExtentReportLog.testCaseInfo("Add to cart clicked.");
	}

	public void clickProceedToCheckoutOnProductPage() {
		proceedToCheckoutButtonOnProductPageWebElement.click();
		ExtentReportLog.testCaseInfo("Proceed button clicked on product page.");
	}

	public void clickProceedToCheckoutOnShoppingCartPageSummaryTab() {
		proceedToCheckoutButtonOnShoppingCartPageWebElement.click();
		ExtentReportLog.testCaseInfo("Proceed to checkout button clicked on Shopping cart summary tab.");
	}

	public void clickProceedToCheckoutOnShoppingCartPageAddressTab() {
		proceedToCheckoutButtonOnAddressTabPageWebElement.click();
		ExtentReportLog.testCaseInfo("Proceed to checkout button clicked on Shopping cart address tab.");
	}

	public void acceptTermsAndConditions() {
		acceptTermsAndConditionsWebElement.click();
		ExtentReportLog.testCaseInfo("Clicked accepted terms and Conditions check box.");
	}

	public void clickProceedToCheckoutOnShoppingCartPageShippingTab() {
		proceedToCheckoutButtonOnShippingTabPageWebElement.click();
		ExtentReportLog.testCaseInfo("Proceed to checkout button clicked on Shopping cart Shipping tab.");
	}

	public void payByBankWire() {
		payByBankWireWebElement.click();
		ExtentReportLog.testCaseInfo("Pay by bank wire clicked.");
	}

	public void clickIConfirmMyOrderButton() {
		iConfirmMyOrderButtonWebElement.click();
		ExtentReportLog.testCaseInfo("I confirm my order button clicked.");
	}

	public void checkOutProductFromWomenTabWithPayByBankWire(String productName) {
		clickOnWomenTab();
		selectProduct(productName);
		addToCart();
		clickProceedToCheckoutOnProductPage();
		clickProceedToCheckoutOnShoppingCartPageSummaryTab();
		clickProceedToCheckoutOnShoppingCartPageAddressTab();
		acceptTermsAndConditions();
		clickProceedToCheckoutOnShoppingCartPageShippingTab();
		payByBankWire();
		clickIConfirmMyOrderButton();
	}
}
