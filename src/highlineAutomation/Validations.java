package highlineAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Validations {
	public WebDriver driver;
  @Test
  public void validations() {
	  String[] invalidChars = {"#", "!", "$", "@", "%", "^", "&", "1","2","3","4","5","6","7","8","9","0"};
	    String name = "acbcdefghijklmnopqrstuvwxyzab";
	    //validation for contact name
	    for (String invalid : invalidChars) {
	    	//contact name
	        driver.findElement(By.id("contact_name")).clear();
	        driver.findElement(By.id("contact_name")).sendKeys(name + invalid);
	        //driver.findElement(By.id("Button1")).click();
	        String alertMessage = driver.switchTo().alert().getText();
	        System.out.println(invalid);
	        if (alertMessage.equals("First name Should not contain Special Characters")) {
	            System.out.println("Error displayed: First name Should not contain Special Characters");
	            driver.switchTo().alert().dismiss();
	        } else {
	            System.out.println("Accepted");
	        }
	    }
	    driver.findElement(By.id("FIRSTNAME")).sendKeys("acbcdefghijklmnopqrstuvwxyzabcdef");
	    driver.findElement(By.id("Button1")).click();
	    String alertMessage = driver.switchTo().alert().getText();
	    if (alertMessage.equals("First name Should not contain Special Characters")) {
	        System.out.println("Error displayed: First name Should not contain Special Characters");
	        driver.switchTo().alert().dismiss();
	    } else {
	        System.out.println("Accepted");
	    }
  }
  public void f() {
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://192.168.50.23:9000");
		driver.findElement(By.id("standard-required")).sendKeys("vishal@gmail.com");
		driver.findElement(By.id("standard-password-input")).sendKeys("vishal1008");
		driver.findElement(By.id("login-button")).click();
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  Thread.sleep(5000);
	  driver.quit();
  }

}
