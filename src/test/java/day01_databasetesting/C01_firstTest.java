package day01_databasetesting;

public class C01_firstTest {

    public static void main(String[] args) {
        String expectedData="selenium";
        String actualData="selenium";

        if (expectedData.equals(actualData)){
            System.out.println("test1 passed");
        }else {
            System.out.println("test 1 failed");
        }

    int expectedNumber=13;
    int actualNumber=7;
    if(expectedNumber==actualNumber){
                System.out.println("test 2 passed");
    }else {
            System.out.println("test 2 failed");
        }
}}
