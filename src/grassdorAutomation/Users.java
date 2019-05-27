package grassdorAutomation;

import org.testng.annotations.Test;

import appModule.SignIn_Action;
import pageObjectGrass.GrassRoles_Page;
import pageObjectGrass.GrassUsers_Page;
import pageObjectGrass.MasterTableGrass_Page;
import utility.Log;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Users {
	public FirefoxDriver driver;
	UserData data = new UserData();
  @Test(dataProvider = "name_dp", priority = 0, enabled = false)
  public void nameValidation(String name, String errorMessage) throws InterruptedException {
	  Log.info("*****Name validation test execution******");
	  GrassUsers_Page.name(driver).clear();
	  Thread.sleep(1000);
	  GrassUsers_Page.name(driver).sendKeys(name);
	  Thread.sleep(1000);
	  
	  boolean nameVal = driver.getPageSource().contains(errorMessage);
	  Assert.assertTrue(nameVal);
	  
	 if(nameVal) {
		 Reporter.log("Name Validation test passed");
	 }
	 else {
		 Reporter.log("Name Validation test failed");
	 }
  }

  @DataProvider
  public Object[][] name_dp() {
    return new Object[][] {
      new Object[] { " ", "Name field is required" },
    };
  }
  
  @Test(dataProvider = "email_dp", priority = 1, enabled = false)
  public void emailValidation(String email, String errorMessage) throws InterruptedException {
	  Log.info("******Email validation test execution*****");
	  GrassUsers_Page.email(driver).clear();
	  Thread.sleep(1000);
	  GrassUsers_Page.email(driver).sendKeys(email);
	  Thread.sleep(1000);
	  
	  boolean emailVal = driver.getPageSource().contains(errorMessage);
	  Assert.assertTrue(emailVal);
	  
	  if(emailVal) {
		  Reporter.log("Email validation test passed");
	  }
	  else {
		  Reporter.log("Email validation test failed");
	  }
  }
  
  @DataProvider
  public Object[][] email_dp(){
	  return new Object[][] {
		new Object[] {" ", "Email field is required"},
		new Object[] {"abhis", "Email is invalid."},
		new Object[] {"abhis.com", "Email is invalid."},
		new Object[] {"abhis@com", "Email is invalid."},
	  };
  }
  
  @Test(priority = 2, enabled = false)
  public void existingUser() throws InterruptedException {
	  Log.info("********Existing user test execution********");
	  String existingName = "Saurabh Pilankar";
	  String[] existingEmail = {"saurabh.pilankar@bidchat.com", "abhishek.terdalkar@bidchat.com", "rahul.harmalkar@bidchat.com"};
	  String expectedErrorMessage = "Email already in use.";
	  
	  for(int i = 0; i<=existingEmail.length-1;i++)
	  {	  
	  GrassUsers_Page.name(driver).clear();
	  Thread.sleep(1000);
	  GrassUsers_Page.name(driver).sendKeys(existingName);
	  Thread.sleep(1000);
	  GrassUsers_Page.email(driver).clear();
	  Thread.sleep(1000);
	  GrassUsers_Page.email(driver).sendKeys(existingEmail);
	  Thread.sleep(1000);
	  GrassUsers_Page.selectRole(driver).click();
	  Thread.sleep(1000);
	  GrassUsers_Page.adminRole(driver).click();
	  Thread.sleep(1000);
	  GrassUsers_Page.saveButton(driver).click();
	  Thread.sleep(1000);
	  String actualErrorMessage = GrassUsers_Page.duplicateErrorMessage(driver).getText();
	  
	  boolean existingUser = actualErrorMessage.contains(expectedErrorMessage);
	  
	  Assert.assertTrue(existingUser);
	  
	  if(existingUser) {
		  Reporter.log("Existing user test passed");
	  }
	  else {
		  Reporter.log("Existing user test failed");
	  }
	  
  }
  }
  
  @Test(priority = 3, enabled = false)
  public void inviteUserFlow() throws InterruptedException {
	  Log.info("******Invite user flow test execution********");
	 // String[] name = {"chetan", "smita", "medhansh"};
	  //String [] email = {"chetan@gmail.com", "smita@gmail.com", "medhansh@gmail.com"};
	  //String name = "chetan";
	  
	  
	  for(int i = 0; i <= 2; i++) {
		  GrassUsers_Page.name(driver).clear();
		  Thread.sleep(1000);
		  GrassUsers_Page.name(driver).sendKeys(data.firstName);
		  Thread.sleep(1000);
		  GrassUsers_Page.email(driver).clear();
		  Thread.sleep(1000);
		  GrassUsers_Page.email(driver).sendKeys(data.email);
		  Thread.sleep(1000);
		  GrassUsers_Page.selectRole(driver).click();
		  Thread.sleep(1000);
		  GrassUsers_Page.adminRole(driver).click();
		  Thread.sleep(1000);
		  GrassUsers_Page.saveButton(driver).click();
		  Thread.sleep(1000);
		  
		  boolean userInfo = driver.getPageSource().contains(data.email);
		  
		  Assert.assertTrue(userInfo);
		  
		  if(userInfo) {
			  Reporter.log("User flow test passed");
		  }
		  else {
			  Reporter.log("User flow test failed");
		  }
	  }
	  
  }
  
  @Test(priority = 4, enabled = true)
  public void userView() throws InterruptedException {
	  Log.info("*****User view test execution******");
//	  String name = "Ramesh";
//	  String email = "ramesh@gmail.com";
	  
	  GrassUsers_Page.name(driver).clear();
	  Thread.sleep(1000);
	  GrassUsers_Page.name(driver).sendKeys(data.firstName);
	  Thread.sleep(1000);
	  GrassUsers_Page.email(driver).clear();
	  Thread.sleep(1000);
	  GrassUsers_Page.email(driver).sendKeys(data.email);
	  Thread.sleep(1000);
	  GrassUsers_Page.selectRole(driver).click();
	  Thread.sleep(1000);
	  GrassUsers_Page.adminRole(driver).click();
	  Thread.sleep(1000);
	  GrassUsers_Page.saveButton(driver).click();
	  WebDriverWait wait = new WebDriverWait(driver,10);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div[2]/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/div/div/a")));

	  GrassUsers_Page.latestUserLink(driver).click();
	  
	  if(driver.getPageSource().contains(data.email) && driver.getPageSource().contains(data.email)) {
		  Assert.assertTrue(true);
	  }
	  else {
		  Assert.assertTrue(false);
	  }
	  
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
	  Log.info("*****Users link clicked********");
	  GrassUsers_Page.usersLink(driver).click();
	  Thread.sleep(1000);
	  GrassUsers_Page.inviteUserButton(driver).click();
	  Thread.sleep(1000);
	  
  }

  @AfterTest
  public void afterTest() {
	 // driver.close();
  }
}
