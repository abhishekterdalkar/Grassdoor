package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Units_Page {
	
	public static WebElement element = null;
	
	public static WebElement unitName(FirefoxDriver driver) {
		return element = driver.findElement(By.id("name"));
	}
	
	public static WebElement unitValue(FirefoxDriver driver) {
		return element = driver.findElement(By.id("units--62"));
	}
	
	public static WebElement status(FirefoxDriver driver) {
		return element = driver.findElement(By.id("select-is_active"));
	}
	
	public static WebElement statusDisabe(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"menu-is_active\"]/div[2]/ul/li[1]"));
	}
	
	public static WebElement statusEnable(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"menu-is_active\"]/div[2]/ul/li[2]"));
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
	
	public static WebElement duplicateUnitErrorMessage(FirefoxDriver driver) {
		return element = driver.findElement(By.id("client-snackbar-0"));
	}
	
	public static WebElement editUnitButton(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/main/div[3]/div[2]/div/div[1]/table/tbody/tr[4]/td[5]/button[1]"));
	}
	
	public static WebElement addUnitsButton(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/main/div[3]/div[1]/button"));
	}
	
	public static WebElement updateButton(FirefoxDriver driver) {
		return element = driver.findElement(By.id("Update"));
	}

}
