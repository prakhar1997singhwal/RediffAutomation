package createidTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.util.test.TestUtil;



public class CreateIdTest {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
	      driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.manage().deleteAllCookies();
	      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
	}
	@DataProvider
	public  Iterator<Object[]> getTestData()
		{
		ArrayList<Object[]> data =  TestUtil.getdatafromexcel();
			return data.iterator();
		}
	
	@Test(dataProvider = "getTestData")
	public void createIdTest(String fullname,String rediffid,String password,String alternateid,String mobno)
	{
		driver.findElement(By.xpath("//input[starts-with(@name,'name')]")).sendKeys(fullname);
		driver.findElement(By.xpath("//input[starts-with(@name,'login')]")).sendKeys(rediffid);
		driver.findElement(By.xpath("//input[starts-with(@name,'passwd')]")).sendKeys(password);
		driver.findElement(By.xpath("//input[starts-with(@name,'altemail')]")).sendKeys(alternateid);
		driver.findElement(By.xpath("//input[starts-with(@name,'mobno')]")).sendKeys(mobno);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
