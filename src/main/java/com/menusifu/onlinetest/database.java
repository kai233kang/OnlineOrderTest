package com.menusifu.onlinetest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Timer;

import java.util.List;
import java.sql.*;


public class database {
    @Test
    public static ResultSet connectdase() {

        String driver = "com.mysql.jdbc.Driver";

        String url = "jdbc:mysql://localhost:22108/kpos";
        String user = "kk";
        String password = "1234";
        ResultSet rs;
        try {

            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, user, password);

            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");

            Statement statement = conn.createStatement();

            //String sql = "select a.first_name,a.last_name,a.email,b.*  from customer_info a join address_info b on a.id=b.customer_id";
            String sql = "select a.first_name,a.last_name,a.email,b.* ,c.* from customer_info a join address_info b join phone_info c on a.id=b.customer_id=c.customer_id";
            //String sql = "select first_name from customer_info";
            rs = statement.executeQuery(sql);
            System.out.println("9999999");

            /*System.out.println("-----------------");
            System.out.println("customer_info list");
            System.out.println("-----------------");
            System.out.println(" id" + "\t" + "first_name"+"\t"+"last_name"+"\t"+"email");
            System.out.println("-----------------");
            String name = null;
            String last_name = null;
            String id=null;
            /*while(rs.next()) {
                name = rs.getString("first_name");
                last_name = rs.getString("last_name");
                if(name !=null) {
                    name = new String(name.getBytes("ISO-8859-1"),"GB2312");
                }

                System.out.println(rs.getString("id")+"\t"+rs.getString("first_name") + "\t" + rs.getString("last_name") + "\t" + rs.getString("email"));
            }*/
            return rs;
            // rs.close();
            // conn.close();


        }  catch(Exception e) {

            e.printStackTrace();
        }
        return null;
    }


}