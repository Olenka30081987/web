package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class AddFavoritesTest extends AbstractTest {
    JavascriptExecutor jse = (JavascriptExecutor)getDriver();

    @Test
    @DisplayName("Добавление в отложенное")
    @Description("Проверка добавления товара в отложенное")
    @Link("http://google.com")
    @Severity(SeverityLevel.MINOR)
    public void addFavorites() {

        AddFavorites addFavorites = new AddFavorites(getDriver());
        addFavorites.search("платье 895430");

        jse.executeScript("window.scrollBy(0,450)", "");


        addFavorites.productClick();

        String urlBefore = getDriver().getCurrentUrl();

        addFavorites
                .productAdd()
                .productInFavorites();

        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        addFavorites.basketPicture();

        String urlAfter = getDriver().getCurrentUrl();

        Assertions.assertEquals(urlBefore,urlAfter);

        addFavorites
                .productInFavorites()
                .delFromFavorites();
    }
}
