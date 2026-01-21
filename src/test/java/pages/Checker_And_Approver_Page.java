package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.Commom_Methods;

public class Checker_And_Approver_Page {
	WebDriver driver;Commom_Methods com;
	public Checker_And_Approver_Page(WebDriver driver) {
		this.driver=driver;com= new Commom_Methods(driver);
	}

	private static final String NOTIFICATION_XPATH = "//i[@class='fas fa-bell']";
	private static final String TRANSACTION_XPATH = "//div[@class='notification-text']";
	private static final String CHECK_TRANSACTION_XPATH = "//button[@type='submit']";
	private static final String BACK_BUTTON_XPATH = "//i[@class='fas fa-arrow-left me-2']";

	// Method to click the notification icon
	public void clickNotification() {
		WebElement notificationIcon = driver.findElement(By.xpath(NOTIFICATION_XPATH));
		notificationIcon.click();

	}

	// Method to click on the transaction text
	public void clickOnTransaction() {
		WebElement transactionText = driver.findElement(By.xpath(TRANSACTION_XPATH));
		transactionText.click();
	}

	// Method to check if the transaction is successful
	public void isTransactionChecked() {
		WebElement checkIcon = driver.findElement(By.xpath(CHECK_TRANSACTION_XPATH));

		com.actions(BACK_BUTTON_XPATH);
		checkIcon.click();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}



	}

	// Method to click on the back button
	public void clickBackButton() {
		WebElement backBtn = driver.findElement(By.xpath(BACK_BUTTON_XPATH));
		com.actions(BACK_BUTTON_XPATH);
		backBtn.click();
	}

	// Method that calls all the above methods in sequence
	public void performAllActions(String id,String pin) {
		Login_Page log=new Login_Page(driver);
		log.userLoginAndDashboardTest(id, pin);
		// Click on the notification
		clickNotification();

		// Click on the transaction
		clickOnTransaction();

		// Check if the transaction is successful and print the result
		isTransactionChecked();


		// Click the back button
		clickBackButton();
	}

}
