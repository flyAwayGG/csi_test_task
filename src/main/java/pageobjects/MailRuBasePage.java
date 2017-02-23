package pageobjects;

import com.google.common.base.Function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
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


    protected void waitForElementLoad(WebElement element, int time, TimeUnit units){
        new FluentWait<>(driver())
                .withTimeout(time, units)
                .pollingEvery((int)(time/4), units)
                .ignoring(NoSuchElementException.class)
                .until((Function<WebDriver,Boolean>) (WebDriver) -> element.isDisplayed());
    }

//    abstract <? extends MailRuBasePage> waitForLoad();

    public void logout(){

    }

    protected WebDriver driver(){
        return webDriver;
    }

}
