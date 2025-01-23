package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.UIResusableMethods;

public class DashboardHomePage extends UIResusableMethods{

	WebDriver driver;

	public DashboardHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Home page Locators
	@FindBy(xpath = "//nav[@role='navigation' and @aria-label='Sidepanel']//ul//a//span[text()='Admin']")
	WebElement AdminLinkSidePanel;

	@FindBy(xpath = "//nav[@role='navigation' and @aria-label='Sidepanel']//ul//a//span[text()='PIM']")
	WebElement PIMLinkSidePanel;

	
	
	// Home Page Side Panel Actions
	public void clickLinkSidePanel(String SidePanelLinkName) {
		switch (SidePanelLinkName) {
		case "Admin":
			AdminLinkSidePanel.click();
			break;
		case "PIM":
			PIMLinkSidePanel.click();
			break;
		default:
		    System.out.println("Something went wrong ...");
		}
	}

}
