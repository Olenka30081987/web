package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterTest extends AbstractTestInit {

    @Test
    public void footer() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement aboutUs = getDriver().findElement(By.xpath("//a[@title='О нас']"));
        aboutUs.click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.urlContains("https://belpodium.ru/about/o-nas/"));
        Assertions.assertEquals("https://belpodium.ru/about/o-nas/",getDriver().getCurrentUrl());
        Thread.sleep(5000L);

        WebElement reviews = getDriver().findElement(By.xpath("//div[@class='menu_block']/a[1]"));
        reviews.click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.urlContains("https://belpodium.ru/about/reviews/"));
        Assertions.assertEquals("https://belpodium.ru/about/reviews/",getDriver().getCurrentUrl());

        WebElement news = getDriver().findElement(By.xpath("//div[@class='menu_block']/a[2]"));
        news.click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.urlContains("https://belpodium.ru/about/news/"));
        Assertions.assertEquals("https://belpodium.ru/about/news/",getDriver().getCurrentUrl());

        WebElement contacts = getDriver().findElement(By.xpath("//div[@class='menu_block']/a[4]"));
        contacts.click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.urlContains("https://belpodium.ru/about/kontakty/"));
        Assertions.assertEquals("https://belpodium.ru/about/kontakty/",getDriver().getCurrentUrl());



        WebElement blog = getDriver().findElement(By.xpath("//div[@class='menu_block']/a[5]"));
        blog.click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.urlContains("https://belpodium.ru/about/blog/"));
        Assertions.assertEquals("https://belpodium.ru/about/blog/",getDriver().getCurrentUrl());

        WebElement questions = getDriver().findElement(By.xpath("//div[@class='menu_block']/a[6]"));
        questions.click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.urlContains("https://belpodium.ru/about/ask_question/"));
        Assertions.assertEquals("https://belpodium.ru/about/ask_question/",getDriver().getCurrentUrl());

        WebElement offer = getDriver().findElement(By.xpath("//div[@class='menu_block']/a[7]"));
        offer.click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.urlContains("https://belpodium.ru/about/publichnaya-oferta/"));
        Assertions.assertEquals("https://belpodium.ru/about/publichnaya-oferta/",getDriver().getCurrentUrl());

        WebElement wholesaleBuyers = getDriver().findElement(By.xpath("//div[@class='menu_block']/a[8]"));
        wholesaleBuyers.click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.urlContains("https://belpodium.ru/about/wholesale_buyers/"));
        Assertions.assertEquals("https://belpodium.ru/about/wholesale_buyers/",getDriver().getCurrentUrl());




    }
}