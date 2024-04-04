package benim_calismalarim;

import org.testng.annotations.Test;

import java.sql.*;

public class Medunna_deneme {
    String url = "jdbc:postgresql://medunna.com:5432/medunna_db_v2";
    String user = "select_user";
    String password = "Medunna_pass_@6";


 @Test
    public void test2() throws SQLException {
     Connection connection=DriverManager.getConnection(url,user,password);
     Statement statement=connection.createStatement();
     ResultSet resultSet=statement.executeQuery("select * from room limit 10"
     );
     while (resultSet.next()){
         System.out.println("resultSet.getInt(\"id\") = " + resultSet.getInt("id"));
         System.out.println("resultSet.getInt(\"room_number\") = " + resultSet.getInt("room_number"));
         System.out.println("resultSet.getString(\"room_type\") = " + resultSet.getString("room_type"));
     }


 }

}
