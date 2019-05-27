package highlineAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Add_User_Flow {
	public FirefoxDriver driver;
  @Test(priority = 0)
  public void add_User_button_enable() throws InterruptedException {
	  driver.findElement(By.id("user_name_id")).clear();
	  driver.findElement(By.id("user_name_id")).sendKeys("Abhishek Terdalkar");
	  	System.out.println("Filling Name field");
	  driver.findElement(By.id("user_phone_id")).clear();
	  driver.findElement(By.id("user_phone_id")).sendKeys("9876543231");
	  	System.out.println("Filling Phone field");
	  driver.findElement(By.id("user_email_id")).clear();
	  driver.findElement(By.id("user_email_id")).sendKeys("abhishek.terdakar@bidchat.com");
	  	System.out.println("Filling Email field");
	  driver.findElement(By.id("user_password_id")).clear();
      driver.findElement(By.id("user_password_id")).sendKeys("password");
	  	System.out.println("Filling Password field");
      driver.findElement(By.xpath("//div[@id='user_role_id']/div/div")).click();
	  	System.out.println("Click Roles field");
 	 	Thread.sleep(1000);
 	  driver.findElement(By.id("option-manager")).click();
	  	System.out.println("Selecting manager role");
 	  driver.findElement(By.xpath("//div[@id='user_role_id']/div/div")).click();
	  	System.out.println("Filling Name field");
	  	System.out.println("Click Roles field");
	  	Thread.sleep(1000);
 	 driver.findElement(By.id("option-admin")).click();
 	 	System.out.println("Selecting admin role");
 	 	Thread.sleep(1000);
 	 	//driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/button[1]")).click();
 	 	
 	 Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/button[1]")).isEnabled());
 	 Thread.sleep(1000);
 	 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/h6/div/button")).click();
  }
  
  //
  
  @Test(priority = 1)
  public void add_User() throws InterruptedException {
	  driver.findElement(By.id("ap_ut_add_user_btn")).click();
	  driver.findElement(By.id("user_name_id")).clear();
	  driver.findElement(By.id("user_name_id")).sendKeys("Sanket Nainani");
	  	System.out.println("Filling Name field");
	  driver.findElement(By.id("user_phone_id")).clear();
	  driver.findElement(By.id("user_phone_id")).sendKeys("9876543231");
	  	System.out.println("Filling Phone field");
	  driver.findElement(By.id("user_email_id")).clear();
	  driver.findElement(By.id("user_email_id")).sendKeys("sanket.nainani@bidchat.com");
	  	System.out.println("Filling Email field");
	  driver.findElement(By.id("user_password_id")).clear();
      driver.findElement(By.id("user_password_id")).sendKeys("password");
	  	System.out.println("Filling Password field");
      driver.findElement(By.xpath("//div[@id='user_role_id']/div/div")).click();
	  	System.out.println("Click Roles field");
 	 	Thread.sleep(1000);
 	  driver.findElement(By.id("option-manager")).click();
	  	System.out.println("Selecting manager role");
 	  driver.findElement(By.xpath("//div[@id='user_role_id']/div/div")).click();
	  	System.out.println("Filling Name field");
	  	System.out.println("Click Roles field");
	  	Thread.sleep(1000);
 	 driver.findElement(By.id("option-admin")).click();
 	 	System.out.println("Selecting admin role");
 	 	Thread.sleep(1000);
 	 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/button[1]")).click();
 	 Thread.sleep(1000);
  }
  
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  	System.setProperty("webdriver.gecko.driver", "C:/Highline/geckodriver-v0.23.0-win64/geckodriver.exe");
	  	System.out.println("Opening the browser.........");
	 driver = new FirefoxDriver();
	  	System.out.println("Maximizing the browser.........");
	 driver.manage().window().maximize();
	  	System.out.println("Navigating to Highline Dev url.........");
	 driver.get("https://dev.admin.highlinedistro.com/login");
	  	Thread.sleep(1000);
	 driver.findElement(By.id("standard-required")).clear();
	  	System.out.println("Filling the email field.........");
	 driver.findElement(By.id("standard-required")).sendKeys("vishal@gmail.com");
	 driver.findElement(By.id("standard-password-input")).clear();
	 	System.out.println("Entering password.........");
	 driver.findElement(By.id("standard-password-input")).sendKeys("vishal1008");
	  	System.out.println("Login button clicked.........");
	 driver.findElement(By.id("login-button")).click();
	  			WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
	  			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("system_settings_btn_id")));
	  	System.out.println("Clicking System Settings.........");
     driver.findElement(By.id("system_settings_btn_id")).click();
      	Thread.sleep(1000);
      	System.out.println("Selecting Users from the list.........");
     driver.findElement(By.xpath("//a[@id='ss_users_list_id']/div[1]")).click();
      	Thread.sleep(1000);
      	System.out.println("Clicking Add User button.........");
     driver.findElement(By.id("ap_ut_add_user_btn")).click();
	  
  }

  @AfterTest
  public void afterTest() {
	  //driver.close();
  }

}
