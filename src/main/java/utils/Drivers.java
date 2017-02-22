package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

/**
 * Created by root on 22.02.17.
 */
public enum Drivers {

    FIREFOX("firefox") {
        public WebDriver getDriver() {

            Properties envProps = PropertyLoader.getProperties();

            String browserPath = envProps.getProperty("browser.path");
//            if(browserPath.)
//
//            FirefoxBinary fb= new FirefoxBinary();
//
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver014");
            FirefoxDriver driver;
            try {
                driver = new FirefoxDriver();
            } catch (Exception e) {
                e.printStackTrace();
                throw new AppException("Cannot create FirefoxDriver, use Firefox version 51 or more");
            }

            return new FirefoxDriver();
        }
    },
    CHROME("chrome") {
        public WebDriver getDriver() {
            return new ChromeDriver();
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

}
