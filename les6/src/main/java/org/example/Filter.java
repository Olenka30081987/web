package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Filter extends AbstractPage {

    @FindBy(xpath = "//li[@class='mi-0'] //a[@title='Женщинам']")
    private WebElement menuItem;

    @FindBy(xpath = "//li[@id='subcategory_201']/a")
    private WebElement getItem;

    @FindBy(xpath = "//*[@id='filtr_form']/div[3]/a/div")
    private WebElement heighPoint;

    @FindBy(xpath = "//*[@id='filter_box_81']/div[1]/div[2]/div[1]/a")
    private WebElement heigh;

    @FindBy(xpath = "//*[@id='filter_box_81']/div[2]/button")
    private WebElement heighButton;

    @FindBy(xpath = "//ul[@class='wrap-elements']/li")
    private WebElement formButton;

    @FindBy(xpath = ".//a[@class='main_cab_link']")
    private List<WebElement> listFilter;

    public Filter waitMenuItem() {
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(menuItem));
        return  this;
    }
    public void menuItemClick() throws InterruptedException {
        this.menuItem.click();
        Thread.sleep(10000L);
    }

    public void getFilter() {
        Actions getFilter = new Actions(getDriver());
        getFilter
                .click(this.heighPoint)
                .pause(1000)
                .click(this.heigh)
                .click(this.heighButton)
                .pause(1000)
                .build()
                .perform();
    }
    public Filter(WebDriver driver) {
        super(driver);
    }
}
