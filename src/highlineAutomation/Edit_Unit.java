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

public class Edit_Unit {
	public FirefoxDriver driver;
	
  @Test(priority = 0)
  public void default_edit_units() {
	  Log.info("******Default value test execution********");
	  String expected_unit_name = "1.3g Jointt";
	  String expected_value = "2.0000";
	  String actual_unit_name = Units_Page.unitName(driver).getAttribute("value");
	  System.out.println(actual_unit_name);
	  String actual_value = Units_Page.unitValue(driver).getAttribute("value");
	  System.out.println(actual_value);
	  Assert.assertEquals(actual_unit_name, expected_unit_name);
	  Assert.assertEquals(actual_value, expected_value);
  }
	 
  @Test(dataProvider = "edit_unit_dp", priority = 1)
  public void unit_name_validation(String name, String errorMessage) throws InterruptedException {
	  Log.info("*****Unit name validation test execution******");
	  Units_Page.unitName(driver).clear();
	  Thread.sleep(1000);
	  Units_Page.unitName(driver).sendKeys(name);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }

  @DataProvider
  public Object[][] edit_unit_dp() {
    return new Object[][] {
    	new Object[] { " ", "The Unit Name field is required." },
        new Object[] { "123", "The Unit Name field accepts only alphabets" },
        new Object[] {"abhu12", "The Unit Name field accepts only alphabets"},
        new Object[] {"!@#", "The Unit Name field accepts only alphabets"}
    };
  }
  
  @Test(dataProvider = "edit_value_dp", priority = 2)
  public void unit_value_validation(String unit_value, String errorMessage) throws InterruptedException {
	  Log.info("*****Unit value test execution****");
	  Units_Page.unitValue(driver).clear();
	  Thread.sleep(1000);
	  Units_Page.unitValue(driver).sendKeys(unit_value);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }
  @DataProvider
  public Object [][] edit_value_dp(){
	return new Object[][] {
		new Object[]{" ", "The Value in Grams field is required."},
		new Object[] {"as", "The Value in Grams field accepts only numbers."},
		new Object[] {"as123", "The Value in Grams field accepts only numbers."},
		new Object[] {"@#", "The Value in Grams field accepts only numbers."}
	};
	  
  }
  
  @Test(priority = 3)
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
 
  @Test(priority = 4)
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

	  Units_Page.updateButton(driver).click();
	  Thread.sleep(1000);
	  String actualErrorMessage = Units_Page.duplicateUnitErrorMessage(driver).getText();
	  Thread.sleep(1000);
	  Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
  }
  
  @Test(priority = 5)
  public void edit_unit_flow() throws InterruptedException {
	  Log.info("*******Edit unit flow test exection******");
	  String unit_name = "testunit12";
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
	  Units_Page.updateButton(driver).click();
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(unit_name);
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	 driver = SignIn_Action.Execute(driver);
      System.out.println("Units link selected.........");
      Master_Table.unitsLink(driver).click();
      Thread.sleep(1000);
      System.out.println("Edit Units button clicked.........");
      Units_Page.editUnitButton(driver).click();
  }

  @AfterTest
  public void afterTest() {
	 // driver.close();
  }

}
