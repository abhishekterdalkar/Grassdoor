package highlineAutomation;

import org.testng.annotations.Test;

import appModule.SignIn_Action;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import pageObjects.Characteristic_Page;
import pageObjects.Master_Table;

public class Charcteristics {
	public FirefoxDriver driver;
  @Test(dataProvider = "charcteristics_dp", priority = 0)
  public void characteristics_validations(String name, String errorMessage) throws InterruptedException {
	  Characteristic_Page.characteristicName(driver).clear();
	  Thread.sleep(1000);
	  Characteristic_Page.characteristicName(driver).sendKeys(name);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }
  
  @DataProvider
  public Object[][] charcteristics_dp() {
    return new Object[][] {
      new Object[] { "   ", "The Characteristic Name field is required." }
    };
  }
  
  @Test(priority = 1)
  public void existing_characteristic() throws InterruptedException {
	  String existingName = "Export";
	  String expectedErrorMessage = "The name has already been taken.";
	  Characteristic_Page.characteristicName(driver).clear();
	  Thread.sleep(1000);
	  Characteristic_Page.characteristicName(driver).sendKeys(existingName);
	  Thread.sleep(1000);
	  Characteristic_Page.addButton(driver).click();
	  Thread.sleep(1000);
	  String actualErrorMessage = Characteristic_Page.duplicateEntryError(driver).getText();
	  Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
  }
  
  @Test(priority = 2)
  public void add_characteristic_flow() throws InterruptedException {
	  String name = "test character";
	  Characteristic_Page.characteristicName(driver).clear();
	  Thread.sleep(1000);
	  Characteristic_Page.characteristicName(driver).sendKeys(name);
	  Thread.sleep(1000);
	  Characteristic_Page.status(driver).click();
	  Characteristic_Page.optionDisable(driver).click();
	  Thread.sleep(1000);
	  Characteristic_Page.addButton(driver).click();
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(name);
	  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  System.out.println();
	  driver = SignIn_Action.Execute(driver); 
	  System.out.println("Characteristic link selected.........");
    	Master_Table.characteristicLink(driver).click();
    	Thread.sleep(1000);
      System.out.println("Add Characteristics button clicked..");
    	Characteristic_Page.addCharacteristicButton(driver).click();
  }

  @AfterTest
  public void afterTest() {
	 // driver.close();
  }

}
