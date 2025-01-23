package testPackage;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import pageClasses.AdminPage;
import pageClasses.DashboardHomePage;
import pageClasses.LoginPage;
import utils.BaseClass;

public class UITest extends BaseClass {

	@Test
	public void addEmployeeTest() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("Admin");
		loginPage.enterUserPassword("admin123");
		loginPage.clickLoginButton();
		
		DashboardHomePage dashboardHomePage = new DashboardHomePage(driver);
		dashboardHomePage.clickLinkSidePanel("Admin");
		
		AdminPage adminPage = new AdminPage(driver);
		
		adminPage.clickButton("Add");
		
		// Enter details to add user functionality using map
		Map<String, String> values = new HashMap<>();
		values.put("EmployeeName", "R");
		values.put("UserName", "Lokiii");
		values.put("Password", "1@Earth2345");
		values.put("ConfirmPassword", "1@Earth2345");
		values.put("User Role", "Admin");
		values.put("Status", "Enabled");
		adminPage.addUserUnderAdmin(values);
		adminPage.clickButton("Save");
		
		// Verify Added user through search functionality
		adminPage.searchAddedUser(values.get("UserName"));
		
		// After User search then verify details of the user in the table
		adminPage.fnVerifyUserDetails(values);
	}
}
