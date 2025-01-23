package utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	// DataProvider to run same Test Case with multiple set of data
	@DataProvider(name = "userDataProvider")
	public static Object[][] getUserData() {
		return new Object[][] { { "admin", "admin" }, { "ronaldo", "player" } };
	}
}
