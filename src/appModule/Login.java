package appModule;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import utility.Log;

public class Login {
	public FirefoxDriver driver;
  @Test
  public void login() throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", "C:/Highline/geckodriver-v0.23.0-win64/geckodriver.exe");
	  Log.info("****************Opening the browser.**************");
      	driver = new FirefoxDriver();
      Log.info("****************Maximazing the browser***************");
      	driver.manage().window().maximize();
      Log.info("********Navigating to Grassdoor url************");
      	driver.get("https://warehouseqa.grassdoor.com/login");
      //driver.get("http://192.168.50.57:9000/login");
      Thread.sleep(1000);
      	//driver.findElement(By.id("email--3")).clear();
      driver.findElement(By.name("email")).clear();
      Log.info("********Entering email id**************");
      driver.findElement(By.name("email")).sendKeys("abhishek.terdalkar@bidchat.com");
      	driver.findElement(By.name("password")).clear();
      Log.info("**************Entering password*****************");
      	driver.findElement(By.name("password")).sendKeys("123456789");
      Log.info("******************Login button clicked*********************");
      	driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/button")).click();
  }
}
