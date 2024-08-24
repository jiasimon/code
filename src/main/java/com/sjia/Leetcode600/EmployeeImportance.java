package com.sjia.Leetcode600;

import java.util.*;

public class EmployeeImportance {
    // #690. Employee Importance    https://leetcode.com/problems/employee-importance/description/
    /*
    Given an integer id that represents an employee's ID, return the total importance value of this employee and all their direct and indirect subordinates.

    Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
    Output: 11

     */

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }



    public int getImportance(List<Employee> employees, int id) {
        // Map to store the id and corresponding Employee object for quick access
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }

        // Use DFS to calculate the total importance
        return dfs(id, employeeMap);
    }

    private int dfs(int id, Map<Integer, Employee> employeeMap) {
        Employee employee = employeeMap.get(id);
        int totalImportance = employee.importance;

        for (int subId : employee.subordinates) {
            totalImportance += dfs(subId, employeeMap);
        }

        return totalImportance;
    }


    public static void main(String[] args) {
        EmployeeImportance solution = new EmployeeImportance();

        // Test Case 1
        Employee e1 = new Employee(1, 5, Arrays.asList(2, 3));
        Employee e2 = new Employee(2, 3, new ArrayList<>());
        Employee e3 = new Employee(3, 3, new ArrayList<>());
        List<Employee> employees1 = Arrays.asList(e1, e2, e3);
        System.out.println("Test Case 1: " + solution.getImportance(employees1, 1)); // Expected output: 11

        // Test Case 2
        Employee e4 = new Employee(1, 10, Arrays.asList(2));
        Employee e5 = new Employee(2, 5, Arrays.asList(3));
        Employee e6 = new Employee(3, 2, new ArrayList<>());
        List<Employee> employees2 = Arrays.asList(e4, e5, e6);
        System.out.println("Test Case 2: " + solution.getImportance(employees2, 2)); // Expected output: 7

        // Test Case 3
        Employee e7 = new Employee(1, 15, Arrays.asList(2, 3));
        Employee e8 = new Employee(2, 10, Arrays.asList(4));
        Employee e9 = new Employee(3, 5, new ArrayList<>());
        Employee e10 = new Employee(4, 5, new ArrayList<>());
        List<Employee> employees3 = Arrays.asList(e7, e8, e9, e10);
        System.out.println("Test Case 3: " + solution.getImportance(employees3, 1)); // Expected output: 35
    }
}
