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
        CreateFileUtil file1= new CreateFileUtil();
        file1.createFile("C:/Users/kai/Documents/report/ErrorReport.txt");


        String errorfileName = "C:/Users/kai/Documents/report/ErrorReport";
        try {

            BufferedWriter out = new BufferedWriter(new FileWriter(errorfileName));
            out.write("error report :");
            out.newLine();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(df.format(new Date()));
            out.write("online order test report of :" + df);
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
    public static ResultSet MenuReport(String menu) throws InterruptedException
    {

        ResultSet rs = null;
        CreateFileUtil file1= new CreateFileUtil();
        file1.createFile("C:/Users/kai/Documents/report/MenuReport.txt");


        String fileName = "C:/Users/kai/Documents/report/MenuReport.txt";
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String today=df.format(new Date());
            out.write(today+"\n");

            out.write(menu);
            out.newLine();

            System.out.println(df.format(new Date()));
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
