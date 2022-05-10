package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {
	WebDriver driver;
	@BeforeTest
	public void BeforeMethod() throws Exception {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
    driver.navigate().to("https://www.google.com");
	driver.manage().window().maximize();
	Thread.sleep(1000);
	}
	@Test()
	public void A4SearchGoogle() throws InterruptedException {
     driver.findElement(By.xpath("//div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Mount everest");
     String search = "height";
	Thread.sleep(3000);
	Actions act = new Actions(driver);
	for (int i = 1; i < 10; i++) {
	try {
	String currString = driver.findElement(By.xpath("//li[" + i + "]/div/div[2]/div[1]/span/b")).getText();
	// System.out.println(currString);
	if (currString.endsWith(search)) {
	act.sendKeys(Keys.ARROW_DOWN).build().perform();
	act.sendKeys(Keys.ENTER).build().perform();
	break;
	} else {
	act.sendKeys(Keys.ARROW_DOWN).build().perform();
	}
	Thread.sleep(1000);
	} catch (Exception e) {
	act.sendKeys(Keys.ARROW_DOWN).build().perform();
	continue;
	}
	}
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
	driver.quit();
	}
	
}
