package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VerifyCartTest {

	public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("prefs", java.util.Map.of(
                "credentials_enable_service", false
        ));

        // Create Chrome browser instance

        WebDriver driver = new ChromeDriver(options);

        // SauceDemo credentials

        String username = "standard_user";
        String password = "secret_sauce";

        // Open SauceDemo website

        driver.get("https://www.saucedemo.com/");

        // Enter username

        driver.findElement(By.id("user-name"))
              .sendKeys(username);

        // Enter password

        driver.findElement(By.id("password"))
              .sendKeys(password);

        // Click Login

        driver.findElement(By.id("login-button"))
              .click();

        // Wait for page to load

        Thread.sleep(2000);

        // Click Add to Cart for Sauce Labs Backpack

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
              .click();

        // Open cart

        driver.findElement(By.className("shopping_cart_link"))
              .click();

        // Wait for cart page

        Thread.sleep(1000);

        // Get product name

        String product = driver.findElement(
                By.className("inventory_item_name")
        ).getText();

        // Verify product name

        if (product.contains("Sauce Labs Backpack")) {

            System.out.println("PASS");

        } else {

            System.out.println("FAIL");

        }

        // Wait so you can see the result

        Thread.sleep(2000);

        // Close browser

        driver.quit();

    }
}
