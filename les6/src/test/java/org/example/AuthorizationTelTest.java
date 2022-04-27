package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AuthorizationTelTest extends AbstractTestInit {

    @Test
    public void authorizationTelTest() {

        Authorization authorization = new Authorization(getDriver());
        authorization.authorizationButtonClick();
        authorization.authorizationTel("9973352618", "qwerty1");
        Assertions.assertNotNull(getDriver().findElement(By.xpath(".//a[@class='main_cab_link']")));
    }
}
