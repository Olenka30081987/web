package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class AddBasketTest extends AbstractTest {

    JavascriptExecutor jse = (JavascriptExecutor) getDriver();

    @Test
    @DisplayName("Добавление в корзину")
    @Description("Проверка добавления товара в корзину")
    @Link("http://google.com")
    @Severity(SeverityLevel.CRITICAL)
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




