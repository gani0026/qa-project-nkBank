package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Admin_Logout {
	WebDriver driver;
public 	Admin_Logout(WebDriver driver){
	this.driver=driver;
}
private String profilebutton="//img[@alt='User']";
private String logoutButton="//a[@data-menu='logout']";
private String logoutDone="//span[text()='Home']";
public String adminlogOut() {
	driver.findElement(By.xpath(profilebutton)).click();
	driver.findElement(By.xpath(logoutButton)).click();
	Boolean result=driver.findElement(By.xpath(logoutDone)).isDisplayed();
	Assert.assertTrue(result,"Logout Failed");
	String str="Logout Done";
	return str;	
}

}
