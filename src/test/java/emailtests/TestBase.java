package emailtests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.Drivers;

/**
 * Created by root on 22.02.17.
 */

public abstract class TestBase {

    private WebDriver driver;

    public WebDriver driver(){
        return driver;
    }

    @BeforeSuite
    private void beforeSuite(){
        //driver = Drivers.getDriverByName();
    }

    @AfterSuite(alwaysRun = true)
    private void afterSuite(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }


}
