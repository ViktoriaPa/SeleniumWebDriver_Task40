package seleniumeasyTests;

import base.BaseTest;
import base.PageDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static constants.LocatorsConstants.*;
import static constants.MainConstants.LINK_SELENIUM_DOWNLOAD;
import static org.testng.Assert.assertEquals;

public class DownloadTest extends BaseTest {
    private static final String ER_OF_TEST_DOWNLOAD_PROGRESS = "0%";
    @Test
    public void testDownloadProgress() {
        WebDriver driver = PageDriver.getDriver();
        driver.get(LINK_SELENIUM_DOWNLOAD);

        WebElement downloadButton = driver.findElement(DOWNLOAD_PROGRESS_BUTTON);
        downloadButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(PERCENT_TEXT, "50%"));

        driver.navigate().refresh();

        WebElement percentText = driver.findElement(PERCENT_TEXT);

        assertEquals(percentText.getText(), ER_OF_TEST_DOWNLOAD_PROGRESS, "The percent mismatch");
    }
}
