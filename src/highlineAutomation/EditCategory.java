package highlineAutomation;

import org.testng.annotations.Test;

import appModule.SignIn_Action;
import pageObjects.Category_Page;
import pageObjects.Master_Table;
import utility.Log;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class EditCategory {
	public FirefoxDriver driver;
	
  @Test(priority = 0)
  public void default_value() {
	  String expected_default_name = "Batteris";
	  String actual_default_name = Category_Page.categoryName(driver).getAttribute("value");
	  Assert.assertEquals(actual_default_name, expected_default_name);
  }
	
  @Test(dataProvider = "edit_category_name_dp", priority = 1)
  public void edit_category_name_validations(String name, String errorMessage) throws InterruptedException {
	  Category_Page.categoryName(driver).clear();
	  Thread.sleep(1000);
	  Category_Page.categoryName(driver).sendKeys(name);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);
  }

  @DataProvider
  public Object[][] edit_category_name_dp() {
    return new Object[][] {
      new Object[] { " ", "The Category Name field is required." }
    };
  }
  
  @Test(priority = 2)
  public void existing_category() throws InterruptedException {
	  String expected_error_message = "The name has already been taken.";
	  String existing_name = "Strips";
	  Category_Page.categoryName(driver).clear();
	  Thread.sleep(1000);
	  Category_Page.categoryName(driver).sendKeys(existing_name);
	  Thread.sleep(1000);
	  Category_Page.status(driver).click();
	  Thread.sleep(1000);
	  Category_Page.statusDisable(driver).click();
	  Thread.sleep(1000);
	  String actual_error_message = Category_Page.duplicateErrorMessages(driver).getText();
	  Assert.assertTrue(actual_error_message.contains(expected_error_message));
	  Category_Page.cancelButton(driver).click();
  }
  
  @Test(priority = 3)
  public void edit_category_flow() throws InterruptedException {
	  String name = "test edit category";
	  Log.info("Edit button clicked................");
    	Category_Page.editCategoryButton(driver).click();
    	Thread.sleep(1000);
	  	 Category_Page.categoryName(driver).clear();
	  	 Thread.sleep(1000);
		 Category_Page.categoryName(driver).sendKeys(name);
		 Thread.sleep(1000);
		 System.out.println("Status bar clicked.........");
		 Category_Page.status(driver).click();
		 Thread.sleep(1000);
		 System.out.println("Enable selected.........");
		 Category_Page.statusEnable(driver).click();
		 Thread.sleep(1000);
		 Category_Page.updateButton(driver).click();
		 Thread.sleep(1000);
		 Assert.assertTrue(driver.getPageSource().contains(name));
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  	driver = SignIn_Action.Execute(driver);
      	Thread.sleep(1000);
      	System.out.println("Category link selected.........");
      	Master_Table.categoryLink(driver).click();
      	Thread.sleep(1000);
      	System.out.println("Edit button clicked..");
      	Category_Page.editCategoryButton(driver).click();
  }

  @AfterTest
  public void afterTest() {
	//  driver.close();
  }

}
