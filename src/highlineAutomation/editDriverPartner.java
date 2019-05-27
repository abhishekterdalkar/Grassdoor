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

public class editDriverPartner {
	public FirefoxDriver driver;
	
  @Test(priority = 0)
	public void defaultValue() {
	  Log.info("********************Default value test execution***************************");
		String expectedValue = "Meet&Greet";
		String actualValue = DeliveryPartner_Page.companyName(driver).getAttribute("value");
		Assert.assertEquals(actualValue, expectedValue);
	}
  
  @Test(dataProvider = "company_name_dp", priority = 1)
  	public void companyNameValidation(String name, String errorMessage) throws InterruptedException {
	  DeliveryPartner_Page.companyName(driver).clear();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.companyName(driver).sendKeys(name);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }

  @DataProvider
  	public Object[][] company_name_dp(){
	  return new Object[][] {
		  new Object[] { "  ", "The Company Name field is required." },
	      new Object[] { "a", "The Company Name may not be less than 2 characters." },
	      new Object[] {"zxzxzxzxzxzxzxzxzxzxz", "The Company Name may not be greater than 15 characters."},
	      new Object[] {"##", "The Company Name field should have atleast 2 alphabets"}
	  };
  }
  
  @Test(dataProvider = "license_dp", priority = 2)
  	public void licenseValidation(String license, String errorMessage) throws InterruptedException {
	  Log.info("**********************License validation test execution***************");
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
  
  @Test(dataProvider = "address_dp", priority = 3)
  	public void addressValidation(String address, String errorMessage) throws InterruptedException {
	  Log.info("**************Address validation test execution***************");
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
  
  @Test(priority = 4)
  	public void existingCompany() throws InterruptedException {
	  String companyName = "Amzzons";
	  String license = "782547";
	  String address = "test address";
	  String expectedErrorMessage = "The company name has already been taken.";
	  
	  DeliveryPartner_Page.companyName(driver).clear();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.companyName(driver).sendKeys(companyName);
	  Thread.sleep(1000);;
	  DeliveryPartner_Page.licenseNumber(driver).clear();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.licenseNumber(driver).sendKeys(license);
	  Thread.sleep(1000);
	  DeliveryPartner_Page.address(driver).clear();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.address(driver).sendKeys(address);
	  Thread.sleep(1000);
	  DeliveryPartner_Page.updateButton(driver).click();
	  Thread.sleep(1000);
	  String actualErrorMessage = DeliveryPartner_Page.duplicateCompanyName(driver).getText();
	  Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
  }
  
  @Test(priority = 5)
  	public void existingLicense() throws InterruptedException {
	  Log.info("******************Existing license test execution*******************");
	  String companyName = "Amzzonssss";
	  String license = "782547";
	  String address = "test address";
	  String expectedErrorMessage = "The license number has already been taken.";
	  
	  DeliveryPartner_Page.companyName(driver).clear();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.companyName(driver).sendKeys(companyName);
	  Thread.sleep(1000);
	  DeliveryPartner_Page.licenseNumber(driver).clear();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.licenseNumber(driver).sendKeys(license);
	  Thread.sleep(1000);
	  DeliveryPartner_Page.address(driver).clear();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.address(driver).sendKeys(address);
	  Thread.sleep(1000);
	  DeliveryPartner_Page.status(driver).click();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.statusDisable(driver).click();
	  Thread.sleep(1000);
	  DeliveryPartner_Page.updateButton(driver).click();
	  Thread.sleep(1000);
	  String actualErrorMessage = DeliveryPartner_Page.duplicateLicenseNumber(driver).getText();
	  Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
  }
	
  @BeforeTest
  	public void beforeTest() throws InterruptedException {
	 
	  	driver = SignIn_Action.Execute(driver);
      	Log.info("***************Delivery Partner link selected************");
      	Master_Table.deliveryPartnereLink(driver).click();
      	Thread.sleep(1000);
      	Log.info("******************Edit Delivery Partner button clicked****************");
      	DeliveryPartner_Page.editDeliveryPartnerButton(driver).click();
  }
  

  @AfterTest
  public void afterTest() {
	//  driver.close();
  }

}
