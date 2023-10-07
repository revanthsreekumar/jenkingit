package jewellerstesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import util.TestConfigProperties;

public class WebDriverManager {
	private static WebDriver driver;
	public static WebDriver getDriver() {
		if (driver == null) {
			ChromeOptions options = new ChromeOptions();
		//	System.out.println(new TestConfigProperties().testReadConfigProperties("chrome.driver"));
			options.setBinary(new TestConfigProperties().testReadConfigProperties("chrome.binary"));
			System.setProperty("webdriver.chrome.driver", new TestConfigProperties().testReadConfigProperties("chrome.driver"));
			driver = new ChromeDriver(options);
		}
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
