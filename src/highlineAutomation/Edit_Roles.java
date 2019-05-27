package highlineAutomation;

import org.testng.annotations.Test;

import appModule.SignIn_Action;
import pageObjects.Master_Table;
import pageObjects.Roles_Page;
import utility.Log;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Edit_Roles {
	public FirefoxDriver driver;
	
  @Test(priority = 0)
  //Test to check the value in the Role name field
  public void default_role_value() {
	  Log.info("********Default value test execution********");
	  String expectedValue = "customer";
	  String actualValue = Roles_Page.roleName(driver).getAttribute("value");
	  Assert.assertEquals(actualValue, expectedValue);
  }
	
  @Test(priority = 0 ,dataProvider = "rolename_dp")
	public void roleNameValidation(String name, String errorMessage) throws InterruptedException {
	  	Log.info("********Role name validation test execution*********");
		Roles_Page.roleName(driver).clear();
		Thread.sleep(1000);
		Roles_Page.roleName(driver).sendKeys(name);
		Thread.sleep(1000);
		assert driver.getPageSource().contains(errorMessage);
		
	}
	
	@DataProvider
	public Object[][] rolename_dp(){
		return new Object[][] {
			new Object[] {" ", "The Role Name field is required."}
		};
	}
  
	/*
	@Test(priority = 1)
	public void noPermissionSelected() throws InterruptedException {
		Log.info("*********No Permissions test execution*********");
		String roleName = "test role";
		String errorMessage = "Need to select atleast one.";
		Roles_Page.roleName(driver).clear();
		Thread.sleep(1000);
		Roles_Page.roleName(driver).sendKeys(roleName);
		Thread.sleep(1000);
		Roles_Page.updateButton(driver).click();
		Thread.sleep(1000);
		assert driver.getPageSource().contains(errorMessage);
	}
	*/
	
	@Test(priority = 2)
	public void noFieldValidation() throws InterruptedException {
		Log.info("********No field selected test execution****");
		String roleNameErrorMessage = "The Role Name field is required.";
		String permissionErrorMessage = "Need to select atleast one.";
		Roles_Page.roleName(driver).clear();
		Thread.sleep(1000);
		Roles_Page.updateButton(driver).click();
		Thread.sleep(1000);
		assert driver.getPageSource().contains(roleNameErrorMessage);
		assert driver.getPageSource().contains(permissionErrorMessage);
	}
	
	@Test(priority = 3)
	public void existingRolesValidation() throws InterruptedException {
		Log.info("**********Existing roles test execution***********");
		String rolesName = "admin";
		String expectedErrorMessage = "The name has already been taken.";
		Roles_Page.roleName(driver).clear();
		Thread.sleep(1000);
		Roles_Page.roleName(driver).sendKeys(rolesName);
		Thread.sleep(1000);
		Roles_Page.createCategoryPermissions(driver).click();
		Thread.sleep(1000);
		Roles_Page.updateButton(driver).click();
		Thread.sleep(1000);
		String actualErrorMessage = Roles_Page.duplicateErrorMessage(driver).getText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
	}
	
	@Test(priority = 4)
	public void editRolesFlow() throws InterruptedException {
		Log.info("*******Edit roles flow test execution**********");
		String roleName = "customersssss";
		Roles_Page.editCustomerRoleButton(driver).click();
		Thread.sleep(1000);
		Roles_Page.roleName(driver).clear();
		Thread.sleep(1000);
		Roles_Page.roleName(driver).sendKeys(roleName);
		Thread.sleep(1000);
		Roles_Page.createCategoryPermissions(driver).click();
		Thread.sleep(1000);
		Roles_Page.updateButton(driver).click();
		Thread.sleep(1000);
		assert driver.getPageSource().contains(roleName);
	}
	
	
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver =SignIn_Action.Execute(driver);
      Thread.sleep(1000);
      System.out.println("Roles link selected.........");
      Log.info("*********Roles link selected*********");
      Master_Table.userRolesLink(driver).click();
      Thread.sleep(1000);
      System.out.println("Edit button clicked.............");
      Log.info("********Edit button clicked************");
      Roles_Page.editCustomerRoleButton(driver).click();
  }

  @AfterTest
  public void afterTest() {
	  //driver.close();
  }

}
