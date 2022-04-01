package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RosterServiceImpl implements RosterService {

    private final int maxRosterLen = 5;
    private int rosterLength = 0;

    private final List<Employee> employeeRoster = new ArrayList<>();

//    private final Employee[] employeeRoster = new Employee[maxRosterLen];

    private int indexOf(Employee employee) {
        for (int i = 0; i < rosterLength; i++) {
            if (employeeRoster.get(i).equals(employee))
                return i;
        }
        return -1;
    }

    private String addItem(Employee employee) {
        employeeRoster.add(rosterLength++, employee);
        return employee.toString();
    }

    private void removeItem(int i) {
        employeeRoster.remove(i);
        rosterLength--;
    }

    public String findEmployee ( String firstName, String lastName ) {
        Employee employee = new Employee(firstName, lastName);
        int i = indexOf(employee);
        if ( i == -1) {
            return "Employee " + employee + " not found";
        } else
            return employeeRoster.get(i).toString();
    }

    public String addEmployee ( String firstName, String lastName ) {
        Employee employee = new Employee(firstName, lastName);
        if ( rosterLength >= maxRosterLen ) {
            return "The roster is full!";
        } else if ( indexOf(employee) >= 0 ) {
            return "Employee " + employee + " already exists.";
        } else {
            return "Employee " + addItem(employee) + " added successfully.";
        }
    }

    public String removeEmployee ( String firstName, String lastName ) {
        Employee employee = new Employee(firstName, lastName);
        int i = indexOf(employee);
        removeItem(i);
        return "Employee " + employee + " removed successfully.";
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < rosterLength; i++) {
            output +=  employeeRoster.get(i) + ",";
        }
        return String.format("{\"Employees\":[%s]}",output);
    }

}
