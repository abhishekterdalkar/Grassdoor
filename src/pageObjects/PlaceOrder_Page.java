package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PlaceOrder_Page {
	
	public static WebElement element = null;
	
	public static WebElement countryCode(FirefoxDriver driver) {
		return element = driver.findElement(By.id(""));
	}

}
