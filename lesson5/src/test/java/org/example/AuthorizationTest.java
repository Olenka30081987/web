package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class AuthorizationTest extends AbstractTest {

    @Test
    public void authorizationTest() {

        Assertions.assertNotNull(getDriver().findElement(By.xpath(".//a[@class='main_cab_link']")));

    }
}
