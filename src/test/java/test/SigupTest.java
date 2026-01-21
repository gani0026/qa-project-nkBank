package test;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import baseNKBank.BaseNk;
import common.MyTestListener;
import pages.Admin_Login;
import pages.Admin_Logout;
import pages.Admin_Page;
import pages.Approve_Fund_Transfer;
import pages.Benefiser_Adding;
import pages.Checker_And_Approver_Page;
import pages.Credit_To_User_Via_Admin;
import pages.FundTrans_Page;
import pages.Login_Page;
import pages.Registation_Page;
import pages.Verify_Beni_transaction_page;
import pages.Verify_Credit;

@Listeners(MyTestListener.class)  
public class SigupTest extends BaseNk {


	@Test(priority = 1,enabled = false)
	public void signUpTestForKYC() throws Exception {
		Registation_Page obj=new Registation_Page(driver);
		String str;
		str=obj.signup(pin);
//		String	id= obj.id;
//		String acc=obj.getacc();
//		prop.setProperty("acc", acc); 
//		prop.setProperty("id", id);
//		// 💾 Save back to the same file (overwrite the existing account number)
//		FileOutputStream out = new FileOutputStream(fe);
//		prop.store(out, "Updated config values");
//		out.close();
		System.out.println(str);
		Reporter.getCurrentTestResult().setAttribute("str", str);
	}
	@Test(priority = 2,enabled = true)
	public void userActivation() throws Exception {
		Admin_Login log=new Admin_Login(driver);
		String loginresult=	log.logIn(username, password);
		Admin_Page obj= new Admin_Page(driver);
		String str1=obj.userActive(username, password, id,pin);
		Admin_Logout logOut=new Admin_Logout(driver);
		String logoutResult=  logOut.adminlogOut();
		String str=loginresult+ " \n " +str1+"  "+id+ "  " + logoutResult;
		Reporter.getCurrentTestResult().setAttribute("str", str);
	}
	@Test(priority = 2,enabled = true,dependsOnMethods = "userActivation")
	public void userLogin() {
		Login_Page obj=new Login_Page(driver);
		String str1=	obj.userLoginAndDashboardTest(id,pin);
		String str=str1+" "+id;
		Reporter.getCurrentTestResult().setAttribute("str", str);
		obj.logout();	
	}
	String afterBalance="";
	
	String credit="Credit";
	String debit="Debit";
	String beforeBalance;
	@Test(priority = 4,enabled = true)
	public void credit_Amount() throws InterruptedException {
		Admin_Login log=new Admin_Login(driver);
		String loginresult=	log.logIn(username, password);
		Credit_To_User_Via_Admin obj=new Credit_To_User_Via_Admin(driver, acc);
		String str1= obj.processTransaction(credit);
		// Get the balances after transaction
	     afterBalance = obj.getAfterBalance();
	     beforeBalance = obj.getBeforeBalance();

	    // Remove commas from the balance strings to avoid the NumberFormatException
	    beforeBalance = beforeBalance.replaceAll(",", "");
	    afterBalance = afterBalance.replaceAll(",", "");

	    
	        // Print cleaned-up balances for debugging
	        System.out.println("Cleaned beforeBalance: " + beforeBalance);
	        System.out.println("Cleaned afterBalance: " + afterBalance);

	        // Convert before and after balances to doubles (after removing commas)
	        double doubleBefore = Double.parseDouble(beforeBalance);
	        double doubleAfter = Double.parseDouble(afterBalance);

	        // Transaction amount (set this as required, for example 1000.00)
	        double transactionAmt = 1000.00;  // Example transaction amount
	      
	        double d=doubleAfter- doubleBefore ;
	        // Check if the difference between before and after balances equals the transaction amount
	        if (d  == transactionAmt) {
	            System.out.println("✅ Test passed: The balance change is as expected."+d);
	        } else {
	            System.out.println("❌ Test failed: The balance change is incorrect."+d);
	            Assert.fail("❌ Test failed: The balance change is incorrect. Expected change: " + transactionAmt + ", but found: " + d);
	        }
		System.out.println(str1);  
		Admin_Logout logOut=new Admin_Logout(driver);
		afterBalance = obj.getAfterBalance();
		String logoutResult=  logOut.adminlogOut();
		String str=loginresult+ " \n " +str1+"  "+id+ "  " + logoutResult;
		Reporter.getCurrentTestResult().setAttribute("str", str);
	}
	@Test(priority = 4,enabled = true,dependsOnMethods = "credit_Amount")
	public void verifyCreditAmount() {
		Verify_Credit obj=new Verify_Credit(driver);
		String str=	obj.verifyAmountAfterLogin(id, afterBalance,credit,pin);
		Reporter.getCurrentTestResult().setAttribute("str", str);
	}
	@Test(priority = 6,enabled = true)
	public void debit_Amount() throws InterruptedException {
		Admin_Login log=new Admin_Login(driver);
		String loginresult=	log.logIn(username, password);
		Credit_To_User_Via_Admin obj=new Credit_To_User_Via_Admin(driver, acc);
		String str1= obj.processTransaction(debit);
		// Get the balances after transaction
	     afterBalance = obj.getAfterBalance();
	     beforeBalance = obj.getBeforeBalance();

	    // Remove commas from the balance strings to avoid the NumberFormatException
	    beforeBalance = beforeBalance.replaceAll(",", "");
	    afterBalance = afterBalance.replaceAll(",", "");

	    
	        // Print cleaned-up balances for debugging
	        System.out.println("Cleaned beforeBalance: " + beforeBalance);
	        System.out.println("Cleaned afterBalance: " + afterBalance);

	        // Convert before and after balances to doubles (after removing commas)
	        double doubleBefore = Double.parseDouble(beforeBalance);
	        double doubleAfter = Double.parseDouble(afterBalance);

	        // Transaction amount (set this as required, for example 1000.00)
	        double transactionAmt = 1000.00;  // Example transaction amount
	      
	        double d=doubleBefore - doubleAfter;
	        // Check if the difference between before and after balances equals the transaction amount
	        if (d  == transactionAmt) {
	            System.out.println("✅ Test passed: The balance change is as expected."+d);
	        } else {
	            System.out.println("❌ Test failed: The balance change is incorrect."+d);
	            Assert.fail("❌ Test failed: The balance change is incorrect. Expected change: " + transactionAmt + ", but found: " + d);
	        }
		System.out.println(str1);  
		afterBalance=obj.getAfterBalance();

		Admin_Logout logOut=new Admin_Logout(driver);
		String logoutResult=  logOut.adminlogOut();
		String str=loginresult+ " \n " +str1+"  "+id+ "  " + logoutResult;
		Reporter.getCurrentTestResult().setAttribute("str", str);
	}
	@Test(priority = 6,enabled = true,dependsOnMethods = "debit_Amount")
	public void verifyDebitAmount() {
		Verify_Credit obj=new Verify_Credit(driver);
		String str=	obj.verifyAmountAfterLogin(id, afterBalance,debit,pin);
		Reporter.getCurrentTestResult().setAttribute("str", str);
	}
	String name = "test";
	String accNum = "12345678901234";
	String confirmAccNumVal = "12345678901234";
	String ifsc = "IDFC0CNEELA";
	String bank = "HDFC Bank";
	@Test(priority =8,enabled = true)
	public void addBeni() {

		Benefiser_Adding obj= new Benefiser_Adding(driver);
		String str=	obj.addNewBeneficiary(id, name, accNum, confirmAccNumVal, ifsc, bank,pin);
		Reporter.getCurrentTestResult().setAttribute("str", str);


	}
	@Test(priority = 9,enabled = true)
	public void moneySendViaBeni()
	{

		FundTrans_Page obj=new FundTrans_Page(driver);
		String str=	obj.performFundTransfer(oldid,pin);
		Reporter.getCurrentTestResult().setAttribute("str", str);	
	}
	String transactionId;
	@Test(priority = 10,enabled = true)
	public void benimoneyApprove() {
		Approve_Fund_Transfer aop= new Approve_Fund_Transfer(driver);
		String str=		aop.approverTransaction(username, password, oldacc);
		// Get the balances after transaction
	    String afterBalance = aop.afterBalance;
	    String beforeBalance = aop.beforeBalance;

	    // Remove commas from the balance strings to avoid the NumberFormatException
	    beforeBalance = beforeBalance.replaceAll(",", "");
	    afterBalance = afterBalance.replaceAll(",", "");

	    
	        // Print cleaned-up balances for debugging
	        System.out.println("Cleaned beforeBalance: " + beforeBalance);
	        System.out.println("Cleaned afterBalance: " + afterBalance);

	        // Convert before and after balances to doubles (after removing commas)
	        double doubleBefore = Double.parseDouble(beforeBalance);
	        double doubleAfter = Double.parseDouble(afterBalance);

	        // Transaction amount (set this as required, for example 1000.00)
	        double transactionAmt = 1000.00;  // Example transaction amount
	      
	        double d=doubleBefore - doubleAfter;
	        // Check if the difference between before and after balances equals the transaction amount
	        if (d  == transactionAmt) {
	            System.out.println("✅ Test passed: The balance change is as expected."+d);
	        } else {
	            System.out.println("❌ Test failed: The balance change is incorrect."+d);
	            Assert.fail("❌ Test failed: The balance change is incorrect. Expected change: " + transactionAmt + ", but found: " + d);
	        }
		transactionId=aop.transactionID();
		System.out.println("*******************"+transactionId);
		Reporter.getCurrentTestResult().setAttribute("str", str);	

	}
	@Test(priority = 10,dependsOnMethods = "benimoneyApprove",enabled = true)
	public void beniMoneyVerify() {
		Verify_Beni_transaction_page beni=new Verify_Beni_transaction_page(driver);
		String transactionid=	beni.verifyTransactionID(oldid, pin);
		System.out.println("*******************"+transactionid);
		String str;
		if (transactionId.equals(transactionid)) {
			str=	("benitransaction Done");
		} else {
			str=("benitransaction Failed");
		}
		Reporter.getCurrentTestResult().setAttribute("str", str);	
	}
	@Test(priority = 11)
	public void maker() {
		FundTrans_Page obj=new FundTrans_Page(driver);
		String str=	obj.performFundTransfer(maker,pin);
		Reporter.getCurrentTestResult().setAttribute("str", str);
	}
	@Test(priority = 12)
	public void checker(){
		Checker_And_Approver_Page obj= new Checker_And_Approver_Page(driver);
		obj.performAllActions(checker, pin);

	}
	@Test(priority = 13)
	public void approver(){

		Checker_And_Approver_Page obj= new Checker_And_Approver_Page(driver);

		obj.performAllActions(approver, pin);
	}

}
