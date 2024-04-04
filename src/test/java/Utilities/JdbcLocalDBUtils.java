package Utilities;

import java.sql.*;

public class JdbcLocalDBUtils {

    private static Connection connection;
    private static Statement statement;

    //sitring ler case sensetive dir.buyuk kucuk harf duyarlidir
    // connection olusturup onu kullanmak istiyorum datatype dir
    public static Connection connectToDatabase() {
        //reusable methodlar da try catch koyariz class a throws exception yaparak tekrar kullandigimizda yine hataaliriz
        String url = "jdbc:postgresql://localhost:5432/myDatabase";
        String user = "tester";
        String password = "tester";
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    /// class ismiyle kolay erisim icin static dedik
    public static Statement createStatement() {
        try {
            statement = connectToDatabase().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return statement;

    }

    public static ResultSet executeQuery(String sql) {
        ResultSet resultSet= null;
        try {
            resultSet = createStatement().executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
    public static void  closeConnection(){
        try {
            statement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
