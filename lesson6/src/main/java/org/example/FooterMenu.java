package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterMenu extends AbstractPage{

    @FindBy(xpath = "//a[@title='О нас']")
    private WebElement aboutUs;

    @FindBy(xpath = "//div[@class='menu_block']/a[1]")
    private WebElement reviews;

    @FindBy(xpath = "//div[@class='menu_block']/a[2]")
    private WebElement news ;

    @FindBy(xpath = "//div[@class='menu_block']/a[4]")
    private WebElement contacts;

    @FindBy(xpath = "//div[@class='menu_block']/a[5]")
    private WebElement blog;

    @FindBy(xpath = "//div[@class='menu_block']/a[6]")
    private WebElement questions;

    @FindBy(xpath = "//div[@class='menu_block']/a[7]")
    private WebElement offer;

    @FindBy(xpath = "//div[@class='menu_block']/a[8]")
    private WebElement wholesaleBuyers;

    public FooterMenu(WebDriver driver) {
        super(driver);
    }

    public FooterMenu clickAboutUs() throws InterruptedException {

        try {
            this.aboutUs.click();
        } catch (Exception e){
            Screenshot.makeScreenshot(getDriver(),
                    "FooterMenuTest" + System.currentTimeMillis() + ".png");
        }

        Thread.sleep(10000L);
        return this;
    }

    public FooterMenu waitReviews() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(),10);
            wait.until(ExpectedConditions.elementToBeClickable(reviews));
        } catch (Exception e){
            Screenshot.makeScreenshot(getDriver(),
                    "FooterMenuTest" + System.currentTimeMillis() + ".png");
        }
        return this;
    }

    public void clickReviews() throws InterruptedException {

        try {
             this.reviews.click();
        } catch (Exception e){
            Screenshot.makeScreenshot(getDriver(),
                    "FooterMenuTest" + System.currentTimeMillis() + ".png");
        }
        Thread.sleep(3000L);
    }

    public void clickNews() throws InterruptedException {

        try {
            this.news.click();
        } catch (Exception e){
            Screenshot.makeScreenshot(getDriver(),
                    "FooterMenuTest" + System.currentTimeMillis() + ".png");
        }
        Thread.sleep(3000L);
    }

    public void clickContacts() throws InterruptedException {

        try {
            this.contacts.click();
        } catch (Exception e){
            Screenshot.makeScreenshot(getDriver(),
                    "FooterMenuTest" + System.currentTimeMillis() + ".png");
        }
        Thread.sleep(3000L);
    }

    public void clickBlog() throws InterruptedException {

        try {
            this.blog.click();
        } catch (Exception e){
            Screenshot.makeScreenshot(getDriver(),
                    "FooterMenuTest" + System.currentTimeMillis() + ".png");
        }
        Thread.sleep(3000L);
    }

    public void clickQuestions() throws InterruptedException {

        try {
            this.questions.click();
        } catch (Exception e){
            Screenshot.makeScreenshot(getDriver(),
                    "FooterMenuTest" + System.currentTimeMillis() + ".png");
        }
        Thread.sleep(3000L);
    }

    public void clickOffer() throws InterruptedException {

        try {
            this.offer.click();
        } catch (Exception e){
            Screenshot.makeScreenshot(getDriver(),
                    "FooterMenuTest" + System.currentTimeMillis() + ".png");
        }
        Thread.sleep(3000L);
    }

    public void clickWholesaleBuyers() throws InterruptedException {

        try {
            this.wholesaleBuyers.click();
        } catch (Exception e){
            Screenshot.makeScreenshot(getDriver(),
                    "FooterMenuTest" + System.currentTimeMillis() + ".png");
        }
        Thread.sleep(3000L);
    }
}
