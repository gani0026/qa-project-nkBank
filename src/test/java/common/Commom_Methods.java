package common;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Commom_Methods {
	
	Actions act;
WebDriver driver;	
	
	public Commom_Methods(WebDriver driver) {
		this.driver=driver;
	}
	
	private String otpTextField="//input[@name='otp_code']";
	private String otpSubmitButton="//button[@type='submit']";
	
	public void enterOtp() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Otp");
		int otp = sc.nextInt();
		String str = String.valueOf(otp);
	    driver.findElement(By.xpath(otpTextField)).sendKeys(str);
	    driver.findElement(By.xpath(otpSubmitButton)).click();
	}

	
	
	
	
	public void actions(String str) {
		act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(str))).build().perform();
	}

}
