package praktikum.ui.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver getDriver() {
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--lang=ru");
        // options.addArguments("--no-sandbox");
        // options.addArguments("--disable-dev-shm-usage");
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));

        return new FirefoxDriver(options);
    }
}