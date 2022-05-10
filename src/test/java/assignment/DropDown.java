package assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	WebDriver driver;
	
	@BeforeClass
	public void PreCondition() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		
	}
	@Test
	public void test() throws Exception {
		WebElement ddown = driver.findElement(By.id("option-droup-demo"));
		Select select = new Select(ddown);
		select.selectByVisibleText("Bootstrap");
		Thread.sleep(2000);
		List<WebElement> o = select.getAllSelectedOptions();
		for (WebElement option : o) {
			System.out.println(option.getText());
		}
			
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}


}
