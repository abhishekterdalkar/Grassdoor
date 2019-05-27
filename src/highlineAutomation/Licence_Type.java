package highlineAutomation;

import org.testng.annotations.Test;

import appModule.SignIn_Action;
import pageObjects.LicenseType_Page;
import pageObjects.Master_Table;
import utility.Log;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Licence_Type {
	public FirefoxDriver driver;
  @Test(dataProvider = "licence_validation", priority = 0)
  public void licenseTypeValidation(String licence_name, String errorMessage) throws InterruptedException {
	  Log.info("********************License type name validation test execution***********");
	  LicenseType_Page.licenseType(driver).clear();
	  Thread.sleep(1000);
	  LicenseType_Page.licenseType(driver).sendKeys(licence_name);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
	  
  }

  @DataProvider
  public Object[][] licence_validation() {
    return new Object[][] {
      new Object[] { "  ", "The Licence Type field is required." },
      new Object[] { "12", "Licence Type name cannot be a numeric value" },
    };
  }
  
  @Test(priority = 1)
  public void existing_licence_validation() throws InterruptedException {
	  Log.info("*************Existing license type validation test execution**********");
	  String expectedErrorMessage = "The type has already been taken.";
	  String existingLicenceName = "admin";
	  LicenseType_Page.licenseType(driver).clear();
	  Thread.sleep(1000);
	  LicenseType_Page.licenseType(driver).sendKeys(existingLicenceName);
	  Thread.sleep(1000);
	  LicenseType_Page.licenseTypeRelation(driver).click();
	  Thread.sleep(1000);
	  LicenseType_Page.licenseTypeVendor(driver).click();
	  Thread.sleep(1000);
	  LicenseType_Page.status(driver).click();
	  Thread.sleep(1000);
	  LicenseType_Page.statusDisable(driver).click();
	  Thread.sleep(1000);
	  LicenseType_Page.addButton(driver).click();
	  Thread.sleep(1000);
	  String message = LicenseType_Page.duplicateLicenseType(driver).getText();
	  Thread.sleep(1000);
	  Assert.assertTrue(message.contains(expectedErrorMessage));
  }
  
  @Test(priority = 2)
  public void add_licence_flow() throws InterruptedException {
	  Log.info("************Add License Type Flow test execution**********");
	  String licence_name = "test licence 5";
	  LicenseType_Page.licenseType(driver).clear();
	  Thread.sleep(1000);
	  LicenseType_Page.licenseType(driver).sendKeys(licence_name);
	  Thread.sleep(1000);
	  LicenseType_Page.licenseTypeRelation(driver).click();
	  Thread.sleep(1000);
	  LicenseType_Page.licenseTypeCustomer(driver).click();
	  Thread.sleep(1000);
	  LicenseType_Page.status(driver).click();
	  Thread.sleep(1000);
	  LicenseType_Page.statusDisable(driver).click();
	  Thread.sleep(1000);
	  LicenseType_Page.addButton(driver).click();
	  Assert.assertTrue(driver.getPageSource().contains(licence_name));
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = SignIn_Action.Execute(driver);
      Log.info("**********Licence link selected************");
      Master_Table.licenseTypeLink(driver).click();
      Thread.sleep(1000);
      System.out.println("Add Licence Type button clicked.........");
      LicenseType_Page.addLicenseTypeButton(driver).click();
  }

  @AfterTest
  public void afterTest() {
	  //driver.close();
  }

}
