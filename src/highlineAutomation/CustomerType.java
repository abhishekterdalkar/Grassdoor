package highlineAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

//Code has not been tested

public class CustomerType {
	public FirefoxDriver driver;
  @Test(dataProvider = "custTypeDp", priority = 0)
  public void customerTypeValidation(String name, String errorMessage) throws InterruptedException {
	  driver.findElement(By.id("name--57")).clear();
	  driver.findElement(By.id("name--57")).sendKeys(name);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }

  @DataProvider
  public Object[][] custTypeDp() {
    return new Object[][] {
      new Object[] { "  ", "The Customer Type field is required." },
    };
  }
  
  @Test(priority = 1)
  public void existingCustomerType() throws InterruptedException {
	  String name = "test name";
	  String expectedErrorMessage = "The name has already been taken.";
	  driver.findElement(By.id("name--57")).clear();
	  driver.findElement(By.id("name--57")).sendKeys(name);
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/button[1]")).click();
	  Thread.sleep(1000);
	  String actualErrorMessage = driver.findElement(By.id("client-snackbar-0")).getText();
	  Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
	  
  }
  
  @Test(priority = 2)
  public void addCustmomerTypeFlow() throws InterruptedException {
	  String name = "test2";
	  driver.findElement(By.id("name--57")).clear();
	  driver.findElement(By.id("name--57")).sendKeys(name);
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/button[1]")).click();
	  Thread.sleep(1000);
	  Assert.assertTrue(driver.getPageSource().contains(name));
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
      //driver.get("http://192.168.50.57:9000/login");
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
      System.out.println("Customer Type link selected.........");
      	driver.findElement(By.xpath("//*[@id=\"ss_customer_type_id\"]/div/span")).click();
      	Thread.sleep(1000);
      	driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/main/div[3]/div[1]/button")).click();
  }

  @AfterTest
  public void afterTest() {
  }

}
