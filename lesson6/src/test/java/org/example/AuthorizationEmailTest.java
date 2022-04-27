package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AuthorizationEmailTest extends AbstractTest {

    @Test
    @DisplayName("Авторизация по email")
    @Description("Проверка авторизации пользователя по email")
    @Link("http://google.com")
    @Severity(SeverityLevel.CRITICAL)
    public void authorizationEmailTest() {

        Assertions.assertNotNull(getDriver().findElement(By.xpath(".//a[@class='main_cab_link']")));
    }
}
