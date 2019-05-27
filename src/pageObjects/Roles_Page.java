package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Roles_Page {
	
	public static WebElement element = null;
	
	public static WebElement roleName(FirefoxDriver driver) {
		return element = driver.findElement(By.id("name"));
	}
	
	public static WebElement createCategoryPermissions(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/form/div/div[2]/fieldset/div/div/div[1]/label/span[1]/span[1]/input"));
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
	public static WebElement addRoleButton(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/main/div[3]/div[1]/button"));
	}
	
	public static WebElement editCustomerRoleButton(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/main/div[3]/div[2]/div/div[1]/table/tbody/tr[7]/td[3]/button"));
	}
	
	public static WebElement updateButton(FirefoxDriver driver) {
		return element = driver.findElement(By.id("Update"));
	}
	
	public static WebElement duplicateErrorMessage(FirefoxDriver driver) {
		return element = driver.findElement(By.id("client-snackbar-0"));
	}

	
}
