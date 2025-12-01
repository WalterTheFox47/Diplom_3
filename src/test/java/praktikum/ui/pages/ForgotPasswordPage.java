package praktikum.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {
    private final By recoverButton = By.xpath(".//button[contains(text(), 'Восстановить')]");
    private final By loginLink = By.xpath(".//a[@href='/login']");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'Login' link")
    public LoginPage clickLoginLink() {
        safeClick(loginLink);
        return new LoginPage(driver);
    }
}