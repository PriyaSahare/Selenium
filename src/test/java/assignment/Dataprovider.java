package assignment;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dataprovider {
	 WebDriver driver;
	    @BeforeClass
	    
	    public void PreCondition() {
	    	WebDriverManager.chromedriver().setup();
	    	driver = new ChromeDriver();
	    	driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	driver.get("http://10.82.180.36/Common/Login.aspx");
	    }
	    @DataProvider
	    public Object[][] getData(){
	    Object[][] data = new Object[2][3];
	    data[0][0] = "donhere";
	    data[0][1] = "don";
	    data[0][2] = "Incorrect Username/Password";
	    data[1][0] = "donere";
	    data[1][1] = "don";
	    data[1][2] = "User Id does not exist";
	    return data;
	    }
	    @Test (dataProvider = "getData")
	    public void test(String username, String password, String expectedErrorMessage) throws InterruptedException {
	    	WebElement usernameTextBox = driver.findElement(By.id("body_txtUserID"));
	    	WebElement passwordTextBox = driver.findElement(By.id("body_txtPassword"));
	    	WebElement loginButton = driver.findElement(By.id("body_btnLogin"));
	    	
	    	usernameTextBox.sendKeys(username);
	    	passwordTextBox.sendKeys(password);
	    	loginButton.click();
	    	String actualErrorMessage = driver.findElement(By.id("body_lblStatus")).getText();
	        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	        Thread.sleep(5000);
	        
	    }
	    @AfterClass
	    public void tearDown() throws InterruptedException {
	    	Thread.sleep(2000);
	    	driver.close();
	    
	}

}
