import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static constants.LocatorsConstants.*;
import static constants.MainConstants.LINK_SELENIUM_DYNAMIC_DATA;
import static org.testng.Assert.assertTrue;

public class DynamicDataTest {
    private WebDriver driver;

    @BeforeClass
    void setup () {
        ChromeOptions handlingSSL = new ChromeOptions();
        handlingSSL.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(handlingSSL);
        driver.get(LINK_SELENIUM_DYNAMIC_DATA);
    }

    @Test
    void testDynamicData() {
        WebElement getNewUserButton = driver.findElement(LOCATOR_GET_NEW_USER_BUTTON);
        getNewUserButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.pollingEvery(Duration.ofSeconds(2));
        WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(LOCATOR_USER));

        assertTrue(user.isDisplayed(),"The user must be displayed");
    }

    @AfterClass
    void cleanup () {
        driver.quit();
    }
}
