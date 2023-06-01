package com.mycompany.mavenproject1;

import java.sql.ResultSet;

public class EmployeeDAO {
    SQLiteConnection conn = new SQLiteConnection();

    public EmployeeDAO() {
        try {
            conn.connect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addEmployee(Employee employee) {
        String[] values = { employee.getFirstName(), employee.getLastName(), employee.getGender(),
                String.valueOf(employee.getAge()), employee.getPhoneNumber(), employee.getDepartment() };
        try {
            conn.insertData(values);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.disconnect();
        }
    }

    public ResultSet getEmployees() {
        ResultSet rs = null;
        String query = "SELECT * FROM Employees";
        try {
            rs = conn.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public void editEmployee(Employee employee, String id) {
        String[] values = { employee.getFirstName(), employee.getLastName(), employee.getGender(),
                String.valueOf(employee.getAge()), employee.getPhoneNumber(), employee.getDepartment() };
        try {
            conn.updateData(values, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.disconnect();
        }
    }

    public void close() {
        conn.disconnect();
    }

}
