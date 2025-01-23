package reusableComponents;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIResusableMethods {

	WebDriver driver;

	public UIResusableMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public void waitForElementToAppear(By loc) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
	}

	public void waitForWebElementToAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitForElementToDisappear(By loc) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loc));
	}
	
	public void clickDropdownArrowIconAndSelectValue(String fieldName, String option) {
		WebElement arrowIcon = driver.findElement(By.xpath("//label[text()='"+fieldName+"']/parent::div/following-sibling::div//i"));
		arrowIcon.click();
		WebElement listBoxOption = driver.findElement(By.xpath("//div[@role='listbox']//span[text()='"+option+"']"));
		listBoxOption.click();
	}
	
	public void clickButton(String btnName) {
		WebElement btn = driver.findElement(By.xpath("//button[text()=' "+btnName+" ']"));
		btn.click();
	}

	public boolean isElementDisplayedOrNot(WebElement ele) {
		if (ele.isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}
	
	public void scrollUpOrDown(int pixel, String scroll) {
		//to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(scroll.equals("ScrollDown")) {
			js.executeScript("window.scrollBy(0,"+pixel+")", "");
		} else if(scroll.equals("ScrollUp")) {
			js.executeScript("window.scrollBy("+pixel+",0)", "");
		}
	}
	
	public boolean compareTwoArrayList(List<String> l1, List<String> l2) {
		Collections.sort(l1);
		Collections.sort(l2);
		System.out.println(l1);
		System.out.println(l2);
		if(l1.equals(l2)) {
			return true;
		} else {
			return false;
		}
	}

}
