package emailtests;

import org.testng.annotations.Test;
import pageobjects.EmailPage;
import pageobjects.LoginPage;
import pageobjects.MainEmailsPage;
import pageobjects.MainPage;
import webobjects.EmailData;
import webobjects.LoginData;

/**
 * Created by root on 22.02.17.
 */
public class FirstEmailTest extends TestBase {

    private LoginPage loginPage = new LoginPage(driver());
    private MainEmailsPage mainEmailsPage = new MainEmailsPage(driver());
    private EmailPage emailPage = new EmailPage(driver());

    @Test
    private void checkDataOfFirstEmail() {
        LoginData registeredMail = LoginData.builder("","").build();
        EmailData expectedEmail = EmailData.builder("","").setContent("").build();

        loginPage.login(registeredMail);
        mainEmailsPage.openEmailByTheme(expectedEmail.getTheme());
        EmailData realEmail = emailPage.getEmailData();

        assertEquals(realEmail.getAuthor(),expectedEmail.getAuthor());
        assertEquals(realEmail.getTheme(),expectedEmail.getTheme());
        assertEquals(realEmail.getContent(),expectedEmail.getContent());

    }

    @AfterClass
    private void logout(){
        emailPage.logout();
    }
}
