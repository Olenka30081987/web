package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddFavorites extends AbstractPage {

    @FindBy(xpath = ".//form[@id='search_form']/input")
    private WebElement search;

    @FindBy(xpath = ".//span[@class='header_main_search_button']")
    private WebElement searchButton;

    @FindBy(xpath = "//img[@alt='Платье Wisell арт: 895430']")
    private WebElement product;

    @FindBy(xpath = "//label[@for='size_17']")
    private WebElement productSize;

    @FindBy(xpath = "//div[@id='add_to_favorites_button']")
    private WebElement buttonFavorites;

    @FindBy(xpath = "//li[@class='favorited']")
    private WebElement itemFavorites;

    @FindBy(xpath = "//a[@class='basket_picture']")
    private WebElement basketPicture;

    @FindBy(xpath = "//a[@class='delFromFavorites del_product_ref']")
    private WebElement delFromFavorites;

    public void search(String product){

        try {
            Actions search = new Actions(getDriver());
            search
                    .click(this.search)
                    .sendKeys(product)
                    .click(this.searchButton)
                    .build()
                    .perform();
        } catch (Exception e){
            Screenshot.makeScreenshot(getDriver(),
                    "AddFavoritesTest" + System.currentTimeMillis() + ".png");
        }
    }

    public void productClick(){

        try {
            this.product.click();
        } catch (Exception e){
            Screenshot.makeScreenshot(getDriver(),
                    "AddFavoritesTest" + System.currentTimeMillis() + ".png");
        }
    }

    public AddFavorites productAdd(){

        try {
            Actions productAdd  = new Actions(getDriver());
            productAdd
                    .click(this.productSize)
                    .click(this.buttonFavorites)
                    .build()
                    .perform();
        } catch (Exception e){
            Screenshot.makeScreenshot(getDriver(),
                    "AddFavoritesTest" + System.currentTimeMillis() + ".png");
        }
        return this;
    }

    public AddFavorites productInFavorites(){

        try {
            this.itemFavorites.click();
        } catch (Exception e){
            Screenshot.makeScreenshot(getDriver(),
                    "AddFavoritesTest" + System.currentTimeMillis() + ".png");
        }
        return this;
    }

    public void basketPicture(){

        try {
            this.basketPicture.click();
        } catch (Exception e){
            Screenshot.makeScreenshot(getDriver(),
                    "AddFavoritesTest" + System.currentTimeMillis() + ".png");
        }
    }

    public void delFromFavorites(){

        try {
            this.delFromFavorites.click();
        } catch (Exception e){
            Screenshot.makeScreenshot(getDriver(),
                    "AddFavoritesTest" + System.currentTimeMillis() + ".png");
        }
    }

    public AddFavorites(WebDriver driver) {
        super(driver);
    }
}
