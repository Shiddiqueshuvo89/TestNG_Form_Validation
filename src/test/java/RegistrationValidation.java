import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationValidation {
	
WebDriver driver;
	
	@BeforeTest
	public void Setup () throws InterruptedException {
		
		String browserName = "firefox";
		
		if (browserName.equals("chrome")) {
			
			driver = new ChromeDriver();
			
		} else if (browserName.equals("firefox")) {
			
			driver = new FirefoxDriver();
			
		} else if(browserName.equals("edge")) {
			
			driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//Open URL	
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		Thread.sleep(2000);
		
	}
	
	@AfterTest
	public void CloseBrowser () {
		
		driver.quit();
		
	}
	
	@Test(priority=1, description="Registration")
	public void VerifyRegistration () throws InterruptedException {
	
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
	Thread.sleep(2000);
	
	//Click Submit Button
	driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
	Thread.sleep(1000);
	
    
    }
	

}
