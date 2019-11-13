package com.hellofresh.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.hellofresh.base.BaseClass;
import com.hellofresh.constants.LoggingMessageContants;
import com.hellofresh.dataprovider.RepositoryCreateAccountTestCase;
import com.hellofresh.page.CreateAccountPage;
import com.hellofresh.page.HomePage;
import com.hellofresh.page.SignInPage;
import com.hellofresh.util.AssertionUtil;
import com.hellofresh.util.ExtentReportLog;
import com.hellofresh.util.PropertiesReader;
import com.hellofresh.util.UtililtyFunctions;

public class CreateAccountTestCase extends BaseClass {

	HomePage homePageObj;
	CreateAccountPage createAccountPageObj;
	SignInPage signInPageObj;

	@Test(dataProviderClass = RepositoryCreateAccountTestCase.class, dataProvider = "TestData")
	public void createAccount(String emailAddress, String title, String fristName, String lastName, String password,
			String day, String month, String year, String companyName, String address, String address2, String city,
			String state, String postalCode, String additionalInfo, String homePhone, String mobilePhone,
			String addressAlias) throws IOException {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + browser);
		PropertiesReader.load(userNamePasswordPropertifile);
		UtililtyFunctions.openURL(baseUrl);
		homePageObj = PageFactory.initElements(driver, HomePage.class);
		homePageObj.clickSignLink();

		signInPageObj = PageFactory.initElements(driver, SignInPage.class);
		signInPageObj.enterEmailIdToCreateAccountAndClickCreateAccount(emailAddress);

		createAccountPageObj = PageFactory.initElements(driver, CreateAccountPage.class);
		createAccountPageObj.enterDetailsOnCreateAccountPageRegisterButton(title, fristName, lastName, password, day,
				month, year, companyName, address, address2, city, state, postalCode, additionalInfo, homePhone,
				mobilePhone, addressAlias);

		AssertionUtil.assertEquals(homePageObj.pageHeadingWebElement.getText(), LoggingMessageContants.MY_ACCOUNT,
				LoggingMessageContants.MY_ACCOUNT + LoggingMessageContants.TEXT_PRESENT,
				LoggingMessageContants.MY_ACCOUNT + LoggingMessageContants.TEXT_NOT_PRESENT);

		AssertionUtil.assertEquals(homePageObj.accountNameWebElement.getText(), fristName + " " + lastName,
				fristName + " " + lastName + LoggingMessageContants.TEXT_PRESENT,
				fristName + " " + lastName + LoggingMessageContants.TEXT_NOT_PRESENT);

		AssertionUtil.assertEquals(
				homePageObj.infoAccountWebElement.getText().contains(LoggingMessageContants.WELCOME_TO_YOUR_ACCOUNT),
				true, LoggingMessageContants.WELCOME_TO_YOUR_ACCOUNT + LoggingMessageContants.TEXT_PRESENT,
				LoggingMessageContants.WELCOME_TO_YOUR_ACCOUNT + LoggingMessageContants.TEXT_NOT_PRESENT);

		AssertionUtil.assertEquals(UtililtyFunctions.isElementExists(homePageObj.logoutWebElement), true,
				LoggingMessageContants.LOGOUT_LINK_DISPLAYED, LoggingMessageContants.LOGOUT_LINK_NOT_DISPLAYED);

		AssertionUtil.assertEquals(UtililtyFunctions.getCurrentUrl().contains(LoggingMessageContants.MY_ACCOUNT_URL),
				true, LoggingMessageContants.EXPECTED_DATA_PRESENT_IN_URL + UtililtyFunctions.getCurrentUrl(),
				LoggingMessageContants.EXPECTED_DATA_NOT_PRESENT_IN_URL + UtililtyFunctions.getCurrentUrl());
	}

}