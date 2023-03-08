import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static constants.LocatorsConstants.*;
import static constants.MainConstants.*;
import static org.testng.Assert.assertEquals;

public class TableSortSearchTest {
    private WebDriver driver;

    @BeforeClass
    void setup () {
        ChromeOptions handlingSSL = new ChromeOptions();
        handlingSSL.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(handlingSSL);
        driver.get(LINK_SELENIUM_TABLE_SORT_SEARCH);
    }

    @Test
    void testTableSortSearch() {
        WebElement dropdown = driver.findElement(LOCATOR_SHOW_DROPDOWN);
        Select s = new Select(dropdown);
        s.selectByIndex(0);

        Employee employee = new Employee();
        List<Employee> employeeList = employee.getEmployeeList(driver, LOCATOR_TABLE, LOCATOR_NEXT_BUTTON);

        employee.printEmployeeFromList();

        assertEquals(employeeList.size(), 5, "The table must include 5 employees with age > 60 and salary <= 10000");
    }

    @AfterClass
    void cleanup () {
        driver.quit();
    }
}
