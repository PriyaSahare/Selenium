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

public class SwitchTab {
	 WebDriver driver;
     
	    @BeforeClass
	    public void PrecCondition() {
	    	WebDriverManager.chromedriver().setup();
	    	driver = new ChromeDriver();
	    	driver.manage().window().maximize();                 
            driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    }
	    @Test
	    public void test() throws InterruptedException {
	    	driver.findElement(By.linkText("Medical Records")).click();
	    	Thread.sleep(2000);
	    	driver.findElement(By.linkText("Search Patient")).click();
	    	Thread.sleep(2000);
	    	WebElement ddown = driver.findElement(By.id("search_type"));
	    	Select select = new Select(ddown);
	        select.selectByValue("3");
			
			Thread.sleep(2000);
			List<WebElement> a = select.getAllSelectedOptions();
			for (WebElement option : a) {
				System.out.println(option.getText());
			}	
	    }
	    	@AfterClass
		    public void tearDown() throws InterruptedException {
		    	Thread.sleep(2000);
		    	driver.close();
		    }
	    
}
