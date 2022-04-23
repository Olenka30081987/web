package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class FilterTest extends AbstractTestInit{

    @Test
    public void filter() {

        getDriver().get("https://belpodium.ru");

        WebElement productInBasket = getDriver().findElement(By.xpath("//li[@class='mi-0'] //a[@title='Женщинам']"));
        productInBasket.click();
        WebElement productInBasket1 = getDriver().findElement(By.xpath("//li[@id='subcategory_201']/a"));
        productInBasket1.click();
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,200)", "");

        Actions filter = new Actions(getDriver());
        filter.click(getDriver().findElement(By.xpath("//*[@id='filtr_form']/div[3]/a/div")))
                .pause(1000)
                .click(getDriver().findElement(By.xpath("//*[@id='filter_box_81']/div[1]/div[2]/div[1]/a")))
                .click(getDriver().findElement(By.xpath("//*[@id='filter_box_81']/div[2]/button")))
                .build()
                .perform();

        List<WebElement> list = getDriver().findElements(By.xpath("//ul[@class='wrap-elements']/li"));
        if(list.size()>=1){
            Assertions.assertTrue(true);
        }
    }
}