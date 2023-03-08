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
import static constants.MainConstants.LINK_SELENIUM_DOWNLOAD;
import static org.testng.Assert.assertEquals;

public class DownloadTest {
    private WebDriver driver;

    @BeforeClass
    void setup () {
        ChromeOptions handlingSSL = new ChromeOptions();
        handlingSSL.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(handlingSSL);
        driver.get(LINK_SELENIUM_DOWNLOAD);
    }

    @Test
    void testDownloadProgress() {
        WebElement downloadButton = driver.findElement(LOCATOR_DOWNLOAD_PROGRESS_BUTTON);
        downloadButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(LOCATOR_PERCENT_TEXT, "50%"));

        driver.navigate().refresh();

        WebElement percentText = driver.findElement(LOCATOR_PERCENT_TEXT);

        assertEquals(percentText.getText(), "0%", "The percent must be 0%");
    }

    @AfterClass
    void cleanup () {
        driver.quit();
    }
}
