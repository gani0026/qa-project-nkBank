package pages;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Benefiser_Adding {

	WebDriver driver;
	public  Benefiser_Adding(WebDriver driver) {
		this.driver=driver;
	}
private	String fundTransfer= "//span[text()='Add Beneficiary']";
private String beniName="//input[@name='beneficiary_name']";
private String accountNum="//input[@name='account_number']";
private String confrimAccNum="//input[@name='confirm_account_number']";
private String ifscCode="//input[@name='ifsc_code']";
private String bankName="//input[@name='bank_name']";
private String addButton="//button[contains(normalize-space(.), 'Add Beneficiary')]";
private String addPopupButton="//button[contains(text(),'Add')]";
private String otpTextField="//input[@name='otp_code']";
private String otpSubmitButton="//button[@type='submit']";
private String successPopUp="//button[contains(text(),'Continue')]";
private void clickFundTransfer() {
    driver.findElement(By.xpath(fundTransfer)).click();
}

public void enterBeneficiaryName(String name) {
    driver.findElement(By.xpath(beniName)).sendKeys(name);
}

public void enterAccountNumber(String accNum) {
    driver.findElement(By.xpath(accountNum)).sendKeys(accNum);
}

public void enterConfirmAccountNumber(String confirmAccNumVal) {
    driver.findElement(By.xpath(confrimAccNum)).sendKeys(confirmAccNumVal);
}

public void enterIfscCode(String ifsc) {
    driver.findElement(By.xpath(ifscCode)).sendKeys(ifsc);
}

public void enterBankName(String bank) {
    driver.findElement(By.xpath(bankName)).sendKeys(bank);
}

public void clickAddBeneficiaryButton() {
    driver.findElement(By.xpath(addButton)).click();
}

public void clickAddPopupButton() {
    driver.findElement(By.xpath(addPopupButton)).click();
}

public void enterOtp() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Otp");
	int otp = sc.nextInt();
	String str = String.valueOf(otp);
    driver.findElement(By.xpath(otpTextField)).sendKeys(str);
}

public void clickOtpSubmitButton() {
    driver.findElement(By.xpath(otpSubmitButton)).click();
    if (driver.findElement(By.xpath(successPopUp)).isDisplayed()) {
		System.out.println("otp verification Succesfull");
	} else {
		System.out.println("otp verification Failed");
	}
}

public void clickSuccessContinueButton() {
    driver.findElement(By.xpath(successPopUp)).click();
}

// ==============================
// 🔹 Public Business Flow Method
// ==============================

public String addNewBeneficiary(String id,String name, String accNum, String confirmAccNumVal, String ifsc, String bank,String pin) {
	Login_Page obj=new Login_Page(driver);
	String result=	obj.userLoginAndDashboardTest(id,pin);
    clickFundTransfer();
    enterBeneficiaryName(name);
    enterAccountNumber(accNum);
    enterConfirmAccountNumber(confirmAccNumVal);
    enterIfscCode(ifsc);
    enterBankName(bank);
    clickAddBeneficiaryButton();
    clickAddPopupButton();
    enterOtp();
    clickOtpSubmitButton();
    clickSuccessContinueButton();
    
    String str=id+name+accNum+confirmAccNumVal+ifsc+bank;
    
    return str;
}


}
