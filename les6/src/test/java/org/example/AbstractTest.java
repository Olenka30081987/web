package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    private static WebDriver driver;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    void goTo() throws InterruptedException {
        Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://belpodium.ru"),
                "Страница не доступна");

        getDriver().get("https://belpodium.ru");

        Authorization authorization = new Authorization(getDriver());
        authorization.authorizationButtonClick();
        authorization.authorizationEmail("aaa1@mail.ru", "qwerty1");
        Thread.sleep(5000L);
    }

//    @AfterAll
//    static void close(){
//        driver.quit();
//    }

    public static WebDriver getDriver() {
        return driver;
    }
}
