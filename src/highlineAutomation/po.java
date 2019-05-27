package highlineAutomation;

import org.testng.annotations.Test;

import appModule.SignIn_Action;
import pageObjects.Master_Table;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class po {
	public FirefoxDriver driver;
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
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
	Master_Table.purchaseOrderNavigationLink(driver);
  }

  @AfterTest
  public void afterTest() {
  }

}
