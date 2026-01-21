package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Admin_Page {
	WebDriver driver;
	public  Admin_Page(WebDriver driver) {
		this.driver=driver;
	}
	// Store XPath strings in variables

	
	private String searchBoxXpath = "//input[@role='searchbox']";
	private String membershipIdLabelXpath = "//b[text()='Membership ID']";
	private String membershipIdFieldXpath = "//td[@name='membership_id']";
	private String accountStatusDropdownXpath = "//select[@id='account_status_1']";
	private String saveButtonXpath = "//button[@data-tooltip='Save manually']";
	private String activationXpath="//span[text()='Active']";
	private String setPin="//input[@id='customer_pin_0']";
	private String mblNum="//input[@id='mobile_number_0']";
	// Page actions (methods for interacting with elements)
	

	

	public void enterSearch(String searchTerm) {
		driver.findElement(By.xpath(searchBoxXpath)).sendKeys(searchTerm);
	}

	public void clickMembershipIdLabel() {
		driver.findElement(By.xpath(membershipIdLabelXpath)).click();
	}

	public void clickMembershipIdField() {
		driver.findElement(By.xpath(membershipIdFieldXpath)).click();
	}

	public void selectAccountStatus(String status,String pin) {
		driver.findElement(By.xpath(setPin)).clear();
		driver.findElement(By.xpath(mblNum)).clear();
		driver.findElement(By.xpath(mblNum)).sendKeys("6303798360");
		driver.findElement(By.xpath(setPin)).sendKeys(pin);
		new Select(driver.findElement(By.xpath(accountStatusDropdownXpath))).selectByVisibleText(status);
	}

	public Boolean clickSaveButton() {
		driver.findElement(By.xpath(saveButtonXpath)).click();
		Boolean str=   driver.findElement(By.xpath(activationXpath)).isDisplayed();
		return str;

	}

	// Method to perform login and post-login actions
	public String userActive(String username, String password, String id,String pin) throws InterruptedException {
		// Perform further actions after login
		enterSearch(id);
		clickMembershipIdLabel();
		Thread.sleep(1000); // Wait if needed
		clickMembershipIdField();
		selectAccountStatus("Active",pin);
		Boolean result=   clickSaveButton();
		Assert.assertTrue(result,"User Activation Failed");
		String str;
		
		str="User activation is successfull for: ";
		
		return str;
	}
	


}
