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

public class Edit_Licence {
	public FirefoxDriver driver;
	
  @Test(priority = 0)
  public void default_licence_value() {
	  Log.info("*******Default value test execution*******");
	  String expectedValue = "vendor";
	  String actualValue = LicenseType_Page.licenseType(driver).getAttribute("value");
	  Assert.assertEquals(expectedValue, actualValue);
  }
	
  @Test(dataProvider = "edit_licence_dp", priority = 1)
  public void edit_licence_validation(String name, String errorMessage) throws InterruptedException {
	  Log.info("******License Type name validation test executon*******");
	  LicenseType_Page.licenseType(driver).clear();
	  Thread.sleep(1000);
	  LicenseType_Page.licenseType(driver).sendKeys(name);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }

  @DataProvider
  public Object[][] edit_licence_dp() {
    return new Object[][] {
    	new Object[] { "  ", "The Licence Type field is required." },
        new Object[] { "12", "Licence Type name cannot be a numeric value" },
    };
  }
  
  @Test(priority = 2)
  public void existing_licence() throws InterruptedException {
	  Log.info("*********existing license type test execution*********");
	  String editLicenceName = "vendor";
	  String expectedErrorMessage = "The type has already been taken.";
	  LicenseType_Page.licenseType(driver).clear();
	  Thread.sleep(1000);
	  LicenseType_Page.licenseType(driver).sendKeys(editLicenceName);
	  Thread.sleep(1000);
	  LicenseType_Page.licenseTypeRelation(driver).click();
	  Thread.sleep(1000);
	  LicenseType_Page.licenseTypeBoth(driver).click();
	  Thread.sleep(1000);
	  LicenseType_Page.status(driver).click();
	  Thread.sleep(1000);
	  LicenseType_Page.statusEnable(driver).click();
	  Thread.sleep(1000);
	  LicenseType_Page.updateButton(driver).click();
	  Thread.sleep(1000);
	  String actualErrorMessage = LicenseType_Page.duplicateLicenseType(driver).getText();
	  Thread.sleep(1000);
	  Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
	  
  }
  
  @Test(priority = 3)
  //Test foe edit flow(positive test)
  public void edit_flow() throws InterruptedException {
	  String editLicenceName = "test licence";
	  LicenseType_Page.licenseType(driver).clear();
	  Thread.sleep(1000);
	  LicenseType_Page.licenseType(driver).sendKeys(editLicenceName);
	  Thread.sleep(1000);
	  LicenseType_Page.licenseTypeRelation(driver).click();
	  Thread.sleep(1000);
	  LicenseType_Page.licenseTypeBoth(driver).click();
	  Thread.sleep(1000);
	  LicenseType_Page.status(driver).click();
	  Thread.sleep(1000);
	  LicenseType_Page.statusEnable(driver).click();
	  Thread.sleep(1000);
	  LicenseType_Page.updateButton(driver).click();
	  Thread.sleep(1000);
	  Assert.assertTrue(driver.getPageSource().contains(editLicenceName));
	  
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = SignIn_Action.Execute(driver);
      Log.info("***********Licence link selected************");
      Master_Table.licenseTypeLink(driver).click();
      Thread.sleep(1000);
      Log.info("********Edit License type button clicked************");
      LicenseType_Page.editLicenseTypeButton(driver).click();
  }

  @AfterTest
  public void afterTest() {
	  //driver.close();
  }

}
