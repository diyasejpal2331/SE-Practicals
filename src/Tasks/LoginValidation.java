package Tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class LoginValidation {

	public static void main(String args[])throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		driver.findElement(By.id("username")).sendKeys("student");
		
		driver.findElement(By.id("password")).sendKeys("Password123");
		
		driver.findElement(By.id("submit")).click();
		
		String url=driver.getCurrentUrl();
		
		if(url.contains("logged-in-sucessfully"))
		{
			 System.out.println("Login Passed");
		}
		else
		{
			System.out.println("Login Failed");
		}
		
		Thread.sleep(8000);
		driver.quit();
		}
	}
