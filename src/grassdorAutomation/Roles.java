package grassdorAutomation;

import org.testng.annotations.Test;

import appModule.SignIn_Action;
import pageObjectGrass.GrassRoles_Page;
import pageObjectGrass.MasterTableGrass_Page;
import utility.Log;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Roles {
	public FirefoxDriver driver;
	UserData data = new UserData();

  @Test(dataProvider = "roleName_dp", priority = 0, enabled = true)
  public void roleNameValidation(String name, String errorMessage) throws InterruptedException {
	  Log.info("********Role validation test execution*********");
	  GrassRoles_Page.roleName(driver).clear();
	  Thread.sleep(1000);
	  GrassRoles_Page.roleName(driver).sendKeys(name);
	  Thread.sleep(1000);
	  //assert driver.getPageSource().contains(errorMessage);
	  
	  boolean roleVal = driver.getPageSource().contains(errorMessage);
	  if(roleVal) {
		  Reporter.log("Role name validation passed");
	  }
	  else {
		  Reporter.log("Role name validation failed");
	  }
	  
	  
  }

  @DataProvider
  public Object[][] roleName_dp() {
    return new Object[][] {
      new Object[] { " ", "Role name field is required." },
    };
  }
  
  
  @Test(dataProvider = "description_dp", priority = 1, enabled = true)
  public void descriptionValidation(String description, String errorMessage) throws InterruptedException {
	  Log.info("*****Description validation test execution***********");
	  GrassRoles_Page.description(driver).clear();
	  Thread.sleep(1000);
	  GrassRoles_Page.description(driver).sendKeys(description);
	  Thread.sleep(1000);
	  //assert driver.getPageSource().contains(errorMessage);
	  boolean descriptionVal = driver.getPageSource().contains(errorMessage);
	  
	  Assert.assertTrue(descriptionVal);
	  
	  if(descriptionVal) {
		  Reporter.log("Role name validation passed");
	  }
	  else {
		  Reporter.log("Role name validation failed");
	  }
  }
  
  @DataProvider
  public Object[][] description_dp(){
	  return new Object[][]{
		 new Object[] {" ", "Role name field is required."} 
	  };
  }
  
  @Test(priority = 2, enabled = true)
  public void existingRoles() throws InterruptedException {
	  
	  Log.info("******Existing Role test execution**********");
	  String roleName = "test role";
	  String expectedErrorMessage = "Role Name Already Exist.";
	  GrassRoles_Page.roleName(driver).clear();
	  Thread.sleep(1000);
	  GrassRoles_Page.roleName(driver).sendKeys(roleName);
	  Thread.sleep(1000);
	  GrassRoles_Page.description(driver).clear();
	  Thread.sleep(1000);
	  GrassRoles_Page.description(driver).sendKeys(data.roleDescription);
	  Thread.sleep(1000);
	  GrassRoles_Page.checkBox(driver).click();
	  Thread.sleep(1000);
	  GrassRoles_Page.saveButton(driver).click();
	  Thread.sleep(1000);
	  String actualErrorMessage = GrassRoles_Page.duplicateErrorMessage(driver).getText();
	  
	  boolean existingRole = actualErrorMessage.contains(expectedErrorMessage);
	  
	  Assert.assertTrue(existingRole);
	  
	  if(existingRole) {
		  Reporter.log("Role name validation passed");
	  }
	  else {
		  Reporter.log("Role name validation failed");
	  }
	  
  }
  
  @Test(priority = 3, enabled = true)
  public void addRoleFlow() throws InterruptedException {
	  Log.info("********Add Role flow test execution***********");
	  
	  //String[] role = {"test role5", "test role 6", "test role 7"};
	  String role = data.roleName;
	  String description = data.roleDescription;
	  
	  
	  for(int i = 0; i<2; i++) {
		  
	  GrassRoles_Page.roleName(driver).clear();
	  Thread.sleep(1000);
	 // GrassRoles_Page.roleName(driver).sendKeys(role[i]);
	  GrassRoles_Page.roleName(driver).sendKeys(role);
	  Thread.sleep(1000);
	  GrassRoles_Page.description(driver).clear();
	  Thread.sleep(1000);
	  GrassRoles_Page.description(driver).sendKeys(description);
	  Thread.sleep(1000); 
	  GrassRoles_Page.checkBox(driver).click();
//	  Thread.sleep(1000);
	  GrassRoles_Page.saveButton(driver).click();
	  Thread.sleep(1000);
	  GrassRoles_Page.newRoleButton(driver).click();
	  //assert driver.getPageSource().contains(role[i]);
      //assert driver.getPageSource().contains(role);
//	  assert driver.getPageSource().contains(description);
      
      boolean roleIsPresent = driver.getPageSource().contains(role) && driver.getPageSource().contains(description);
	  
		  Assert.assertTrue(roleIsPresent);
		  if (roleIsPresent) {
			  Reporter.log("Add role flow test passed");
		  } else {
			  Reporter.log("Add role flow test failed");
		  }
	    
	  
	  }
	  
  }
    
  @Test(priority = 4, enabled = true)
  public void onClickNewRole() throws InterruptedException {
	  Log.info("**********On click new role test**************");
	  if(GrassRoles_Page.backButton(driver).isDisplayed()) {
		  GrassRoles_Page.backButton(driver).click();
		  Thread.sleep(1000);
		  GrassRoles_Page.testRoleViewButton(driver).click();
		  Thread.sleep(1000);
		  GrassRoles_Page.newRoleButton(driver).click();
		  WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.name("name")));
		  GrassRoles_Page.backButton(driver).click();
	  }
	  else {
		  GrassRoles_Page.testRoleViewButton(driver).click();
		  Thread.sleep(1000);
		  GrassRoles_Page.newRoleButton(driver).click();
		  WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.name("name")));
		  GrassRoles_Page.backButton(driver).click();
	  }
	  

  }
  
  @Test(priority = 5, enabled = true)
  public void onClickViewButton() throws InterruptedException {
	  Log.info("******View test functionality**********");
	  String header = "View Role";
	  GrassRoles_Page.newRoleButton(driver).click();
	  Thread.sleep(1000);
	  GrassRoles_Page.testRoleViewButton(driver).click();
	  
	  boolean clickView = driver.getPageSource().contains(header);
	  
	  Assert.assertTrue(clickView);
	  
	  if(clickView) {
		  Reporter.log("Role name validation passed");
	  }
	  
	  else {
		  Reporter.log("Role name validation failed");
	  }
  }

  
  @Test(priority = 6, enabled = true)
  public void viewRoleFlow() throws InterruptedException {
	  Log.info("*********View flow test************");
	  String header = "View Role";
	  String roleName = "test role";
	  GrassRoles_Page.testRoleViewButton(driver).click();
	  Thread.sleep(1000);
	  
	  boolean viewRole = driver.getPageSource().contains(header) && driver.getPageSource().contains(roleName);
	  Assert.assertTrue(viewRole);
	  
	  if(viewRole) {
		  Reporter.log("Role name validation passed");
	  }
	  
	  else {
		  Reporter.log("Role name validation failed");
	  }
	  
//	  assert driver.getPageSource().contains(header);
//	  assert driver.getPageSource().contains(roleName);  	  
  }


  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = SignIn_Action.Execute(driver);
	  WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/ul/div[6]")));
  	  Log.info("*****************Admin link button clicked**********************");
	  Log.info("********Admin link selected*******");
	  MasterTableGrass_Page.adminLink(driver).click();
	  Thread.sleep(1000);
	  Log.info("*****Roles link clicked********");
	  GrassRoles_Page.rolesLink(driver).click();
	  Thread.sleep(1000);
	  GrassRoles_Page.newRoleButton(driver).click();
	  Thread.sleep(1000);
	  
  }

  @AfterTest
  public void afterTest() {
	 // driver.close();
  }

}
