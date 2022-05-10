package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopUpWindow {
	WebDriver driver;
	 @BeforeClass
	 public void PreCondition() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://popuptest.com/goodpopups.html/");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }
	@ Test
	 public void A3Popups() throws InterruptedException {

		 driver.findElement(By.xpath("//span[@class='hamburger-section'][@role='button']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[@class='login-button'][@rel='nofollow']")).click();
		 Thread.sleep(2000);

		 System.out.println(driver.getTitle());
		 Thread.sleep(2000);

		 driver.findElement(By.xpath("//button[@id='popup_modal_dismiss_button']")).click();
		 System.out.println(driver.getTitle());

		// driver.findElement(By.xpath("//*[@id=\"popup_modal_dismiss_button\"]")).click();

		// driver.close();
		 Thread.sleep(3000);
		 }

     @AfterClass
	 public void afterClass() throws InterruptedException {
    	 
	  driver.quit();
	 }
}