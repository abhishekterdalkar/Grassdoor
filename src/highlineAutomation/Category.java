package highlineAutomation;

import org.testng.annotations.Test;

import appModule.SignIn_Action;
import pageObjects.Category_Page;
import utility.Log;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Category {
	public FirefoxDriver driver;
	
  @Test(dataProvider = "category_name_dp", priority = 0)
  public void categoryNameValidation(String name, String errorMessage) throws InterruptedException {
	  Log.info("********Category name validation test execution*********");
	  Category_Page.categoryName(driver).clear();
	  Thread.sleep(1000);
	  Category_Page.categoryName(driver).sendKeys(name);
	  Thread.sleep(1000);
	  assert driver.getPageSource().contains(errorMessage);  
  }

  @DataProvider
  public Object[][] category_name_dp() {
    return new Object[][] {
      new Object[] { " ", "The Category Name field is required." },
      new Object[] {"1", "The Category Name field should contain atleast 2 alphabets"},
      new Object[] {"a", "The Category Name may not be less than 2 characters"},
      new Object[] {"zxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", "The Category Name may not be greater than 20 characters."}
    };
  }

  @Test(priority = 1)
  public void existingCategory() throws InterruptedException {
	  
	 Log.info("*********Existing category test execution*********");
	 String expectedErrorMessage = "The name has already been taken.";
	 String name = "Flower";
	 
	 Category_Page.categoryName(driver).clear();
	 Thread.sleep(1000);
	 Category_Page.categoryName(driver).sendKeys(name);
	 Thread.sleep(1000);
	 Category_Page.status(driver).click();
	 Thread.sleep(1000);
	 Category_Page.statusDisable(driver).click();
	 Thread.sleep(1000);
	 Category_Page.addButton(driver).click();
	 Thread.sleep(1000);
	 String actualErrorMessage = Category_Page.duplicateErrorMessages(driver).getText();
	 
	 Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
  }
  
  @Test(priority = 2)
  public void categoryAddFlow() throws InterruptedException {
	  	Log.info("******Add category flow test execution*********");
	  	 String name = "SanketCat";
	  	 Category_Page.categoryName(driver).clear();
	  	 Thread.sleep(1000);
		 Category_Page.categoryName(driver).sendKeys(name);
		 Thread.sleep(1000);
		 Category_Page.status(driver).click();
		 Thread.sleep(1000);
		 Category_Page.statusEnable(driver).click();
		 Thread.sleep(1000);
		 Category_Page.addButton(driver).click();
		 Thread.sleep(1000);
		 Assert.assertTrue(driver.getPageSource().contains(name));
  }
  
  @Test(priority=3)
	public void noFieldsFilledValidation() throws InterruptedException {
	    Log.info("******No field validation error message*********");
		String errorMessage1 = "The Category Name field is required.";
		String errorMessage2 = "The Status field is required.";
		Category_Page.addCategoryButton(driver).click();
		Thread.sleep(1000);
		Category_Page.addButton(driver).click();
		Thread.sleep(1000);
		assert driver.getPageSource().contains(errorMessage1);
		assert driver.getPageSource().contains(errorMessage2);
		System.out.println("cancel clicked");
		Category_Page.cancelButton(driver).click();
	}
  
 
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	 driver = SignIn_Action.Execute(driver);
	 Log.info("******Category link clicked********");
	 driver.findElement(By.xpath("//*[@id=\"ss_categories_id\"]/div")).click();
	 Thread.sleep(1000);
	 Log.info("*****Add category button clicked********");
	 Category_Page.addCategoryButton(driver).click();
  }

  @AfterTest
  public void afterTest() {
	  // driver.close();
  }

}
