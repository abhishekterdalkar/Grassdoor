package highlineAutomation;


import org.testng.annotations.Test;

import appModule.SignIn_Action;
import pageObjects.Master_Table;
import pageObjects.Units_Page;
import utility.Log;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Unit {
	public FirefoxDriver driver;
  @Test(dataProvider = "unit_name_dp", priority = 0)
  public void unit_name_validation(String unitname, String errorMessage) throws InterruptedException {
	  Log.info("*****Unit name validation test execution******");
	  Units_Page.unitName(driver).clear();
	  Thread.sleep(1000);
	  Units_Page.unitName(driver).sendKeys(unitname);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }

  @DataProvider
  public Object[][] unit_name_dp() {
    return new Object[][] {
      new Object[] { " ", "The Unit Name field is required." },
      new Object[] { "123", "The Unit Name field accepts only alphabets" },
      new Object[] {"abhu12", "The Unit Name field accepts only alphabets"},
      new Object[] {"!@#", "The Unit Name field accepts only alphabets"},
    };
  }
  
  @Test(dataProvider = "value_dp", priority = 1)
  public void value_validation(CharSequence[] value, String errorMessage) throws InterruptedException {
	  Log.info("*****Unit value test execution****");
	  Units_Page.unitValue(driver).clear();
	  Thread.sleep(1000);
	  Units_Page.unitValue(driver).sendKeys(value);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }
  
  @DataProvider
  public Object[][] value_dp(){
	return new Object[][] {
		new Object[]{" ", "The Value in Grams field is required."},
		new Object[] {"as", "The Value in Grams field accepts only numbers."},
		new Object[] {"as123", "The Value in Grams field accepts only numbers."},
		new Object[] {"@#", "The Value in Grams field accepts only numbers."},
	};
	  
  }
  
  @Test(priority = 2)
  public void status_dropdown() throws InterruptedException {
	  Log.info("*******Status dropdown test execution******");
	  String unitname = "test unit";
	  String value = "2";
	  Units_Page.unitName(driver).clear();
	  Thread.sleep(1000);
	  Units_Page.unitName(driver).sendKeys(unitname);
	  Units_Page.unitValue(driver).clear();
	  Thread.sleep(1000);
	  Units_Page.unitValue(driver).sendKeys(value);
	  Units_Page.status(driver).click();
	  Thread.sleep(1000);
	  Units_Page.statusDisabe(driver).click();
	  Thread.sleep(1000);
	  Assert.assertTrue(Units_Page.addButton(driver).isEnabled());
  }
  @Test
  public void existing_unit() throws InterruptedException {
	  Log.info("******Existing unit test execution******");
	  String existingName = "kg";
	  String value = "2";
	  String expectedErrorMessage = "The name has already been taken.";
	  Units_Page.unitName(driver).clear();
	  Thread.sleep(1000);
	  Units_Page.unitName(driver).sendKeys(existingName);
	  Thread.sleep(1000);
	  
	  Units_Page.unitValue(driver).clear();
	  Thread.sleep(1000);
	  Units_Page.unitValue(driver).sendKeys(value);
	  Thread.sleep(1000);
	  
	  Units_Page.status(driver).click();
	  Thread.sleep(1000);
	  Units_Page.statusEnable(driver).click();
	  Thread.sleep(1000);

	  Units_Page.addButton(driver).click();
	  Thread.sleep(1000);
	  String actualErrorMessage = Units_Page.duplicateUnitErrorMessage(driver).getText();
	  Thread.sleep(1000);
	  Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
  }
  
  @Test(priority = 3)
  public void add_unit_flow() throws InterruptedException {
	  Log.info("*******Add unit flow test exection******");
	  String unit_name = "test unit";
	  String unit_value = "2";
	  Units_Page.unitName(driver).clear();
	  Thread.sleep(1000);
	  Units_Page.unitName(driver).sendKeys(unit_name);
	  Thread.sleep(1000);
	  Units_Page.unitValue(driver).clear();
	  Thread.sleep(1000);
	  Units_Page.unitValue(driver).sendKeys(unit_value);
	  Thread.sleep(1000);
	  Units_Page.status(driver).click();
	  Thread.sleep(1000);
	  Units_Page.statusEnable(driver).click();
	  Thread.sleep(1000);
	  Units_Page.addButton(driver).click();
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(unit_name);
  }

  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	 driver = SignIn_Action.Execute(driver);
      Log.info("****Units link selected********");

  }

  @AfterTest
  public void afterTest() {
	 // driver.close();
  }
 

}
