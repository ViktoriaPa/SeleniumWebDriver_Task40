package seleniumeasyTests;

import base.BaseTest;
import base.PageDriver;
import org.Employee;
import org.Employees;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.List;

import static constants.LocatorsConstants.*;
import static constants.MainConstants.*;
import static org.testng.Assert.assertEquals;

public class TableSortSearchTest extends BaseTest {
    private static final int ER_OF_TEST_TABLE_SORT_SEARCH = 5;
    @Test
    public void testTableSortSearch() {
        WebDriver driver = PageDriver.getDriver();
        driver.get(LINK_SELENIUM_TABLE_SORT_SEARCH);

        WebElement dropdown = driver.findElement(SHOW_DROPDOWN);
        Select dropdownElements = new Select(dropdown);
        dropdownElements.selectByIndex(0);

        Employees employee = new Employees();
        List<Employee> employeeList = employee.getEmployeeList(driver, TABLE, NEXT_BUTTON);

        employee.printEmployeeFromList();

        assertEquals(employeeList.size(), ER_OF_TEST_TABLE_SORT_SEARCH, "Mismatch in the number of employees that have age > 60 and salary <= 10000");
    }
}
