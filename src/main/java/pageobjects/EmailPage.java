package pageobjects;

import org.openqa.selenium.WebDriver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import utils.Drivers;
import webobjects.EmailData;

/**
 * Created by root on 22.02.17.
 */
public class EmailPage extends MailRuBasePage{

    @FindBy(css="")
    private WebElement authorElement;

    @FindBy(css="")
    private WebElement themeElement;

    @FindBy(css="")
    private WebElement contentElement;

    @FindBy(css="")
    private WebElement logoutButton;

    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public EmailPage waitForLoad(){
        return this;
    }

    public EmailData getEmailData(){
        return EmailData.builder(authorElement.getText(),themeElement.getText())
                .setContent(contentElement.getText()).build();
    }

    public void logout(){
        logoutButton.click();
    }
}
