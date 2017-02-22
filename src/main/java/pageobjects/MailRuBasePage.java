package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by root on 22.02.17.
 */
public abstract class MailRuBasePage {

    private WebDriver webDriver;

    protected MailRuBasePage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver,this);
    }

    protected WebDriver driver(){
        return webDriver;
    }

}
