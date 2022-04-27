package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Authorization extends AbstractPage {

    public Authorization(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//a[@class='auth_link']")
        private WebElement authorizationButton;

    @FindBy(id = "emailButton")
        private WebElement emailButton;

    @FindBy(id = "phoneButton")
    private WebElement telButton;

    @FindBy(xpath = "//input[@id='log_phone']")
    private WebElement tel;

    @FindBy(xpath = "//div[@class='login-type type-mail']/input")
    private WebElement email;

    @FindBy(xpath = ".//input[@class='passowrd-track']")
    private WebElement pwd;

    @FindBy(xpath = ".//form/div[2]/div[2]/div[6]/button ")
    private WebElement formButton;

    @FindBy(xpath = ".//a[@class='main_cab_link']")
    private WebElement personalAccount;


    public void authorizationButtonClick() {
        this.authorizationButton.click();
    }

    public Authorization setEmail(String email) {
            this.email.click();
            this.email.sendKeys(email);
            return this;
    }


    public Authorization setPassword(String password) {
            this.pwd.click();
            this.pwd.sendKeys(password);
            return this;
    }

    public void authorizationEmail(String email, String password) {
        Actions authorizationEmail = new Actions(getDriver());
        authorizationEmail
                    .click(this.emailButton)
                    .click(this.email)
                    .sendKeys(email)
                    .click(this.pwd)
                    .sendKeys(password)
                    .click(this.formButton)
                    .build()
                    .perform();
    }

    public void authorizationTel(String tel, String password) {
        Actions authorizationTel = new Actions(getDriver());
        authorizationTel
                .click(this.telButton)
                .click(this.tel)
                .sendKeys(tel)
                .sendKeys(tel)
                .click(this.pwd)
                .sendKeys(password)
                .click(this.formButton)
                .build()
                .perform();
    }
}

