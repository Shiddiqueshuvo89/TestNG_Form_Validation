import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FormValidation {
	
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
	
	@Test(priority=1)
	public void VerifyLoginTestValidEmail () throws InterruptedException {
		
	driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("admin@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("123456");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
    
    }
	
	@Test(priority=2)
	public void VerifyLoginTestInValidEmail () throws InterruptedException {
		
	driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("abcd");
	driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("123456");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	Thread.sleep(2000);
	
	String actuwalWarningMessage = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
	System.out.println(actuwalWarningMessage);
	String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
	Assert.assertTrue(actuwalWarningMessage.contains(expectedWarningMessage),"Expected Warning");
	
    }
	
	
}
