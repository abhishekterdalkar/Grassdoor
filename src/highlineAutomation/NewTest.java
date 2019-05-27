package highlineAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewTest {
    public static void main(String[] args) {
    // TODO Auto-generated method stub
    // Initialize WebDriver
    System.setProperty("webdriver.gecko.driver", "C:/Highline/geckodriver-v0.23.0-win64/geckodriver.exe");
    WebDriver driver = new FirefoxDriver();

    // Maximize Window
   driver.manage().window().maximize();
  
    // Wait For Page To Load
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

   //Navigate to Google webstites
   driver.get("http://192.168.50.23:9000/login");
/*CASE- 1. Both User name and Password are entered correctly. 
Check whether Email field exists or not */
    try
        {
          WebElement a1 = driver.findElement(By.id("standard-required"));
          System.out.println("---------Email field exists --------------\n-----------------------");
          a1.sendKeys("vishal@gmail.com");
         }
    catch(Throwable e)
         {
         System.out.println("Emaild not found: " + e.getMessage());
         }

    //Check whether Password field exists or not
     try
        {
	 WebElement password = driver.findElement(By.id("standard-password-input"));
         System.out.println("----------Passwordd field exits ------------\n-----------------------");
         password.sendKeys("vishal1008");
        }
    catch(Throwable e)
        {
	 System.out.println("Passwordd not found: " + e.getMessage());
        }

     //Asserting the Sign In button exists or not and clicking it
    try
       {
	 driver.findElement(By.id("login-button")).click();        
	 System.out.println("-------Signutton exists----------\n-----------------------");
       //To uncheck the "Check sign in" checkbox
      // WebElement check_stay_sign_in = driver.findElement(By.xpath("//*[@id='PersistentCookie']"));
        //check_stay_sign_in.click();   
        }
    catch(Throwable e)
        {
	System.out.println("Signutton not found: "+ e.getMessage());
        }
    
    
    try
    {
    	WebElement HighlineText = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/ul/a[1]/div"));
    	String text = HighlineText.getText();
    	if(text.equals("Dashboard"))
    	{
    	   System.out.println("----------Login Success -------");
    	}
    	else
    	{
    		System.out.println("----------Login Fail ----------");
    			}
    			
     }
 catch(Throwable e)
     {
	System.out.println("Signutton not found: "+ e.getMessage());
     }
    
    //Case: Valid Email ID and No Password
    try
    {
    	driver.findElement(By.id("standard-required")).sendKeys("vishal@gmail.com");
    	driver.findElement(By.id("standard-password-input")).sendKeys(" ");
    	WebElement HighlineText = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/ul/a[1]/div"));
    	String text = HighlineText.getText();
    	if(text.equals("Dashboard"))
    	{
    	   System.out.println("----------Login Success -------");
    	}
    	else
    	{
    		System.out.println("----------Login Fail ----------");
    			}
    			
     }
 catch(Throwable e)
     {
	System.out.println("Signutton not found: "+ e.getMessage());
     }
    
    //Case: Valid Password and Blank Email
    
    try
    {
    	driver.findElement(By.id("standard-required")).sendKeys("");
    	driver.findElement(By.id("standard-password-input")).sendKeys("vishal1008");
    	WebElement HighlineText = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/ul/a[1]/div"));
    	String text = HighlineText.getText();
    	if(text.equals("Dashboard"))
    	{
    	   System.out.println("----------Login Success -------");
    	}
    	else
    	{
    		System.out.println("----------Login Fail ----------");
    			}
    			
     }
 catch(Throwable e)
     {
	System.out.println("Signup button not found: "+ e.getMessage());
     }
    
    //Case: Blank Email and Password
    
    try
    {
    	driver.findElement(By.id("standard-required")).sendKeys(" ");
    	driver.findElement(By.id("standard-password-input")).sendKeys(" ");
    	WebElement HighlineText = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/ul/a[1]/div"));
    	String text = HighlineText.getText();
    	if(text.equals("Dashboard"))
    	{
    	   System.out.println("----------Login Success -------");
    	}
    	else
    	{
    		System.out.println("----------Login Fail ----------");
    			}
    			
     }
 catch(Throwable e)
     {
	System.out.println("Signutton not found: "+ e.getMessage());
     }
    
    
   
    }
}