package baseNKBank;

import java.io.File;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import common.Config_File;


public class BaseNk {	
	public 	WebDriver driver;
	public String username;
	public String  password;
	public Properties prop;
	public File fe;
	String url;
	String browser;
	public String acc;
	public String id;
	public String pin;
	public String maker;
	public String checker;
	public String approver;
	public String oldid;
	public String oldacc;
	Config_File config = new Config_File();
	@BeforeMethod
	public void pages() throws Exception {
		url = config.properiesOf("url");
		browser = config.properiesOf("browser");
		username = config.properiesOf("username");
		password = config.properiesOf("password");
		acc = config.properiesOf("acc");
		id = config.properiesOf("id");
		pin = config.properiesOf("pin");
		maker=config.properiesOf("maker");
		checker=config.properiesOf("checker");
		approver=config.properiesOf("approver");
		oldid=config.properiesOf("oldid");
		oldacc=config.properiesOf("oldacc");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\ganes\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		} 
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterMethod(enabled  =true)
	public void closeBrowser() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
}
