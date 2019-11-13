package com.hellofresh.base;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.hellofresh.constants.LoggingMessageContants;
import com.hellofresh.util.ExtentReportLog;
import com.hellofresh.util.PropertiesReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	protected static String baseUrl = System.getProperty("url");
	protected static String browser = System.getProperty("browser");

	protected static String randomNumber = new SimpleDateFormat("dd_MM_yy_HHmmssSSSZZZ").format(new Date());
	protected static String fileSeprator = File.separator;

	protected static String extentReportFilePath = System.getProperty("user.dir") + fileSeprator + "src" + fileSeprator
			+ "ExtentReports" + fileSeprator + randomNumber;

	protected static String extentReportFilename = extentReportFilePath + fileSeprator + "extentReportFile" + ".html";
	protected static String extentReportPathForStoringImage = extentReportFilePath + fileSeprator + "images"
			+ fileSeprator;
	protected static String extentReportImagePathForHTML = ".." + fileSeprator + randomNumber + fileSeprator + "images"
			+ fileSeprator;
	protected static ExtentTest extentTest;
	protected static ExtentHtmlReporter htmlReporter;
	protected static ExtentReports extent;
	protected static String placeHolder = "placeholder";

	protected static String propertiesFilePath = System.getProperty("user.dir") + fileSeprator + "src" + fileSeprator
			+ "test" + fileSeprator + "resources" + fileSeprator;
	protected static String userNamePasswordPropertifile = propertiesFilePath + "usernamepassword.properties";

	@BeforeSuite
	public static void startReport() throws IOException {
		System.out.println("Extent Report path:" + extentReportFilename);
		htmlReporter = new ExtentHtmlReporter(extentReportFilename);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.loadXMLConfig("html-config.xml");
		PropertiesReader.load(userNamePasswordPropertifile);
		try {
			if (baseUrl.isEmpty() || baseUrl == null) {
				System.out.println(
						"url not entered in command line. Please check url passed through command line -Durl=");
				System.exit(0);
			} else {
				URL u = new URL(baseUrl);
				HttpURLConnection huc = (HttpURLConnection) u.openConnection();
				huc.setRequestMethod("GET");
				huc.connect();
				int code = huc.getResponseCode();
				if (code != 200) {
					System.out.println("URL not reachable:" + PropertiesReader.get("baseURL"));
					System.out.println("response code:" + code);
					System.exit(0);
				}
				System.out.println("Status code of response." + code);
			}
		} catch (Exception e) {
			System.out.println("URL not reachable:" + PropertiesReader.get("baseURL"));
			System.out.println("Exception:" + e);
			System.exit(0);
		}
	}

	@BeforeClass
	public static void setUp() {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println(
					"Driver not initialized. Please check browser name passed through command line -Dbrowser=");
			System.exit(0);
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			ExtentReportLog.testCaseFail("Test Case Failed is " + result.getName());
			ExtentReportLog.testCaseFailWithImage("Test Case Failed Snapshot is below " + result.getThrowable());
			System.out.println("Test Case Failed :" + result.getName());
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtentReportLog.testCaseSkip("Test Case Skipped is " + result.getName());
			System.out.println("Test Case Skipped :" + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentReportLog.testCasePass("Test Case Passed is " + result.getName());
			System.out.println("Test Case Passed :" + result.getName());
		}
		if ((extent != null) && (!extent.toString().contains(LoggingMessageContants.NULL_CHECK_STRING))) {
			extent.flush();
		}
	}

	@AfterTest
	public void endReport() {
		if ((extent != null) && (!extent.toString().contains(LoggingMessageContants.NULL_CHECK_STRING))) {
			extent.flush();
		}
		if ((driver != null) && (!driver.toString().contains(LoggingMessageContants.NULL_CHECK_STRING))) {
			driver.manage().deleteAllCookies();
		}
	}

	@AfterClass
	public static void closeBrowser() {
		if ((driver != null) && (!driver.toString().contains(LoggingMessageContants.NULL_CHECK_STRING))) {
			driver.quit();
		}
	}
}