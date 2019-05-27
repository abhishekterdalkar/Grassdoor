package pageObjectGrass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MasterTableGrass_Page {
	
	public static WebElement element = null;
	
	public static WebElement adminLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/ul/div[6]"));
	}
	
	public static WebElement customerLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("/html/body/div/div/div/div/ul/a[4]/div"));
	}

	
}
