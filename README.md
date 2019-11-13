
# Automation Assignment ExpenseTracker (Selenium-WebDriver + Java)

## Project Structure

```
pom.xml
testng.xml
html-config.xml - (For Extent report configurations)

src
└── ExtentReports (It will contain folder with reports for every execution cycle)

src
  └──test
        └──java
               └──com
                     └──hellofresh
                  	       └── base
                                ├── BaseClass.java : Base class with driver configuration
    
                  	       └── constants
                                ├── LoggingMessageContants.java : Class to keep defined Constant messages 

                  	       └── dataprovider
                                ├── RepositoryForCheckoutTestCase.java : Class for defining data for TestCases 
                                ├── RepositoryCreateAccountTestCase.java : Class for defining data for TestCases
                                ├── RepositoryForLogInTestCase.java : Class for defining data for TestCases
    
                  	       └── pages
                                ├── CreateAccountPage.java : Class for Create Account page WebElements and functions  
                                ├── HomePage.java : Class for Home page WebElements and functions
                                ├── SignInPage.java : Class for SignIn page WebElements and functions
                                        
                  	       └── testcases
                                ├── CheckOutPageTestCase.java : Class for CheckOut TestCases 
                                ├── CreateAccountTestCase.java : Class for Creating Account TestCases
                                ├── LogInTestCase.java : Class for LogIn TestCases
                                             
                  	       └── util
                                ├── AssertionUtil.java : Class for Assertion code. 
                                ├── ExtentReportLog.java : Class for Extent Report Logging.
                                ├── ScreenshotUtil.java : Class for Screenshot functionality.
                                ├── PropertiesReader.java : Class for reading data from file.
                                ├── UtililtyFunctions.java :  Utility functions with super driver and common functions.
                                       
src
  └──test
        └──resources
               ├── usernamepassword.properties : properties file to define existing user details.
    

```

## Libraries:

- testng 6.14.3
- selenium webDriver 3.141.59
- webdrivermanager 3.7.1
- extentreports 4.0.9


## Requirements

- Chrome browser to be installed (Other browser should be installed if you want to run test on other browser e.g. ie,Edge or Firefox)
- Maven 3.0 installed

## Framework
 - Maven build tool, maintaining all the library definition in POM.xml 
 - Page Object Model design pattern for maintaining the separate class for each feature
 - Page Factory Model for defining and locating web elements
 - Extent Report for effective reporting


## Java
 -java version "1.8.0_112"
 -Java(TM) SE Runtime Environment (build 1.8.0_112-b16)
 -Java HotSpot(TM) 64-Bit Server VM (build 25.112-b16, mixed mode)
 -Java 8 is used as "selenium webDriver : 3.141.59" requires java 8.
 
## Start the tests

Open terminal, browse to root directory of project, run the test suite:

	mvn clean install -Durl="http://automationpractice.com/index.php" -Dbrowser="Chrome"

    Pass URL with "-Durl="
    Pass Browser name with "-Dbrowser="
    "Chrome" for chrome browser.
    "firefox" for Firefox browser.
    "ie" for Internet Explorer browser.
    "edge" for Edge browser.
    browser name is not case sensitive.
    
## Test Report Location

Please find test report under below path 

/src/ExtentReports/{currentTestExecutionfolder}/

## Comments in code 

Entire code styling is influenced by Clean Code principle - Robert Martin
Which says
'Truth can only be found in one place: the code’.
So you may not find any comments anywhere in the project.
Keeping in mind that Git can be used to versioning of file and method, class names should be kept as self explanatory.

However, if you need comments on each file. I can do that too.

## Design principles used in Project :

- POM (Page Object Model)
- DRY(Don’t repeat yourself)
- KISS(Keep it simple, stupid)
