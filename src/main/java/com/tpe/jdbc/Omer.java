package com.tpe.jdbc;

import org.testng.annotations.Test;

import java.sql.*;

public class Omer {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    Statement statement;


    public void createConnections() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tbed_nt", "postgres", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void executeUpdate(String sql) {

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Test
    public void test1(){
        createConnections();
        executeUpdate("delete from ogrenci where id = 10");
    }

    public void insertUser(int id,String firstName,String lastName,int age,int odeme)  {
        createConnections();
        try {
            preparedStatement =connection.prepareStatement("insert into ogrenci values (?,?,?,?,?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setInt(4, age);
            preparedStatement.setInt(5, odeme);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test2(){
        insertUser(3,"omer","hadi uyuyalim",0,0);
    }

}
