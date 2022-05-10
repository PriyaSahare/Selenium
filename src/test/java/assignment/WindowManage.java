package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowManage {
 WebDriver driver;
     
     @BeforeClass
     public void PreCondition() {
    	 WebDriverManager.chromedriver().setup();
    	 driver = new ChromeDriver();
    	 driver.manage().window().maximize();
    	 driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
    	 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
     }
     @Test
     public void test() throws InterruptedException {
    	 Dimension currentDimension = driver.manage().window().getSize();
    	 int height = currentDimension.getHeight();
    	 int width = currentDimension.getWidth();
    	 System.out.println("current Height: "+ height);
    	 System.out.println("current width: "+ width);
    	 Dimension newDimension = new Dimension(300,900);
    	 driver.manage().window().setSize(newDimension);
    	 Thread.sleep(2000);
    	 Dimension newSetDimension = driver.manage().window().getSize();
    	 int newHeight = newSetDimension.getHeight();
    	 int newWidth = newSetDimension.getWidth();
    	 System.out.println("New height: "+ newHeight);
    	 System.out.println("New width: "+ newWidth);
     }
     @AfterClass
     public void tearDown() throws InterruptedException {
    	 Thread.sleep(2000);
    	 driver.close();
     }
}
