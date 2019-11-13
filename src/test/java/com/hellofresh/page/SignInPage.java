package com.hellofresh.page;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.hellofresh.base.BaseClass;
import com.hellofresh.util.ExtentReportLog;

public class SignInPage extends BaseClass {

	@FindBy(how = How.ID, using = "email_create")
	public WebElement emailCreateAccountWebElement;

	@FindBy(how = How.ID, using = "SubmitCreate")
	public WebElement createAccountButtonWebElement;

	@FindBy(how = How.ID, using = "email")
	public WebElement emailRegisteredUserWebElement;

	@FindBy(how = How.ID, using = "passwd")
	public WebElement passwdRegisteredUserWebElement;

	@FindBy(how = How.ID, using = "SubmitLogin")
	public WebElement signInButtonWebElement;

	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterEmailIdToCreateAccountAndClickCreateAccount(String emailId) throws IOException {
		enterEmailAddressInCreateAccount(emailId);
		clickCreateAccount();
	}

	public void enterEmailIdAndPasswdAndClickSignIn(String emailId, String passwd) throws IOException {
		enterEmailAddressInRegisteredUser(emailId);
		enterPasswdAddressInRegisteredUser(passwd);
		clickSignInButton();
	}

	public void enterEmailAddressInCreateAccount(String emailId) {
		emailCreateAccountWebElement.clear();
		emailCreateAccountWebElement.sendKeys(emailId);
		ExtentReportLog.testCaseInfo("Entered Value in Email field : " + emailId);
	}

	public void clickCreateAccount() throws IOException {
		createAccountButtonWebElement.click();
		ExtentReportLog.testCaseInfo("Create Account Button clicked.");
	}

	public void enterEmailAddressInRegisteredUser(String emailId) {
		emailRegisteredUserWebElement.clear();
		emailRegisteredUserWebElement.sendKeys(emailId);
		ExtentReportLog.testCaseInfo("Entered Value in Email field : " + emailId);
	}

	public void enterPasswdAddressInRegisteredUser(String passwd) {
		passwdRegisteredUserWebElement.clear();
		passwdRegisteredUserWebElement.sendKeys(passwd);
		ExtentReportLog.testCaseInfo("Entered Value in Password field : " + passwd);
	}

	public void clickSignInButton() throws IOException {
		signInButtonWebElement.click();
		ExtentReportLog.testCaseInfo("SignIn Button clicked.");
	}
}
