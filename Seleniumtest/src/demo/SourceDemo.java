package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SourceDemo {

    public static void main(String[] args) {

        // Create Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open SauceDemo website
        driver.get("https://www.saucedemo.com/");

        // Leave username empty
        driver.findElement(By.id("username")).sendKeys("standard_user");
        // Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Click Login button
        driver.findElement(By.id("login-button")).click();

        // Get error message
        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();

        // Verify error message
        if (error.contains("Username is required")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        // Keep browser open for 5 seconds
        //Thread.sleep(5000);

        // Close browser
        driver.quit();
    }
}