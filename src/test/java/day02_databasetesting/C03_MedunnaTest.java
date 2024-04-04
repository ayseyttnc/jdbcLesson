package day02_databasetesting;

import Utilities.JdbcMedunnaDBUtils;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class C03_MedunnaTest {
    @Test
    public void medunnaTest() throws SQLException {

        //    Kullanıcı veritabanına bağlanır
        //    (Host name: medunna.com, Database name: medunna_db_v2, Username: select_user, Password: Medunna_pass_@6)
        //    Kullanıcı, oluşturulan odayı getirmek için room_number ile sorgu gönderir
        //    Kullanıcı, oda bilgilerinin doğru kaydedildiğini doğrular
        //    Kullanıcı, bağlantıyı kapatır



    //1) Expected Datalar düzenlenir
    String expectedRoomType = "TWIN";
    boolean expectedStatus = true;
    String expectedDecription = "batch 231 icin olusturuldu";


    //2) Database den gerekli query ile datalar cekilir
    ResultSet resultSet = JdbcMedunnaDBUtils.executeQuery("select * from room where room_number = 19191314");
        resultSet.next();


    //3) Actual Datalar düzenlenir
    String actualRoomType = resultSet.getString("room_type");
    boolean actualStatus = resultSet.getBoolean("status");
    String actualDescription = resultSet.getString("description");


    //4) Assetionlar yapilir
        Assert.assertEquals(expectedRoomType,actualRoomType);
        Assert.assertEquals(expectedStatus,actualStatus);
        Assert.assertEquals(expectedDecription,actualDescription);

}

    @Test
    public void medunnaTest2() throws SQLException {

        ResultSet resultSet = JdbcMedunnaDBUtils.executeQuery("select * from room where room_number = 19191314");
        resultSet.next();

        Assert.assertEquals("TWIN",resultSet.getString("room_type"));
        Assert.assertTrue(resultSet.getBoolean("status"));
        Assert.assertEquals("batch 231 icin olusturuldu", resultSet.getString("description"));

    }




}







