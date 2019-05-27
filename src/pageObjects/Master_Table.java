package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Master_Table {

	public static WebElement element = null;
	
	public static WebElement categoryLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"ss_categories_id\"]/div/span"));
	}
	
	public static WebElement characteristicLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"ss_characteristics_id\"]/div/span"));
	}
	
	public static WebElement driverLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"ss_drivers_id\"]/div/span"));
	}
	
	public static WebElement deliveryPartnereLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"ss_delivery_partners_id\"]/div/span"));
	}

	public static WebElement vehicleLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"ss_vehicle_id\"]/div/span"));
	}
	
	public static WebElement taxRateLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"ss_tax_rates_id\"]/div/span"));
	}
	
	public static WebElement paymentTermsLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"ss_payment_terms_id\"]/div/span"));
	}
	
	public static WebElement unitsLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"ss_units_id\"]/div/span"));
	}
	
	public static WebElement licenseTypeLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"ss_license_type_id\"]/div/span"));
	}
	
	public static WebElement userRolesLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"ss_user_roles_id\"]/div/span"));
	}
	
	public static WebElement userLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"ss_users_list_id\"]/div/span"));
	}
	
	public static WebElement globalSettingsLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"ss_global_settings_id\"]/div/span"));
	}
	
	public static WebElement customerNavigationLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"customer-navigation\"]/div"));
	}
	
	public static WebElement vendorNavigationLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"vendor-navigation\"]/div"));
	}
	
	public static WebElement purchaseOrderNavigationLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/ul/a[2]/div"));
	}
	
	public static WebElement salesOrderNavigationLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/ul/a[3]/div"));
	}
	
	public static WebElement shipmentOrderNavigationLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/ul/a[4]/div"));
	}
	
	public static WebElement invoicesNavigationLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/ul/a[5]/div"));
	}
	
	public static WebElement accountingNavigationLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/ul/a[6]/div"));
	}
	
	public static WebElement reportsNavigationLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/ul/a[9]/div"));
	}
	
	public static WebElement inventoryNavigationLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/ul/div"));
	}
	
	public static WebElement batchesNavigationLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/ul/div[2]/div/div/ul/div/a[1]/div"));
	}
	
	public static WebElement productsNavigationLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/ul/div[2]/div/div/ul/div/a[2]/div"));
	}
	
	public static WebElement reconcilationNavigationLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/ul/div[2]/div/div/ul/div/a[3]/div"));
	}
	
	public static WebElement brandsNavigationLink(FirefoxDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/ul/div[2]/div/div/ul/div/a[4]/div"));
	}
}
