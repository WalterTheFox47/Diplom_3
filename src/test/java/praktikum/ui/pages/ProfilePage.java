package praktikum.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage {
    private final By logoutButton = By.xpath(".//button[contains(@class, 'button_button_type_secondary')]");
    private final By profileLink = By.xpath(".//a[contains(@href, '/profile')]");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'Logout' button")
    public LoginPage clickLogoutButton() {
        safeClick(logoutButton);
        return new LoginPage(driver);
    }

    @Step("Wait for profile page to load")
    public void waitForProfilePageToLoad() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(profileLink));
        } catch (TimeoutException e) {
            System.err.println("Profile page did not load in time.");
            throw e;
        }
    }

    @Step("Check if profile page is displayed")
    public boolean isProfilePageDisplayed() {
        return driver.findElements(profileLink).size() > 0;
    }
}