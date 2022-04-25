package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
public class FooterMenuTest extends AbstractTestInit {

    @Test
    @DisplayName("Нижнее меню")
    @Description("Проверка нижнего меню сайта")
    @Link("http://google.com")
    @Severity(SeverityLevel.MINOR)
    void footerMenuTest(){
        FooterMenu footerMenu = new FooterMenu(getDriver());

        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        footerMenu.clickAboutUs();
        Assertions.assertEquals("https://belpodium.ru/about/o-nas/",getDriver().getCurrentUrl());

        footerMenu.clickReviews();
        Assertions.assertEquals("https://belpodium.ru/about/reviews/",getDriver().getCurrentUrl());

        footerMenu.clickNews();
        Assertions.assertEquals("https://belpodium.ru/about/news/",getDriver().getCurrentUrl());

        footerMenu.clickContacts();
        Assertions.assertEquals("https://belpodium.ru/about/kontakty/",getDriver().getCurrentUrl());

        footerMenu.clickBlog();
        Assertions.assertEquals("https://belpodium.ru/about/blog/",getDriver().getCurrentUrl());

        footerMenu.clickQuestions();
        Assertions.assertEquals("https://belpodium.ru/about/ask_question/",getDriver().getCurrentUrl());

        footerMenu.clickOffer();
        Assertions.assertEquals("https://belpodium.ru/about/publichnaya-oferta/",getDriver().getCurrentUrl());

        footerMenu.clickWholesaleBuyers();
        Assertions.assertEquals("https://belpodium.ru/about/wholesale_buyers/",getDriver().getCurrentUrl());
    }
}
