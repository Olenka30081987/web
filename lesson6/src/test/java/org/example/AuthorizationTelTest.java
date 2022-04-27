package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AuthorizationTelTest extends AbstractTestInit {

    @Test
    @DisplayName("Авторизация по телефону")
    @Description("Проверка авторизации пользователя по номеру телефона")
    @Link("http://google.com")
    @Severity(SeverityLevel.NORMAL)
    public void authorizationTelTest() {

        Authorization authorization = new Authorization(getDriver());
        authorization.authorizationButtonClick();
        authorization.authorizationTel("9973352618", "qwerty1");
        Assertions.assertNotNull(getDriver().findElement(By.xpath(".//a[@class='main_cab_link']")));
    }
}
