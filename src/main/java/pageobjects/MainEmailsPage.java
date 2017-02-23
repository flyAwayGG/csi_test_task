package pageobjects;

import org.openqa.selenium.WebDriver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import utils.AppException;

/**
 * Created by root on 22.02.17.
 */
public class MainEmailsPage extends MailRuBasePage{
    public MainEmailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBys({@FindBy(css="")})
    private List<WebElement> emailsOnThisPage;

    public MainEmailsPage openAllEmails(){

    }

    public EmailPage openEmailByTheme(String theme){
        for(WebElement emailRow: emailsOnThisPage){
            /** If email have   */
            if (theme.equals(emailRow.findElement(By.cssSelector("")).getText())){
                emailRow.click();
                return new EmailPage(driver()).waitForLoad();
            }
        }
        throw new AppException("Email with name of theme ["+ theme +"] not found.");
    }

    public MainEmailsPage waitForLoad(){
        return this;
    }

    public void logout(){
        throw new NotImplementedException();
    }
}
