/**
 * 
 */
/**
 * @author Admin
 *
 */
package pageObjects;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Characteristic_Page {

private static WebElement element = null;

public static WebElement characteristicName(FirefoxDriver driver){
	
	element = driver.findElement(By.id("name"));

	return element;

}

public static WebElement status(FirefoxDriver driver){

element = driver.findElement(By.id("select-is_active"));

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

public static WebElement duplicateEntryError(FirefoxDriver driver) {
	
	element = driver.findElement(By.id("client-snackbar-0"));
	
	return element;
}

public static WebElement optionDisable(FirefoxDriver driver) {
	element = driver.findElement(By.xpath("//*[@id=\"menu-is_active\"]/div[2]/ul/li[1]"));
	return element;
}

public static WebElement optionEnable(FirefoxDriver driver) {
	element = driver.findElement(By.xpath("//*[@id=\"menu-is_active\"]/div[2]/ul/li[2]"));
	//*[@id="menu-is_active"]/div[2]/ul/li[2]
	return element;
}

public static WebElement addCharacteristicButton(FirefoxDriver driver) {
	element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/main/div[3]/div[1]/button"));
	//*[@id="menu-is_active"]/div[2]/ul/li[2]
	return element;
}

public static WebElement updateButton(FirefoxDriver driver) {
	
	element = driver.findElement(By.id("Update"));
	
	return element;
}



}