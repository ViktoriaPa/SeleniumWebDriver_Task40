package seleniumeasyTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import static constants.LocatorsConstants.MULTISELECT;
import static constants.MainConstants.LINK_SELENIUM_DROPDOWN;
import static org.testng.Assert.assertEquals;

public class MultiselectTest {
    private WebDriver driver;
    private static final String ER_OF_TEST_MULTISELECT = "Florida";

    @BeforeMethod
    public void setup () {
        ChromeOptions handlingSSL = new ChromeOptions();
        handlingSSL.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(handlingSSL);
        driver.get(LINK_SELENIUM_DROPDOWN);
    }

    @Test
    public void testMultiselect() {
        WebElement dropdown = driver.findElement(MULTISELECT);
        Select dropdownElements = new Select(dropdown);
        dropdownElements.selectByIndex(1);
        dropdownElements.selectByIndex(2);
        dropdownElements.selectByIndex(4);

        WebElement firstSelectedOption = dropdownElements.getFirstSelectedOption();

        assertEquals(firstSelectedOption.getText(), ER_OF_TEST_MULTISELECT, "The first selected option mismatch");
    }

    @AfterMethod
    public void cleanup () {
        driver.quit();
    }
}
