package org.example;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class MyWebDriverEventListener implements WebDriverEventListener {
    @Override
    public void beforeAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {

    }


    @Override
    public void beforeAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {


    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        String messageId = UUID.randomUUID().toString();
        System.out.println(messageId + " : Navigating to [" + url + "] with driver [" + driver + "]");
        makeScreenshot(driver,messageId);

    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("I want to find element: "+ by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("I have finded element: "+element.getTagName());

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        String messageId = UUID.randomUUID().toString();
        System.out.println("Throwable to print message: "+throwable.getMessage());
        makeScreenshot(driver, messageId);
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {

    }

    public static File makeScreenshot(WebDriver driver, String filename) {
        File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("C:/Users/User/Desktop/Java Web/lessons/lesson6/screenshots/" + filename);
        try {
            FileUtils.copyFile(temp, destination);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return destination;
    }

}
