package Tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitle {

	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		System.out.println("Title is:"+driver.getTitle());
		
		System.out.println("Url is:"+driver.getCurrentUrl());
		
		System.out.println("Source is:"+driver.getPageSource());
		
		driver.quit();
	}
}
