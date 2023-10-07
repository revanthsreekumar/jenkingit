package jewellerstesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectsEarring {
	private WebDriver driver;

	public PageObjectsEarring() {
		this.driver = WebDriverManager.getDriver();
	}

	public WebElement earringPrice() {

		return driver.findElement(By.xpath(
				"//*[@id=\"amasty-shopby-product-list\"]/div[2]/ol/li[1]/div[2]/div/div[3]/div/span/span[1]/span"));
	}
	
	public List<WebElement> earringsList() {

		return driver.findElements(By.xpath("//div[@class=\"product name product-item-name\"]"));

		
	}

}