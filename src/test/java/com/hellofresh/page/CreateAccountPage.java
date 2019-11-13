package com.hellofresh.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hellofresh.util.ExtentReportLog;

public class CreateAccountPage {

	@FindBy(how = How.ID, using = "id_gender2")
	public WebElement mrsRadioWebElement;

	@FindBy(how = How.ID, using = "id_gender1")
	public WebElement mrRadioWebElement;

	@FindBy(how = How.ID, using = "customer_firstname")
	public WebElement fristNameWebElement;

	@FindBy(how = How.ID, using = "customer_lastname")
	public WebElement lastNameWebElement;

	@FindBy(how = How.ID, using = "passwd")
	public WebElement passwordWebElement;

	@FindBy(how = How.ID, using = "days")
	public WebElement dayDropdownWebElement;

	@FindBy(how = How.ID, using = "months")
	public WebElement monthDropdownWebElement;

	@FindBy(how = How.ID, using = "years")
	public WebElement yearDropdownWebElement;

	@FindBy(how = How.ID, using = "company")
	public WebElement companyNameWebElement;

	@FindBy(how = How.ID, using = "address1")
	public WebElement address1WebElement;

	@FindBy(how = How.ID, using = "address2")
	public WebElement address2WebElement;

	@FindBy(how = How.ID, using = "city")
	public WebElement cityWebElement;

	@FindBy(how = How.ID, using = "id_state")
	public WebElement stateWebElement;

	@FindBy(how = How.ID, using = "postcode")
	public WebElement postalCodeWebElement;

	@FindBy(how = How.ID, using = "other")
	public WebElement additionalInfoWebElement;

	@FindBy(how = How.ID, using = "phone")
	public WebElement homePhoneWebElement;

	@FindBy(how = How.ID, using = "phone_mobile")
	public WebElement mobilePhoneWebElement;

	@FindBy(how = How.ID, using = "alias")
	public WebElement addressAliasWebElement;

	@FindBy(how = How.ID, using = "submitAccount")
	public WebElement registerButtonWebElement;

	public CreateAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void selectTitle(String title) {
		if (title.equalsIgnoreCase("mrs")) {
			mrsRadioWebElement.click();
			ExtentReportLog.testCaseInfo("Mrs title clicked.");
		} else if (title.equalsIgnoreCase("mr")) {
			mrRadioWebElement.click();
			ExtentReportLog.testCaseInfo("Mr title clicked.");
		}
	}

	public void enterFristname(String fristName) {
		fristNameWebElement.clear();
		fristNameWebElement.sendKeys(fristName);
		ExtentReportLog.testCaseInfo("Entered Value in Frist name field : " + fristName);
	}

	public void enterLastName(String lastName) {
		lastNameWebElement.clear();
		lastNameWebElement.sendKeys(lastName);
		ExtentReportLog.testCaseInfo("Entered Value in Last Name field : " + lastName);
	}

	public void enterPassword(String password) {
		passwordWebElement.clear();
		passwordWebElement.sendKeys(password);
		ExtentReportLog.testCaseInfo("Entered Value in Password field : " + password);
	}

	public void selectDay(String day) {
		Select select = new Select(dayDropdownWebElement);
		select.selectByValue(day);
		ExtentReportLog.testCaseInfo("Selected day:" + day);
	}

	public void selectMonth(String month) {
		Select select = new Select(monthDropdownWebElement);
		select.selectByValue(month);
		ExtentReportLog.testCaseInfo("Selected month:" + month);
	}

	public void selectYear(String year) {
		Select select = new Select(yearDropdownWebElement);
		select.selectByValue(year);
		ExtentReportLog.testCaseInfo("Selected year:" + year);
	}

	public void enterCompanyName(String companyName) {
		companyNameWebElement.clear();
		companyNameWebElement.sendKeys(companyName);
		ExtentReportLog.testCaseInfo("Entered Value in Company name field : " + companyName);
	}

	public void enterAddress(String address) {
		address1WebElement.clear();
		address1WebElement.sendKeys(address);
		ExtentReportLog.testCaseInfo("Entered Value in address field : " + address);
	}

	public void enterAddress2(String address2) {
		address2WebElement.clear();
		address2WebElement.sendKeys(address2);
		ExtentReportLog.testCaseInfo("Entered Value in address2 field : " + address2);
	}

	public void enterCity(String city) {
		cityWebElement.clear();
		cityWebElement.sendKeys(city);
		ExtentReportLog.testCaseInfo("Entered Value in City field : " + city);
	}

	public void selectState(String state) {
		Select select = new Select(stateWebElement);
		select.selectByVisibleText(state);
		ExtentReportLog.testCaseInfo("Selected state:" + state);
	}

	public void enterPostalCode(String postalCode) {
		postalCodeWebElement.clear();
		postalCodeWebElement.sendKeys(postalCode);
		ExtentReportLog.testCaseInfo("Entered Value in Zip / Postal Code field : " + postalCode);
	}

	public void enterAdditionalInfo(String additionalInfo) {
		additionalInfoWebElement.clear();
		additionalInfoWebElement.sendKeys(additionalInfo);
		ExtentReportLog.testCaseInfo("Entered Value in Additional Info field : " + additionalInfo);
	}

	public void enterHomePhone(String homePhone) {
		homePhoneWebElement.clear();
		homePhoneWebElement.sendKeys(homePhone);
		ExtentReportLog.testCaseInfo("Entered Value in Home Phone field : " + homePhone);
	}

	public void enterMobilePhone(String mobilePhone) {
		mobilePhoneWebElement.clear();
		mobilePhoneWebElement.sendKeys(mobilePhone);
		ExtentReportLog.testCaseInfo("Entered Value in Mobile Phone field : " + mobilePhone);
	}

	public void enterAddressAlias(String addressAlias) {
		addressAliasWebElement.clear();
		addressAliasWebElement.sendKeys(addressAlias);
		ExtentReportLog.testCaseInfo("Entered Value in Address Alias field : " + addressAlias);
	}

	public void clickRegisterButton() {
		registerButtonWebElement.click();
		ExtentReportLog.testCaseInfo("Register button clicked.");
	}

	public void enterDetailsOnCreateAccountPageRegisterButton(String title, String fristName, String lastName,
			String password, String day, String month, String year, String companyName, String address, String address2,
			String city, String state, String postalCode, String additionalInfo, String homePhone, String mobilePhone,
			String addressAlias) {
		selectTitle(title);
		enterFristname(fristName);
		enterLastName(lastName);
		enterPassword(password);
		selectDay(day);
		selectMonth(month);
		selectYear(year);
		enterCompanyName(companyName);
		enterAddress(address);
		enterAddress2(address2);
		enterCity(city);
		selectState(state);
		enterPostalCode(postalCode);
		enterAdditionalInfo(additionalInfo);
		enterHomePhone(homePhone);
		enterMobilePhone(mobilePhone);
		enterAddressAlias(addressAlias);

		clickRegisterButton();
	}
}
