package grassdorAutomation;

import org.testng.annotations.Test;

import appModule.SignIn_Action;
import pageObjectGrass.Customer_Page;
import pageObjectGrass.MasterTableGrass_Page;
import utility.Log;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class CustomersEdit {
	public FirefoxDriver driver;
	UserData data = new UserData();
  @Test(dataProvider = "name_dp", priority = 0, enabled = true)
  public void nameValidation(String name, String err) throws InterruptedException {
	  Customer_Page.custName(driver).clear();
	  Thread.sleep(1000);
	  Customer_Page.custName(driver).sendKeys(name);
	  Thread.sleep(1000);
	  boolean custVal = driver.getPageSource().contains(err);
	  Assert.assertTrue(custVal);
	  if(custVal) {
		  Reporter.log("Customer Name validation passed");
	  }
	  else {
		  Reporter.log("Customer Name validation failed");
	  }
  }

  @DataProvider
  public Object[][] name_dp() {
    return new Object[][] {
      new Object[] { " ", "Customer Name field is required." }
    };
  }
  
  @Test(priority = 1, enabled = true, dataProvider = "phone_dp")
  public void phoneValidation(String phone, String err) throws InterruptedException {
	  Customer_Page.phoneNumber(driver).clear();
	  Thread.sleep(1000);
	  Customer_Page.phoneNumber(driver).sendKeys(phone);
	  Thread.sleep(1000);
	  boolean phoneVal = driver.getPageSource().contains(err);
	  Assert.assertTrue(phoneVal);
	  if(phoneVal) {
		  Reporter.log("Phone validation test passed");
	  }
	  else {
		  Reporter.log("Phone validation test failed");
	  }
  }
  
  @DataProvider
  public Object[][] phone_dp(){
	  return new Object[][] {
		new Object[] {" ", "Phone Number field is required."}  
	  };
  }
  
  @Test(priority = 2, enabled = true)
  public void editCustomerFlow() throws InterruptedException {
	  
	  Customer_Page.custName(driver).clear();
	  Thread.sleep(1000);
	  Customer_Page.custName(driver).sendKeys(data.customerName);
	  Thread.sleep(1000);
	  Customer_Page.phoneNumber(driver).clear();
	  Thread.sleep(1000);
	  Customer_Page.phoneNumber(driver).sendKeys(data.phoneNumber);
	  Thread.sleep(1000);
	  Customer_Page.saveButton(driver).click();
	  Thread.sleep(1000);
	  boolean editFlow = driver.getPageSource().contains(data.customerName) && driver.getPageSource().contains(data.phoneNumber);
	  Assert.assertTrue(editFlow);
	  if(editFlow) {
		  Reporter.log("Edit flow test passed");
	  }
	  else {
		  Reporter.log("Edit flow test failed");
	  }
  }
  
  @Test(priority = 3, enabled = true)
  public void existingCustomer() throws InterruptedException {
	  
	  String[] existingCustPhone = {"9824842332", "9845454515", "7577577575"};
	  String custName = "Abhishek Ter";
	  
	  for(int i = 0; i<=existingCustPhone.length-1; i++) {
		  Customer_Page.custName(driver).clear();
		  Thread.sleep(1000);
		  Customer_Page.custName(driver).sendKeys(custName);
		  Thread.sleep(1000);
		  Customer_Page.phoneNumber(driver).clear();
		  Thread.sleep(1000);
		  Customer_Page.phoneNumber(driver).sendKeys(existingCustPhone[i]);
		  Customer_Page.saveButton(driver).click();
		  Thread.sleep(1000);
	  }
  }
  
  
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = SignIn_Action.Execute(driver);
	  WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/ul/a[4]/div")));
  	  Log.info("*****************Customer link button clicked**********************");
	  MasterTableGrass_Page.customerLink(driver).click();
	  Thread.sleep(1000);
	  Customer_Page.customerId(driver).click();
	  Thread.sleep(1000);
	  Customer_Page.editButton(driver).click();
	  Thread.sleep(1000);
  }

  @AfterTest
  public void afterTest() {
	  //driver.close();
  }

}
