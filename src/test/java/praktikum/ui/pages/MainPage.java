package praktikum.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    private final By loginButton = By.xpath(".//button[contains(text(), 'Войти в аккаунт')]");
    private final By bunsTab = By.xpath(".//span[contains(text(), 'Булки')]/parent::div");
    private final By saucesTab = By.xpath(".//span[contains(text(), 'Соусы')]/parent::div");
    private final By fillingsTab = By.xpath(".//span[contains(text(), 'Начинки')]/parent::div");
    private final By orderButton = By.xpath(".//button[contains(text(), 'Оформить заказ')]");
    private final By constructorHeader = By.xpath(".//h1[contains(text(), 'Соберите бургер')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'Login to account' button")
    public LoginPage clickLoginButton() {
        safeClick(loginButton);
        return new LoginPage(driver);
    }

    @Step("Click 'Buns' tab")
    public MainPage clickBunsTab() {
        WebElement element = driver.findElement(bunsTab);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        safeClick(bunsTab);
        return this;
    }

    @Step("Click 'Sauces' tab")
    public MainPage clickSaucesTab() {
        WebElement element = driver.findElement(saucesTab);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        safeClick(saucesTab);
        return this;
    }

    @Step("Click 'Fillings' tab")
    public MainPage clickFillingsTab() {
        WebElement element = driver.findElement(fillingsTab);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        safeClick(fillingsTab);
        return this;
    }

    @Step("Check if section '{sectionText}' is visible")
    public boolean isSectionVisible(String sectionText) {
        By sectionHeader = By.xpath("//h2[text()='" + sectionText + "']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(sectionHeader));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Step("Check if order button is displayed")
    public boolean isOrderButtonDisplayed() {
        return driver.findElement(orderButton).isDisplayed();
    }

    @Step("Check if main page is displayed")
    public boolean isMainPageDisplayed() {
        return driver.findElement(constructorHeader).isDisplayed();
    }

    public By getBunsTabLocator() { return bunsTab; }
    public By getSaucesTabLocator() { return saucesTab; }
    public By getFillingsTabLocator() { return By.xpath(".//span[contains(text(), 'Начинки')]/parent::div"); }
}