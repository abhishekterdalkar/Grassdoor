package pageObjectGrass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GrassRoles_Page {
	
	public static WebElement element = null;
	
	public static WebElement rolesLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div/div/div/div/ul/div[7]/div/div/a[2]/div/div[2]/span"));
	}
	
	public static WebElement newRoleButton(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[1]/button"));
	}
	
	public static WebElement roleName(FirefoxDriver driver) {
		return element = driver.findElement(By.name("name"));
	}
	
	public static WebElement description(FirefoxDriver driver) {
		return element = driver.findElement(By.name("description"));
	}
	
	public static WebElement ambassadorViewButton(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div/div/main/div[3]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/div/label/svg"));
	}
	
	public static WebElement saveButton(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div/div/main/div[3]/div/div/div[2]/div[3]/button"));
	}
	
	public static WebElement checkBox(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div/div/main/div[3]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]/span/span[1]/input"));
	}
	
	public static WebElement testRoleViewButton(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[2]/div/div/table/tbody/tr[8]/td[3]/button"));
	}
	public static WebElement duplicateErrorMessage(FirefoxDriver driver) {
		return element = driver.findElement(By.id("client-snackbar"));
	}
	
	public static WebElement backButton(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div/div/main/div[3]/div/div/div[1]/div/button"));
	}

}
