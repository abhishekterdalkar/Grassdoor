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

public class VendorBatch {
	public FirefoxDriver driver;
	UserData data = new UserData();
  @Test(dataProvider = "invoice_dp", priority = 0, enabled = true)
  public void invoiceValidation(String invoice, String err) throws InterruptedException {
	  VendorManagement_Page.invoiceVendorBatch(driver).clear();
	  Thread.sleep(1000);
	  VendorManagement_Page.invoiceVendorBatch(driver).sendKeys(invoice);
	  Thread.sleep(1000);
	  boolean invoiceVal = driver.getPageSource().contains(err);
	  
	  Assert.assertTrue(invoiceVal);
	  
	  if(invoiceVal) {
		  Reporter.log("Invoice Validation test passed");
	  }
	  else {
		  Reporter.log("Invoice Validation test failed"); 
	  }
  }


  @DataProvider
  public Object[][] invoice_dp() {
    return new Object[][] {
      new Object[] { " ", "Invoice No. field is required" }
    };
  }
  
  @Test(dataProvider = "cost_dp", priority = 1, enabled = true)
  public void costValidation(String cost, String err) throws InterruptedException {
	  VendorManagement_Page.costVendorBatch(driver).clear();
	  Thread.sleep(1000);
	  VendorManagement_Page.costVendorBatch(driver).sendKeys(cost);
	  Thread.sleep(1000);
	  boolean costVal = driver.getPageSource().contains(err);
	  
	  Assert.assertTrue(costVal);
	  
	  if(costVal) {
		  Reporter.log("Cost validation test passed");
	  }
	  else {
		  Reporter.log("Cost validation test failed");
	  }
	  
  }
  
  @DataProvider
  public Object[][] cost_dp(){
	  return new Object[][] {
		new Object[] {" ", "Cost field is required"},
		new Object[] {"asas", "Invalid Cost"},
		new Object[] {"asa122s", "Invalid Cost"}
	  };
  }
  
  @Test(dataProvider = "qty_dp", priority = 2)
  public void quantityValidation(String qty, String err) throws InterruptedException {
	  VendorManagement_Page.quantity(driver).clear();
	  Thread.sleep(1000);
	  VendorManagement_Page.quantity(driver).sendKeys(qty);
	  Thread.sleep(1000);
	  boolean quantVal = driver.getPageSource().contains(err);
	  
	  Assert.assertTrue(quantVal);
	  
	  if(quantVal) {
		  Reporter.log("Quantity validation test passed");
	  }
	  else {
		  Reporter.log("Quantity validation test failed");
	  }
  }
  
  @DataProvider
  public Object[][] qty_dp(){
	  return new Object[][] {
		  new Object[] {" " , "Quantity field is required."},
		  new Object[] {"as" , "Invalid Quantity"},
		  new Object[] {"a1223s" , "Invalid Quantity"}
	  };
  }
  
  @Test(priority = 3)
  public void addVendorBatchFlow() {
	  VendorManagement_Page.selectVendor(driver).click();
	  VendorManagement_Page.selectVendorAllProductVendor(driver).click();
  }
  
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = SignIn_Action.Execute(driver);
	  WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));
	  Log.info("*****Vendor management link clicked******");
	  VendorManagement_Page.vendorLink(driver).click();
	  Thread.sleep(1000);
	  VendorManagement_Page.addVendorBatch(driver).click();
  }

  @AfterTest
  public void afterTest() {
	  // driver.close();
	  
  }

}
