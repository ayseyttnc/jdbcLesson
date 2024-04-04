package com.tpe.jdbc;

import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {

        //!!! 2.ADIM : Hangi DB , Hangi kullaniciAdi ve sifre
        Connection con =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/tbed_nt", "postgres", "postgres");

        //!!! 3.ADIM : statement nesnesi olusturuluyor
        Statement st  = con.createStatement();
        System.out.println("success");

        //!!! 4.ADIM : sorgu olusturulmasi

        //!!!   ÖRNEK 1:id'si 5 ile 10 arasında olan ülkelerin "country_name" bilgisini listeleyiniz.
        System.out.println("----------------------- ORNEK-1 -------------------------");
        String sql1 = "SELECT country_name FROM countries WHERE id BETWEEN 5 AND 10";
        boolean query1 = st.execute(sql1);
        System.out.println("query1 : " + query1); // true


        // verileri alalim :
        ResultSet rs = st.executeQuery(sql1);
        while (rs.next()){
            System.out.println("Ulke adi : " + rs.getString("country_name"));
        }

        st.close();
        con.close();
    }
}
