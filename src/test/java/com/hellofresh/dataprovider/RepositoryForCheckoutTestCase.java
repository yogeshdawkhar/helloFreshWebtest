
package com.hellofresh.dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.hellofresh.base.BaseClass;
import com.hellofresh.util.PropertiesReader;

public class RepositoryForCheckoutTestCase extends BaseClass {

	@DataProvider(name = "TestData", parallel = true)
	public static Object[][] bothCaseData(Method mtd) {
		PropertiesReader.load(userNamePasswordPropertifile);
		Object detail[][] = null;

		if (mtd.getName().equalsIgnoreCase("checkout")) {
			return new Object[][] { { PropertiesReader.get("existingUserEmail"),
					PropertiesReader.get("existingUserPassword"), "Faded Short Sleeve T-shirts" } };
		}
		return detail;
	}
}
