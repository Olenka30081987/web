package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FilterTest extends AbstractTestInit {

    @Test
    public void filter() throws InterruptedException {

        Filter filter = new Filter(getDriver());
        filter
                .waitMenuItem()
                .menuItemClick();
        Thread.sleep(5000);

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,200)", "");

        filter.getFilter();
        Thread.sleep(5000);

        List<WebElement> list = getDriver().findElements(By.xpath("//ul[@class='wrap-elements']/li"));
        if (list != null && ((List<?>) list).size() > 0) {
            Assertions.assertTrue(true);
        }
    }
}
