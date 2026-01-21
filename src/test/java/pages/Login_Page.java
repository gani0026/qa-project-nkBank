package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login_Page {
	WebDriver driver;
	public Login_Page(WebDriver driver) {
		this.driver=driver;
	}
	String signInXPath = "//a[text()='Sign in']";
	String membershipIdXPath = "//input[@id='membership_id']";
	String customerPinXPath = "//input[@id='customer_pin']";
	String loginButtonXPath = "//button[@id='loginButton']";
	String goToDashboardXPath = "//button[contains(text(),'Go to Dashboard Now')]";
	String dashboardOverviewXPath = "//h1[text()='Dashboard Overview']";
	String profileButton="//div[@class='user-profile']";
	String logoutButton="//span[text()='Logout']";
	//Click the 'Sign in' link
	public void clickSignIn() {
		try {
			driver.findElement(By.xpath(signInXPath)).click();
		} catch (Exception e) {
			System.out.println("Singn in button Skkiped");
		}
		
	}

	//Enter Membership ID
	public void enterMembershipId(String id) {
		driver.findElement(By.xpath(membershipIdXPath)).sendKeys(id);
	}

	//Enter Customer PIN
	public void enterCustomerPin(String pin) {
		driver.findElement(By.xpath(customerPinXPath)).sendKeys(pin);
	}

	//Click the 'Login' button
	public void clickLoginButton() {
		driver.findElement(By.xpath(loginButtonXPath)).click();
	}

	//Click 'Go to Dashboard Now' button
	public void clickGoToDashboardButton() {
		driver.findElement(By.xpath(goToDashboardXPath)).click();
	}

	//Verify if the 'Dashboard Overview' is displayed
	public boolean isDashboardOverviewDisplayed() {
		return driver.findElement(By.xpath(dashboardOverviewXPath)).isDisplayed();
	}

	public String userLoginAndDashboardTest(String id,String pin) {
		// Calling the methods one by one
		clickSignIn();
		enterMembershipId(id);
		enterCustomerPin(pin);
		clickLoginButton();
		clickGoToDashboardButton();

		// Verifying if the dashboard is displayed
		boolean isDisplayed = isDashboardOverviewDisplayed();
		Assert.assertTrue(isDisplayed, "Dashboard overview is not displayed.");
		String str="user login was succesfull For:";
		
		return str;
	}
	public void logout() {
		driver.findElement(By.xpath(profileButton)).click();
		driver.findElement(By.xpath(logoutButton)).click();
	}

}
