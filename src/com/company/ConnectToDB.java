package com.company;

import java.sql.*;

public class ConnectToDB {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mydb352";
        String user = "root";
        String password = "03071997";
        try {
            Connection myConn = DriverManager.getConnection(url, user, password);

            Statement stmt = myConn.createStatement();
            String q1 = "insert into mydb352.contacts  (name) values ('" + "new name" + "')";
            int x = stmt.executeUpdate(q1);
            System.out.println(x);

            String sql = "select * from mydb352.contacts";
            Statement myStmt = myConn.createStatement();
            ResultSet rs = myStmt.executeQuery(sql);
            System.out.println("working");
            while(rs.next()) {
                System.out.println("first: " + rs.getInt(1));
                System.out.println("second: " + rs.getString(2));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}



