package day01_databasetesting;


import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class C03_CityTest {

    /*
connect to the database
get city names from the 'cities' table
verify that there are at least 10 city names in the city_name column
close the connection
*/
    @Test
    public void test1() throws SQLException {

        //  Database bağlan
        String url = "jdbc:postgresql://localhost:5432/myDatabase";
        String user = "tester";
        String password = "tester";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        //  'cities' tablosundan city_name al

        String sql = "select city_name from cities";
        ResultSet resultSet = statement.executeQuery(sql);


        //  city_name sütununda en az 10 tane sehir ismi olduğunu doğrulayın
        int counter = 0;
        while (resultSet.next()) {
            counter++;
        }
        System.out.println(counter);
        Assert.assertTrue(counter > 9);


        //  bağlantıyı kapat
        statement.close();
        connection.close();


    }

    @Test
    public void test() throws SQLException {

        //  Database bağlan
        String url="jdbc:postgresql://localhost:5432/myDatabase";
        String user="tester";
        String password="tester";
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();

        //  'cities' tablosundan city_name al

        String sql="select city_name from cities";
        ResultSet resultSet = statement.executeQuery(sql);


        //  city_name sütununda en az 10 tane sehir ismi olduğunu doğrulayın
        int counter=0;
        while (resultSet.next()){
            counter++;
        }
        Assert.assertTrue(counter>9);

        //  bağlantıyı kapat
        statement.close();
        connection.close();

    }

    @Test
    public void secondWay() throws SQLException {

        //  Database bağlan
        String url="jdbc:postgresql://localhost:5432/myDatabase";
        String user="tester";
        String password="tester";
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();

        //  'cities' tablosundan city_name al

        String sql="select count(city_name) from cities";
        ResultSet resultSet = statement.executeQuery(sql);

        resultSet.next();
        int actualResult = resultSet.getInt("count");




       // Assert.assertTrue(actualResult>9);
Assert.assertEquals(10,actualResult);
        statement.close();
        connection.close();

    }
}











