/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.sql.ResultSet;

public class Mavenproject1 {

    public static void main(String[] args) {
       SQLiteConnection conn = new SQLiteConnection();
        conn.connect();
        ResultSet rs = conn.executeQuery("SELECT * FROM employee");
        try {
            while (rs.next()) {
                System.out.println(rs.getString("First_name"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        conn.disconnect();
    }
}