package appModule;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;

public class SignIn_Action {

	public static FirefoxDriver Execute(FirefoxDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:/Highline/geckodriver-v0.23.0-win64/geckodriver.exe");
		  Log.info("****************Opening the browser.**************");
	      	driver = new FirefoxDriver();
	      Log.info("****************Maximazing the browser***************");
	      	driver.manage().window().maximize();
	      Log.info("********Navigating to Highline Dev url************");
	      	driver.get("https://warehouseqa.grassdoor.com/login");
	      //driver.get("http://192.168.50.57:9000/login");
	      Thread.sleep(1000);
	      	driver.findElement(By.id("email--3")).clear();
	      Log.info("********Entering email id**************");
	      	driver.findElement(By.id("email--3")).sendKeys("abhishek.terdalkar@bidchat.com");
	      	driver.findElement(By.id("password--4")).clear();
	      Log.info("**************Entering password*****************");
	      	driver.findElement(By.id("password--4")).sendKeys("123456789");
	      Log.info("******************Login button clicked*********************");
	      	driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/form/div[2]/button")).click();
	      	
	
	      	return driver;
	}

}
