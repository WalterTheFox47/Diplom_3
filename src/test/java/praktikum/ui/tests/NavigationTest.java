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

public class NavigationTest {
    private WebDriver driver;
    private Header header;
    private ProfilePage profilePage;
    private MainPage mainPage;
    private LoginPage loginPage;
    private CreateUserRequest userResponse;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        header = new Header(driver);
        profilePage = new ProfilePage(driver);
        mainPage = new MainPage(driver);
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
    @DisplayName("Transition to personal account")
    public void transitionToPersonalAccountTest() {
        header.clickPersonalAccount();
        assertTrue("Should be on profile page", profilePage.isProfilePageDisplayed());
    }

    @Test
    @DisplayName("Transition from personal account to constructor via button")
    public void transitionToConstructorViaButtonTest() {
        header.clickPersonalAccount();
        header.clickConstructor();
        assertTrue("Should be on main page", mainPage.isMainPageDisplayed());
    }

    @Test
    @DisplayName("Transition from personal account to constructor via logo")
    public void transitionToConstructorViaLogoTest() {
        header.clickPersonalAccount();
        header.clickLogo();
        assertTrue("Should be on main page", mainPage.isMainPageDisplayed());
    }

    private void loginUser(String email, String password) {
        driver.get("https://stellarburgers.education-services.ru/login");
        loginPage.login(email, password);
    }
}