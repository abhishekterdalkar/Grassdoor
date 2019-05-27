package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tax_Page {
	
	public static WebElement element = null;
	
	public static WebElement taxName(FirefoxDriver driver) {
		return element = driver.findElement(By.id("name"));
	}
	
	public static WebElement taxCalculationType(FirefoxDriver driver) {
		return element = driver.findElement(By.id("select-tax_calculation_type"));
	}
	
	public static WebElement taxCalculationTypeWeight(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"menu-tax_calculation_type\"]/div[2]/ul/li[1]"));
	}
	
	public static WebElement taxCalculationTypeValue(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"menu-tax_calculation_type\"]/div[2]/ul/li[2]"));
	}
	
	public static WebElement taxType(FirefoxDriver driver) {
		return element = driver.findElement(By.id("select-tax_type"));
	}
	
	public static WebElement taxTypeCultivation(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"menu-tax_type\"]/div[2]/ul/li[1]"));
	}
	
	public static WebElement taxTypeExise(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"menu-tax_type\"]/div[2]/ul/li[2]"));
	} 

	public static WebElement taxRate(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("rate--37"));
	} 
	
	public static WebElement taxUnit(FirefoxDriver driver) {
		return element = driver.findElement(By.id("units-id"));
	} 
	
	public static WebElement taxUnitLb(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"menu-units\"]/div[2]/ul/li[1]"));
	} 
	
	public static WebElement status(FirefoxDriver driver) {
		return element = driver.findElement(By.id("select-is_active"));
	} 
	
	public static WebElement statusDisable(FirefoxDriver driver) {
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
	
	public static WebElement duplicateErrorMessage(FirefoxDriver driver) {
		return element = driver.findElement(By.id("client-snackbar-0"));
	} 
	
	public static WebElement addTaxRateButton(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/main/div[3]/div[1]/button"));
	}
	
}
