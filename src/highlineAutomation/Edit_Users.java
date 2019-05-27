package highlineAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Edit_Users {
	public FirefoxDriver driver;
  @Test(dataProvider = "name_dp", priority = 0)
  public void name_validation(String name, String errorMessage) throws InterruptedException {
	  System.out.println(name);
	  System.out.println(errorMessage);
	  driver.findElement(By.id("user_name_id")).clear();
	  driver.findElement(By.id("user_name_id")).sendKeys(name);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }
  
  @DataProvider
  public Object[][] name_dp() {
    return new Object[][] {
      new Object[] { "  ", "The Name field is required." },
      new Object[] { "123", "The Name field accepts only letter" },
      new Object[] {"abhi123", "The Name field accepts only letter"},
      new Object[] {"@#$$", "The Name field accepts only letter"}
    };
  }
    
    
    @Test(dataProvider = "phone_dp", priority = 1)
    public void phone_validation(String phone, String errorMessage) throws InterruptedException {
  	  System.out.println(phone);
  	  System.out.println(errorMessage);
  	  driver.findElement(By.id("user_phone_id")).clear();
  	  driver.findElement(By.id("user_phone_id")).sendKeys(phone);
  	  Thread.sleep(1000);
  	  assert driver.getPageSource().contains(errorMessage);
    }
    
    @DataProvider
    public Object[][] phone_dp() {
      return new Object[][] {
        new Object[] { "  ", "The Phone field is required." },
        new Object[] { "123asd", "The Phone Number must be a number." },
        new Object[] {"abhi123@#", "The Phone Number must be a number."},
        new Object[] {"@#$$", "The Phone Number must be a number."}
      };
  }
    
    @Test(dataProvider = "email_dp", priority = 2)
    public void email_validation(String email, String errorMessage) throws InterruptedException {
  	  System.out.println(email);
  	  System.out.println(errorMessage);
  	  driver.findElement(By.id("user_email_id")).clear();
  	  driver.findElement(By.id("user_email_id")).sendKeys(email);
  	  Thread.sleep(1000);
  	  assert driver.getPageSource().contains(errorMessage);
    }
    
    @DataProvider
    public Object[][] email_dp() {
      return new Object[][] {
        new Object[] { "  ", "The Email Address field is required." },
        new Object[] { "123asd", "The Email Address format is invalid." },
        new Object[] {"abhi123@#", "The Email Address format is invalid."},
        new Object[] {"@#$$", "The Email Address format is invalid."}
      };
  }
    
    @Test(priority = 3)
    public void roles() throws InterruptedException {
    	driver.findElement(By.xpath("//*[@id='user_role_id']/div/div")).click();
    	Thread.sleep(1000);
    	driver.findElement(By.id("option-admin")).click();
    }
    
    
    
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", "C:/Highline/geckodriver-v0.23.0-win64/geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("https://dev.admin.highlinedistro.com/login");
	  driver.findElement(By.id("standard-required")).clear();
	  driver.findElement(By.id("standard-required")).sendKeys("vishal@gmail.com");
	  driver.findElement(By.id("standard-password-input")).clear();
	  driver.findElement(By.id("standard-password-input")).sendKeys("vishal1008");
	  driver.findElement(By.id("login-button")).click();
	  WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("system_settings_btn_id")));
	  driver.findElement(By.id("system_settings_btn_id")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[@id='ss_users_list_id']/div[1]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/main/div[3]/div[2]/div/div[1]/table/tbody/tr[1]/td[6]/button")).click();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
