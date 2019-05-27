package highlineAutomation;

import org.testng.annotations.Test;
import appModule.SignIn_Action;
import pageObjects.Master_Table;
import pageObjects.Tax_Page;
import utility.Log;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Tax_Rate {
	public FirefoxDriver driver;
  @Test(dataProvider = "tax_name_validation_dp", priority = 0)
  public void tax_name_validation(String name, String errorMessage) throws InterruptedException {
	  Log.info("*******Tax name validation test execution*******");
	  Tax_Page.taxName(driver).clear();
	  Thread.sleep(1000);
	  Tax_Page.taxName(driver).sendKeys(name);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }

  @DataProvider
  public Object[][] tax_name_validation_dp() {
    return new Object[][] {
      new Object[] { "  ", "The Tax Name field is required." },
    };
  }
  /*
  @Test(dataProvider = "tax_calculation_type_dp", priority = 1)
  public void tax_calculation_type_validation(String errorMessage) throws InterruptedException{
	  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[2]/div/div/div/div")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[3]/div/div/div/div")).click();
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }
  
  @DataProvider
  public Object[][] tax_calculation_type_dp(){
	  return new Object[][] {
		new Object[] {"The Tax Calculation Type field is required."}  
	  };
  }
  
  */
  
  @Test(priority = 1)
  public void Tax_Calculation_Type() throws InterruptedException {
	  Log.info("******Tax calculation type test exection*********");
	  Log.info("*****Test to check Tax calculation type = Weight**********");
	  //Test to check Tax calculation type = Weight
	  Tax_Page.taxCalculationType(driver).click();
	  Thread.sleep(1000);
	  Tax_Page.taxCalculationTypeWeight(driver).click();
	  Thread.sleep(1000);
	  Assert.assertTrue(Tax_Page.taxUnit(driver).isDisplayed());
	  
	  //Test to check Tax calculation type = Value
	 /* 
	  System.out.println("Tax Calculation Type clicked..");
	  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[2]/div/div/div/div")).click();
	  System.out.println("Value Selected..");
	  driver.findElement(By.xpath("//*[@id=\"menu-tax_calculation_type\"]/div[2]/ul/li[2]")).click();
	  Thread.sleep(1000);
	  Assert.assertFalse(driver.getPageSource().contains((driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[5]"))));
  */
  }
  
  @Test(dataProvider = "tax_rate_dp", priority = 2)
  public void tax_rate(String taxName, String errorMessage) throws InterruptedException {
	  Log.info("*********Tax rate validation test execution************");
	  Tax_Page.taxRate(driver).clear();
	  Thread.sleep(1000);
	  Tax_Page.taxRate(driver).sendKeys(taxName);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }
  
  @DataProvider
  public Object[][] tax_rate_dp(){
	  return new Object[][] {
		 new Object[]{"  ", "The Tax Rate field is required."},
		 //new Object[]{"", "The Tax Rate field is required."},
		 // new Object[]{"  ", "The Tax Rate field is required."} 
	  };
  }
  
  @Test(priority = 3)
  public void existing_tax() throws InterruptedException {
	  Log.info("******Existing tax name test exection**********");
	  String tname = "VAT";
	  String taxRate = "23";
	  String expectedErrorMessage = "The name has already been taken.";
	  Tax_Page.taxName(driver).clear();
	  Thread.sleep(1000);
	  Tax_Page.taxName(driver).sendKeys(tname);
	  Thread.sleep(1000);
	  Tax_Page.taxCalculationType(driver).click();
	  Thread.sleep(1000);
	  Tax_Page.taxCalculationTypeWeight(driver).click();
	  Thread.sleep(1000);
	  Tax_Page.taxType(driver).click();
	  Thread.sleep(1000);
	  Tax_Page.taxTypeCultivation(driver).click();
	  Thread.sleep(1000);
	  Tax_Page.taxRate(driver).clear();
	  Thread.sleep(1000);
	  System.out.println("Tax rate entered..");
	  Tax_Page.taxRate(driver).sendKeys(taxRate);
	  Tax_Page.addButton(driver).click();
	  Thread.sleep(1000);
	  String actualErrorMessage = Tax_Page.duplicateErrorMessage(driver).getText();
	  Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
 
  }
  
  
  @Test(priority = 4)
  public void add_tax_flow_calculation_value() throws InterruptedException {
	  Log.info("*****Add tax rate flow with calculation type weight*******");
	  String tname = "test tax";
	  String taxRate = "23";
	  Tax_Page.taxName(driver).clear();
	  Thread.sleep(1000);
	  Tax_Page.taxName(driver).sendKeys(tname);
	  Thread.sleep(1000);
	  Tax_Page.taxCalculationType(driver).click();
	  Thread.sleep(1000);
	  Tax_Page.taxCalculationTypeValue(driver).click();
	  Thread.sleep(1000);
	  Tax_Page.taxType(driver).click();
	  Thread.sleep(1000);
	  Tax_Page.taxTypeCultivation(driver).click();
	  Thread.sleep(1000);
	  Tax_Page.taxRate(driver).clear();
	  Thread.sleep(1000);
	  Tax_Page.taxRate(driver).sendKeys(taxRate);
	  Thread.sleep(1000);
	  Tax_Page.addButton(driver).click();
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(tname); 
  }
  
  @Test(priority = 5)
  public void add_tax_flow_calculation_weight() throws InterruptedException {
	  Log.info("*****Add tax rate flow with calculation type value*******");
	  String tname = "test tax1";
	  String taxRate = "23";
	  Tax_Page.taxName(driver).clear();
	  Thread.sleep(1000);
	  Tax_Page.taxName(driver).sendKeys(tname);
	  Thread.sleep(1000);
	  Tax_Page.taxCalculationType(driver).click();
	  Thread.sleep(1000);
	  Tax_Page.taxCalculationTypeWeight(driver).click();
	  Thread.sleep(1000);
	  Tax_Page.taxType(driver).click();
	  Thread.sleep(1000);
	  Tax_Page.taxTypeExise(driver).click();
	  Thread.sleep(1000);
	  Tax_Page.taxRate(driver).clear();
	  Thread.sleep(1000);
	  Tax_Page.taxRate(driver).sendKeys(taxRate);
	  Thread.sleep(1000);
	  Tax_Page.taxUnit(driver).click();
	  Thread.sleep(1000);
	  Tax_Page.taxUnitLb(driver).click();
	  Thread.sleep(1000);
	  Tax_Page.addButton(driver).click();
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(tname); 
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  	driver = SignIn_Action.Execute(driver);
      	Log.info("****Tax rate link clicked*********");
      	Master_Table.taxRateLink(driver).click();
      	Thread.sleep(1000);
      	Log.info("*******Add Tax rate button clicked*********");
      	Tax_Page.addTaxRateButton(driver).click();
  }

  @AfterTest
  public void afterTest() {
	 // driver.close();
  }

}
