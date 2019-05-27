package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver_Page {
	
	public static WebElement element = null;
	
	public static WebElement addDriverButton(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/main/div[3]/div[1]/button"));
	}
	
	public static WebElement entityType(FirefoxDriver driver) {
		return element = driver.findElement(By.id("select-entity_type"));
	}
	
	public static WebElement entityTypeHighline(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"menu-entity_type\"]/div[2]/ul/li[1]"));
	}
	
	public static WebElement entityTypeCustomer(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"menu-entity_type\"]/div[2]/ul/li[2]"));
	}
	
	public static WebElement entityTypeDeliveryPartner(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"menu-entity_type\"]/div[2]/ul/li[3]"));
	}
	
	public static WebElement entityName(FirefoxDriver driver) {
		return element = driver.findElement(By.id("select-entity_id"));
	}
	
	public static WebElement entityNameFlipkart(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"menu-entity_id\"]/div[2]/ul/li[27]"));
	}
	
	public static WebElement driverName(FirefoxDriver driver) {
		return element = driver.findElement(By.id("full_name"));
	}
	
	public static WebElement driverLicense(FirefoxDriver driver) {
		return element = driver.findElement(By.id("driver_license_number"));
	}
	
	public static WebElement driverAddress(FirefoxDriver driver) {
		return element = driver.findElement(By.id("address"));
	}
	
	public static WebElement driverState(FirefoxDriver driver) {
		return element = driver.findElement(By.id("state_issued"));
	}
	
	public static WebElement licenseExpiryDate(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/form/div/div[6]/div/div/input"));
	}
	
	public static WebElement dateOfBirth(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/form/div/div[7]/div/div/input"));
	}
	
	public static WebElement status(FirefoxDriver driver) {
		return element = driver.findElement(By.id("select-is_active"));
	}
	
	public static WebElement statusDisable(FirefoxDriver driver) {
		return element = driver.findElement(By.id("//*[@id=\"menu-is_active\"]/div[2]/ul/li[1]"));
	}
	
	public static WebElement statusEnable(FirefoxDriver driver) {
		return element = driver.findElement(By.id("//*[@id=\"menu-is_active\"]/div[2]/ul/li[2]"));
	}
	
	public static WebElement addButton(FirefoxDriver driver) {
		return element = driver.findElement(By.id("Add"));
	}
	
	public static WebElement cancelButton(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/button[2]"));
	}
	
	public static WebElement closeButton(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/h6/div/button"));
	}


}
