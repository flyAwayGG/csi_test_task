package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import utils.AppException;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by root on 22.02.17.
 */
public class MainEmailsPage extends MailRuBasePage{
    public MainEmailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".b-datalist__body")
    private WebElement emailsBody;

    @FindBys({@FindBy( css=".b-datalist__body .b-datalist__item__link")})
    private List<WebElement> allEmails;

    public EmailPage openEmailByTheme(String theme){
        for(WebElement emailRow: allEmails){
            String emailSubject = emailRow.getAttribute("data-subject");
            /** If email have  */
            if (theme.equals(emailSubject)){
                emailRow.click();
                return new EmailPage(driver()).waitForLoad();
            }
        }
        throw new AppException("Email with name of theme ["+ theme +"] not found.");
    }

    public MainEmailsPage waitForLoad(){
        waitForElementLoad(emailsBody,10, TimeUnit.SECONDS);
        return this;
    }

    public void logout(){
        throw new NotImplementedException();
    }
}
