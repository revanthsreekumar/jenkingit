package jewellerstesting;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.TestfileWriter;

public class EarringlistsFileWriting {
	WebDriver driver;
	PageObjectsEarring earringPage;

	@BeforeTest
	public void setup() {
		driver = WebDriverManager.getDriver();
		earringPage = new PageObjectsEarring();
		
	}

	@Test
	public void earringList()
	{
		driver.get("https://www.candere.com/jewellery/earrings.html/");

	List<WebElement>	earringNames=earringPage.earringsList();	

	for(WebElement earringname:earringNames) {
		
		TestfileWriter fw = new TestfileWriter();
		System.out.println(earringname.getText());
		fw.lineWriter("earring.txt", earringname.getText());
	}
}
		
	
	
	
	
	
	}
