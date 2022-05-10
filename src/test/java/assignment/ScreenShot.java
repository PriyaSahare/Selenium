package assignment;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {
	WebDriver driver;
	 @BeforeClass
	 public void PreCondition() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		
		 driver.get("https://api.jquery.com/dblclick/");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }
	@Test
	public void test() {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
		FileUtils.copyFile(screenshot, new File("C:\\Users\\priya.sahare\\eclipse-workspace\\SeleniumAssignment\\Screenshot.png"));
		}
		catch (IOException e) {
		System.out.println(e.getMessage());
		}
		driver.close();
	}
}