package com.example;

import java.sql.*;

public class CustomerDAO {

    private String driver;
    private String url;
    private String userName;
    private String password;

    // Setter methods for dependency injection
    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Fetch customer records
    public void selectAllRows() throws ClassNotFoundException, SQLException {

        System.out.println("Retrieving customer data..");

        // Load driver
        Class.forName(driver);

        // Establish connection
        Connection con = DriverManager.getConnection(
                url,
                userName,
                password
        );

        // Execute query
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(
                "SELECT * FROM CustomerDb.CustomerInfo"
        );

        while (rs.next()) {

            int customerId = rs.getInt(1);
            String customerName = rs.getString(2);
            double customerFees = rs.getDouble(3);
            String custAddress = rs.getString(4);

            System.out.println(
                    customerId + " "
                            + customerName + " "
                            + customerFees + " "
                            + custAddress
            );
        }

        con.close();
    }
}