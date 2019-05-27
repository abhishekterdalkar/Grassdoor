package highlineAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class User {
	public FirefoxDriver driver;
		@Test(dataProvider = "name_dp", priority = 0)
		//Test Case for name validation
			public void name_validation(String name, String errorMessage) throws InterruptedException {
			System.out.println("error maessage");
			System.out.println(errorMessage);
				//WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_phone_id")));
				driver.findElement(By.id("user_name_id")).clear();
				//WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_phone_id")));
				driver.findElement(By.id("user_name_id")).sendKeys(name);
				//driver.findElement(By.id("user_name_id")).sendKeys(name);
				Thread.sleep(1000);
			assert driver.getPageSource().contains(errorMessage);   
  }

  @DataProvider
  	public Object[][] name_dp() {
	  return new Object[][] {
		  new Object[] { "  ", "The Name field is required." },
		  new Object[] { "1212", "The Name field accepts only letter"  },
		  new Object[] {"abhi123", "The Name field accepts only letter"},
		  new Object[] {"!@#$", "The Name field accepts only letter"},
    };
  }	
  
  @Test(dataProvider = "phone_dp", priority = 1)
  //Test Case for phone validation
  	public void phone_validation(String phone, String errorMessage) throws InterruptedException {
	  System.out.println("error message");
	  System.out.println(errorMessage);
	  	driver.findElement(By.id("user_phone_id")).clear();
	  	driver.findElement(By.id("user_phone_id")).sendKeys(phone);
	  	Thread.sleep(1000);
     assert driver.getPageSource().contains(errorMessage);   
  }

  @DataProvider
  	public Object[][] phone_dp() {
	  return new Object[][] {
		  new Object[] { "  ", "The Phone field is required" },
		  new Object[] { "asas", "The Phone Number must be a number."  },
		  new Object[] {"abhi123", "The Phone Number must be a number."},
		  new Object[] {"!@#$", "The Phone Number must be a number."}
    };
  }
  
  
  @Test(dataProvider = "email_dp", priority = 2)
  //Test Case for email validation
 	public void email_validation(String email, String errorMessage) throws InterruptedException {
	  System.out.println("error message");
	  System.out.println(errorMessage);
	  	driver.findElement(By.id("user_email_id")).clear();
	  	driver.findElement(By.id("user_email_id")).sendKeys(email);
	  	Thread.sleep(1000);
     assert driver.getPageSource().contains(errorMessage);   
  }

  @DataProvider
  	public Object[][] email_dp() {
	  return new Object[][] {
		  new Object[] { " ", "The Email Address field is required." },
		  new Object[] { "asas", "The Email Address format is invalid."  },
		  new Object[] {"abhi123", "The Email Address format is invalid."},
      	  new Object[] {"abhi@gmail", "The Email Address format is invalid."}
    };
  }

  
  @Test(dataProvider = "password_dp", priority = 3)
  //Test Case for password validation
  	public void password_validation(String password, String errorMessage) throws InterruptedException {
	  System.out.println("error message");
	  System.out.println(errorMessage);
	  	driver.findElement(By.id("user_password_id")).clear();
	  	driver.findElement(By.id("user_password_id")).sendKeys(password);
	  	Thread.sleep(1000);
     assert driver.getPageSource().contains(errorMessage);   
  }

  @DataProvider
  	public Object[][] password_dp() {
	  return new Object[][] {
		  new Object[] { "  ", "The Password field is required." }
    }; 
  }
  
  @Test(priority = 4)
  //Test Case to check whether the roles from the dropdowm gets selected along with the permission
	  public void roles() throws InterruptedException {
	  //Select drpRole = new Select(driver.findElement(By.id("")));
	  //drpRole.selectByVisibleText("admin");
	  //Select drpRole = new Select(driver.findElement(By.xpath("//div[@id='user_role_id']/div/div/div")));
	 // drpRole.selectByIndex(1);
	  System.out.println("Roles field clicked.........");
	  	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[6]/div/div/div/div/div[1]")).click();
	  	Thread.sleep(1000);
	 System.out.println("Manager role selected.........");
	 	driver.findElement(By.id("option-manager")).click();
	 System.out.println("Roles field clicked.........");
	 	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[6]/div/div/div/div/div[1]")).click();
	 	Thread.sleep(1000);
	 System.out.println("Admin role selected.........");
	 	driver.findElement(By.id("option-admin")).click();
	 	Thread.sleep(1000);
	 	//driver.findElement(By.xpath("//*[@id=\"Submit\"]")).click();
	 	WebElement element = driver.findElement(By.id("Submit"));
	 	Actions actions = new Actions(driver);
	 	actions.moveToElement(element).click().build().perform();
	 //driver.findElement(By.xpath("//div[@id='user_role_id']/div/div")).sendKeys("admin");
	 //Select drpRole = new Select(driver.findElement(By.xpath("//div[@id='user_role_id']/div/div")));
	 	Thread.sleep(1000);
	 //drpRole.selectByVisibleText("admin");
	  //driver.findElement(By.xpath("//div[@id='user_role_id']/div/div")).sendKeys("admin");
  }

  @BeforeTest
  	public void beforeTest() throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", "C:/Highline/geckodriver-v0.23.0-win64/geckodriver.exe");
	  System.out.println("Opening the browser................");
      	driver = new FirefoxDriver();
      System.out.println("Maximizing browser.........");
      	driver.manage().window().maximize();
      System.out.println("Navigating to Highline Dev url.........");
      	driver.get("https://dev.admin.highlinedistro.com/login");
      Thread.sleep(3000);
      	driver.findElement(By.id("standard-required")).clear();
      System.out.println("Entering email id.........");
      	driver.findElement(By.id("standard-required")).sendKeys("vishal@gmail.com");
      	driver.findElement(By.id("standard-password-input")).clear();
      System.out.println("Entering password.........");
      	driver.findElement(By.id("standard-password-input")).sendKeys("vishal1008");
      System.out.println("Login button clicked.........");
      	driver.findElement(By.id("login-button")).click();
      		WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
      		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("system_settings_btn_id")));
      System.out.println("System Settings button clicked.........");
      	driver.findElement(By.id("system_settings_btn_id")).click();
      	Thread.sleep(1000);
      System.out.println("Users link selected.........");
      	driver.findElement(By.xpath("//a[@id='ss_users_list_id']/div[1]")).click();
      	Thread.sleep(1000);

      //driver.findElement(By.id("ss_users_list_id")).click();
      //WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
      //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_ut_add_user_btn")));
      System.out.println("Add user button clicked.........");
      	driver.findElement(By.id("ap_ut_add_user_btn")).click();      
  }

  @AfterTest
  	public void afterTest() {
	 driver.close();
  }

}
