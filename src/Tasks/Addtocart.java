package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Addtocart {

	public static void main(String args[])throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		try
		{
			driver.get("https://www.saucedemo.com/");
			
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.id("login-button")).click();
			
			driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
			driver.findElement(By.id("shopping_cart_link")).click();
			
			String badge=driver.findElement(By.className("shopping_cart_badge")).getText();
			if(badge.equals("1"))
			{
				System.out.println("PASS:Product Added To Cart");
			}
			else
			{
				System.out.println("FAIL:Product Not Added");
			}
			
			String productName=driver.findElement(By.className("inventory_item_name")).getText();
			if(productName.equals("Sauce Labs Backpack"))
			{
				System.out.println("PASS:Product Verified");
			}
			else
			{
				System.out.println("FAIL:Product Verification Failed");
			}
		}
		finally
		{
			Thread.sleep(8000);
			driver.quit();
		}
	}
}
