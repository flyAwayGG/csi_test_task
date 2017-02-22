package pageobjects;

import com.google.common.base.Function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.NoSuchElementException;
import java.util.function.Predicate;

import static java.util.concurrent.TimeUnit.*;

/**
 * Created by root on 22.02.17.
 */
public abstract class MailRuBasePage {

    private WebDriver webDriver;

    protected MailRuBasePage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver,this);
    }

    

    public void open(){
        driver().get("https://mail.ru/");
        waitForElementLoad();
    }

    protected void waitForElementLoad(WebElement element){
        new FluentWait<>(driver())
                .withTimeout(2, SECONDS)
                .pollingEvery(500,MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .until((Function<WebDriver,Boolean>) (WebDriver) -> element.isDisplayed());
    }

    protected WebDriver driver(){
        return webDriver;
    }

}
