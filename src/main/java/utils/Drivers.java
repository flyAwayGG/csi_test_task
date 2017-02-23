package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
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
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver014");

            File browserFile = PropertyStore.getInstance().getBrowserFile();
            FirefoxDriver driver;

            try {
                if (browserFile != null) {
                    FirefoxBinary fb = new FirefoxBinary(browserFile);
                    driver = new FirefoxDriver(fb);
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
            manageDriver(driver);
            return new ChromeDriver();
        }
    };

    private String driverName;

    private Drivers(String driverName) {
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

    private void manageDriver(WebDriver driver) {
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
    }
}
