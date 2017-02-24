package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by root on 22.02.17.
 * Enum for all available drivers.
 * Contains logic of driver initialization with desired properties.
 */
public enum Drivers {

    FIREFOX("firefox") {
        public WebDriver getDriver() {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");

            FirefoxProfile fp = new FirefoxProfile();
            File browserFile = PropertyStore.getInstance().getBrowserFile();
            FirefoxDriver driver;

            try {
                if (browserFile != null) {
                    FirefoxBinary fb = new FirefoxBinary(browserFile);
                    driver = new FirefoxDriver(fb, fp);
                } else {
                    driver = new FirefoxDriver();
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new AppException("Cannot create FirefoxDriver, use Firefox version 51 or more");
            }

            manageDriver(driver);
            return driver;
        }
    },
    CHROME("chrome") {
        public WebDriver getDriver() {
            ChromeDriver driver = new ChromeDriver();
            manageDriver(driver);
            return driver;
        }
    };

    private String driverName;

    Drivers(String driverName) {
        this.driverName = driverName;
    }

    public abstract WebDriver getDriver();

    public static WebDriver getDriverByName(String name) {
        for (Drivers driver : Drivers.values())
            if (driver.getDriverName().equals(name))
                return driver.getDriver();

        throw new AppException("Driver with name [" + name + "] is not implemented.");
    }

    public String getDriverName() {
        return driverName;
    }

    private static void manageDriver(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
    }
}
