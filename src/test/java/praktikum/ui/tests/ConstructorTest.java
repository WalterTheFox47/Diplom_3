package praktikum.ui.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.ui.pages.BasePage;
import praktikum.ui.pages.MainPage;
import praktikum.ui.utils.DriverFactory;

import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        mainPage = new MainPage(driver);
        driver.get("https://stellarburgers.education-services.ru/");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            new BasePage(driver).waitForModalToDisappear();
            driver.quit();
        }
    }

    @Test
    @DisplayName("Switch to Buns tab")
    public void switchToBunsTabTest() {
        mainPage.clickBunsTab();
        assertTrue("Buns section should be visible", mainPage.isSectionVisible("Булки"));
    }

    @Test
    @DisplayName("Switch to Sauces tab")
    public void switchToSaucesTabTest() {
        mainPage.clickSaucesTab();
        assertTrue("Sauces section should be visible", mainPage.isSectionVisible("Соусы"));
    }

    @Test
    @DisplayName("Switch to Fillings tab")
    public void switchToFillingsTabTest() {
        mainPage.clickFillingsTab();
        assertTrue("Fillings section should be visible", mainPage.isSectionVisible("Начинки"));
    }
}