package logInTests;

import base.BaseTest;
import base.PageDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static constants.LocatorsConstants.*;
import static constants.MainConstants.*;
import static java.util.concurrent.TimeUnit.*;
import static org.testng.Assert.*;

public class LogInParameterizedTest extends BaseTest {
    @Test (dataProvider = "login")
    public void logInTest(String username, String password) {
        WebDriver driver = PageDriver.getDriver();
        driver.get(LINK_TO_MAIN_YANDEX_PAGE);
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().window().maximize();
        WebElement logInButton = driver.findElement(LOGIN_BUTTON_ON_MAIN_PAGE);
        logInButton.click();

        WebElement usernameField = driver.findElement(USERNAME_FIELD);
        usernameField.sendKeys(username);

        WebElement submitUsername = driver.findElement(LOGIN_BUTTON_ON_USERNAME_PAGE);
        submitUsername.click();

        WebElement passwordField = driver.findElement(PASSWORD_FIELD);
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(LOGIN_BUTTON_ON_PASSWORD_PAGE);
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.pollingEvery(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME));

        String actualTitle = driver.getTitle();

        assertTrue(actualTitle.contains("Inbox — Yandex Mail"),"The title must contain \"Inbox — Yandex Mail\"");
    }
    @DataProvider(name = "login")
    public Object[][] getData(){
        return new Object[][]
                {
                        {USERNAME_OF_FIRST_TEST_ACCOUNT, PASSWORD_OF_FIRST_TEST_ACCOUNT},
                        {USERNAME_OF_SECOND_TEST_ACCOUNT, PASSWORD_OF_SECOND_TEST_ACCOUNT}
                };
    }
}



