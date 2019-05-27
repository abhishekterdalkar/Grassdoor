package pageObjectGrass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GrassUsers_Page {
	
	public static WebElement element = null;
	
	public static WebElement usersLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div/div/div/div/ul/div[7]/div/div/a[1]/div"));
	}

	public static WebElement inviteUserButton(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[1]/button"));
	}
	
	public static WebElement name(FirefoxDriver driver) {
		return element = driver.findElement(By.name("name"));
	}
	
	public static WebElement email(FirefoxDriver driver) {
		return element = driver.findElement(By.name("email"));
	}
	
	public static WebElement selectRole(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div[3]/div/div"));
	}
	
	public static WebElement adminRole(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div[3]/div[2]/ul/li[2]"));
	}
	
	public static WebElement superAdminRole(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div[3]/div[2]/ul/li[1]"));
	}
	
	public static WebElement saveButton(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/button[1]"));
	}
	
	public static WebElement cancelButton(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/button[2]"));
	}
	
	public static WebElement latestUserLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/div/div/a"));
	}
	
	public static WebElement duplicateErrorMessage(FirefoxDriver driver) {
		return element = driver.findElement(By.id("client-snackbar"));
	}
}
