package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
	WebDriver driver;
	 @BeforeClass
	 public void PreCondition() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		
		 driver.get("https://jqueryui.com/droppable/");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }
	 @Test
	 public void test() throws Exception {
		 driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		 WebElement fromElement = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
		 Thread.sleep(9000);
		 WebElement toElement = driver.findElement(By.id("droppable"));
		 Actions act = new Actions(driver);
		 act.dragAndDrop(fromElement, toElement).build().perform();
		 
		 Thread.sleep(2000);	 
	 }
	 @AfterClass
	 public void tearDoen() {
		 driver.close();
	 }
}
