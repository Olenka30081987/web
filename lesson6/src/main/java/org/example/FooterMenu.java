package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void clickAboutUs(){
        aboutUs.click();
    }

    public void clickReviews(){
        reviews.click();
    }

    public void clickNews(){
        news.click();
    }

    public void clickContacts(){
        contacts.click();
    }

    public void clickBlog(){
        blog.click();
    }

    public void clickQuestions(){
        questions.click();
    }

    public void clickOffer(){
        offer.click();
    }

    public void clickWholesaleBuyers(){
        wholesaleBuyers.click();
    }
}
