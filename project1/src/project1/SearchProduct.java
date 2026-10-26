package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class SearchProduct {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(1500));

        try {
            // Open shopping website
            driver.manage().window().maximize();
            driver.get("https://demowebshop.tricentis.com/");

            // Search for a particular product
            WebElement searchBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.id("small-searchterms")));

            searchBox.sendKeys("computer");

            driver.findElement(By.cssSelector(
                    "input.search-box-button")).click();

            // Wait for the product search results
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.cssSelector(".product-title a")));

            // Get all displayed product links
            List<WebElement> products =
                    driver.findElements(By.cssSelector(".product-title a"));

            // Display one particular product automatically
            WebElement selectedProduct = null;

            for (WebElement product : products) {
                if (product.getText().toLowerCase()
                        .contains("build your own computer")) {
                    selectedProduct = product;
                    break;
                }
            }

            if (selectedProduct != null) {

                String productName = selectedProduct.getText();

                System.out.println("Product found: " + productName);

                // Open the selected product
                selectedProduct.click();

                // Wait for the product details page
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".product-name")));

                System.out.println("Product displayed successfully!");
                System.out.println("Product page: "
                        + driver.getCurrentUrl());

            } else {
                System.out.println(
                        "The requested product was not found in the results.");
            }

        } catch (Exception e) {
            System.out.println("Product automation failed.");
            e.printStackTrace();

        } finally {
            driver.quit();
        }
    }
}

