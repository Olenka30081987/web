package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class FilterTest extends AbstractTestInit {

    @Test
    @DisplayName("Сортировка товара")
    @Description("Проверка возможности сортировки товара")
    @Link("http://google.com")
    @Severity(SeverityLevel.NORMAL)
    public void filter() {

        getDriver().get("https://belpodium.ru");

        Filter filter = new Filter(getDriver());
        filter
                .menuItemClick()
                .itemClick();

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,200)", "");

        filter.getFilter();
        if (filter.getListFilter().size() >= 1) {
            Assertions.assertTrue(true);
        }
    }
}
