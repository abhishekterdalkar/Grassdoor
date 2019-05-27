package highlineAutomation;

import org.testng.annotations.Test;

import appModule.SignIn_Action;
import pageObjects.DeliveryPartner_Page;
import pageObjects.Master_Table;
import utility.Log;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class deliveryPartner {
	public FirefoxDriver driver;
  @Test(dataProvider = "comp_name_dp", priority = 0)
  public void companyNameValidation(String name, String errorMessage) throws InterruptedException {
	  Log.info("****************************Company name validation execution*********************************");
	  DeliveryPartner_Page.companyName(driver).clear();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.companyName(driver).sendKeys(name);
	  assert driver.getPageSource().contains(errorMessage);
  }

  @DataProvider
  public Object[][] comp_name_dp() {
    return new Object[][] {
      new Object[] { "  ", "The Company Name field is required." },
      new Object[] { "a", "The Company Name may not be less than 2 characters." },
      new Object[] {"zxzxzxzxzxzxzxzxzxzxz", "The Company Name may not be greater than 15 characters."},
      new Object[] {"##", "The Company Name field should have atleast 2 alphabets"}
    };
  }
  
  @Test(dataProvider = "license_dp", priority = 1)
  public void licenseValidation(String license, String errorMessage) throws InterruptedException {
	  Log.info("*********************************License validation test execution*******************************");
	  DeliveryPartner_Page.licenseNumber(driver).clear();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.licenseNumber(driver).sendKeys(license);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
	  
  }
  
  @DataProvider
  public Object[][] license_dp(){
	return new Object[][] {
		new Object[] {"  ", "The License Number field is required."},
		new Object[] {"qwertyuiopa", "The License Number may not be greater than 10 characters."}
	};
	  
  }
  
  @Test(dataProvider = "address_dp", priority = 2)
  public void addressValidation(String address, String errorMessage) throws InterruptedException {
	  Log.info("****************************************Address validation test execution*********************************");
	  DeliveryPartner_Page.address(driver).clear();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.address(driver).sendKeys(address);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
	  
  }
  
  @DataProvider
  public Object[][] address_dp(){
	  return new Object[][] {
		new Object[] {"  ","The Address field is required."}  
	  };
  }
  
  @Test(priority = 3)
  public void existingCompanyName() throws InterruptedException {
	  Log.info("***********************************Existing comapny name test execution************************************************");
	  String existingName = "Meet&Greet";
	  String expectedErrorMessage = "The company name has already been taken.";
	  String licenseNumber = "lics111";
	  String address = "test address";
	  DeliveryPartner_Page.companyName(driver).clear();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.companyName(driver).sendKeys(existingName);
	  Thread.sleep(1000);;
	  DeliveryPartner_Page.licenseNumber(driver).clear();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.licenseNumber(driver).sendKeys(licenseNumber);
	  Thread.sleep(1000);
	  DeliveryPartner_Page.address(driver).clear();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.address(driver).sendKeys(address);
	  Thread.sleep(1000);
	  DeliveryPartner_Page.status(driver).click();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.statusEnable(driver).click();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.addButton(driver).click();
	  Thread.sleep(1000);
	  String actualErrorMessage = DeliveryPartner_Page.duplicateCompanyName(driver).getText();
	  Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
	    
  }
  
  @Test(priority = 4)
  public void existingLicenseNumber() throws InterruptedException {
	  Log.info("***********************Existing license name test execution**********************************");
	  String name = "testdelpa";
	  String existingLicense = "meetand";
	  String address = "test address";
	  String expectedErrorMessage = "The license number has already been taken.";
	  DeliveryPartner_Page.companyName(driver).clear();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.companyName(driver).sendKeys(name);
	  Thread.sleep(1000);
	  DeliveryPartner_Page.licenseNumber(driver).clear();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.licenseNumber(driver).sendKeys(existingLicense);
	  Thread.sleep(1000);
	  DeliveryPartner_Page.address(driver).clear();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.address(driver).sendKeys(address);
	  Thread.sleep(1000);
	  DeliveryPartner_Page.status(driver).click();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.statusDisable(driver).click();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.addButton(driver).click();
	  Thread.sleep(1000);
	  String actualErrorMessage = DeliveryPartner_Page.duplicateLicenseNumber(driver).getText();
	  Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
  }
  
  @Test(priority = 5)
  public void addDeliveryPartnerFlow() throws InterruptedException {
	  Log.info("***********************************Add delivery partner flow test execution**********************************");
	  String name = "testdelivery1";
	  String licenseNumber = "lis-110";
	  String address = "test address";
	  DeliveryPartner_Page.companyName(driver).clear();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.companyName(driver).sendKeys(name);
	  Thread.sleep(1000);
	  DeliveryPartner_Page.licenseNumber(driver).clear();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.licenseNumber(driver).sendKeys(licenseNumber);
	  Thread.sleep(1000);
	  DeliveryPartner_Page.address(driver).clear();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.address(driver).sendKeys(address);
	  Thread.sleep(1000);
	  DeliveryPartner_Page.status(driver).click();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.statusDisable(driver).click();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.addButton(driver).click();
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(name);
  }
  
  @Test(priority = 6)
  public void noFieldsValidation() throws InterruptedException {
	  Log.info("******************************No field validation test execution****************************************");
	  String errorMessageOne = "The Company Name field is required.";
	  String errorMessageTwo = "The License Number field is required.";
	  String errorMessageThree = "The Address field is required.";
	  DeliveryPartner_Page.addDeliveryPartnerButton(driver).click();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.addButton(driver).click();
	  assert driver.getPageSource().contains(errorMessageOne);
	  assert driver.getPageSource().contains(errorMessageTwo);
	  assert driver.getPageSource().contains(errorMessageThree);
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  
	 driver =  SignIn_Action.Execute(driver);
      Log.info("****************************************Delivery Partner link selected********************************************");
      	Master_Table.deliveryPartnereLink(driver).click();
      	Thread.sleep(1000);
      	Log.info("*************************************Add Delivery Partner button clicked******************************");
      	DeliveryPartner_Page.addDeliveryPartnerButton(driver).click();
  }

  @AfterTest
  public void afterTest() {
	 // driver.close();
  }

}
