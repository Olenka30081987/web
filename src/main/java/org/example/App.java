package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.concurrent.TimeUnit;

public class App
{
    public static void main( String[] args ) throws InterruptedException {

//        Тест № 1 Регистрация нового профиля пользователя

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://otzovik.com/");
        WebElement registration = driver.findElement(By.xpath(".//a [text() = 'Регистрация']"));
        registration.click();
        WebElement login = driver.findElement(By.id("id_login"));
        login.click();
        login.sendKeys("123zzzz");
        WebElement pwd = driver.findElement(By.id("id_pwd"));
        pwd.click();
        pwd.sendKeys("Zxcvb321654");
        WebElement mail = driver.findElement(By.id("id_mail"));
        mail.click();
        mail.sendKeys("as11@mail.ru");
        WebElement checkbox = driver.findElement(By.xpath(".//div [@class='cdot']"));
        checkbox.click();
        WebElement button_registration = driver.findElement(By.cssSelector(".auth-bottom:nth-child(3) > .submit"));
        button_registration.click();
        Thread.sleep(5000L);

//        Тест № 2 Поиск и добавление статьи в закладки

        WebElement search = driver.findElement(By.id("header-search-input"));
        search.click();
        search.sendKeys("олимпийский парк");
        WebElement button_search = driver.findElement(By.xpath(".//input [@class='header-search-btn']"));
        button_search.click();
        WebElement subject = driver.findElement(By.xpath(".//a [text()='Экскурсия по Олимпийскому парку (Россия, Сочи)']"));
        subject.click();
        WebElement article = driver.findElement(By.xpath(".//a [text()='Один раз увидеть можно']"));
        article.click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,4500)", "");
        WebElement bookmark = driver.findElement(By.id("review-bookmark"));
        bookmark.click();

//        Тест № 3 Поиск и добавление автора в подписки

        WebElement author_search = driver.findElement(By.xpath(".//a [@ href ='/findusers.php']"));
        author_search.click();
        WebElement city = driver.findElement(By.id("etCity"));
        city.click();
        city.sendKeys("Саратов");
        WebElement etLogin = driver.findElement(By.id("etLogin"));
        etLogin.click();
        etLogin.sendKeys("Ольга");
        WebElement to_find = driver.findElement(By.xpath(".//button [@id = 'btnFind']"));
        to_find.click();
        WebElement user_login = driver.findElement(By.xpath(".//a [text()='ольга 0609']"));
        user_login.click();
        WebElement subscription = driver.findElement(By.xpath(".//span [@class='check-label']"));
        subscription.click();
        WebElement element = driver.findElement(By.xpath(".//span[text() = 'ОК']"));
        element.click();

//        Тест № 4 Удаление профиля пользователя

        WebElement profile = driver.findElement(By.cssSelector(".header-nav-arrow"));
        profile.click();
        WebElement myprofile = driver.findElement(By.xpath(".//a [@title = 'Информация о Вас на Отзовике']"));
        myprofile.click();
        WebElement edit = driver.findElement(By.xpath(".//a [@href='/myprofile.php?ev=profile']"));
        edit.click();
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement delete = driver.findElement(By.xpath(".//a [@id='delete-myprofile']"));
        delete.click();
        WebElement delete_text = driver.findElement(By.xpath(".//input [@id='deletetext']"));
        delete_text.click();
        delete_text.sendKeys("delete");
        WebElement button_ok = driver.findElement(By.xpath(".//span[text()='OK']"));
        button_ok.click();



//      Завершаем работу с ресурсом
//      driver.quit();

    }
}
