package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    private WebDriver driver;
    public Screenshot screenshot;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebDriver getDriver(){
        return this.driver;
    }
}
