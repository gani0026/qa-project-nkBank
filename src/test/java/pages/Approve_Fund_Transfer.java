package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Approve_Fund_Transfer {
	WebDriver driver;
	String send = "//span[text()='Transactions']";
	String transactionPage = "//span[text()='Banking Transactions']";//Wait for this element
	String accNumClick="//b[text()='Account Number']";
	String selectTransaction="//td[@name='account_number']";
	String transactionID="//div[@name='transaction_reference']";
	String clickJurnol = "//input[@id='journal_id_0']";
	String selectcash = "//a[@id='journal_id_0_0_0']";
	String clcikOnaccount = "//input[@id='debit_account_id_0']";
	String selectAccount = "//a[text()='100100 Cash']";
	String CreditAccount = "//input[@id='credit_account_id_0']";
	String selectCreditacc = "//a[text()='100100 Cash']";
	public	Approve_Fund_Transfer (WebDriver driver){
		this.driver=driver;
	}

	public void openTransactionPage() {
		// Click on Transactions
		driver.findElement(By.xpath(send)).click();

		// Wait for Banking Transactions element to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(transactionPage)));
	}
	public void clickAccountNumber() {
		driver.findElement(By.xpath(accNumClick)).click();
	}

	// Method 2 → Wait for and click on the transaction
	public void clickSelectTransaction() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement transactionElement = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(selectTransaction))
				);
		transactionElement.click();
	}
	public String transactionID() {
		String str=	driver.findElement(By.xpath(transactionID)).getText();
		return str;
	}
public	String beforeBalance;
public	String afterBalance;
	public String approverTransaction(String username,String passord,String acc) {
		Admin_Login obj=new Admin_Login(driver);
		String str="";	try {
			obj.logIn(username, passord);

			openTransactionPage();

			Admin_Page adm=new Admin_Page(driver);
			adm.enterSearch(acc);
			clickAccountNumber();
			clickSelectTransaction();

			Credit_To_User_Via_Admin cre= new Credit_To_User_Via_Admin(driver, acc);
			cre.selectJournal(clickJurnol,selectcash);
			cre.selectAccount(clcikOnaccount,selectAccount,CreditAccount,selectCreditacc);
			//			cre.selectJournal();
			//			cre.selectAccount();
			//			cre.sendToChecker();
			cre.sendToApprover();
			cre.approveTransaction();
			cre.parentBankSuccess();
			afterBalance=		cre.getAfterBalance();
			beforeBalance=	cre.getBeforeBalance();
			str	=	cre.postToDashordButton();} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		if(str.equalsIgnoreCase("done")) {
			str="Test Case passes";
		}else {
			str="Test Case Failed";
		}
		return str;


	}

}
