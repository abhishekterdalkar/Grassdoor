package highlineAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class EditVehicle {
	public FirefoxDriver driver;
  @Test(priority=0)
  public void defaultValue() {
	  String expectedValue = "licence598";
	  String actualValue = driver.findElement(By.id("license_plate_number")).getAttribute("value");
	  Assert.assertEquals(actualValue, expectedValue);
  }

  @Test(dataProvider = "license_dp", priority = 0)
  public void licenseValidation(String license, String errorMessage) throws InterruptedException {
	  driver.findElement(By.id("license_plate_number")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.id("license_plate_number")).sendKeys(license);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }

  @DataProvider
  public Object[][] license_dp() {
    return new Object[][] {
    	new Object[] {"  ", "The License Number field is required."},
		new Object[] {"qwertyuiopa", "The License Number may not be greater than 10 characters."}
    };
  }
  
  @Test(dataProvider = "car_make_dp", priority = 1)
  	public void carMakeValidation(String make, String errorMessage) throws InterruptedException {
	  driver.findElement(By.id("make")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.id("make")).sendKeys(make);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }
  
  @DataProvider
  	public Object[][] car_make_dp(){
	  return new Object[][] {
		new Object[] {" ", "The Car Make field is required."},
		new Object[] {"a" , "The Car Make may not be less than 2 characters."},
		new Object[] {"as-23-23232323" , "The Car Make may not be greater than 10 characters."},
		new Object[] {"12" , "The Car Make should contain atleast one alphabet"},
	  };
  }
  
  @Test(dataProvider = "car_model_dp", priority = 2)
  	public void carModelValidation(String model, String errorMessage) throws InterruptedException {
	  driver.findElement(By.id("model")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.id("model")).sendKeys(model);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }
  
  @DataProvider
  	public Object[][] car_model_dp(){
	  return new Object[][] {
		  new Object[] {"  ", "The Car Model field is required."},
		  new Object[] {"a" , "The Car Model may not be less than 2 characters."},
			new Object[] {"as-23-23232323" , "The Car Model may not be greater than 15 characters."},
			new Object[] {"12" , "The Car Make should contain atleast one alphabet"},
	  };
  }
  
  @Test(dataProvider = "year_dp", priority = 3)
  	public void yearValidation(String year, String errorMessage) throws InterruptedException {
	  driver.findElement(By.id("year")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.id("year")).sendKeys(year);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);  
  }
  
  @DataProvider
  	public Object[][] year_dp(){
	  return new Object[][] {
		 new Object[] {"  ", "The Year of Car manufacture field is required."},
		 new Object[] {"-2012", "The Year of Car manufacture must be at least 1950"},
		 new Object[] {"2050", "The Year of Car manufacture may not be greater than 2019."},
		 new Object[] {"asas", "The Year of Car manufacture must be an integer."},
		 new Object[] {"2018.2", "The Year of Car manufacture must be an integer."}
	  };
  }
  
  @Test(priority = 4)
  	public void existingLicenseNumber() throws InterruptedException {
	  String licenseNumber = "abhishek";
	  String make = "testmake";
	  String model = "testmodel";
	  String year = "2011";
	  String expectedErrorMessage = "The license plate number has already been taken.";
	  
	  System.out.println("Entity Type field clicked.....");
	  driver.findElement(By.id("select-entity_type")).click();
	  Thread.sleep(1000);
	  System.out.println("Highline selected as Entity Type..");
	  driver.findElement(By.xpath("//*[@id=\"menu-entity_type\"]/div[2]/ul/li[1]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.id("license_plate_number")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.id("license_plate_number")).sendKeys(licenseNumber);
	  Thread.sleep(1000);
	  
	  driver.findElement(By.id("make")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.id("make")).sendKeys(make);
	  Thread.sleep(1000);
	  
	  driver.findElement(By.id("model")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.id("model")).sendKeys(model);
	  Thread.sleep(1000);
	  
	  driver.findElement(By.id("year")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.id("year")).sendKeys(year);
	  Thread.sleep(1000);
	  
	  driver.findElement(By.id("Update")).click();
	  Thread.sleep(1000);
	  
	  String actualErrorMessage = driver.findElement(By.id("snackbar0")).getText();
	  
	  Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/button[2]")).click();
  }
  
  @Test(priority = 5)
  	public void vehicleUpdateFlowWithEntityTypeHighline() throws InterruptedException {
	  String licenseNumber = "guddu";
	  String make = "testmake";
	  String model = "testmodel";
	  String year = "2011";
	  String expectedEntityType = "Highline";
	  String expectedLicense = "guddu";
	  String expectedCarMake = "testmake";
	  String expectedCarModel = "testmodel";
	  String expectedYear = "2011";
	  
	  System.out.println("Entity Type field clicked.....");
	  driver.findElement(By.id("select-entity_type")).click();
	  Thread.sleep(1000);
	  System.out.println("Highline selected as Entity Type..");
	  driver.findElement(By.xpath("//*[@id=\"menu-entity_type\"]/div[2]/ul/li[1]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.id("license_plate_number")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.id("license_plate_number")).sendKeys(licenseNumber);
	  Thread.sleep(1000);
	  
	  driver.findElement(By.id("make")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.id("make")).sendKeys(make);
	  Thread.sleep(1000);
	  
	  driver.findElement(By.id("model")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.id("model")).sendKeys(model);
	  Thread.sleep(1000);
	  
	  driver.findElement(By.id("year")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.id("year")).sendKeys(year);
	  Thread.sleep(1000);
	  
	  driver.findElement(By.id("Update")).click();
	  Thread.sleep(1000);
	  
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/main/div[3]/div[2]/div/div[1]/table/tbody/tr[2]/td[7]/button[1]")).click();
	  
	  String actualEntityType = driver.findElement(By.id("")).getAttribute("value");
	  String actualLicense = driver.findElement(By.id("license_plate_number")).getAttribute("value");
	  String actualMake = driver.findElement(By.id("make")).getAttribute("value");
	  String actualModel = driver.findElement(By.id("model")).getAttribute("value");
	  String actualYear = driver.findElement(By.id("year")).getAttribute("value");
	  
	  Assert.assertEquals(actualEntityType, expectedEntityType);
	  Assert.assertEquals(actualLicense, expectedLicense);
	  Assert.assertEquals(actualMake, expectedCarMake);
	  Assert.assertEquals(actualModel, expectedCarModel);
	  Assert.assertEquals(actualYear, expectedYear);
	  
  
	    }
  
  @Test(priority = 5)
	public void vehicleUpdateFlowWithEntityTypeCustomer() throws InterruptedException {
	  String licenseNumber = "lenc23";
	  String make = "testmake";
	  String model = "testmodel";
	  String year = "2011";
	  String expectedEntityType = "customer";
	 // String expectedEntityName = "3";
	  String expectedLicense = "lenc23";
	  String expectedCarMake = "testmake";
	  String expectedCarModel = "testmodel";
	  String expectedYear = "2011";
	  
	  System.out.print("Edit Vehicle button clicked......");
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/main/div[3]/div[2]/div/div[1]/table/tbody/tr/td[7]/button[1]")).click();
	  
	  System.out.println("Entity Type field clicked.....");
	  driver.findElement(By.id("select-entity_type")).click();
	  Thread.sleep(1000);
	  System.out.println("Customer selected as Entity Type..");
	  driver.findElement(By.xpath("//*[@id=\"menu-entity_type\"]/div[2]/ul/li[2]")).click();
	  Thread.sleep(1000);
	  
	  System.out.println("Entity Name field clicked....");
	  driver.findElement(By.id("select-entity_id")).click();
	  
	  System.out.println("Entity name selected.....");
	  driver.findElement(By.xpath("//*[@id=\"menu-entity_id\"]/div[2]/ul/li[2]")).click();
	  
	  driver.findElement(By.id("license_plate_number")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.id("license_plate_number")).sendKeys(licenseNumber);
	  Thread.sleep(1000);
	  
	  driver.findElement(By.id("make")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.id("make")).sendKeys(make);
	  Thread.sleep(1000);
	  
	  driver.findElement(By.id("model")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.id("model")).sendKeys(model);
	  Thread.sleep(1000);
	  
	  driver.findElement(By.id("year")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.id("year")).sendKeys(year);
	  Thread.sleep(1000);
	  
	  driver.findElement(By.id("Update")).click();
	  Thread.sleep(1000);
	  
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/main/div[3]/div[2]/div/div[1]/table/tbody/tr/td[7]/button[1]")).click();
	  
	  String actualEntityType = driver.findElement(By.id("entity_type-id")).getAttribute("value");
	//  String actualEntityName = driver.findElement(By.id("select-entity_id")).getAttribute("value");
	  String actualLicense = driver.findElement(By.id("license_plate_number")).getAttribute("value");
	  String actualCarMake = driver.findElement(By.id("make")).getAttribute("value");
	  String actualCarModel = driver.findElement(By.id("model")).getAttribute("value");
	  String actualYear = driver.findElement(By.id("year")).getAttribute("value");
	  
	  Assert.assertEquals(actualEntityType, expectedEntityType);
	 // Assert.assertEquals(actualEntityName, expectedEntityName);
	  Assert.assertEquals(actualLicense, expectedLicense);
	  Assert.assertEquals(actualCarMake, expectedCarMake);
	  Assert.assertEquals(actualCarModel, expectedCarModel);
	  Assert.assertEquals(actualYear, expectedYear);
}
  
 
  @Test(priority = 6)
 	public void vehicleFlowWithEntityTypeDeliveryPartner() throws InterruptedException {
 	  String licenseNumber = "leeenc23";
 	  String make = "test make";
 	  String model = "test model";
 	  String year = "2011";
 	  
 	  System.out.print("Add Vehicle button clicked......");
 	  driver.findElement(By.xpath("//*[@id=\\\"app\\\"]/div/div/main/div[3]/div[1]/button")).click();
 	  
 	  System.out.println("Entity Type field clicked.....");
 	  driver.findElement(By.id("select-entity_type")).click();
 	  Thread.sleep(1000);
 	  System.out.println("Delivery Partner selected as Entity Type..");
 	  driver.findElement(By.xpath("//*[@id=\"menu-entity_type\"]/div[2]/ul/li[3]")).click();
 	  Thread.sleep(1000);
 	  
 	  System.out.println("Entity Name selected....");
 	  driver.findElement(By.xpath("//*[@id=\"menu-entity_id\"]/div[2]/ul/li[23]")).click();
 	  
 	  driver.findElement(By.id("license_plate_number--67")).clear();
 	  Thread.sleep(1000);
 	  driver.findElement(By.id("license_plate_number--67")).sendKeys(licenseNumber);
 	  Thread.sleep(1000);
 	  
 	  driver.findElement(By.id("make--68")).clear();
 	  Thread.sleep(1000);
 	  driver.findElement(By.id("make--68")).sendKeys(make);
 	  Thread.sleep(1000);
 	  
 	  driver.findElement(By.id("model--69")).clear();
 	  Thread.sleep(1000);
 	  driver.findElement(By.id("model--69")).sendKeys(model);
 	  Thread.sleep(1000);
 	  
 	  driver.findElement(By.id("year--70")).clear();
 	  Thread.sleep(1000);
 	  driver.findElement(By.id("year--70")).sendKeys(year);
 	  Thread.sleep(1000);
 	  
 	  driver.findElement(By.id("Add")).click();
 	  Thread.sleep(1000);
 	  
 	  assert driver.getPageSource().contains(licenseNumber);
  }
 
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", "C:/Highline/geckodriver-v0.23.0-win64/geckodriver.exe");
	  System.out.println("Opening the browser................");
      	driver = new FirefoxDriver();
      System.out.println("Maximizing browser.........");
      	driver.manage().window().maximize();
      System.out.println("Navigating to Highline Dev url.........");
      	driver.get("https://dev.admin.highlinedistro.com/login");
      //driver.get("http://192.168.50.57:9000/login");
      Thread.sleep(1000);
      	driver.findElement(By.id("standard-required")).clear();
      System.out.println("Entering email id.........");
      	driver.findElement(By.id("standard-required")).sendKeys("vishal@gmail.com");
      	driver.findElement(By.id("standard-password-input")).clear();
      System.out.println("Entering password.........");
      	driver.findElement(By.id("standard-password-input")).sendKeys("vishal1008");
      System.out.println("Login button clicked.........");
      	driver.findElement(By.id("login-button")).click();
      		WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
      		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("system_settings_btn_id")));
      System.out.println("System Settings button clicked.........");
      	driver.findElement(By.id("system_settings_btn_id")).click();
      	Thread.sleep(1000);
      System.out.println("Vehicle link selected.........");
      	driver.findElement(By.xpath("//*[@id=\"ss_vehicle_id\"]/div/span")).click();
      	Thread.sleep(1000);
      	System.out.println("Edit Vehicle button clicked");
      	driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/main/div[3]/div[2]/div/div[1]/table/tbody/tr/td[7]/button[1]")).click();
  }

  @AfterTest
  public void afterTest() {
	  // driver.close();
  }

}
