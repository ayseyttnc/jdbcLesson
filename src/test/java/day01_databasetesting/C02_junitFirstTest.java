package day01_databasetesting;

import org.junit.Assert;
import org.testng.annotations.Test;

public class C02_junitFirstTest {

  @Test
    public void test1(){
String expectedData="JDBC";
String actualData="JDBC";
    Assert.assertEquals(expectedData,actualData);
            /*
        assertEquals(expectedData,actualData) parantez icinde belirtilen iki degerin birbirine esit olup olmadigini
        kontrol eder, Esitse test gecer, degiles test kalir
         */

  }
    @Test
    public void test2(){
Assert.assertTrue("selenium".contains("E")); // fail , kucuk e pass
                /*
        assertTrue(boolean) parantez icinde belirtilen kosulun true olup olmadigini kontrol eder, true ise
        test gecer, false ise test kalir
         */


    }

  @Test
  public void test3(){
         /*
        assertFalse(boolean) parantez icinde belirtilen kosulun false olup olmadigini kontrol eder,
        false ise test gecer, true ise test kalir
         */
    Assert.assertFalse("java".contains("e")); //pass
    Assert.assertFalse("java".contains("a")); //fail

  }
  @Test
  public void test4(){
              /*
          assertNotEquals() parantez icinde belirtilen parametreler esit degilse test gecer, esitse kalir
         */
Assert.assertNotEquals("selenium","jdbc"); //pass
    System.out.println("bu mesaj consolda gorunecek");
    Assert.assertNotEquals("selenium","selenium"); //fail
    System.out.println("bu mesaj gorulemeyecek");

  }
}
