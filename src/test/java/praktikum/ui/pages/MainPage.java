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

    private final String ACTIVE_CLASS = "tab_tab_type_current__2BEPc";

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
        safeClick(bunsTab);
        wait.until(ExpectedConditions.attributeContains(
                driver.findElement(bunsTab),
                "class",
                ACTIVE_CLASS
        ));
        return this;
    }

    @Step("Click 'Sauces' tab")
    public MainPage clickSaucesTab() {
        safeClick(saucesTab);
        wait.until(ExpectedConditions.attributeContains(
                driver.findElement(saucesTab),
                "class",
                ACTIVE_CLASS
        ));
        return this;
    }

    @Step("Click 'Fillings' tab")
    public MainPage clickFillingsTab() {
        safeClick(fillingsTab);
        wait.until(ExpectedConditions.attributeContains(
                driver.findElement(fillingsTab),
                "class",
                ACTIVE_CLASS
        ));
        return this;
    }

    @Step("Is buns tab active")
    public boolean isBunsTabActive() {
        return driver.findElement(bunsTab).getAttribute("class").contains(ACTIVE_CLASS);
    }

    @Step("Is sauce tab active")
    public boolean isSaucesTabActive() {
        return driver.findElement(saucesTab).getAttribute("class").contains(ACTIVE_CLASS);
    }

    @Step("Is fillings tab active")
    public boolean isFillingsTabActive() {
        return driver.findElement(fillingsTab).getAttribute("class").contains(ACTIVE_CLASS);
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