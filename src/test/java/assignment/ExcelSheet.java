package assignment;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelSheet {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("http://10.82.180.36/Common/Login.aspx");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
	@Test
	public void test() throws Exception {
	String tittle = driver.getTitle();
	System.out.println("title is" + tittle);
	Thread.sleep(5000);
	FileInputStream fis = new FileInputStream("C:\\Users\\priya.sahare\\eclipse-workspace\\SeleniumAssignment\\Book1.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet("Sheet1");
	String username = sheet.getRow(0).getCell(0).getStringCellValue();
	String password = sheet.getRow(1).getCell(0).getStringCellValue();
	System.out.println(username + password);
	driver.findElement(By.id("body_txtUserID")).sendKeys(username);
	Thread.sleep(5000);
	driver.findElement(By.id("body_txtPassword")).sendKeys(password);
	Thread.sleep(5000);
	driver.findElement(By.id("body_btnLogin")).click();
	workbook.close();
	}
	

	@AfterMethod
	public void afterMethod() {
	driver.close();
	}
}
