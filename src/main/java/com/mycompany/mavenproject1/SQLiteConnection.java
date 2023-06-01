package com.mycompany.mavenproject1;

import java.sql.*;

public class SQLiteConnection {
    private Connection conn;

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir")+"/src/main/java/com/mycompany/mavenproject1/Employee.db");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void disconnect() {
        try {
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public void insertData(String[] values) {
        try {
            StringBuilder query = new StringBuilder();
            query.append("INSERT INTO Employees (First_name, Last_name, Gender, Age, Phone_number, Department ) VALUES") ;
            query.append(" (");
            for (int i = 0; i < values.length; i++) {
                query.append("'").append(values[i]).append("'");
                if (i < values.length - 1) {
                    query.append(", ");
                }
            }
            query.append(")");

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query.toString());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void updateData(String[] values, String id) {
        try {
            Statement stmt = conn.createStatement();
            String updateQuery = "UPDATE Employees SET First_name = '" + values[0] + "', Last_name = '" + values[1] + "', Gender = '" + values[2] + "', Age = '" + values[3] + "', Phone_number = '" + values[4] + "', Department = '" + values[5] + "'  WHERE id = " + id;
            stmt.executeUpdate(updateQuery);
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
        }

