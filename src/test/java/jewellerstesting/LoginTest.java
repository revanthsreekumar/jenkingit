package jewellerstesting;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import util.TestConfigProperties;
import util.TestListener;
@Listeners({ TestListener.class }) // Add a custom TestListener class to generate the report
public class LoginTest {
	WebDriver driver;
	PageObjectSauceDemo sd;

	@BeforeTest
	public void setup() {
		driver = WebDriverManager.getDriver();
		 sd = new PageObjectSauceDemo();
		
	}
	@Test
public void login() throws InterruptedException {
	driver.get(new TestConfigProperties().testReadConfigProperties("saucedemo.url"));
	
	Thread.sleep(3000);
	//TestConfigProperties tp=	new TestConfigProperties();
	sd.sdUname().sendKeys(new TestConfigProperties().testReadConfigProperties("saucedemo.uname"));
	sd.sdPword().sendKeys(new TestConfigProperties().testReadConfigProperties("saucedemo.pwd"));
	sd.sdLoginBtn().click();
	if(!sd.productTitle().isEmpty()) {
	Assert.assertEquals("Products", sd.productTitle().get(0).getText());
	}
	else {
		Assert.fail("element not found");
	}
	
}
	@Test
	public void loginValidation() throws InterruptedException {
		driver.get(new TestConfigProperties().testReadConfigProperties("saucedemo.url"));
		
		Thread.sleep(3000);
		//TestConfigProperties tp=	new TestConfigProperties();
		sd.sdUname().sendKeys(new TestConfigProperties().testReadConfigProperties("saucedemo.uname"));
		sd.sdPword().sendKeys("wrongpwd");
		sd.sdLoginBtn().click();
		if(!sd.sdLoginErrormsg().isEmpty()) {
		Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", sd.sdLoginErrormsg().get(0).getText());
		}
		else {
			Assert.fail("element not found");
		}
		
	}
@AfterSuite
public void drvierclose() {
	driver.quit();
}
}
