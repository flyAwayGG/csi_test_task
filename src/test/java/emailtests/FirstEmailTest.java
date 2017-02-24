package emailtests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.EmailPage;
import pageobjects.LoginPage;
import pageobjects.MainEmailsPage;
import utils.AppException;
import webobjects.EmailData;
import webobjects.LoginData;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by root on 22.02.17.
 */
public class FirstEmailTest extends TestBase {

    private LoginPage loginPage;
    private MainEmailsPage mainEmailsPage;
    private EmailPage emailPage;

    @BeforeClass
    public void beforeClass(){
        loginPage = new LoginPage(driver());
        mainEmailsPage = new MainEmailsPage(driver());
        emailPage = new EmailPage(driver());
    }

    @Test
    public void checkDataOfFirstEmail() {
        LoginData registeredMail = LoginData.builder("csi_testing","qwe123qwe")
                .build();
        EmailData expectedEmail = EmailData.builder("csi_testing@mail.ru","Test_mail_1")
                .setContent("Content\n" +
                        "\n" +
                        "\n" +
                        "--\n" +
                        "Nikita Fomichev")
                .setAuthor("Nikita Fomichev")
                .build();

        loginPage.open();
        loginPage.login(registeredMail);
        mainEmailsPage.openEmailByTheme(expectedEmail.getTheme());
        EmailData realEmail = emailPage.getEmailData();

        assertEquals(realEmail.getAuthor(),expectedEmail.getAuthor());
        assertEquals(realEmail.getTheme(),expectedEmail.getTheme());
        assertEquals(realEmail.getContent(),expectedEmail.getContent());

    }

    @AfterClass
    public void logout(){
        emailPage.logout();
    }
}
