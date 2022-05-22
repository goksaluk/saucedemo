package com.sauce.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {


        private Driver() {
    }

    private static WebDriver driver;

    public static WebDriver get() {
        if (driver == null) {
            String browser = ConfigurationReadar.get("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }















//    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();
//    private Driver() {
//    }
//    public static WebDriver get() {
//        if (driverPool.get() == null) {
//            String browserParamFromEnv = System.getProperty("browser");
//            String browser = browserParamFromEnv == null ? ConfigurationReadar.get("browser") : browserParamFromEnv;
//            switch (browser) {
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    driverPool.set(new ChromeDriver());
//                    break;
//                case "chrome_headless":
//                    WebDriverManager.chromedriver().setup();
//                    driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
//                    break;
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    driverPool.set(new FirefoxDriver());
//                    break;
//                case "firefox_headless":
//                    WebDriverManager.firefoxdriver().setup();
//                    driverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
//                    break;
//                case "remote_chrome":
//                    try {
//                        ChromeOptions chromeOptions = new ChromeOptions();
//                        chromeOptions.setCapability("platform", Platform.ANY);
//                        driverPool.set(new RemoteWebDriver(new URL("http://ec2-18-212-156-23.compute-1.amazonaws.com/4444/wd/hub"), chromeOptions));
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    break;
//            }
//        }
//        return driverPool.get();
//    }
//    public static void close() {
//        driverPool.get().quit();
//        driverPool.remove();
//    }


}
