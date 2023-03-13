package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp () {
        ChromeOptions handlingSSL = new ChromeOptions();
        handlingSSL.setAcceptInsecureCerts(true);
        handlingSSL.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(handlingSSL);

        PageDriver.setDriver(driver);
    }

    @AfterMethod
    public void cleanUp() {
        PageDriver.getDriver().quit();
    }
}
