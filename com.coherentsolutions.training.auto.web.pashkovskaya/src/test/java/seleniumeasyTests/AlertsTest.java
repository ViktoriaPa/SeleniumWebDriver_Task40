package seleniumeasyTests;

import base.BaseTest;
import base.PageDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import static constants.LocatorsConstants.*;
import static constants.MainConstants.LINK_SELENIUM_ALERT;
import static org.testng.Assert.assertEquals;

public class AlertsTest extends BaseTest {
    private static final String ER_OF_TEST_CONFIRM_BOX_ACCEPT = "You pressed OK!";
    private static final String ER_OF_TEST_CONFIRM_BOX_DISMISS = "You pressed Cancel!";
    private static final String ER_OF_TEST_ALERT_BOX_SEND_MESSAGE = "You have entered 'Vika' !";
    @Test
    public void testConfirmBoxAccept() {
        WebDriver driver = PageDriver.getDriver();
        driver.get(LINK_SELENIUM_ALERT);

        WebElement confirmBox = driver.findElement(CONFIRM_BOX);
        confirmBox.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement confirmMessage = driver.findElement(CONFIRM_BOX_MESSAGE);

        assertEquals(confirmMessage.getText(), ER_OF_TEST_CONFIRM_BOX_ACCEPT, "Confirmation message mismatch");
    }

    @Test
    public void testConfirmBoxDismiss() {
        WebDriver driver = PageDriver.getDriver();
        driver.get(LINK_SELENIUM_ALERT);

        WebElement confirmBox = driver.findElement(CONFIRM_BOX);
        confirmBox.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        WebElement confirmMessage = driver.findElement(CONFIRM_BOX_MESSAGE);

        assertEquals(confirmMessage.getText(), ER_OF_TEST_CONFIRM_BOX_DISMISS, "Confirmation message mismatch");
    }

    @Test
    public void testAlertBoxSendMessage() {
        WebDriver driver = PageDriver.getDriver();
        driver.get(LINK_SELENIUM_ALERT);

        WebElement alertBox = driver.findElement(ALERT_BOX);
        alertBox.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Vika");
        alert.accept();

        WebElement confirmMessage = driver.findElement(ALERT_BOX_MESSAGE);

        assertEquals(confirmMessage.getText(), ER_OF_TEST_ALERT_BOX_SEND_MESSAGE, "Entered message mismatch");
    }
}
