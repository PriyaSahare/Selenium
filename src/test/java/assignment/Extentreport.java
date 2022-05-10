package assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extentreport {
	WebDriver driver;
    static ExtentTest test;
    static ExtentReports report;
    @BeforeClass
    public static void preCondition() {
    	report = new ExtentReports("ExtentReportResults.html");
    	test = report.startTest("Extentreport");
    }
    @Test
    public void extentReportstest() {
    	WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://www.google.com/");
    	if(driver.getTitle().equals("Google"))
    	{
    		test.log(LogStatus.PASS,"Navigate to the specified URL");
    		
    	}
    	else {
    		test.log(LogStatus.FAIL,"Test Failed");
    	}
    	driver.close();
    }
    @AfterClass
    public static void  endTest() {
    	report.endTest(test);
    	report.flush();
    	
    }
}
