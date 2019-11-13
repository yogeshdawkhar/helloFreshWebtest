package com.hellofresh.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.hellofresh.base.BaseClass;
import com.hellofresh.constants.LoggingMessageContants;
import com.hellofresh.dataprovider.RepositoryForCheckoutTestCase;
import com.hellofresh.page.HomePage;
import com.hellofresh.page.SignInPage;
import com.hellofresh.util.AssertionUtil;
import com.hellofresh.util.ExtentReportLog;
import com.hellofresh.util.PropertiesReader;
import com.hellofresh.util.UtililtyFunctions;

public class CheckOutPageTestCase extends BaseClass {

	HomePage homePageObj;
	SignInPage signInPageObj;

	@Test(dataProviderClass = RepositoryForCheckoutTestCase.class, dataProvider = "TestData")
	public void checkout(String emailAddress, String passwd, String productName)
			throws IOException, InterruptedException {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + browser);
		PropertiesReader.load(userNamePasswordPropertifile);
		UtililtyFunctions.openURL(baseUrl);
		homePageObj = PageFactory.initElements(driver, HomePage.class);
		homePageObj.clickSignLink();

		signInPageObj = PageFactory.initElements(driver, SignInPage.class);
		signInPageObj.enterEmailIdAndPasswdAndClickSignIn(emailAddress, passwd);

		homePageObj.checkOutProductFromWomenTabWithPayByBankWire(productName);

		AssertionUtil.assertEquals(homePageObj.pageHeadingWebElement.getText(),
				LoggingMessageContants.ORDER_CONFIRMATION,
				LoggingMessageContants.ORDER_CONFIRMATION + LoggingMessageContants.TEXT_PRESENT,
				LoggingMessageContants.ORDER_CONFIRMATION + LoggingMessageContants.TEXT_NOT_PRESENT);

		AssertionUtil.assertEquals(UtililtyFunctions.isElementExists(homePageObj.stepDoneLastFourWebElement), true,
				LoggingMessageContants.ELEMENT_ENABLED, LoggingMessageContants.ELEMENT_DISABLED);

		AssertionUtil.assertEquals(UtililtyFunctions.isElementExists(homePageObj.stepLastWebElement), true,
				LoggingMessageContants.ELEMENT_ENABLED, LoggingMessageContants.ELEMENT_DISABLED);

		AssertionUtil.assertEquals(homePageObj.orderCompleteHeadingWebElement.getText(),
				LoggingMessageContants.YOUR_ORDER_ON_MY_STORE_IS_COMPLETE,
				LoggingMessageContants.YOUR_ORDER_ON_MY_STORE_IS_COMPLETE + LoggingMessageContants.TEXT_PRESENT,
				LoggingMessageContants.YOUR_ORDER_ON_MY_STORE_IS_COMPLETE + LoggingMessageContants.TEXT_NOT_PRESENT);

		AssertionUtil.assertEquals(
				UtililtyFunctions.getCurrentUrl().contains(LoggingMessageContants.ORDER_CONFIRMATION_URL), true,
				LoggingMessageContants.EXPECTED_DATA_PRESENT_IN_URL + UtililtyFunctions.getCurrentUrl(),
				LoggingMessageContants.EXPECTED_DATA_NOT_PRESENT_IN_URL + UtililtyFunctions.getCurrentUrl());
	}

}