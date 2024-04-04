package com.tpe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ayse {

    public static void main(String[] args) throws SQLException {
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/tbed_nt", "postgres", "postgres");
//
//        PreparedStatement preparedStatement=con.prepareStatement("INSERT INTO ogrenci VALUES (?,?,?,?,?)");
//        preparedStatement.setInt(1,4);
//        preparedStatement.setString(2,"liugfghjk");
//        preparedStatement.setString(3,"df");
//        preparedStatement.setInt(4,4);
//        preparedStatement.setInt(5,4);
//        preparedStatement.executeUpdate();

        PreparedStatement preparedStatement=con.prepareStatement("DELETE FROM ogrenci WHERE id=?");
        preparedStatement.setInt(1,4);
        int i = preparedStatement.executeUpdate();

        System.out.println("i = " + i);
    }
}
