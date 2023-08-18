
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationValidation {
	
WebDriver driver;

Random randomGenerator = new Random();  
int randomInt = randomGenerator.nextInt(1000);
	
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
		
		
	}
	
	
	@Test(priority=1)
	public void VerifyRegistration () throws InterruptedException {
		
    driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
    Thread.sleep(2000);
    driver.manage().window().maximize();
	Thread.sleep(2000);
	
	//Enter FirstName
	driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("Shiddique");
	//Enter LastName
	driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys("Shuvo");
	//Enter Email
	driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("username"+ randomInt +"@gmail.com");
	//Enter Telephone
	driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys("01666666666");
	//Enter Password
	driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("123456");
	//Enter Confirm Password
	driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys("123456");
	Thread.sleep(2000);
	
	driver.findElement(By.name("agree")).click();
	
	//Click Submit Button
	driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
	Thread.sleep(1000);
	
	String actualMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
	Assert.assertEquals(actualMessage, "Your Account Has Been Created!", "Heading is not displayed");
	
	//Click Logout 	
	driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
	driver.findElement(By.linkText("Logout")).click();
	Thread.sleep(3000);
	
    }
	
	
	@Test(priority=2)
	public void VerifyRegistrationWithoutFirstName () throws InterruptedException {
		
	driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
	Thread.sleep(2000);
	driver.manage().window().maximize();
	Thread.sleep(2000);
	
	//Enter LastName
	driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys("Shuvo");
	//Enter Email
	driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("username"+ randomInt +"@gmail.com");
	Thread.sleep(3000);
	//Enter Telephone
	driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys("01666666666");
	//Enter Password
	driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("123456");
	//Enter Confirm Password
	driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys("123456");
	Thread.sleep(2000);
	
	//Click Submit Button
	driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
	Thread.sleep(5000);
	
	String actualPrivacyWarning = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText();
	Assert.assertTrue(actualPrivacyWarning.contains("Warning: You must agree to the Privacy Policy!"),"Privacy Policy is not Displayed");
	
	String actialFirstNameWarning = driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).getText();
	Assert.assertEquals(actialFirstNameWarning, "First Name must be between 1 and 32 characters!", "First Name is not displayed");
	
	
	}
	
	
	

}
