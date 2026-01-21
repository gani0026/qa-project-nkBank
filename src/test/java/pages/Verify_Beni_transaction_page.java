package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Verify_Beni_transaction_page {
	WebDriver driver;
	String viewStatmentButton="//span[text()='View Statement']";
	String transactionId="//code[contains(text(),'110')]";
	public Verify_Beni_transaction_page(WebDriver driver)
	{
		this.driver=driver;
	}
	public void viewStatment() {
		driver.findElement(By.xpath(viewStatmentButton)).click();
	}
	public String transactionID() {
		String str=	driver.findElement(By.xpath(transactionId)).getText();
		return str;
	}
	
	public String verifyTransactionID(String id,String pin) {
		Login_Page log=new Login_Page(driver);
		log.userLoginAndDashboardTest(id, pin);
		viewStatment();
		String str=	transactionID();
		
		 return str;
	}

}
