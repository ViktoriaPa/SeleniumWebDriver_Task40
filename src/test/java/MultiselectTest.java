import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static constants.LocatorsConstants.LOCATOR_MULTISELECT;
import static constants.MainConstants.LINK_SELENIUM_DROPDOWN;
import static org.testng.Assert.assertEquals;

public class MultiselectTest {
    private WebDriver driver;

    @BeforeClass
    void setup () {
        ChromeOptions handlingSSL = new ChromeOptions();
        handlingSSL.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(handlingSSL);
    }

    @Test
    void testMultiselect() {
        driver.get(LINK_SELENIUM_DROPDOWN);

        WebElement dropdown = driver.findElement(LOCATOR_MULTISELECT);
        Select s = new Select(dropdown);
        s.selectByIndex(1);
        s.selectByIndex(2);
        s.selectByIndex(4);

        List<WebElement> l = s.getAllSelectedOptions();
        for (WebElement i: l){
            System.out.println(i.getText());
        }

        WebElement f = s.getFirstSelectedOption();

        assertEquals(f.getText(), "Florida", "The first selected option must be Florida");
    }

    @AfterClass
    void cleanup () {
        driver.quit();
    }
}
