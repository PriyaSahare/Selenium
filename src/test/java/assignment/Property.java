package assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Property {
	WebDriver driver;
	
	@BeforeClass
	public void PreCondition() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	@Test
	public void test() throws IOException, InterruptedException {
		 Properties prop = new Properties();
   	  FileInputStream ip = new FileInputStream("C:\\Users\\priya.sahare\\eclipse-workspace\\SeleniumAssignment\\config.properties");
         prop.load(ip);
         System.out.println(prop.getProperty("name"));
         driver.get(prop.getProperty("url"));
         Thread.sleep(2000);
         
		
	}
   @AfterClass
   public void tearDown() {
	   driver.quit();
   }
}
