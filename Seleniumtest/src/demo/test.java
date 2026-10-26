package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class test {
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.faceboook.com");
		System.out.println("The title of web page is:"+ driver.getTitle());
		
		System.out.println("Url  of web page is:"+ driver.getCurrentUrl());
		
//		System.out.println("source code of web page is:"+ driver.getPageSource());
		
		driver.quit();
	}
}

