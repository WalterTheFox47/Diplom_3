package praktikum.ui.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.ui.pages.BasePage;
import praktikum.ui.pages.LoginPage;
import praktikum.ui.pages.RegisterPage;
import praktikum.ui.utils.DriverFactory;

import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    private WebDriver driver;
    private RegisterPage registerPage;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        driver.get("https://stellarburgers.education-services.ru/register");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            new BasePage(driver).waitForModalToDisappear();
            driver.quit();
        }
    }

    @Test
    @DisplayName("Successful registration")
    public void successfulRegistrationTest() {
        registerPage.setName("TestUser");
        registerPage.setEmail("testuser" + System.currentTimeMillis() + "@yandex.ru");
        registerPage.setPassword("password123");
        registerPage.clickRegisterButton();

        assertTrue("Should be on login page after registration", loginPage.isLoginButtonDisplayed());
    }

    @Test
    @DisplayName("Error for incorrect password")
    public void incorrectPasswordErrorTest() {
        registerPage.setName("TestUser");
        registerPage.setEmail("testuser@yandex.ru");
        registerPage.setPassword("123");
        registerPage.clickRegisterButton();

        assertTrue("Error message should be displayed", registerPage.isErrorMessageDisplayed());
    }
}