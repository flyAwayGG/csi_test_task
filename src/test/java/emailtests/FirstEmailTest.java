package emailtests;

import org.testng.annotations.*;
import pageobjects.EmailPage;
import pageobjects.LoginPage;
import pageobjects.MainEmailsPage;
import webobjects.EmailData;
import webobjects.LoginData;

import static org.testng.Assert.assertEquals;


/**
 * Created by root on 22.02.17.
 */
public class FirstEmailTest extends TestBase {

    private LoginPage loginPage;
    private MainEmailsPage mainEmailsPage;
    private EmailPage emailPage;

    @BeforeTest
    public void beforeTest(){
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

    @AfterTest
    public void logout(){
        emailPage.logout();
    }
}
