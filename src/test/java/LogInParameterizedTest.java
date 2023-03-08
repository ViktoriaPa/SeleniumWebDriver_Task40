import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static constants.LocatorsConstants.*;
import static constants.MainConstants.*;
import static java.util.concurrent.TimeUnit.*;
import static org.testng.Assert.*;

public class LogInParameterizedTest {
    private WebDriver driver;
    @Test (dataProvider = "login")
    public void logInTest(String username, String password) {
        driver = new ChromeDriver();
        driver.get(LINK_MAIN_PAGE_YANDEX);
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().window().maximize();
        WebElement logInButton = driver.findElement(LOCATOR_LOGIN_BUTTON_ON_MAIN_PAGE);
        logInButton.click();

        WebElement usernameField = driver.findElement(LOCATOR_USERNAME_FIELD);
        usernameField.sendKeys(username);

        WebElement submitUsername = driver.findElement(LOCATOR_LOGIN_BUTTON_ON_USERNAME_PAGE);
        submitUsername.click();

        WebElement passwordField = driver.findElement(LOCATOR_PASSWORD_FIELD);
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(LOCATOR_LOGIN_BUTTON_ON_PASSWORD_PAGE);
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.pollingEvery(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOCATOR_USERNAME));

        String actualTitle = driver.getTitle();
        driver.quit();

        assertTrue(actualTitle.contains("Inbox — Yandex Mail"),"The title must contain \"Inbox — Yandex Mail\"");
    }
    @DataProvider(name = "login")
    public Object[][] getData(){
        return new Object[][]
                {
                        {USERNAME1, PASSWORD1},
                        {USERNAME2, PASSWORD2}
                };
    }
}



