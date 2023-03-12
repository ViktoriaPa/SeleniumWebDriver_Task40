package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private String position;
    private String office;
    List<Employee> employeeList = new ArrayList<>();

    public Employee() {
    }

    public Employee(String name, String position, String office) {
        this.name = name;
        this.position = position;
        this.office = office;
    }

    public List<Employee> getEmployeeList(WebDriver driver, By tableLocator, By nextButton) {
        while (driver.findElement(nextButton).getAttribute("class").equals("paginate_button next")) {
            List<WebElement> rows = driver.findElements(tableLocator);
            for (WebElement row : rows) {
                List<WebElement> columns = row.findElements(By.tagName("td"));
                int salary = Integer.parseInt(columns.get(5).getText().replaceAll("[^A-Za-z0-9]", "").replaceAll("y", ""));
                int age = Integer.parseInt(columns.get(3).getText());
                if (age > 60 && salary >= 10000) {
                    Employee employee = new Employee(columns.get(0).getText(), columns.get(1).getText(), columns.get(2).getText());
                    employeeList.add(employee);
                }
            }
            WebElement nextButtonForTable = driver.findElement(nextButton);
            nextButtonForTable.click();
        }
        return employeeList;
    }

    public void printEmployeeFromList() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public String toString() {
        String employeeInfo = String.format("Name: '%s', Position: '%s', Office: '%s'", name, position, office);
        return employeeInfo;
    }
}
