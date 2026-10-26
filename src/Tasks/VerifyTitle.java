package Tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitle {

	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		
		String expectedtitle="Google";
		String actucaltitle=driver.getTitle();
		
		if(actucaltitle.equals(expectedtitle))
		{
			System.out.println("Title Verfied");
		}
		else
		{
			System.out.println("Title Mismatch");
		}
		
		driver.quit();
	}
}
