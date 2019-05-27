package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Category_Page {

	public static WebElement element = null;
	
	public static WebElement categoryName(FirefoxDriver driver) {
		 element = driver.findElement(By.id("name"));
		 return element;
	}
	
	public static WebElement status(FirefoxDriver driver) {
		element = driver.findElement(By.id("select-is_active"));
		return element;
	}
	
	public static WebElement statusDisable(FirefoxDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"menu-is_active\"]/div[2]/ul/li[1]"));
		return element;
	}
	
	public static WebElement statusEnable(FirefoxDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"menu-is_active\"]/div[2]/ul/li[2]"));
		return element;
	}
	
	public static WebElement addButton(FirefoxDriver driver) {
		element = driver.findElement(By.id("Add"));
		return element;
	}
	
	public static WebElement cancelButton(FirefoxDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/button[2]"));
		return element;
	}
	
	public static WebElement closeButton(FirefoxDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/h6/div/button"));
		return element;
	}
	
	public static WebElement duplicateErrorMessage(FirefoxDriver driver) {
		element = driver.findElement(By.id("snackbar0"));
		return element;
	}
	
	public static WebElement addCategoryButton(FirefoxDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/main/div[3]/div[1]/button"));
		return element;
	}

	public static WebElement duplicateErrorMessages(FirefoxDriver driver) {
		// TODO Auto-generated method stub
		element = driver.findElement(By.id("snackbar0"));
		return element;
	}
	
	public static WebElement editCategoryButton(FirefoxDriver driver) {
		// TODO Auto-generated method stub
		element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/main/div[3]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/button[1]"));
		return element;
	}
	
	public static WebElement updateButton(FirefoxDriver driver) {
		element = driver.findElement(By.id("Update"));
		return element;
	}

	}


