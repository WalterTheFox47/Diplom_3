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

public class LoginTest {
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private Header header;
    private RegisterPage registerPage;
    private ForgotPasswordPage forgotPasswordPage;
    private CreateUserRequest userResponse;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        header = new Header(driver);
        registerPage = new RegisterPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        userResponse = UserApiSteps.createUniqueUser();
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
    @DisplayName("Login from main page button")
    public void loginFromMainPageButtonTest() {
        driver.get("https://stellarburgers.education-services.ru/");
        mainPage.clickLoginButton().login(userResponse.email, userResponse.password);
        assertTrue("Should be on main page after login", mainPage.isOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Login from personal account button")
    public void loginFromPersonalAccountButtonTest() {
        driver.get("https://stellarburgers.education-services.ru/");
        header.clickPersonalAccount();
        loginPage.login(userResponse.email, userResponse.password);
        assertTrue("Should be on main page after login", mainPage.isOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Login from registration page link")
    public void loginFromRegistrationPageLinkTest() {
        driver.get("https://stellarburgers.education-services.ru/register");
        registerPage.clickLoginLink().login(userResponse.email, userResponse.password);
        assertTrue("Should be on main page after login", mainPage.isOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Login from forgot password page link")
    public void loginFromForgotPasswordPageLinkTest() {
        driver.get("https://stellarburgers.education-services.ru/forgot-password");
        forgotPasswordPage.clickLoginLink().login(userResponse.email, userResponse.password);
        assertTrue("Should be on main page after login", mainPage.isOrderButtonDisplayed());
    }
}