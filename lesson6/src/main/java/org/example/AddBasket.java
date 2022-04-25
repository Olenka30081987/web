package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddBasket extends AbstractPage {

    @FindBy(xpath = ".//form[@id='search_form']/input")
    private WebElement search;

    @FindBy(xpath = ".//span[@class='header_main_search_button']")
    private WebElement searchButton;

    @FindBy(xpath = "//img[@alt='Платье Wisell арт: 895430']")
    private WebElement product;

    @FindBy(xpath = "//label[@for='size_17']")
    private WebElement productSize;

    @FindBy(xpath = "//div[@class='wrap_btns_item']/div[1]/a")
    private WebElement productAdd;

    @FindBy(xpath = "//a[@class='basket_picture']")
    private WebElement productInBasket;

    @FindBy(xpath = "//div[@class='hidden_minicart_hover']")
    private WebElement basket;

    @FindBy(xpath = "///div[@class='minicart_item_delete active_ev']")
    private WebElement deleteProduct;

    public void search(String product){

        Actions search = new Actions(getDriver());
        search
                .click(this.search)
                .sendKeys(product)
                .click(this.searchButton)
                .build()
                .perform();
    }

    public void productClick(){
        this.product.click();
    }

    public AddBasket productAdd (){

        Actions productAdd  = new Actions(getDriver());
        productAdd
                .click(this.productSize)
                .click(this.productAdd)
                .click(this.productAdd)
                .build()
                .perform();
        return this;
    }

    public void productInBasket(){
        this.productInBasket.click();
    }

    public AddBasket(WebDriver driver) {
        super(driver);
    }
}
