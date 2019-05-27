package highlineAutomation;

import org.testng.annotations.Test;

import appModule.SignIn_Action;
import pageObjects.Driver_Page;
import pageObjects.Master_Table;
import utility.Log;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Drivers {
	public FirefoxDriver driver;
  @Test(dataProvider = "driverName_dp", priority = 0)
  public void driverNameValidation(String name, String errorMessage) throws InterruptedException {
	  Driver_Page.driverName(driver).clear();
	  Thread.sleep(1000);
	  Driver_Page.driverName(driver).sendKeys(name);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }

  @DataProvider
  public Object[][] driverName_dp() {
    return new Object[][] {
      new Object[] { "  ", "The Driver Name field is required." },
      new Object[] {"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", "The Driver name may not be greater than 15 characters."}
    };
  }
  
  @Test(dataProvider = "license_dp", priority = 1)
  public void licenseNameValidation(String license, String errorMessage) throws InterruptedException {
	  Driver_Page.driverLicense(driver).clear();
	  Thread.sleep(1000);
	  Driver_Page.driverLicense(driver).sendKeys(license);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }
  
  @DataProvider
  public Object[][] license_dp(){
	  return new Object[][] {
		new Object[]{"  ", "The Driver License Number field is required."},
		new Object[] {"as-23-23232323", "The Car Make may not be greater than 10 characters."}
	  };
  }
  
  @Test(dataProvider = "address_dp", priority = 2)
  public void addressValidation(String address, String errorMessage) throws InterruptedException {
	  Driver_Page.driverAddress(driver).clear();
	  Thread.sleep(1000);
	  Driver_Page.driverAddress(driver).sendKeys(address);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
	  }
  
  @DataProvider
  public Object[][] address_dp(){
	  return new Object[][] {
		  new Object[] {"  ", "The Driver Address field is required."}
	  };
  }
  
  @Test(dataProvider = "state_dp", priority = 3)
  public void stateValidation(String state, String errorMessage) throws InterruptedException {
	  Driver_Page.driverState(driver).clear();
	  Thread.sleep(1000);
	  Driver_Page.driverState(driver).sendKeys(state);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }
  
  @DataProvider
  public Object[][] state_dp(){
	  return new Object[][] {
		  new Object[] {" ","The License Issue State field is required."},
		  new Object[] {"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq","The Driver name may not be greater than 10 characters."}
	  };
  }
  
  @Test(dataProvider = "licenseExpiryDate_dp", priority = 4)
  public void licenseExpiryDataValidation(String expiryDate, String errorMessage) {
	  
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = SignIn_Action.Execute(driver);
	  Log.info("*******Driver link clicked********");
	  Master_Table.driverLink(driver).click();
	  Thread.sleep(1000);
	  Log.info("********Add Driver button clicked***********");
	  Driver_Page.addDriverButton(driver).click();
  }

  @AfterTest
  public void afterTest() {
	  // driver.close();
  }
  

}
