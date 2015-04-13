package com.menusifu.onlinetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by kai on 4/13/2015.
 */
public class menu
{

    public static ResultSet test() throws InterruptedException {

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
       ResultSet rs2 = null;

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://nytest.menusifu.com:8666/test-demonyc#/store");

        List<WebElement> category = driver.findElements(By.cssSelector("h4.ng-binding"));

        int k = 0;
        for (int i = 0; i < category.size(); i++) {

            System.out.println("category size():" + category.size());

            //category = driver.findElements(By.cssSelector("h4.ng-binding"));

            System.out.println("category name:" + category.get(i).getText() + "\n");

            category.get(i).click();
            //System.out.println("category name:" + category.get(i).getText() + "\n");


            List<WebElement> dise = driver.findElements(By.className("menudishname "));

            List<WebElement> item = driver.findElements(By.className("menudishprice"));


            System.out.println("dise size :" + dise.size() + "\n");
            //System.out.println("price :" + item.get(i).getText() + "\n");


            for (int j = k; j < dise.size(); j++) {

                System.out.print("===============>dishname:" + dise.get(j).getText() + "diseprice:" + item.get(j).getText() + "\n");
                System.out.print("===============>disesize" + dise.size() + "\n");
                //if(item.get(j).getText()="Null")
                item.get(j).click();
                WebElement guan = driver.findElement(By.className("fa-times"));
                guan.click();
            }
            k = dise.size();
            System.out.print("dise size is : " + dise.size() + "k is :" + k + "\n");
        }

        reporter menureport = new reporter();
        System.out.println(menureport);
        System.out.println("**************");

        System.out.println("---------------------------------------------------------------------------------------");
        driver.close();
        driver.quit();
        return rs2;
    }
}