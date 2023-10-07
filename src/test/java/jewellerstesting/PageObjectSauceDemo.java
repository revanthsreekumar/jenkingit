package jewellerstesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectSauceDemo {
	private WebDriver driver;

	public PageObjectSauceDemo() {
		this.driver = WebDriverManager.getDriver();
	}

	public WebElement sdUname() {

		return driver.findElement(By.cssSelector("#user-name"));
	}
	public WebElement sdPword() {

		return driver.findElement(By.cssSelector("#password"));
	}
	
	public WebElement sdLoginBtn() {

		return driver.findElement(By.cssSelector("#login-button"));
	}
	
	public List<WebElement> productTitle() {

		return driver.findElements(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
	}
	
	
	public  List<WebElement> sdLoginErrormsg() {

		return driver.findElements(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
	}
	
}
