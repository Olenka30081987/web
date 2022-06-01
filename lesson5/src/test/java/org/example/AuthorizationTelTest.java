package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AuthorizationTelTest extends AbstractTestInit{

    @Test
    public void authorizationTel() throws InterruptedException {


        getDriver().get("https://belpodium.ru");
        WebElement authorization = getDriver().findElement(By.xpath(".//a[@class='auth_link']"));
        authorization.click();
        Actions authorizationForm = new Actions(getDriver());
        authorizationForm.click(getDriver().findElement(By.id("phoneButton")))
                .doubleClick(getDriver().findElement(By.xpath("//input[@id='log_phone']")))
                .sendKeys(getDriver().findElement(By.xpath("//input[@id='log_phone']")),"9973352618")
                .click(getDriver().findElement(By.xpath(".//input[@class='passowrd-track']")))
                .sendKeys(getDriver().findElement(By.xpath(".//input[@class='passowrd-track']")), "qwerty1")
                .click(getDriver().findElement(By.xpath(".//form/div[2]/div[2]/div[6]/button ")))
                .build()
                .perform();
        Thread.sleep(5000L);

        Assertions.assertNotNull(getDriver().findElement(By.xpath(".//a[@class='main_cab_link']")));

    }




}
