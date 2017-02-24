package utils;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by root on 22.02.17.
 * Enum for all available drivers.
 * Contains logic of driver initialization with desired properties.
 */
public enum Drivers {

    FIREFOX("firefox") {
        public WebDriver getDriver() {
            String driverPath;
            if (SystemUtils.IS_OS_WINDOWS) {
                driverPath = "src/main/resources/drivers/geckodriver.exe";
            } else if (SystemUtils.IS_OS_LINUX) {
                driverPath = "src/main/resources/drivers/geckodriver";
            } else {
                throw new AppException("OS is not defined.");
            }
            System.setProperty("webdriver.gecko.driver", driverPath);

            FirefoxDriver driver = new FirefoxDriver();
            manageDriver(driver);
            return driver;
        }
    },
    CHROME("chrome") {
        public WebDriver getDriver() {
            String driverPath;
            if (SystemUtils.IS_OS_WINDOWS) {
                driverPath = "src/main/resources/drivers/chromedriver.exe";
            } else if (SystemUtils.IS_OS_LINUX) {
                driverPath = "src/main/resources/drivers/chromedriver";
            } else {
                throw new AppException("OS is not defined.");
            }
            System.setProperty("webdriver.chrome.driver", driverPath);

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
    }
}
