package com.student.helper;

import java.sql.*;

/**
 *
 * @author Nil
 */
public class ConnectionProvider {
    private static Connection con;

    public static Connection getConnection() {
        try {
            if (con == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = DBUtilities.DB_URL + DBUtilities.DB_NAME;
                con = DriverManager.getConnection(url, DBUtilities.HOST_ID, DBUtilities.HOST_PASSWORD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
