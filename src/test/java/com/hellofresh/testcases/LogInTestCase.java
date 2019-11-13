
package com.hellofresh.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.hellofresh.base.BaseClass;
import com.hellofresh.constants.LoggingMessageContants;
import com.hellofresh.dataprovider.RepositoryForLogInTestCase;
import com.hellofresh.page.HomePage;
import com.hellofresh.page.SignInPage;
import com.hellofresh.util.AssertionUtil;
import com.hellofresh.util.ExtentReportLog;
import com.hellofresh.util.PropertiesReader;
import com.hellofresh.util.UtililtyFunctions;

public class LogInTestCase extends BaseClass {

	HomePage homePageObj;
	SignInPage signInPageObj;

	@Test(dataProviderClass = RepositoryForLogInTestCase.class, dataProvider = "TestData")
	public void logInTest(String emailAddress, String passwd, String fullName)
			throws IOException, InterruptedException {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + browser);
		PropertiesReader.load(userNamePasswordPropertifile);
		UtililtyFunctions.openURL(baseUrl);
		homePageObj = PageFactory.initElements(driver, HomePage.class);
		homePageObj.clickSignLink();

		signInPageObj = PageFactory.initElements(driver, SignInPage.class);
		signInPageObj.enterEmailIdAndPasswdAndClickSignIn(emailAddress, passwd);

		AssertionUtil.assertEquals(homePageObj.pageHeadingWebElement.getText(), LoggingMessageContants.MY_ACCOUNT,
				LoggingMessageContants.MY_ACCOUNT + LoggingMessageContants.TEXT_PRESENT,
				LoggingMessageContants.MY_ACCOUNT + LoggingMessageContants.TEXT_NOT_PRESENT);

		AssertionUtil.assertEquals(homePageObj.accountNameWebElement.getText(), fullName,
				fullName + LoggingMessageContants.TEXT_PRESENT, fullName + LoggingMessageContants.TEXT_NOT_PRESENT);

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
