package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Verify_Credit {
	WebDriver driver;
	String amountXpath="//span[@id='totalBalance']";
	public Verify_Credit(WebDriver driver) {
		this.driver= driver;
	}


	public String verifyAmountAfterLogin(String id, String afterBalance,String transaction,String pin) {
		Login_Page obj=new Login_Page(driver);
		String result=	obj.userLoginAndDashboardTest(id,pin); // login and get status

		// Get the displayed amount from the page
		String amount = driver.findElement(By.xpath(amountXpath)).getText();
		String secondAmount = amount.replace("₹", "").trim();

		// Compare the balances (string comparison)
		if (transaction.equals("Debit")) {
			if (afterBalance.equals(secondAmount)) {
				result = result + " | ✅ Amount Debited to user account";
				obj.logout();
			} else {
				result = result + " | ❌ Amount mismatch! Expected: " 
						+ afterBalance + ", Found: " + secondAmount;
				Assert.fail("❌ Amount mismatch! Expected: " + afterBalance + ", Found: " + secondAmount);
			}
		} else if(transaction.equals("Credit")) {
			if (afterBalance.equals(secondAmount)) {
				result = result + " | ✅ Amount credited to user account";
				obj.logout();
			} else {
				result = result + " | ❌ Amount mismatch! Expected: " 
						+ afterBalance + ", Found: " + secondAmount;
				Assert.fail("❌ Amount mismatch! Expected: " + afterBalance + ", Found: " + secondAmount);
			}
		}
		

		// Return the combined message
		return result;

	}

}
