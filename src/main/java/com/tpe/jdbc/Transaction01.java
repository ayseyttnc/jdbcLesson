package com.tpe.jdbc;

import java.sql.*;

public class Transaction01 {
    public static void main(String[] args) throws SQLException {
        //!!! 2.ADIM : Hangi DB , Hangi kullaniciAdi ve sifre
        Connection con =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/tbed_nt", "postgres", "postgres");

        //!!! 3.ADIM : statement nesnesi olusturuluyor
        Statement st  = con.createStatement();

        st.execute("CREATE TABLE IF NOT EXISTS hesaplar(hesap_no INT UNIQUE, isim VARCHAR(50), bakiye REAL)");

        String sql1 ="INSERT INTO hesaplar VALUES(?,?,?)";
        PreparedStatement prst1 = con.prepareStatement(sql1);

        prst1.setInt(1, 12345);
        prst1.setString(2, "Fatma");
        prst1.setDouble(3, 9000);
        prst1.executeUpdate();

        prst1.setInt(1, 56789);
        prst1.setString(2, "Gokhan");
        prst1.setDouble(3, 6000);
        prst1.executeUpdate();

        // TASK : hesap no : 12345 den hesap no 56789'a 1000 birimlik para transferi gerceklestirelim
        String sql2 = "UPDATE hesaplar SET bakiye=bakiye+? WHERE hesap_no=?";
        PreparedStatement prst = con.prepareStatement(sql2);

        // 1.ADIM : Fatma hanimin bakiyesini 1000 birim azaltacagim
        prst.setInt(1, -1000);
        prst.setInt(2, 12345);
        prst.executeUpdate();


        // 2.ADIM : Gokhan beyin bakiyesini 1000 birim artiracagiz
        prst.setInt(1, 1000);
        prst.setInt(2, 56789);
        prst.executeUpdate();


        st.close();
        con.close();
    }
}

