package praktikum.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    private final By nameField = By.xpath(".//label[contains(text(), 'Имя')]/following-sibling::input");
    private final By emailField = By.xpath(".//label[contains(text(), 'Email')]/following-sibling::input");
    private final By passwordField = By.xpath(".//label[contains(text(), 'Пароль')]/following-sibling::input");
    private final By registerButton = By.xpath(".//button[contains(text(), 'Зарегистрироваться')]");
    private final By loginLink = By.xpath(".//a[@href='/login']");
    private final By errorMessage = By.xpath(".//p[contains(text(), 'Некорректный пароль')]");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Set name '{name}'")
    public RegisterPage setName(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    @Step("Set email '{email}'")
    public RegisterPage setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    @Step("Set password '{password}'")
    public RegisterPage setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    @Step("Click 'Register' button")
    public LoginPage clickRegisterButton() {
        safeClick(registerButton);
        return new LoginPage(driver);
    }

    @Step("Click 'Login' link")
    public LoginPage clickLoginLink() {
        safeClick(loginLink);
        return new LoginPage(driver);
    }

    @Step("Check if error message is displayed")
    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }
}