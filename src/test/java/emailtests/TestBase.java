package emailtests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.Drivers;
import utils.PropertyStore;

import java.util.concurrent.TimeUnit;

/**
 * Created by root on 22.02.17.
 */

public abstract class TestBase {

    private WebDriver driver;

    protected WebDriver driver(){
        return driver;
    }

    @BeforeSuite
    public void beforeSuite(){
        String browserName = PropertyStore.getInstance().getBrowserName();
        driver = Drivers.getDriverByName(browserName);

    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        driver.quit();
    }


}
