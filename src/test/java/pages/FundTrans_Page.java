package pages;





import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.Commom_Methods;

public class FundTrans_Page 

{

	WebDriver driver;

	// Constructor
	public FundTrans_Page(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	String fundTransfer = "//span[text()='Fund Transfer']";
	String selectBeni = "//select[@name='beneficiary_id']";
	String selectAcc = "//select[@name='from_account_id']";
	String sendMoney = "//input[@name='amount']";
	String sendButton = "//button[@onclick='submitTransferForm()']";
	String successPage = "//a[@class='btn btn-success w-100']";
	String makerSuccess="//h1[text()='Transaction Workflow - MCA Process']";
	// Methods for each element

	public void clickFundTransfer() {
		driver.findElement(By.xpath(fundTransfer)).click();

	}

	public void selectBeneficiary() {
		WebElement beniDropdown = driver.findElement(By.xpath(selectBeni));
		try {
			Thread.sleep(1000);

		} catch (Exception e) {
			// TODO: handle exception
		}
		new Select(beniDropdown).selectByIndex(1);
	}

	public void selectAccount() {
		WebElement accDropdown = driver.findElement(By.xpath(selectAcc));
		new Select(accDropdown).selectByIndex(1);
	}

	public void enterAmount() {
		driver.findElement(By.xpath(sendMoney)).sendKeys("1000");
	}

	public void clickSendButton() {
		driver.findElement(By.xpath(sendButton)).click();
	}
	public boolean verifySuccessPage() {
		try {

			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(successPage)));

			return true;
		} catch (TimeoutException  e) {
			return false;
		}	}
	public boolean makerSuccessPage() {
		try {
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(makerSuccess)));
			return true;
		} catch (TimeoutException  e) {
			return false;
		}
	}
	// Master method to perform the whole fund transfer
	public String performFundTransfer(String id,String pin) {
		Login_Page obj=new Login_Page(driver);
		obj.userLoginAndDashboardTest(id, pin);
		clickFundTransfer();
		selectBeneficiary();
		selectAccount();
		enterAmount();
		clickSendButton();
		Commom_Methods com=new Commom_Methods(driver);
		com.enterOtp();  
		String str="";
		//		if (makerSuccessPage()) {
		//		    str = "Fund Transfer Successful (Maker)";
		//		    // logout if needed
		//		    // obj.logout();
		//		} else if (verifySuccessPage()) {
		//		    str = "Fund Transfer Successful (Verifier)";
		//		    // logout if needed
		//		    // obj.logout();
		//		} else {
		//			 
		//		    str = "otp verificatio failed"+ "Fund Transfer Failed";
		//		}
		if (makerSuccessPage()||verifySuccessPage()) {
			str = "Fund Transfer Successful (Maker)";
			// logout if needed
			// obj.logout();
		} else {

			str = "otp verificatio failed"+ "Fund Transfer Failed";
		}
		return str;

	}
}

/*
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.Commom_Methods;

public class FundTrans_Page {

    WebDriver driver;

    // Constructor
    public FundTrans_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    String fundTransfer = "//span[text()='Fund Transfer']";
    String selectBeni = "//select[@name='beneficiary_id']";
    String selectAcc = "//select[@name='from_account_id']";
    String sendMoney = "//input[@name='amount']";
    String sendButton = "//button[@onclick='submitTransferForm()']";
    String successPage = "//a[@class='btn btn-success w-100']";
    String makerSuccess = "//h1[text()='Transaction Workflow - MCA Process']";

    // Methods for each element
    public void clickFundTransfer() {
        driver.findElement(By.xpath(fundTransfer)).click();
    }

    public void selectBeneficiary() {
        WebElement beniDropdown = driver.findElement(By.xpath(selectBeni));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Select(beniDropdown).selectByIndex(1);
    }

    public void selectAccount() {
        WebElement accDropdown = driver.findElement(By.xpath(selectAcc));
        new Select(accDropdown).selectByIndex(1);
    }

    public void enterAmount() {
        driver.findElement(By.xpath(sendMoney)).sendKeys("1000");
    }

    public void clickSendButton() {
        driver.findElement(By.xpath(sendButton)).click();
    }

    // Check if Verifier Success Page is displayed
    public boolean verifySuccessPage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(successPage)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Check if Maker Success Page is displayed
    public boolean makerSuccessPage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(makerSuccess)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Master method to perform the whole fund transfer
    public String performFundTransfer(String id, String pin) {
        Login_Page obj = new Login_Page(driver);
        obj.userLoginAndDashboardTest(id, pin);

        clickFundTransfer();
        selectBeneficiary();
        selectAccount();
        enterAmount();
        clickSendButton();

        Commom_Methods com = new Commom_Methods(driver);
        com.enterOtp();

        String str = "";

        // If either Maker or Verifier success page is displayed
        if (makerSuccessPage() || verifySuccessPage()) {
            str = "Fund Transfer Successful";
            // Optional: logout
            // obj.logout();
        } else {
            str = "OTP verification failed. Fund Transfer Failed";
        }

        return str;
    }
}

*/





