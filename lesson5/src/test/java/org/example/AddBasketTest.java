package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class AddBasketTest extends AbstractTest {

    @Test
    public void addBasket() throws InterruptedException {

        Actions search = new Actions(getDriver());
        search.click(getDriver().findElement(By.xpath(".//form[@id='search_form']/input")))
                .sendKeys(getDriver().findElement(By.xpath(".//form[@id='search_form']/input")),"платье 895430")
                .click(getDriver().findElement(By.xpath(".//span[@class='header_main_search_button']")))
                .build()
                .perform();

        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,450)", "");
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


        WebElement basket = getDriver().findElement(By.xpath("//div[@class='hidden_minicart_hover']"));
        Actions deleteProduct = new Actions(getDriver());
        deleteProduct.moveToElement(basket)
                .click(getDriver().findElement(By.xpath("//div[@class='minicart_item_delete active_ev']")))
                .build()
                .perform();

    }
}
