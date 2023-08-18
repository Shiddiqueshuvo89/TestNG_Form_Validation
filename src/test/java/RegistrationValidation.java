import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationValidation {
	
	
WebDriver driver;
	
	@BeforeTest
	public void Setup () {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	@AfterTest
	public void CloseBrowser () {
		
		driver.quit();
		
	}
	
	@Test(priority=1, description="Registration")
	public void VerifyRegistration () throws InterruptedException {
		
	driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
	driver.manage().window().maximize();
	
	//Enter FirstName
	driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("Shiddique");
	//Enter LastName
	driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys("Shuvo");
	//Enter Email
	driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("test@gmail.com");
	//Enter Telephone
	driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys("01666666666");
	//Enter Password
	driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("123456");
	//Enter Confirm Password
	driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys("123456");
	Thread.sleep(5000);
	
    
    }
	

}
