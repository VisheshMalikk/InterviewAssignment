package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.UIResusableMethods;

public class LoginPage extends UIResusableMethods {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Login page locators
	@FindBy(name = "username")
	WebElement usernameInput;

	@FindBy(name = "password")
	WebElement passwordInput;

	@FindBy(tagName = "button")
	WebElement loginButton;

	public void enterUserName(String userName) {
		usernameInput.sendKeys(userName);
	}

	public void enterUserPassword(String userPassword) {
		passwordInput.sendKeys(userPassword);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
}
