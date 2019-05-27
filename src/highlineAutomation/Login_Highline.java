package highlineAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_Highline {
    public FirefoxDriver driver;
      @BeforeTest
      public void beforeTest() throws InterruptedException {
    	  System.setProperty("webdriver.gecko.driver", "C:/Highline/geckodriver-v0.23.0-win64/geckodriver.exe");
          driver = new FirefoxDriver();
          driver.get("https://dev.admin.highlinedistro.com/login");
          Thread.sleep(3000);
      }
      
 @Test(dataProvider = "login_validations")
 
 public void f(String email, String password, String errorMessage) throws InterruptedException {
	 // String actualErrorMessage = "Email does not exist";
      driver.findElement(By.id("standard-required")).clear();
      driver.findElement(By.id("standard-required")).sendKeys(email);
      driver.findElement(By.id("standard-password-input")).clear();
      driver.findElement(By.id("standard-password-input")).sendKeys(password);
      driver.findElement(By.id("login-button")).click();
      Thread.sleep(1000);
      
      Assert.assertTrue(driver.findElement(By.id("")).isDisplayed()); //ID yet to be updated by developer
      Thread.sleep(1000);
 }
 
 @DataProvider
 public Object[][] login_validations(){
	 return new Object [][] {
			 new Object[]{"vishal@gmail.com", "passw", "Email or password is wrong."},
			 new Object[] {"vishal@gmail.com" , "  " ,"Email or password is wrong." },
			 new Object[] {"abhi@gmail.com" , "vishal1008" ,"Email or password is wrong." },
			 new Object[] {"  " , "vishal1008" ,"Email or password is wrong." },
			 new Object[] {"", "", "Email or password is wrong."}
	 };
 }
 
 @Test
 public void positive_login() throws InterruptedException {
	 driver.findElement(By.id("standard-required")).clear();
	 driver.findElement(By.id("standard-required")).sendKeys("vishal@gmail.com");
	 driver.findElement(By.id("standard-password-input")).clear();
	 driver.findElement(By.id("standard-password-input")).sendKeys("vishal1008");
	 driver.findElement(By.id("login-button")).click();
     Thread.sleep(1000);
 }
	 
 

 @AfterTest
 public void afterTest() {
      driver.close();
 }

}
