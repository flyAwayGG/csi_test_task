package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import utils.Drivers;
import webobjects.EmailData;

import java.util.concurrent.TimeUnit;

/**
 * Created by root on 22.02.17.
 */
public class EmailPage extends MailRuBasePage {

    @FindBy(css = ".b-contact-informer-target.js-contact-informer")
    private WebElement authorElement;

    @FindBy(css = ".b-letter__head__subj__text")
    private WebElement themeElement;

    @FindBy(css = ".b-letter__body div[id]")
    private WebElement contentElement;

    @FindBy(css = "#PH_logoutLink")
    private WebElement logoutButton;

    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public EmailPage waitForLoad() {
        waitForElementLoad(authorElement, 5, TimeUnit.SECONDS);
        return this;
    }

    public EmailData getEmailData() {
        return EmailData.builder(
                authorElement.getAttribute("data-contact-informer-email")
                , themeElement.getText())
                .setAuthor(authorElement.getAttribute("data-contact-informer-name"))
                .setContent(contentElement.getText())
                .build();
    }

    public void logout() {
        logoutButton.click();
    }
}
