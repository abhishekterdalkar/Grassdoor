package pageObjectGrass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Customer_Page {
	
	public static WebElement element = null;
	
	public static WebElement customerId(FirefoxDriver driver) {
		//first id
		return element = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/a"));
	}
	
	public static WebElement editButton(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div/div/main/div[3]/div/div/div[2]/div/div/div/div[1]/button"));
	}
	
	public static WebElement custName(FirefoxDriver driver) {
		return element = driver.findElement(By.name("name"));
	}
	
	public static WebElement phoneNumber(FirefoxDriver driver) {
		return element = driver.findElement(By.name("phone_number"));
	}
	
	public static WebElement saveButton(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div/div/main/div[3]/div/div/div[2]/div/div/div/div[1]/div[4]/button[1]"));
	}
	
	public static WebElement cancelButton(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div/div/main/div[3]/div/div/div[2]/div/div/div/div[1]/div[4]/button[2]"));
	}
	
	public static WebElement duplicateErrorMessage(FirefoxDriver driver) {
		return element = driver.findElement(By.id("client-snackbar"));
	}
	

}
