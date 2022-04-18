package com.northWesternMutual.utilites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;


public class Driver_utilities{



    private Driver_utilities() {}


    private static final Logger logger = Logger.getLogger(String.valueOf(Driver_utilities.class));
    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public synchronized static WebDriver getDriver() {
        //if webdriver object doesn't exist
        //create it
        if (driverPool.get() == null) {
            //specify browser type in configuration.properties file
            String browser = ConfigurationReader.getProperty("browser").toLowerCase();
            // -Dbrowser=firefox
            if (System.getProperty("browser") != null) {
                browser = System.getProperty("browser");
            }

            logger.info("Browser :: " + browser);
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();//help us to disabllty blocking in page
                    chromeOptions.addArguments("--start-maximized");
                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;

                case "remote-chrome":
                    try {
                        URL url=new URL("");//Selenium Grid url needs to be assigned here
                        ChromeOptions chromeOptions1=new ChromeOptions();
                        driverPool.set(new RemoteWebDriver(url,chromeOptions1));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                case "chromeheadless":
                    //to run chrome without interface (headless mode)
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driverPool.set(new ChromeDriver(options));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                default:
                    //logger.error("Wrong browser name :: " + browser);
                    throw new RuntimeException("Wrong browser name :: " + browser);


            }
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}