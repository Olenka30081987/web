package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.time.Duration;
import java.util.List;

public abstract class AbstractTest {

    private static EventFiringWebDriver eventDriver;

    @BeforeAll
    static void setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
//        options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(10));

        eventDriver = new EventFiringWebDriver(new ChromeDriver(options));
        eventDriver.register(new MyWebDriverEventListener());

        eventDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @BeforeEach
    void goTo() throws InterruptedException {
        Assertions.assertDoesNotThrow(() -> getDriver().navigate().to("https://belpodium.ru"),
                "Страница не доступна");

        Authorization authorization = new Authorization(getDriver());
        authorization.authorizationButtonClick();
        authorization.authorizationEmail("aaa1@mail.ru", "qwerty1");
        Thread.sleep(5000L);
    }

    @AfterAll
    public static void exit() {

        if (eventDriver != null) eventDriver.quit();
    }

    @AfterEach
    public void checkBrowser() {
        List<LogEntry> allLogRows = getDriver().manage().logs().get(LogType.BROWSER).getAll();
        if (!allLogRows.isEmpty()) {

            if (allLogRows.size() > 0) {
                allLogRows.forEach(logEntry -> {
                    System.out.println(logEntry.getMessage());
                });
            }
        }
    }

    public WebDriver getDriver() {
        return this.eventDriver;
    }
}

