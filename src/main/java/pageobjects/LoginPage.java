package pageobjects;

import org.openqa.selenium.WebDriver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import webobjects.LoginData;

/**
 * Created by root on 22.02.17.
 */
public class LoginPage extends MailRuBasePage {

    @FindBy(css ="")
    private WebElement elemForWait;

    @FindBy(css ="")
    private WebElement emailInput;

    @FindBy(css ="")
    private WebElement passInput;

    @FindBy(css="")
    private WebElement saveCredentialsCheckbox;

    @FindBy(css="")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver().get("https://mail.ru/");
        waitForElementLoad(elemForWait);
    }


    public MainEmailsPage login(LoginData loginData){
        emailInput.sendKeys(loginData.getEmail());
        passInput.sendKeys(loginData.getPassword());
        saveCredentialsCheckbox.sendKeys(loginData.getSaveCredentials());

        loginButton.click();
        return new MainEmailsPage(driver()).waitForLoad();
        // Wait for opening MainPage

    }

    public LoginPage waitForLoad(){
        return this;
    }

    public void logout(){
        throw new NotImplementedException();
    }
}
