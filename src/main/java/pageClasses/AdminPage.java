package pageClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import reusableComponents.UIResusableMethods;

public class AdminPage extends UIResusableMethods {

	WebDriver driver;
	List<String> l1 = new ArrayList<>();
	List<String> l2 = new ArrayList<>();

	public AdminPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Admin page locators
	
	@FindBy(xpath = "//h6[text()='Add User']")
	WebElement AddUserHeading;
	
	@FindBy(xpath = "//h5[text()='System Users']")
	WebElement SystemUserHeading;
	
	@FindBy(xpath = "//label[text()='Username']/parent::div/following-sibling::div/input")
	WebElement UserNameInput;

	@FindBy(xpath = "//label[text()='Employee Name']/parent::div/following-sibling::div//input")
	WebElement EmployeeNameInput;

	@FindBy(xpath = "//label[text()='Password']/parent::div/following-sibling::div//input")
	WebElement PasswordInput;

	@FindBy(xpath = "//label[text()='Confirm Password']/parent::div/following-sibling::div//input")
	WebElement ConfirmPasswordInput;
	
	@FindBy(xpath = "//div[@role='listbox']//span")
	List<WebElement> list;
	
	@FindBy(xpath = "//div[@role='listbox']")
	WebElement listBox;

	
	public void enterValueInInputField(WebElement element, String value) {
		element.click();
		element.clear();
		element.sendKeys(value);
	}

	public void selectValueFromDropdown(String fieldName, String optionToBeSelect) {
		clickDropdownArrowIconAndSelectValue(fieldName, optionToBeSelect);
	}
	
	public void selectValueFromSuggestionDropdown(WebElement element, String value) {
		element.sendKeys(value);
		waitForWebElementToAppear(listBox);
		for (WebElement webElement : list) {
			String optionText = webElement.getText();
			if(optionText.equalsIgnoreCase("Ranga Akunuri")) {
				webElement.click();
				break;
			}
		}
	}

	public void addUserUnderAdmin(Map<String, String> values) {
		waitForWebElementToAppear(AddUserHeading);
		
		if (values.containsKey("User Role")) {
			selectValueFromDropdown("User Role", values.get("User Role"));
			l2.add(values.get("User Role"));
		} else {
			System.out.println("Something went wrong ..");
		}
		if (values.containsKey("EmployeeName")) {
			selectValueFromSuggestionDropdown(EmployeeNameInput, values.get("EmployeeName"));
			l2.add(values.get("EmployeeName"));
		} else {
			System.out.println("Something went wrong ..");
		}
		if (values.containsKey("Status")) {
			selectValueFromDropdown("Status", values.get("Status"));
			l2.add(values.get("Status"));
		} else {
			System.out.println("Something went wrong ..");
		}
		if (values.containsKey("UserName")) {
			enterValueInInputField(UserNameInput, values.get("UserName"));
			l2.add(values.get("UserName"));
		} else {
			System.out.println("Something went wrong ..");
		}
		if (values.containsKey("Password")) {
			enterValueInInputField(PasswordInput, values.get("Password"));
		} else {
			System.out.println("Something went wrong ..");
		}
		if (values.containsKey("ConfirmPassword")) {
			enterValueInInputField(ConfirmPasswordInput, values.get("ConfirmPassword"));
		} else {
			System.out.println("Something went wrong ..");
		}
	}
	
	public void searchAddedUser(String username) {
		waitForWebElementToAppear(SystemUserHeading);
		UserNameInput.sendKeys(username);
		clickButton("Search");
	}
	
	public void fnVerifyUserDetails(Map<String, String> values) {
		scrollUpOrDown(100, "ScrollDown");
		int i = 2;
		while (i<=5) {
			WebElement cell = driver.findElement(By.xpath("//div[@class='oxd-table-card']/div//div[@role='cell']["+i+"]/div"));
			l1.add(cell.getText());
			i++;
		}
		System.out.println(l1);
		boolean flag = compareTwoArrayList(l1, l2);
		Assert.assertTrue(flag, "Table data is not matching ..");
	}
}
