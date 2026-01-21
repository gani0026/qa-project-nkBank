package test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseNKBank.BaseNk;
import common.MyTestListener;
import pages.Admin_Login;
import pages.Admin_Logout;
import pages.Approve_Fund_Transfer;
import pages.Checker_And_Approver_Page;
import pages.Credit_To_User_Via_Admin;
import pages.FundTrans_Page;
import pages.Verify_Beni_transaction_page;


@Listeners(MyTestListener.class)  
public class Beni_Fund_Test extends BaseNk{
//	@Test(priority = 11)
//	public void maker() {
//		FundTrans_Page obj=new FundTrans_Page(driver);
//		String str=	obj.performFundTransfer(maker,pin);
//		Reporter.getCurrentTestResult().setAttribute("str", str);
//	}
//	@Test(priority = 12)
//	public void checker(){
//		Checker_And_Approver_Page obj= new Checker_And_Approver_Page(driver);
//		obj.performAllActions(checker, pin);
//
//	}
//	@Test(priority = 13)
//	public void approver(){
//
//		Checker_And_Approver_Page obj= new Checker_And_Approver_Page(driver);
//
//		obj.performAllActions(approver, pin);
//	}
	@Test(priority = 9,enabled = true)
	public void moneySendViaBeni()
	{

		FundTrans_Page obj=new FundTrans_Page(driver);
		String str=	obj.performFundTransfer(oldid,pin);
		Reporter.getCurrentTestResult().setAttribute("str", str);	
	}

	////	@Test(priority = 9)
	////	public void moneySendViaBeni()
	////	{
	////
	////		FundTrans_Page obj=new FundTrans_Page(driver);
	////		String str=	obj.performFundTransfer(id,pin);
	////		Reporter.getCurrentTestResult().setAttribute("str", str);	
	////	}
	////	String transactionId;
	////	@Test(priority = 10)
	////	public void benimoneyApprove() {
	////		Approve_Fund_Transfer aop= new Approve_Fund_Transfer(driver);
	////		String str=		aop.approverTransaction(username, password, acc);
	////		transactionId=aop.transactionID();
	////		System.out.println("*******************"+transactionId);
	////		Reporter.getCurrentTestResult().setAttribute("str", str);
	////
	////
	////
	////}
	//	String aftherBalance="";
	//	String credit="Credit";
	//	String debit="Debit";
	//	String beforeBalance;
	//	@Test
	//	public void credit_Amount() throws InterruptedException {
	//		Admin_Login log=new Admin_Login(driver);
	//		String loginresult=	log.logIn(username, password);
	//		Credit_To_User_Via_Admin obj=new Credit_To_User_Via_Admin(driver, acc);
	//		String str1= obj.processTransaction(credit);
	//
	//	    // Get the balances after transaction
	//	    String afterBalance = obj.getAfterBalance();
	//	    String beforeBalance = obj.getBeforeBalance();
	//
	//	    // Remove commas from the balance strings to avoid the NumberFormatException
	//	    beforeBalance = beforeBalance.replaceAll(",", "");
	//	    afterBalance = afterBalance.replaceAll(",", "");
	//
	//	    
	//	        // Print cleaned-up balances for debugging
	//	        System.out.println("Cleaned beforeBalance: " + beforeBalance);
	//	        System.out.println("Cleaned afterBalance: " + afterBalance);
	//
	//	        // Convert before and after balances to doubles (after removing commas)
	//	        double doubleBefore = Double.parseDouble(beforeBalance);
	//	        double doubleAfter = Double.parseDouble(afterBalance);
	//
	//	        // Transaction amount (set this as required, for example 1000.00)
	//	        double transactionAmt = 1000.00;  // Example transaction amount
	//	      
	//	        double d=doubleAfter- doubleBefore ;
	//	        // Check if the difference between before and after balances equals the transaction amount
	//	        if (d  == transactionAmt) {
	//	            System.out.println("✅ Test passed: The balance change is as expected."+d);
	//	        } else {
	//	            System.out.println("❌ Test failed: The balance change is incorrect."+d);
	//	            Assert.fail("❌ Test failed: The balance change is incorrect. Expected change: " + transactionAmt + ", but found: " + d);
	//	        }
	//	    
	//	       	        
	//	   
	////		System.out.println(str1);  
	//		Admin_Logout logOut=new Admin_Logout(driver);
	//		String logoutResult=  logOut.adminlogOut();
	//		String str=loginresult+ " \n " +str1+"  "+id+ "  " + logoutResult;
	//		Reporter.getCurrentTestResult().setAttribute("str", str);
	//	}

	//	@Test(priority = 9,enabled = true)
	//	public void moneySendViaBeni()
	//	{
	//
	//		FundTrans_Page obj=new FundTrans_Page(driver);
	//		String str=	obj.performFundTransfer(oldid,pin);
	//		Reporter.getCurrentTestResult().setAttribute("str", str);	
	//	}
	//	String transactionId;
	//	@Test(priority = 10,enabled = true)
	//	public void benimoneyApprove() {
	//		Approve_Fund_Transfer aop= new Approve_Fund_Transfer(driver);
	//		String str=		aop.approverTransaction(username, password, oldacc);
	//		// Get the balances after transaction
	//	    String afterBalance = aop.afterBalance;
	//	    String beforeBalance = aop.beforeBalance;
	//
	//	    // Remove commas from the balance strings to avoid the NumberFormatException
	//	    beforeBalance = beforeBalance.replaceAll(",", "");
	//	    afterBalance = afterBalance.replaceAll(",", "");
	//
	//	    
	//	        // Print cleaned-up balances for debugging
	//	        System.out.println("Cleaned beforeBalance: " + beforeBalance);
	//	        System.out.println("Cleaned afterBalance: " + afterBalance);
	//
	//	        // Convert before and after balances to doubles (after removing commas)
	//	        double doubleBefore = Double.parseDouble(beforeBalance);
	//	        double doubleAfter = Double.parseDouble(afterBalance);
	//
	//	        // Transaction amount (set this as required, for example 1000.00)
	//	        double transactionAmt = 1000.00;  // Example transaction amount
	//	      
	//	        double d=doubleBefore - doubleAfter;
	//	        // Check if the difference between before and after balances equals the transaction amount
	//	        if (d  == transactionAmt) {
	//	            System.out.println("✅ Test passed: The balance change is as expected."+d);
	//	        } else {
	//	            System.out.println("❌ Test failed: The balance change is incorrect."+d);
	//	            Assert.fail("❌ Test failed: The balance change is incorrect. Expected change: " + transactionAmt + ", but found: " + d);
	//	        }
	//		transactionId=aop.transactionID();
	//		System.out.println("*******************"+transactionId);
	//		Reporter.getCurrentTestResult().setAttribute("str", str);	
	//
	//	}
	//	@Test(priority = 10,dependsOnMethods = "benimoneyApprove",enabled = true)
	//	public void beniMoneyVerify() {
	//		Verify_Beni_transaction_page beni=new Verify_Beni_transaction_page(driver);
	//		String transactionid=	beni.verifyTransactionID(oldid, pin);
	//		System.out.println("*******************"+transactionid);
	//		String str;
	//		if (transactionId.equals(transactionid)) {
	//			str=	("benitransaction Done");
	//		} else {
	//			str=("benitransaction Failed");
	//		}
	//		Reporter.getCurrentTestResult().setAttribute("str", str);	
	//	}


}
