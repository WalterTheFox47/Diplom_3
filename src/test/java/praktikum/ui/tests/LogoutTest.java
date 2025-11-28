package praktikum.ui.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.api.model.CreateUserRequest;
import praktikum.ui.pages.*;
import praktikum.ui.utils.DriverFactory;
import praktikum.ui.utils.UserApiSteps;

import static org.junit.Assert.assertTrue;

public class LogoutTest {
    private WebDriver driver;
    private Header header;
    private ProfilePage profilePage;
    private LoginPage loginPage;
    private CreateUserRequest userResponse;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        header = new Header(driver);
        profilePage = new ProfilePage(driver);
        loginPage = new LoginPage(driver);
        userResponse = UserApiSteps.createUniqueUser();
        loginUser(userResponse.email, userResponse.password);
    }

    @After
    public void tearDown() {
        if (userResponse != null) {
            UserApiSteps.deleteUser(userResponse);
        }
        if (driver != null) {
            new BasePage(driver).waitForModalToDisappear();
            driver.quit();
        }
    }

    @Test
    @DisplayName("Logout from personal account")
    public void logoutFromPersonalAccountTest() {
        driver.get("https://stellarburgers.education-services.ru/");
        header.clickPersonalAccount();
        profilePage.clickLogoutButton();
        assertTrue("Should be on login page after logout", loginPage.isLoginButtonDisplayed());
    }

    private void loginUser(String email, String password) {
        driver.get("https://stellarburgers.education-services.ru/login");
        loginPage.login(email, password);
    }
}