package emailtests;

import org.testng.annotations.Test;
import pageobjects.EmailPage;
import pageobjects.LoginPage;
import pageobjects.MailRuBasePage;
import pageobjects.MainPage;

/**
 * Created by root on 22.02.17.
 */
public class FirstEmailTest extends TestBase {

    private MainPage mainPage = new MainPage(driver());
    private LoginPage loginPage = new LoginPage(driver());
    private EmailPage emailPage = new EmailPage(driver());

    @Test
    private void checkDataOfFirstEmail() {

    }
}
