package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Admin_Login {
	WebDriver driver;

	public 	Admin_Login(WebDriver driver) {
		this.driver=driver;
	}
	private String signinButtom="//a[text()='Sign in']";
	private String adminLogin="//a[contains(text(),'Banking User Login')]";
	private String loginInputXpath = "//input[@name='login']";
	private String passwordInputXpath = "//input[@name='password']";
	private String loginButtonXpath = "//button[text()='Log in']";
	private String porfileButton="//span[@class='user-name']";
	String cliclAny="//i[@class='fas fa-piggy-bank']";
	Boolean result;
	public void enterLogin(String username) {

		try {
			driver.findElement(By.xpath(signinButtom)).click();
		} catch (Exception e) {
			System.out.println("sign in button Skipped or logged in direclyt from userlogin page");}

		driver.findElement(By.xpath(adminLogin)).click();
		driver.findElement(By.xpath(loginInputXpath)).sendKeys(username);
	}
	public void enterPassword(String password) {
		driver.findElement(By.xpath(passwordInputXpath)).sendKeys(password);
	}
	public Boolean clickLoginButton() {
		driver.findElement(By.xpath(loginButtonXpath)).click();
		Boolean result=	driver.findElement(By.xpath(porfileButton)).isDisplayed();
		return result;
	}
	public void clickonany() {
		driver.findElement(By.xpath(cliclAny)).click();
	}
	public String logIn(String username, String password) throws InterruptedException {
		enterLogin(username);
		enterPassword(password);
		Boolean result=	clickLoginButton();
		Assert.assertTrue(result,"Admin Login failed");
		String str="Admin logged into his account";
		clickonany();
		return str;
	}
}
