package praktikum.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By emailField = By.xpath(".//label[contains(text(), 'Email')]/following-sibling::input");
    private final By passwordField = By.xpath(".//label[contains(text(), 'Пароль')]/following-sibling::input");
    private final By loginButton = By.xpath(".//button[contains(text(), 'Войти')]");
    private final By registerLink = By.xpath(".//a[@href='/register']");
    private final By forgotPasswordLink = By.xpath(".//a[@href='/forgot-password']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Set email '{email}'")
    public LoginPage setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    @Step("Set password '{password}'")
    public LoginPage setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    @Step("Click 'Login' button")
    public MainPage clickLoginButton() {
        safeClick(loginButton);
        return new MainPage(driver);
    }

    @Step("Click 'Register' link")
    public RegisterPage clickRegisterLink() {
        safeClick(registerLink);
        return new RegisterPage(driver);
    }

    @Step("Click 'Forgot password' link")
    public ForgotPasswordPage clickForgotPasswordLink() {
        safeClick(forgotPasswordLink);
        return new ForgotPasswordPage(driver);
    }

    @Step("Login with email '{email}' and password '{password}'")
    public MainPage login(String email, String password) {
        setEmail(email);
        setPassword(password);
        return clickLoginButton();
    }

    @Step("Check if login button is displayed")
    public boolean isLoginButtonDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }
}