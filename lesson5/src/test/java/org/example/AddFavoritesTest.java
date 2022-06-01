package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddFavoritesTest extends AbstractTest {

    @Test
    public void AddFavorites() throws InterruptedException {

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

        Actions filterProduct = new Actions(getDriver());
        filterProduct.click(getDriver().findElement(By.xpath("//label[@for='size_17']")))
                .click(getDriver().findElement(By.xpath("//div[@id='add_to_favorites_button']")))
                .build()
                .perform();

        WebElement itemFavorites = getDriver().findElement(By.xpath("//li[@class='favorited']"));
        itemFavorites.click();

        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement basketPicture = getDriver().findElement(By.xpath("//a[@class='basket_picture']"));
        basketPicture.click();

        String urlAfter = getDriver().getCurrentUrl();

        Assertions.assertEquals(urlBefore,urlAfter);

        WebElement deleteProduct = getDriver().findElement(By.xpath("//li[@class='favorited']"));
        deleteProduct.click();

        WebElement delete = getDriver().findElement(By.xpath("//a[@class='delFromFavorites del_product_ref']"));
        delete.click();

    }
}
