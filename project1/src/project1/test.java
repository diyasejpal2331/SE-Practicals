package project1;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import java.time.Duration;
//
//public class test {
//
//	public static void main(String[] args)
//	{
//		WebDriver driver=new ChromeDriver();
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//		
//		try
//		{
//			//open browser
//			driver.get("https://www.qapractice.com/practice-forms");
//			
//			System.out.println("Current URL: " + driver.getCurrentUrl());
//			System.out.println("Page title: " + driver.getTitle());
//			
//			//Select Country and title
//			Select countrySelect = new Select(
//				    driver.findElement(By.id("forms-country"))
//				);
//
//				countrySelect.selectByVisibleText("India");
//
//				System.out.println("Selected country: "
//				    + countrySelect.getFirstSelectedOption().getText());
//			new Select(driver.findElement(By.id("forms-title"))).selectByVisibleText("Dr.");
//			
//			//Fill personal details
//			driver.findElement(By.id("forms-first-name")).sendKeys("Diya");
//			driver.findElement(By.id("forms-last-name")).sendKeys("Makadiya");
//			driver.findElement(By.id("forms-dob")).sendKeys("23-02-2004");
//			driver.findElement(By.id("forms-doj")).sendKeys("01/06/2026");
//			driver.findElement(By.id("forms-email")).sendKeys("diya@sejpalgmail.com");
//			new Select(driver.findElement(By.id("forms-phone-code"))).selectByVisibleText("+91");
//			driver.findElement(By.id("forms-phone-number")).sendKeys("9876543210");
//			
//			WebElement checkbox = driver.findElement(By.id("forms-comm-email"));
//
//			((org.openqa.selenium.JavascriptExecutor) driver)
//			        .executeScript("arguments[0].scrollIntoView({block: 'center'});", checkbox);
//
//			Thread.sleep(500);
//
//			driver.findElement(By.id("forms-comm-email")).click();
//			
//			//Submit the form
//			driver.findElement(By.id("forms-submit")).click();
//			
//			Thread.sleep(1000);
//
//			System.out.println("Page text after submission:");
//			System.out.println(driver.findElement(By.tagName("body")).getText());
//			
//			//Verify success message
//			WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("forms-success")));
//			
//			if(message.getText().contains("Details Successfully Added"))
//			{
//				System.out.println("PASS: Form submitted successfully!");
//			} 
//			else 
//			{
//				System.out.println("FAIL: Unexpected message.");
//			}
//		}
//			
//			catch (Exception e) 
//			{
//	            System.out.println("FAIL: Form automation failed.");
//	            e.printStackTrace();
//
//	        } 
//			finally 
//			{
//	            driver.quit();
//	        }
//		}
//	}
//
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class test {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Open demo form
            driver.get("https://www.qapractice.com/practice-forms");

            // Select country and title
            new Select(driver.findElement(
                By.id("forms-country")
            )).selectByVisibleText("India");

            new Select(driver.findElement(
                By.id("forms-title")
            )).selectByVisibleText("Dr.");

            // Fill personal details
            driver.findElement(By.id("forms-first-name"))
                  .sendKeys("Diya");

            driver.findElement(By.id("forms-last-name"))
                  .sendKeys("Makadiya");

            driver.findElement(By.id("forms-dob"))
                  .sendKeys("2002-05-15");

            driver.findElement(By.id("forms-doj"))
                  .sendKeys("01/06/2026");

            driver.findElement(By.id("forms-email"))
                  .sendKeys("diya.test@example.com");

            new Select(driver.findElement(
                By.id("forms-phone-code")
            )).selectByVisibleText("+91");

            driver.findElement(By.id("forms-phone-number"))
                  .sendKeys("9876543210");

            // Select communication preference
            WebElement checkbox = driver.findElement(By.id("forms-comm-email"));

            ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript(
                        "arguments[0].scrollIntoView({block: 'center'});",
                        checkbox
                    );

            Thread.sleep(1000);

            // Keep your original line unchanged
            driver.findElement(By.id("forms-comm-email")).click();

            // Submit the form
            driver.findElement(By.id("forms-submit")).click();

            // Verify success message
            WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.id("forms-success")
                )
            );

            if (message.getText().contains(
                    "Details Successfully Added")) {
                System.out.println("PASS: Form submitted successfully!");
            } else {
                System.out.println("FAIL: Unexpected message.");
            }

        } catch (Exception e) {
            System.out.println("FAIL: Form automation failed.");
            e.printStackTrace();

        } finally {
            driver.quit();
        }
    }
}
