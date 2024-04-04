package com.tpe.jdbc;

import java.sql.*;

public class countries {
    public static void main(String[] args) throws SQLException {
        Connection con =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/tbed_nt", "postgres", "postgres");
        Statement st  = con.createStatement();
        st.execute("CREATE TABLE IF NOT EXISTS countries(id INT UNIQUE, country_name VARCHAR(50))");
        String sql1 ="INSERT INTO countries VALUES(?,?)";

        PreparedStatement prst1 = con.prepareStatement(sql1);
        prst1.setString(1, "Tokyo");
        prst1.setString(2, "Turkiye");
        prst1.setString(3, "Yunanistan");
        prst1.setString(4, "Azarbaycan");
        prst1.setString(5, "Hollanda");
        prst1.executeUpdate();

        st.close();
        con.close();
    }
}
