package highlineAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class User_list_pagination {
	public FirefoxDriver driver;
  @Test
public boolean userlist_pagination() {
	  int pagination = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/main/div[3]/div[2]/div/div[2]/div/div[2]/div/div")).size();
	  WebElement nextButton = driver.findElement(By.id("//*[@id=\"undefined-next-page-button\"]"));
	  
	  if(pagination > 0) {
		  System.out.println("Pagination exists!!");
		  
		  for(int i=0 ; i<pagination ; i++ ) {
			  if(nextButton.isEnabled()) {
				  nextButton.click();
			  }
		  }
	  }
	  else {
		  System.out.println("Pagination doesn't esists!!");
	  	   }
	  
	  	return false;
	   
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

      driver.findElement(By.id("ss_users_list_id")).click();
      //WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
      //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_ut_add_user_btn")));
      
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
