package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollWebPage {
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
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("window.scrollBy(0,360)");
	    	Thread.sleep(3000);
	    	js.executeScript("window.scrollBy(0,-180)");
	    }
	    @AfterClass
	    public void tearDown() throws InterruptedException {
	    	Thread.sleep(2000);
	    	driver.close();
	    }
}
