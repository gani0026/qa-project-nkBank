package pages;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registation_Page {
	String img = "C:\\Users\\ganes\\Pictures\\Camera Roll\\naruto-sasuke-uhdpaper.com-4K-56.jpg";

	String regButton="//a[text()='Register']";

	public  String id;
	WebDriver driver;
	WebDriverWait wait;
	public Registation_Page(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	public void regButtom() {
		driver.findElement(By.xpath(regButton)).click();
	}
	String mbl = "9951604490";
	// ✅ Store all XPaths as variables
	String firstNameXpath = "//input[@name='first_name']";
	String lastNameXpath = "//input[@name='last_name']";
	String mobileNumberXpath = "//input[@name='mobile_number']";
	String nextButtonXpath = "//button[text()='Next →']";
	String otpInputXpath = "//input[@id='otp_input']";
	String verifyNextButtonXpath = "//button[text()='Verify & Next →']";
	String pinXpath = "//input[@name='customer_pin']";
	String confirmPinXpath = "//input[@name='confirm_pin']";
	String accountTypeXpath = "//select[@id='account_type']";
	String clickButtonXpath = "//button[contains(text(),'click')]";
	String houseNumberXpath = "//input[@name='house_number']";
	String address2Xpath = "//input[@name='address_2']";
	String streetXpath = "//input[@name='street']";
	String pinCodeXpath = "//input[@name='pin_code']";
	String cityXpath = "//select[@name='city']";
	String addressSubmitXpath = "//button[@type='submit']";
	String nomineeNameXpath = "//input[@name='nominee_name']";
	String nomineeGenderXpath = "//select[@name='nominee_gender']";
	String nomineeRelationshipXpath = "//select[@name='nominee_relationship']";
	String nomineeMobileXpath = "//input[@name='nominee_mobile']";
	String aadharXpath = "//input[@name='aadhar_number']";
	String panXpath = "//input[@name='pan_number']";
	String dobXpath = "//input[@id='dob']";
	String photoXpath = "//input[@name='photo']";
	String signatureXpath = "//input[@name='signature']";
	String identityDocXpath = "//input[@name='identity_doc']";
	String addressDocXpath = "//input[@name='address_doc']";
	String identityDocTypeXpath = "//select[@name='identity_doc_type']";
	String addressDocTypeXpath = "//select[@name='address_doc_type']";
	String submitXpath = "//button[@type='submit']";
	String termsXpath = "//input[@id='terms']";
	String declarationsXpath = "//input[@id='declarations']";
	String finalSubmitXpath = "//button[contains(text(),'Submit')]";
	String idXpath = "//p[contains(text(),'20002')]";
	String accountnumber="//p[contains(text(),'1000')]";
	// ✅ Methods
	public void firstName() {
		driver.findElement(By.xpath(firstNameXpath)).sendKeys("ganesh");
	}

	public void lastName() {
		driver.findElement(By.xpath(lastNameXpath)).sendKeys("ganesh");
	}

	public void mobileNumber() {
		driver.findElement(By.xpath(mobileNumberXpath)).sendKeys(mbl);
		driver.findElement(By.xpath(nextButtonXpath)).click();
		System.out.println("enter otp here:");
	}

	public void otp() {
		Scanner sc = new Scanner(System.in);
		int otp = sc.nextInt();
		String str = String.valueOf(otp);
		driver.findElement(By.xpath(otpInputXpath)).sendKeys(str);
		driver.findElement(By.xpath(verifyNextButtonXpath)).click();
		if (driver.findElement(By.xpath(pinXpath)).isDisplayed()) {
			System.out.println("otp verification Succesfull");
		} else {
			System.out.println("otp verification Failed");
		}
	}

	public void pin(String pin) {

		driver.findElement(By.xpath(pinXpath)).sendKeys(pin);
		driver.findElement(By.xpath(confirmPinXpath)).sendKeys("1234");
		driver.findElement(By.xpath(nextButtonXpath)).click();
	}

	public void selectAccount() {
		new Select(driver.findElement(By.xpath(accountTypeXpath))).selectByVisibleText("Savings");
		driver.findElement(By.xpath(nextButtonXpath)).click();
		driver.findElement(By.xpath(clickButtonXpath)).click();
	}

	public void address() throws InterruptedException {
		driver.findElement(By.xpath(houseNumberXpath)).sendKeys("test");
		driver.findElement(By.xpath(address2Xpath)).sendKeys("Landmark");
		driver.findElement(By.xpath(streetXpath)).sendKeys("teststreet");
		driver.findElement(By.xpath(pinCodeXpath)).sendKeys("507002");
		Thread.sleep(2000);
		WebElement element=driver.findElement(By.xpath(cityXpath));
		wait.until(ExpectedConditions.visibilityOf(element));
		new Select(element).selectByVisibleText("Yellandu Cross Rd (Kmm)");
		driver.findElement(By.xpath(addressSubmitXpath)).click();
	}
	public void nomineDetails() {
		driver.findElement(By.xpath(nomineeNameXpath)).sendKeys("nomie test");
		new Select(driver.findElement(By.xpath(nomineeGenderXpath))).selectByVisibleText("Male");
		new Select(driver.findElement(By.xpath(nomineeRelationshipXpath))).selectByVisibleText("Brother");
		driver.findElement(By.xpath(nomineeMobileXpath)).sendKeys(mbl);
		driver.findElement(By.xpath(addressSubmitXpath)).click();
	}

	public void aadharn() {
		driver.findElement(By.xpath(aadharXpath)).sendKeys("319331392560");
	}

	public void pan() {
		driver.findElement(By.xpath(panXpath)).sendKeys("AAAAA1234A");
	}

	public void dob() {
		driver.findElement(By.xpath(dobXpath)).sendKeys("26-11-1999");
	}

	public void imgUpload() {
		driver.findElement(By.xpath(photoXpath)).sendKeys(img);
		driver.findElement(By.xpath(signatureXpath)).sendKeys(img);
		driver.findElement(By.xpath(identityDocXpath)).sendKeys(img);
		driver.findElement(By.xpath(addressDocXpath)).sendKeys(img);
	}

	public void selectId() {
		new Select(driver.findElement(By.xpath(identityDocTypeXpath))).selectByIndex(1);
		new Select(driver.findElement(By.xpath(addressDocTypeXpath))).selectByIndex(1);
	}

	public void submit() {
		driver.findElement(By.xpath(submitXpath)).click();
		driver.findElement(By.xpath(termsXpath)).click();
		driver.findElement(By.xpath(declarationsXpath)).click();
		driver.findElement(By.xpath(finalSubmitXpath)).click();
	}

	public void getId() {
		id = driver.findElement(By.xpath(idXpath)).getText();
	}
	public String getacc() {
	String acc=	driver.findElement(By.xpath(accountnumber)).getText();
	return acc;
	}
	public String signup(String pin) throws InterruptedException { regButtom();
	firstName();
	lastName();
	mobileNumber();
	otp();           // waits for user input
	pin(pin);
	selectAccount();
	address();
	nomineDetails();
	aadharn();
	pan();
	dob();
	imgUpload();
	selectId();
	submit();
	getId();

	String str="Signup process completed successfully!" +"with id : "+id;
	return str;

	}


}
