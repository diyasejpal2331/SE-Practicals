package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleUserTest {

    public static void main(String[] args) throws InterruptedException {

        String[] users = {
                "standard_user",
                "locked_out_user",
                "problem_user",
                "performance_glitch_user",
                "error_user",
                "visual_user",
                ""
        };

        String password = "secret_sauce";

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        for (String username : users) {

            // Open SauceDemo
            driver.get("https://www.saucedemo.com/");

            // Enter username
            driver.findElement(By.id("user-name")).sendKeys(username);

            // Enter password
            driver.findElement(By.id("password")).sendKeys(password);

            // Click login
            driver.findElement(By.id("login-button")).click();

            Thread.sleep(2000);

            // Check result
            if (driver.getCurrentUrl().contains("inventory")) {

                System.out.println(username + " -> LOGIN PASS");

            } else {

                String error = driver.findElement(
                        By.cssSelector("[data-test='error']")
                ).getText();

                System.out.println(username + " -> LOGIN FAIL");
                System.out.println("Error: " + error);
            }
        }

        // Close browser
        driver.quit();
    }
}

