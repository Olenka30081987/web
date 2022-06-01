package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddBasketTest extends AbstractTest {

    @Test
    public void addBasket() {

        Actions search = new Actions(getDriver());
        search.click(getDriver().findElement(By.xpath(".//form[@id='search_form']/input")))
                .sendKeys(getDriver().findElement(By.xpath(".//form[@id='search_form']/input")),"платье 895430")
                .click(getDriver().findElement(By.xpath(".//span[@class='header_main_search_button']")))
                .build()
                .perform();

        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,450)", "");


        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Платье Wisell арт: 895430']")));

        WebElement product = getDriver().findElement(By.xpath("//img[@alt='Платье Wisell арт: 895430']"));
        product.click();
        String urlBefore = getDriver().getCurrentUrl();

        Actions productAdd = new Actions(getDriver());
        productAdd.click(getDriver().findElement(By.xpath("//label[@for='size_17']")))
                .click(getDriver().findElement(By.xpath("//div[@class='wrap_btns_item']/div[1]/a")))
                .click(getDriver().findElement(By.xpath("//div[@class='wrap_btns_item']/div[1]/a")))
                .build()
                .perform();

        WebElement productInBasket = getDriver().findElement(By.xpath("//a[@class='basket_picture']"));
        productInBasket.click();
        String urlAfter = getDriver().getCurrentUrl();

       Assertions.assertEquals(urlBefore,urlAfter);
    }
}
