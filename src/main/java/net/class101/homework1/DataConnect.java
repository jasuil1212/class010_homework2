package net.class101.homework1;

import java.sql.*;
import java.util.List;

public class DataConnect {

    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;


    DataConnect() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
    }

    public void executeQuery(String sql) throws SQLException {
        conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "", "");
        stmt = conn.createStatement();
        stmt.execute(sql);
        stmt.close();
    }

    public List<Object> fetchQuery(String sql) throws SQLException {
        conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "", "");
        stmt = conn.createStatement();
        rs = stmt.executeQuery("select * from user");
        while (rs.next()) {

            System.out.println("id " + rs.getInt("id") + " name " + rs.getString("name"));
        }
        stmt.close();

        return null;
    }

    public  void main() throws ClassNotFoundException, SQLException {


        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "", "");
        stmt = conn.createStatement();
        stmt.execute("drop table if exists user");
        stmt.execute("create table user(id int primary key, name varchar(100))");
        stmt.execute("insert into user values(1, 'hello')");
        stmt.execute("insert into user values(2, 'world')");
        rs = stmt.executeQuery("select * from user");

        while (rs.next()) {
            System.out.println("id " + rs.getInt("id") + " name " + rs.getString("name"));
        }
        stmt.close();
       // conn.close();

        conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "", "");
        stmt = conn.createStatement();

         rs = stmt.executeQuery("select * from user");

        while (rs.next()) {
            System.out.println("id " + rs.getInt("id") + " name " + rs.getString("name"));
        }
        stmt.close();
    }

    public void main2() throws SQLException {
        conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "", "");
        stmt = conn.createStatement();

        rs = stmt.executeQuery("select * from user");

        while (rs.next()) {
            System.out.println("id " + rs.getInt("id") + " name " + rs.getString("name"));
        }
        stmt.close();
    }

}
