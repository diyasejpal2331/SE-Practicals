package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmptyUsername {
	
	public static void main(String args[])throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/"); 
		
		driver.findElement(By.id("username")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		String error=driver.findElement(By.cssSelector("[data-test='error']")).getText();
		
		if(error.contains("Username is required"))
		{
			System.out.println("PASS");
		}
		else
		{
			 System.out.println("FAIL");
		}
		Thread.sleep(8000);
	}
}
