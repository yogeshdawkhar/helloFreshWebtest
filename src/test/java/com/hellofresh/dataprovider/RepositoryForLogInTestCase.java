package com.hellofresh.dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.hellofresh.base.BaseClass;
import com.hellofresh.util.PropertiesReader;

public class RepositoryForLogInTestCase extends BaseClass {

	@DataProvider(name = "TestData", parallel = true)
	public static Object[][] bothCaseData(Method mtd) {
		PropertiesReader.load(userNamePasswordPropertifile);
		Object detail[][] = null;

		if (mtd.getName().equalsIgnoreCase("logInTest")) {
			return new Object[][] { { PropertiesReader.get("existingUserEmail"),
					PropertiesReader.get("existingUserPassword"), PropertiesReader.get("fullname") } };
		}
		return detail;
	}
}
