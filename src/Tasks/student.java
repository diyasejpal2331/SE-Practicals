package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class student {

	public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("http://localhost:8080/login");

            driver.manage().window().maximize();

            driver.findElement(By.id("username"))
                    .sendKeys("admin");

            driver.findElement(By.id("password"))
                    .sendKeys("admin123");

            driver.findElement(By.id("loginButton"))
                    .click();

            String title = driver.findElement(
                    By.className("page-title")
            ).getText();

            if (title.equals("Student Dashboard")) {

                System.out.println("PASS: Login successful");

            } else {

                System.out.println("FAIL: Login unsuccessful");
            }

        } finally {

        	Thread.sleep(8000);
            driver.quit();
        }
    }
}

