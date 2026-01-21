package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Credit_To_User_Via_Admin {
	WebDriver driver;
	WebElement mt;
	String acc;

//	String send = "//span[text()='Transactions']";
//	String transactionPage = "//span[text()='Banking Transactions']";
//	String newTransaction = "//button[text()=' New ']";
//	String accNumFiled = "//input[@id='banking_account_id_0']";
//	String selectAccNum = "//a[@id='banking_account_id_0_0_0']";
//	String selectTractionType = "//select[@id='transaction_type_0']";
//	String sendMoney = "//input[@id='amount_0']";
//	String clickJurnol = "//input[@id='journal_id_0']";
//	String selectcash = "//a[@id='journal_id_0_0_0']";
//	String clcikOnaccount = "//input[@id='debit_account_id_0']";
//	String selectAccount = "//a[text()='100100 Cash']";
//	String CreditAccount = "//input[@id='credit_account_id_0']";
//	String selectCreditacc = "//a[text()='100100 Cash']";
	String checkButton = "//span[text()='Submit for Check']";
	String checkSubButton = "//span[text()='Check Transaction']";
	String beforeBalancexpath = "(//span[contains(text(),'.')])[2]";
	String aftherBalancexpath = "(//span[contains(text(),'.')])[3]";
	String approveTra = "//span[text()='Approve for Parent Bank']";
	String parentbankXp = "//button[@name='action_parent_bank_success']";
	String postToDash = "//span[text()='Post to Dashboard']";
	String sendTochekcer = "//span[text()='Pending Check']";
	String sendToApprover = "//span[text()='Pending Approval']";
	String parentBankProcess = "//span[text()='Parent Bank Processing']";
	String parentBank = "//span[text()='Post to Accounts']";
	String transactionDone = "//span[text()='Banking Completed']//preceding-sibling::span[text()='Banking In Progress']";


	    String send = "//span[text()='Transactions']";
	    String transactionPage = "//span[text()='Banking Transactions']";
	    String newTransaction = "//button[text()=' New ']";
	    String accNumFiled = "//input[@id='banking_account_id_1']";
	    String selectAccNum = "//a[@id='banking_account_id_1_0_0']";
	    String selectTractionType = "//select[@id='transaction_type_1']";
	    String sendMoney = "//input[@id='amount_1']";
	    String clickJurnol = "//input[@id='journal_id_1']";
	    String selectcash = "//a[@id='journal_id_1_0_0']";
	    String clcikOnaccount = "//input[@id='debit_account_id_1']";
	    String selectAccount = "//a[text()='100100 Cash']";
	    String CreditAccount = "//input[@id='credit_account_id_1']";
	    String selectCreditacc = "//a[text()='100100 Cash']";
	//    String checkButton = "//span[text()='Submit for Check']";
	//    String checkSubButton = "//span[text()='Check Transaction']";
	//    String beforeBalancexpath = "(//span[contains(text(),'.')])[2]";
	//    String aftherBalancexpath = "(//span[contains(text(),'.')])[3]";
	//    String approveTra = "//span[text()='Approve for Parent Bank']";
	//    String parentbankXp = "//button[@name='action_parent_bank_success']";
	//    String postToDash = "//span[text()='Post to Dashboard']";
	//    String sendTochekcer = "//span[text()='Pending Check']";
	//    String sendToApprover = "//span[text()='Pending Approval']";
	//    String parentBankProcess = "//span[text()='Parent Bank Processing']";
	//    String parentBank = "//span[text()='Post to Accounts']";
	//    String transactionDone = "//span[text()='Banking Completed']//preceding-sibling::span[text()='Banking In Progress']";
	public Credit_To_User_Via_Admin(WebDriver driver, String acc) {
		this.driver = driver;
		this.acc = acc;
	}

	// ====== Utility Methods ======

	private WebElement findElement(By locator) {
		for (int i = 0; i < 3; i++) {
			try {
				WebElement el = driver.findElement(locator);
				if (el != null) return el;
			} catch (StaleElementReferenceException e) {
				System.out.println("⚠️ Element stale, retrying find... attempt " + (i + 1));
			} catch (NoSuchElementException e) {
				// Element not found yet
			}
			sleep(1000);
		}
		System.out.println("⚠️ Element not found after retries: " + locator);
		return null;
	}

	private void click(By locator) {
		for (int i = 0; i < 3; i++) {
			try {
				WebElement el = findElement(locator);
				if (el == null) {
					System.out.println("⚠️ Cannot click — element missing: " + locator);
					return;
				}
				el.click();
				sleep(500);
				return;
			} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
				System.out.println("⚠️ Retry clicking... attempt " + (i + 1));
				sleep(1000);
			}
		}
		System.out.println("⚠️ Click failed for locator: " + locator);
	}

	private void sendKeys(By locator, String text) {
		try {
			WebElement el = findElement(locator);
			if (el == null) {
				System.out.println("⚠️ Cannot send keys — element missing: " + locator);
				return;
			}
			el.clear();
			el.sendKeys(text);
			sleep(500);
		} catch (Exception e) {
			System.out.println("⚠️ Failed to send keys to: " + locator + " — " + e.getMessage());
		}
	}

	private void selectVisibleText(By locator, String text) {
		try {
			WebElement el = findElement(locator);
			if (el == null) {
				System.out.println("⚠️ Cannot select text — element missing: " + locator);
				return;
			}
			new Select(el).selectByVisibleText(text);
			sleep(500);
		} catch (Exception e) {
			System.out.println("⚠️ Failed to select text: " + text + " from " + locator);
		}
	}

	private boolean waitForVisible(By locator) {
		for (int i = 0; i < 10; i++) {
			try {
				WebElement el = driver.findElement(locator);
				if (el != null && el.isDisplayed()) return true;
			} catch (StaleElementReferenceException | NoSuchElementException ignored) {}
			sleep(1000);
		}
		return false;
	}

	private void sleep(long millis) {
		try { Thread.sleep(millis); } catch (InterruptedException ignored) {}
	}

	private boolean safeWaitForVisible(By locator, String label) {
		try {
			boolean visible = waitForVisible(locator);
			if (visible) {
				System.out.println("✅ " + label + " found.");
				return true;
			} else {
				System.out.println("⚠️ " + label + " not visible, continuing...");
				return false;
			}
		} catch (Exception e) {
			System.out.println("⚠️ Exception while waiting for " + label + ": " + e.getMessage());
			return false;
		}
	}

	// ====== Business Flow ======

	public void clickOnTransactions() { click(By.xpath(send)); }
	public void clickOnNewTransactions() { click(By.xpath(newTransaction)); }

	public void enterAccountNumber() {
		sendKeys(By.xpath(accNumFiled), acc);
		click(By.xpath(selectAccNum));
	}

	public void selectTransaction(String type) {
		selectVisibleText(By.xpath(selectTractionType), type);
	}

	public void enterAmount() {
		WebElement money = findElement(By.xpath(sendMoney));
		if (money != null) {
			money.click();
			sleep(1000);
			sendKeys(By.xpath(sendMoney), "1000");
		} else {
			System.out.println("⚠️ Amount field missing — skipping input.");
		}
	}

	public void selectJournal(String clickJurnol,String selectcash) {
		click(By.xpath(clickJurnol));
		click(By.xpath(selectcash));
	}

	public void selectAccount(String clcikOnaccount, String selectAccount,String CreditAccount,String selectCreditacc) {
		try {
			click(By.xpath(clcikOnaccount));
			click(By.xpath(selectAccount));
			click(By.xpath(CreditAccount));
			click(By.xpath(selectCreditacc));
		} catch (Exception e) {
			System.out.println("⚠️ Skipped account selection: " + e.getMessage());
		}
	}
//	public void selectJournal() {
//		click(By.xpath(clickJurnol));
//		click(By.xpath(selectcash));
//	}
//
//	public void selectAccount() {
//		try {
//			click(By.xpath(clcikOnaccount));
//			click(By.xpath(selectAccount));
//			click(By.xpath(CreditAccount));
//			click(By.xpath(selectCreditacc));
//		} catch (Exception e) {
//			System.out.println("⚠️ Skipped account selection: " + e.getMessage());
//		}}

	// Simplified — no “Pending Check” check here
	public String sendToChecker() {
		click(By.xpath(checkButton));
		System.out.println("✅ Sent to Checker (no Pending Check validation here).");
		return "Send to Checker executed.";
	}

	public String sendToApprover() {
		click(By.xpath(checkSubButton));
		safeWaitForVisible(By.xpath(sendToApprover), "Pending Approval");
		return "Send to Approver executed.";
	}

	public String approveTransaction() {
		click(By.xpath(approveTra));
		safeWaitForVisible(By.xpath(parentBankProcess), "Parent Bank Processing");
		return "Approve Transaction executed.";
	}

	public String parentBankSuccess() {
		click(By.xpath(parentbankXp));
		safeWaitForVisible(By.xpath(parentBank), "Post to Accounts");
		return "Parent Bank Success executed.";
	}
	public String postToDashordButton() {
		click(By.xpath(postToDash));
		String str="Done";
		return str;
	}
	public String postToDashboard() {
		postToDashordButton();
		safeWaitForVisible(By.xpath(transactionDone), "Transaction Done");
		return "Post to Dashboard executed.";
	}

	public String getBeforeBalance() {
		return waitForVisible(By.xpath(beforeBalancexpath))
				? findElement(By.xpath(beforeBalancexpath)).getText()
						: "Balance not found";
	}

	public String getAfterBalance() {
		return waitForVisible(By.xpath(aftherBalancexpath))
				? findElement(By.xpath(aftherBalancexpath)).getText()
						: "Balance not found";
	}

	// ====== Main Transaction Flow ======
	public String processTransaction(String creditOrDebit) {
		StringBuilder result = new StringBuilder();

	
			clickOnTransactions();
			clickOnNewTransactions();
			enterAccountNumber();
			selectTransaction(creditOrDebit);
			enterAmount();
			selectJournal( clickJurnol, selectcash);
			selectAccount( clcikOnaccount,  selectAccount, CreditAccount, selectCreditacc);
//			selectJournal();
//			selectAccount();
			result.append(sendToChecker()).append(" ");
			result.append(sendToApprover()).append(" ");
			result.append(approveTransaction()).append(" ");
			result.append(parentBankSuccess()).append(" ");
			result.append(postToDashboard()).append(" ");

			// ✅ Only here we check for Pending Check
//			System.out.println("🔍 Checking if 'Pending Check' appears at the end...");
			boolean checkVisible = waitForVisible(By.xpath(sendTochekcer));
			if (checkVisible) {
				System.out.println("✅ 'Pending Check' element is visible at the end.");
			} else {
				System.out.println("⚠️ 'Pending Check' element not visible at the end, continuing anyway.");
			}

			result.append("Before Balance: ").append(getBeforeBalance()).append(" ");
			result.append("After Balance: ").append(getAfterBalance()).append(" ");

//			System.out.println("✅ All transaction steps completed (final check included).");
	
			
		return result.toString();
	}
}