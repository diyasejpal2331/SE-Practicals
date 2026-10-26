package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Completeorder {

	 public static void main(String args[]) 
	 {
	        // 1. Open Chrome
	        WebDriver driver = new ChromeDriver();

	        // 2. Open SauceDemo website
	        driver.get("https://www.saucedemo.com/");

	        // 3. Login
	        driver.findElement(By.id("user-name")).sendKeys("standard_user");
	        driver.findElement(By.id("password")).sendKeys("secret_sauce");
	        driver.findElement(By.id("login-button")).click();
	        
	        //4. Add Product to cart
	        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	        
	        //5.Open cart
	        driver.findElement(By.id("shopping_cart_container")).click();
	        
	        //6.Click Checkout
	        driver.findElement(By.id("checkout")).click();
	        
	        //7.Enter customer information
	        driver.findElement(By.id("first-name")).sendKeys("Diya");
	        driver.findElement(By.id("last-name")).sendKeys("Sejpal");
	        driver.findElement(By.id("postal-code")).sendKeys("380015");
	        
	        //8.Click Continue
	        driver.findElement(By.id("continue")).click();
	        
	        //Click Finish
	        driver.findElement(By.id("finish")).click();
	        
	        //Verify order completion message
	        String message = driver.findElement(By.className("complete-header")).getText();

	        if(message.contains("Thank You"))
	        {
	        	 System.out.println("ORDER PASSED");
	        }
	        else
	        {
	        	System.out.println("ORDER FAILED");
	        }
	        driver.quit();
	 }  
}
