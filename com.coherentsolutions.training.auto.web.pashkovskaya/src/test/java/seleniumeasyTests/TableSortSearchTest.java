package seleniumeasyTests;

import org.Employee;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.List;

import static constants.LocatorsConstants.*;
import static constants.MainConstants.*;
import static org.testng.Assert.assertEquals;

public class TableSortSearchTest {
    private WebDriver driver;
    private static final int ER_OF_TEST_TABLE_SORT_SEARCH = 5;

    @BeforeMethod
    public void setup () {
        ChromeOptions handlingSSL = new ChromeOptions();
        handlingSSL.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(handlingSSL);
        driver.get(LINK_SELENIUM_TABLE_SORT_SEARCH);
    }

    @Test
    public void testTableSortSearch() {
        WebElement dropdown = driver.findElement(SHOW_DROPDOWN);
        Select dropdownElements = new Select(dropdown);
        dropdownElements.selectByIndex(0);

        Employee employee = new Employee();
        List<Employee> employeeList = employee.getEmployeeList(driver, TABLE, NEXT_BUTTON);

        employee.printEmployeeFromList();

        assertEquals(employeeList.size(), ER_OF_TEST_TABLE_SORT_SEARCH, "Mismatch in the number of employees that have age > 60 and salary <= 10000");
    }

    @AfterMethod
    public void cleanup () {
        driver.quit();
    }
}
