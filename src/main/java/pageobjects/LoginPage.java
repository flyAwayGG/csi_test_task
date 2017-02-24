package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import webobjects.LoginData;

import java.util.concurrent.TimeUnit;

/**
 * Created by root on 22.02.17.
 */
public class LoginPage extends MailRuBasePage {

    @FindBy(css ="#mailbox__login")
    private WebElement loginInput;

    @FindBy(css ="#mailbox__password")
    private WebElement passInput;

    @FindBy(css="#mailbox__auth__button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver().get("https://mail.ru/");
        waitForElementLoad(loginInput,5, TimeUnit.SECONDS);
    }

    public MainEmailsPage login(LoginData loginData){
        loginInput.sendKeys(loginData.getEmail());
        passInput.sendKeys(loginData.getPassword());

        loginButton.click();
        return new MainEmailsPage(driver()).waitForLoad();
    }

    public LoginPage waitForLoad(){
        return this;
    }

    public void logout(){
        throw new NotImplementedException();
    }
}
