package org;

public class Employee {
    private String name;
    private String position;
    private String office;

    public Employee() {
    }

    public Employee(String name, String position, String office) {
        this.name = name;
        this.position = position;
        this.office = office;
    }

    @Override
    public String toString() {
        String employeeInfo = String.format("Name: '%s', Position: '%s', Office: '%s'", name, position, office);
        return employeeInfo;
    }
}
