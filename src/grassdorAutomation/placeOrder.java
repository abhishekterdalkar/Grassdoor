package grassdorAutomation;

import org.testng.annotations.Test;

import appModule.SignIn_Action;
import utility.Log;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class placeOrder {
	public FirefoxDriver driver;
  @Test(dataProvider = "dp")
  public void telephone(String phone, String errorMessage) {
	  
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = SignIn_Action.Execute(driver);
	  WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/ul/a[2]/div")));
    	Log.info("*****************System Settings button clicked**********************");
    	driver.findElement(By.xpath("/html/body/div/div/div/div/ul/div[6]")).click();
    	Thread.sleep(1000);
  }

  @AfterTest
  public void afterTest() {
  }

}
