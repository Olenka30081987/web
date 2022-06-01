package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class AuthorizationEmailTest extends AbstractTest {

    @Test
    public void authorizationEmail() {

        Assertions.assertNotNull(getDriver().findElement(By.xpath(".//a[@class='main_cab_link']")));


    }
}
