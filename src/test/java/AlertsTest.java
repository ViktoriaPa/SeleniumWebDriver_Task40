import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static constants.LocatorsConstants.*;
import static constants.MainConstants.LINK_SELENIUM_ALERT;
import static org.testng.Assert.assertEquals;

public class AlertsTest {
    private WebDriver driver;

    @BeforeClass
    void setup () {
        ChromeOptions handlingSSL = new ChromeOptions();
        handlingSSL.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(handlingSSL);
        driver.get(LINK_SELENIUM_ALERT);
    }

    @Test
    void testConfirmBoxAccept() {
        WebElement confirmBox = driver.findElement(LOCATOR_CONFIRM_BOX);
        confirmBox.click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);

        alert.accept();

        WebElement confirmMessage = driver.findElement(LOCATOR_CONFIRM_BOX_MESSAGE);

        assertEquals(confirmMessage.getText(), "You pressed OK!", "The confirm message must be \"You pressed OK!\"");
    }

    @Test
    void testConfirmBoxDismiss() {
        WebElement confirmBox = driver.findElement(LOCATOR_CONFIRM_BOX);
        confirmBox.click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);

        alert.dismiss();

        WebElement confirmMessage = driver.findElement(LOCATOR_CONFIRM_BOX_MESSAGE);

        assertEquals(confirmMessage.getText(), "You pressed Cancel!", "The confirm message must be \"You pressed Cancel!\"");
    }

    @Test
    void testAlertBoxSendMessage() {
        WebElement alertBox = driver.findElement(LOCATOR_ALERT_BOX);
        alertBox.click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);

        alert.sendKeys("Vika");
        alert.accept();

        WebElement confirmMessage = driver.findElement(LOCATOR_ALERT_BOX_MESSAGE);

        assertEquals(confirmMessage.getText(), "You have entered 'Vika' !", "The entered message must be \"You have entered 'Vika' !\"");
    }

    @AfterClass
    void cleanup () {
        driver.quit();
    }
}
