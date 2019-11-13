package com.hellofresh.dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.hellofresh.util.UtililtyFunctions;

public class RepositoryCreateAccountTestCase {

	@DataProvider(name = "TestData", parallel = true)
	public static Object[][] bothCaseData(Method mtd) {
		Object detail[][] = null;
		if (mtd.getName().equalsIgnoreCase("createAccount")) {
			return new Object[][] { { UtililtyFunctions.generateRandomEmail(10), "mrs",
					UtililtyFunctions.generateRandomStringWithAlphabetesOnly(8),
					UtililtyFunctions.generateRandomStringWithAlphabetesOnly(8),
					UtililtyFunctions.generateRandomCredentials(8), "7", "12", "1990",
					UtililtyFunctions.generateRandomStringWithAlphabetesOnly(8),
					UtililtyFunctions.generateRandomStringwithAlphabetAndNumber(8),
					UtililtyFunctions.generateRandomStringwithAlphabetAndNumber(8),
					UtililtyFunctions.generateRandomStringWithAlphabetesOnly(6), "Colorado",
					UtililtyFunctions.generateRandomNumber(5),
					UtililtyFunctions.generateRandomStringwithAlphabetAndNumber(8),
					UtililtyFunctions.generateRandomNumber(10), UtililtyFunctions.generateRandomNumber(10),
					UtililtyFunctions.generateRandomStringwithAlphabetAndNumber(8) } };
		}
		return detail;
	}
}
