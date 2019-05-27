package highlineAutomation;

import org.testng.annotations.Test;

import appModule.SignIn_Action;
import pageObjects.Master_Table;
import pageObjects.Payment_Page;
import utility.Log;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Edit_Payment {
	public FirefoxDriver driver;
	
 @Test(priority = 0)
 public void default_payment_value() {
	 Log.info("*******Default data test execution********");
	 String expected_payment_name = "COD";
	 String expected_payment_days = "45";
	 String actual_payment_name =  Payment_Page.paymentTermName(driver).getAttribute("value");
	 String actual_payment_days =  Payment_Page.paymentTermDays(driver).getAttribute("value");
	 Assert.assertEquals(actual_payment_name, expected_payment_name);
	 Assert.assertEquals(actual_payment_days, expected_payment_days);
 }
	
  @Test(dataProvider = "edit_payment_term_validation_dp", priority = 1)
  public void edit_payment_term_validation(String payment_name, String errorMessage) throws InterruptedException {
	  Log.info("********Payment Term name validation test execution******");
	  Payment_Page.paymentTermName(driver).clear();
	  Thread.sleep(1000);
	  Payment_Page.paymentTermName(driver).sendKeys(payment_name);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }

  @DataProvider
  public Object[][] edit_payment_term_validation_dp() {
    return new Object[][] {
    	new Object[] { "  ", "The Payment Term field is required." }
    };
  }
  
  @Test(dataProvider = "edit_payment_days_dp", priority = 2)
  public void edit_payment_days_validation(String days, String errorMessage) throws InterruptedException {
	  Log.info("******Payment Days test execution*********** ");
	  Payment_Page.paymentTermDays(driver).clear();
	  Thread.sleep(1000);
	  Payment_Page.paymentTermDays(driver).sendKeys(days);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }
  
  @DataProvider
  public Object[][] edit_payment_days_dp(){
	return new Object[][] {
		new Object[] {"  ", "The Payment Days field is required."},
		new Object[] {"abhi", "The Payment Days field accepts only numeric values"},
		new Object[] {"@!@#", "The Payment Days field accepts only numeric values"},
		new Object[] {"12abh", "The Payment Days field accepts only numeric values"},
		new Object[] {"abhi!@#", "The Payment Days field accepts only numeric values"}
	};
	  
  }
  
  @Test(priority = 3)
  public void existing_payment() throws InterruptedException {
	  Log.info("******Existing Payment name test execution**********");
	  String payment_term_name = "COD";
	  String days = "2";
	  String expectedErrorMessage = "The name has already been taken.";
	  Payment_Page.paymentTermName(driver).clear();
	  Thread.sleep(1000);
	  Payment_Page.paymentTermName(driver).sendKeys(payment_term_name);
	  Thread.sleep(1000);
	  Payment_Page.paymentTermDays(driver).clear();
	  Thread.sleep(1000);
	  Payment_Page.paymentTermDays(driver).sendKeys(days);
	  Thread.sleep(1000);
	  Payment_Page.updateButton(driver).click();
	  Thread.sleep(1000);
	  String actualErrorMessage = Payment_Page.duplicatePaymentError(driver).getText();
	  Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
  }
  
  @Test(priority = 4)
  public void edit_flow() throws InterruptedException {
	  Log.info("******Edit Flow test execution**********");
	  String payment_term_name = "COD";
	  String days = "2";
	  Payment_Page.paymentTermName(driver).clear();
	  Thread.sleep(1000);
	  Payment_Page.paymentTermName(driver).sendKeys(payment_term_name);
	  Thread.sleep(1000);
	  Payment_Page.paymentTermDays(driver).clear();
	  Thread.sleep(1000);
	  Payment_Page.paymentTermDays(driver).sendKeys(days);
	  Thread.sleep(1000);
	  Payment_Page.updateButton(driver).click();
	  Thread.sleep(1000);
	  Assert.assertTrue(driver.getPageSource().contains(payment_term_name));
	  Assert.assertTrue(driver.getPageSource().contains(days));
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = SignIn_Action.Execute(driver);
      Log.info("********Payment Terms link selected**********");
      Master_Table.paymentTermsLink(driver).click();
      Thread.sleep(1000);
      Log.info("****Edit Payment Terms button clicked**********");	
      Payment_Page.editPaymentTermsButton(driver).click();
  }

  @AfterTest
  public void afterTest() {
	 // driver.close();
  }

}
