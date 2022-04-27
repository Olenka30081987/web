package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class AddBasketTest extends AbstractTest {

    JavascriptExecutor jse = (JavascriptExecutor) getDriver();

    @Test
    public void addBasket() {

        AddBasket addBasket = new AddBasket(getDriver());
        addBasket.search("платье 895430");

        jse.executeScript("window.scrollBy(0,450)", "");

        addBasket.productClick();

        String urlBefore = getDriver().getCurrentUrl();

        addBasket
                .productAdd()
                .productInBasket();

        String urlAfter = getDriver().getCurrentUrl();

        Assertions.assertEquals(urlBefore, urlAfter);
    }
}




