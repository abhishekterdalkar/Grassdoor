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

public class Payment {
  public FirefoxDriver driver;	
  @Test(dataProvider = "payment_terms_dp", priority = 0)
  public void payment_validation(String payment_name, String errorMessage) throws InterruptedException {
	  Log.info("********Payment Term name validation test execution******");
	  Payment_Page.paymentTermName(driver).clear();
	  Thread.sleep(1000);
	  Payment_Page.paymentTermName(driver).sendKeys(payment_name);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage)
;  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "  ", "The Payment Term field is required." }
    };
  }
  
  @Test(dataProvider = "payment_days_dp", priority = 1)
  public void payment_days_validations(String days, String errorMessage) throws InterruptedException {
	  Log.info("*********Payment days validation test execution********");
	  Payment_Page.paymentTermDays(driver).clear();
	  Thread.sleep(1000);
	  Payment_Page.paymentTermDays(driver).sendKeys(days);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }
  
  @DataProvider
  public Object[][] payment_days_dp(){
	return new Object[][] {
		new Object[] {"  ", "The Payment Days field is required."},
		new Object[] {"abhi", "The Payment Days field accepts only numeric values"},
		new Object[] {"@!@#", "The Payment Days field accepts only numeric values"},
		new Object[] {"12abh", "The Payment Days field accepts only numeric values"},
		new Object[] {"abhi!@#", "The Payment Days field accepts only numeric values"}
	};
	  
  }
  
  @Test(priority = 2)
  public void existing_payment_terms() throws InterruptedException {
	  Log.info("****Existing payment term test execution******");
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
	  Payment_Page.addButton(driver).click();
	  Thread.sleep(1000);
	  String actualErrorMessage = Payment_Page.duplicatePaymentError(driver).getText();
	  Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
  }
  
  @Test(priority = 3)
  public void add_payment_flow() throws InterruptedException {
	  Log.info("*****Add payment flow test execution*********");
	  String payment_term_name = "Net 100";
	  String days = "2";
	  Payment_Page.paymentTermName(driver).clear();
	  Thread.sleep(1000);
	  Payment_Page.paymentTermName(driver).sendKeys(payment_term_name);
	  Thread.sleep(1000);
	  Payment_Page.paymentTermDays(driver).clear();
	  Thread.sleep(1000);
	  Payment_Page.paymentTermDays(driver).sendKeys(days);
	  Thread.sleep(1000);
	  Payment_Page.addButton(driver).click();
	  Thread.sleep(1000);
	  
	  //checks in the page list whether the payment term is displayed in the listing
	  Assert.assertTrue(driver.getPageSource().contains(payment_term_name));
	  
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = SignIn_Action.Execute(driver);
      Log.info("*******Payment Terms link selected**********");
      Master_Table.paymentTermsLink(driver).click();
      Thread.sleep(1000);
      Log.info("*******Add Payment Terms button clicked******");
      Payment_Page.addPaymentTermsButton(driver).click();
  }

  @AfterTest
  public void afterTest() {
	  //driver.close();
  }

}
