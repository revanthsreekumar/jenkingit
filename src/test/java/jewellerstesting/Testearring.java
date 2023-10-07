package jewellerstesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testearring {
	WebDriver driver;
	PageObjectsEarring earringPage;

	@BeforeTest
	public void setup() {
		driver = WebDriverManager.getDriver();
		earringPage = new PageObjectsEarring();
	}

	@Test
	public void earrings() throws InterruptedException {
		driver.get("https://www.candere.com/jewellery/earrings.html/");
		// PageObjectsEarring gg= new PageObjectsEarring();
		Thread.sleep(3000);
		String price = earringPage.earringPrice().getText();

		try {
			int extractedNumber = Integer.parseInt(price.replace("₹", "").replace(",", ""));
			System.out.println(extractedNumber);
		} catch (NumberFormatException e) {
			Assert.fail();
		}

	}

	@AfterTest
	public void drvierclose() {
		driver.quit();
	}
}
