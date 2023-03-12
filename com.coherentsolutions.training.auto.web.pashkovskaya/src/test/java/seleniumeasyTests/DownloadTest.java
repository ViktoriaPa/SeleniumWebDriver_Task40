package seleniumeasyTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static constants.LocatorsConstants.*;
import static constants.MainConstants.LINK_SELENIUM_DOWNLOAD;
import static org.testng.Assert.assertEquals;

public class DownloadTest {
    private WebDriver driver;
    private static final String ER_OF_TEST_DOWNLOAD_PROGRESS = "0%";

    @BeforeMethod
    public void setup () {
        ChromeOptions handlingSSL = new ChromeOptions();
        handlingSSL.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(handlingSSL);
        driver.get(LINK_SELENIUM_DOWNLOAD);
    }

    @Test
    public void testDownloadProgress() {
        WebElement downloadButton = driver.findElement(DOWNLOAD_PROGRESS_BUTTON);
        downloadButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(PERCENT_TEXT, "50%"));

        driver.navigate().refresh();

        WebElement percentText = driver.findElement(PERCENT_TEXT);

        assertEquals(percentText.getText(), ER_OF_TEST_DOWNLOAD_PROGRESS, "The percent mismatch");
    }

    @AfterMethod
    public void cleanup () {
        driver.quit();
    }
}
