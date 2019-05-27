package highlineAutomation;

import org.testng.annotations.Test;

import appModule.SignIn_Action;
import pageObjects.Master_Table;
import pageObjects.Roles_Page;
import utility.Log;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Add_Roles_Flow {
	public FirefoxDriver driver;
	
	@Test(priority = 0 ,dataProvider = "rolename_dp")
	public void roleNameValidation(String name, String errorMessage) throws InterruptedException {
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
	
	@Test(priority = 1)
	public void noPermissionSelected() throws InterruptedException {
		String roleName = "test role";
		String errorMessage = "Need to select atleast one.";
		Roles_Page.roleName(driver).clear();
		Thread.sleep(1000);
		Roles_Page.roleName(driver).sendKeys(roleName);
		Thread.sleep(1000);
		Roles_Page.addButton(driver).click();
		Thread.sleep(1000);
		assert driver.getPageSource().contains(errorMessage);
	}
	
	@Test(priority = 2)
	public void noFieldValidation() throws InterruptedException {
		String roleNameErrorMessage = "The Role Name field is required.";
		String permissionErrorMessage = "Need to select atleast one.";
		Roles_Page.roleName(driver).clear();
		Thread.sleep(1000);
		Roles_Page.addButton(driver).click();
		Thread.sleep(1000);
		assert driver.getPageSource().contains(roleNameErrorMessage);
		assert driver.getPageSource().contains(permissionErrorMessage);
	}
	
	@Test(priority = 3)
	public void existingRolesValidation() throws InterruptedException {
		String rolesName = "admin";
		String expectedErrorMessage = "The name has already been taken.";
		Roles_Page.roleName(driver).clear();
		Thread.sleep(1000);
		Roles_Page.roleName(driver).sendKeys(rolesName);
		Thread.sleep(1000);
		Roles_Page.createCategoryPermissions(driver).click();
		Thread.sleep(1000);
		Roles_Page.addButton(driver).click();
		Thread.sleep(1000);
		String actualErrorMessage = Roles_Page.duplicateErrorMessage(driver).getText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
	}
	
	@Test(priority = 4)
	public void addRolesFlow() throws InterruptedException {
		String roleName = "tesT Role";
		Roles_Page.roleName(driver).clear();
		Thread.sleep(1000);
		Roles_Page.roleName(driver).sendKeys(roleName);
		Thread.sleep(1000);
		Roles_Page.createCategoryPermissions(driver).click();
		Thread.sleep(1000);
		Roles_Page.addButton(driver).click();
		Thread.sleep(1000);
		assert driver.getPageSource().contains(roleName);
	}
  

  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = SignIn_Action.Execute(driver);
      Log.info("******Roles link selected*********");
      Master_Table.userRolesLink(driver).click();
      Thread.sleep(1000);
      Log.info("******Add Role button clicked*******");
      Roles_Page.addRoleButton(driver).click();
      Thread.sleep(1000);
  }

  @AfterTest
  public void afterTest() {
	 // driver.close();
  }

}
