package com.menusifu.onlinetest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class reporter {

    String firstname;
    String lastname;
    String companyname;
    String email;
    String address;
    String city;
    String zipcode;
    String phonenumber;
    String faxnumber;
    String dise;
    String totalprice;
    String DeliveryMethod;
    String tips;

    public static ResultSet ErrorReport() throws InterruptedException
    {

        String fileName = "C:/menureport.txt";
        try {

            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            out.write("online order test report of  :");
            out.newLine();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//??????
            System.out.println(df.format(new Date()));// new Date()?????????
            out.write("online order test report of :" + df);
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
    public static ResultSet MenuReport() throws InterruptedException
    {

        String fileName = "C:/menureport.txt";
        try {

            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            out.write("online order test report of  :");
            out.newLine();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//??????
            System.out.println(df.format(new Date()));// new Date()?????????
            out.write("online order test report of :" + df);
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
