package com.wisdom08.dao;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) throws SQLException {
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        String url = "jdbc:mysql://localhost:3333/market_db?serverTimezone=Asia/Seoul";
        String username = "root";
        String password = "1234";
        Connection con = DriverManager.getConnection(url, username, password);

        PreparedStatement stmt = con.prepareStatement("select * from user");
        ResultSet rs = stmt.executeQuery();
        rs.next();
        String email = rs.getString("email");
        System.out.println(email);

        con.close();
    }
}
