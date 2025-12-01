package praktikum.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header extends BasePage {
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By logoButton = By.className("AppHeader_header__logo__2D0X2");

    public Header(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'Personal Account' button")
    public Header clickPersonalAccount() {
        WebElement element = driver.findElement(personalAccountButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        safeClick(personalAccountButton);
        return this;
    }

    @Step("Click 'Constructor' button")
    public Header clickConstructor() {
        WebElement element = driver.findElement(constructorButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        safeClick(constructorButton);
        return this;
    }

    @Step("Click 'Stellar Burgers' logo")
    public Header clickLogo() {
        WebElement element = driver.findElement(logoButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        safeClick(logoButton);
        return this;
    }
}