package grassdorAutomation;

import org.testng.annotations.Test;

import appModule.SignIn_Action;
import pageObjectGrass.VendorManagement_Page;
import utility.Log;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Vendor {
	public FirefoxDriver driver;
	UserData data = new UserData();
  @Test(dataProvider = "name_dp", enabled = true, priority = 0)
  public void nameValidation(String name, String errorMessage) throws InterruptedException {
	  Log.info("*****Vendor name validation*******");
	  VendorManagement_Page.vendorName(driver).clear();
	  Thread.sleep(1000);
	  VendorManagement_Page.vendorName(driver).sendKeys(name);
	  Thread.sleep(1000);
	  
	  boolean nameVal = driver.getPageSource().contains(errorMessage);
	  
	  Assert.assertTrue(nameVal);
	  
	  if(nameVal) {
		  Reporter.log("Vendor name validation is passed");
	  }
	  else {
		  Reporter.log("Vendor name validation is passed");
	  }
  }

  @DataProvider
  public Object[][] name_dp() {
    return new Object[][] {
      new Object[] { "", "Vendor name field is required." }
    };
  }
  
  @Test(dataProvider = "email_dp", enabled = true, priority = 1)
  public void addressValidation(String address, String errorMessage) throws InterruptedException {
	  Log.info("*****Vendor address validation*******");
	  VendorManagement_Page.vendorAddress(driver).clear();
	  Thread.sleep(1000);
	  VendorManagement_Page.vendorAddress(driver).sendKeys(address);
	  Thread.sleep(1000);
	  
	  boolean addressVal = driver.getPageSource().contains(errorMessage);
	  
	  Assert.assertTrue(addressVal);
	  
	  if(addressVal) {
		  Reporter.log("Address validtion test passed");
	  }
	  else {
		  Reporter.log("Address validtion test failed");
	  }
  }
  
  @DataProvider
  public Object[][] address_dp(){
	  return new Object[][] {
		new Object[]{" ", "Vendor name field is required."} 
	  };
  }
  
  @Test(dataProvider = "mobile_dp", enabled = true, priority = 2)
  public void mobileValidation(String mobile, String errorMessage) throws InterruptedException {
	  Log.info("*****Vendor mobile validation*******");
	  VendorManagement_Page.vendorMobile(driver).click();
	  Thread.sleep(1000);
	  VendorManagement_Page.vendorMobile(driver).sendKeys(mobile);
	  Thread.sleep(1000);
	  
	  boolean mobileVal = driver.getPageSource().contains(errorMessage);
	  
	  Assert.assertTrue(mobileVal);
	  
	  if(mobileVal) {
		  Reporter.log("Mobile validation test passed");
	  }
	  
	  else {
		  Reporter.log("Mobile validation test failed"); 
	  }
  }
  
  @DataProvider
  public Object[][] mobile_dp(){
	  return new Object[][] {
		  new Object[] {" ", "Mobile field is required."},
		  new Object[] {"assasa", "Invalid mobile number."},
		  new Object[] {"asa121", "Invalid mobile number."},
		  new Object[] {"789566", "Invalid mobile number."},
		  new Object[] {"2356325896325", "Invalid mobile number."}
	  };
  }
  
  @Test(enabled = true, priority = 3)
  public void addVendorFlow() throws InterruptedException {
	  Log.info("*****Add vendor flow test execution*******");
	  
	  for(int i=0; i<2;i++) {
	  VendorManagement_Page.vendorName(driver).clear();
	  Thread.sleep(1000);
	  VendorManagement_Page.vendorName(driver).sendKeys(data.vendorName);
	  Thread.sleep(1000);
	  VendorManagement_Page.vendorAddress(driver).clear();
	  Thread.sleep(1000);
	  VendorManagement_Page.vendorAddress(driver).sendKeys(data.vendorAddress);
	  Thread.sleep(1000);
	  VendorManagement_Page.vendorMobile(driver).clear();
	  Thread.sleep(1000);
	  VendorManagement_Page.vendorMobile(driver).sendKeys(data.phoneNumber);
	  Thread.sleep(1000);
	  VendorManagement_Page.vendorStatus(driver).click();
	  Thread.sleep(1000);
	  VendorManagement_Page.vendorStatusEnable(driver).click();
	  Thread.sleep(1000);
	  VendorManagement_Page.vendorSaveButton(driver).click();
	  boolean vendorData = driver.getPageSource().contains(data.vendorName) && driver.getPageSource().contains(data.phoneNumber);
	  
	  Assert.assertTrue(vendorData);
	  
	  if(vendorData) {
		  Reporter.log("Add vendor flow test passed");
	  }
	  else {
		  Reporter.log("Add vendor flow test failed");
	  }
	  }
	  
  }
  
  @Test(enabled = true, priority = 4)
  public void existingVendor() throws InterruptedException {
	  String existingVendorName = "Sublime";
	  String existingPhoneNumber = "3106004938";
	  String expectedErrorMessage = "Vendor Name Already Exist";
	  VendorManagement_Page.vendorName(driver).clear();
	  Thread.sleep(1000);
	  VendorManagement_Page.vendorName(driver).sendKeys(existingVendorName);
	  Thread.sleep(1000);
	  VendorManagement_Page.vendorAddress(driver).clear();
	  Thread.sleep(1000);
	  VendorManagement_Page.vendorAddress(driver).sendKeys(data.vendorAddress);
	  Thread.sleep(1000);
	  VendorManagement_Page.vendorMobile(driver).clear();
	  Thread.sleep(1000);
	  VendorManagement_Page.vendorMobile(driver).sendKeys(existingPhoneNumber);
	  Thread.sleep(1000);
	  VendorManagement_Page.vendorStatus(driver).click();
	  Thread.sleep(1000);
	  VendorManagement_Page.vendorStatusEnable(driver).click();
	  Thread.sleep(1000);
	  VendorManagement_Page.vendorSaveButton(driver).click();
	  Thread.sleep(1000);
	  
	 String actualErrorMessage = VendorManagement_Page.duplicateErrorMessage(driver).getText();
	 
	 boolean existingVen = actualErrorMessage.contains(expectedErrorMessage);
	 
	 Assert.assertTrue(existingVen);
	 
	 if(existingVen) {
		 Reporter.log("Existing user test passed");
	 }
	 else {
		 Reporter.log("Existing user test passed");
	 }
  }
  

  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = SignIn_Action.Execute(driver);
	  WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));
	  Log.info("*****Vendor management link clicked******");
	  VendorManagement_Page.vendorLink(driver).click();
	  Thread.sleep(1000);
	  VendorManagement_Page.addVendorButton(driver).click();
	  Thread.sleep(1000);
  }

  @AfterTest
  public void afterTest() {
	  //driver.close();
  }

}
