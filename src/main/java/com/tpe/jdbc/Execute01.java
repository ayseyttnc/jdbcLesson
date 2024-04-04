package com.tpe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //!!! 1.ADIM : driver ekleme
        Class.forName("org.postgresql.Driver"); //JDK nin 7. versiyonu ile buna gerek kalmadi

        //!!! 2.ADIM : hangi DB  ,Hangi kullaniciAdi ve sifre
        Connection con =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/tbed_nt", "postgres", "postgres");

        //!!!  3.ADIM : statement nesnesi olusturuluyor
        Statement st = con.createStatement();
        System.out.println("success");

        //!!! 4.ADIM  : sorguyu olusturulmasi
        //Ornek 1: "workers" adinda bir tablo plusturup "worker_id,worker_name,salary" sutunlarini ekleyiniz.
        boolean sql1 =
                st.execute("CREATE TABLE IF NOT EXISTS workers(worker_id INT ,worker_name VARCHAR(50),salary REAL)");
        System.out.println("sql:" + sql1);
        //execute : tum sorgulari calistimak icin new kullanilir
        //       sorgunun sonucunda Result set aliniyorsa TRUE dondurur, aksi halde FALSE dondurur
        //     1) DDL (data definition language )--> FALSE (create gibi sorgular)
        //   2) DQL (data query language )--> TRUE (select gibi sorgular)
        // 3) DML (data manupulation language) --> FALSE (update ,insert gibi sorgular)
        //  genellikle DDl icin kullanilir

       // ornek 2: "workers" table ina VARCHAR(20) tipinde "city" sutununu ekleyiniz.
     //   st.execute("ALTER TABLE workers ADD COLUMN city VARCHAR(20)");

// ORNEK 3: "workers" tablosunu SCHEMAdan siliniz.
        st.execute("DROP TABLE workers");

        //!!! 5.ADIM  : kaynaklarin kapatilmasi
        st.close();
        con.close();
    }
}
