package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleAccount {
       WebDriver driver;
       @BeforeClass
       public void PreCondition() {
    	   WebDriverManager.chromedriver().setup();
    	   driver = new ChromeDriver();
    	   driver.manage().window().maximize();
    	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	   driver.get("https://accounts.google.com/signup");
       }
       @Test
       public void test() throws InterruptedException {
    	  WebElement fNameTextBox = driver.findElement(By.id("firstName"));
    	  String typeValue = fNameTextBox.getAttribute("class");
    	  System.out.println("first name attribute: "+ typeValue);
    	  driver.findElement(By.id("firstName")).sendKeys("Priya");;
    	  Thread.sleep(2000);
       }
       @AfterClass
       public void tearDown() throws InterruptedException {
    	   Thread.sleep(2000);
    	   driver.close();
       }
       
}
