package seleniumeasyTests;

import base.BaseTest;
import base.PageDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import static constants.LocatorsConstants.MULTISELECT;
import static constants.MainConstants.LINK_SELENIUM_DROPDOWN;
import static org.testng.Assert.assertEquals;

public class MultiselectTest extends BaseTest {
    private static final String ER_OF_TEST_MULTISELECT = "Florida";
    @Test
    public void testMultiselect() {
        WebDriver driver = PageDriver.getDriver();
        driver.get(LINK_SELENIUM_DROPDOWN);

        WebElement dropdown = driver.findElement(MULTISELECT);
        Select dropdownElements = new Select(dropdown);
        dropdownElements.selectByIndex(1);
        dropdownElements.selectByIndex(2);
        dropdownElements.selectByIndex(4);

        WebElement firstSelectedOption = dropdownElements.getFirstSelectedOption();

        assertEquals(firstSelectedOption.getText(), ER_OF_TEST_MULTISELECT, "The first selected option mismatch");
    }
}
