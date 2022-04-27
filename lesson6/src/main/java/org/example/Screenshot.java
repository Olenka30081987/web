package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static void makeScreenshot(WebDriver driver, String filename) {
        File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("C:/Users/User/Desktop/Java Web/lessons/lesson6/screenshots/" + filename);
        try {
            FileUtils.copyFile(temp, destination);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
