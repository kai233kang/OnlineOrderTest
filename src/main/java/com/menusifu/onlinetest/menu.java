package com.menusifu.onlinetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by kai on 4/13/2015.
 */
public class menu
{

    public static void test() throws InterruptedException {

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://nytest.menusifu.com:8666/test-demonyc#/store");
        List<WebElement> group = driver.findElements(By.cssSelector("ul.nav-tabs"));
        List<WebElement> categorygroup = group.get(0).findElements(By.cssSelector("li.ng-isolate-scope"));
        System.out.println("group size is " + categorygroup.size());
        System.out.println("group name is " + categorygroup.get(0).getText());

        for (int g = 0; g < categorygroup.size(); g++) {
            List<WebElement> kk = driver.findElements(By.cssSelector("div.active"));


            for (int k = 0; k < kk.size(); k++) {
                System.out.println("k is: " + k);

                List<WebElement> category = kk.get(k).findElements(By.cssSelector("h4.ng-binding"));
                System.out.println("category size  " + category.size());
                System.out.print("category name========>:" + category.get(g).getText() + "\n");
                category.get(k).click();


                List<WebElement> kk2 = kk.get(k).findElements(By.cssSelector("td.menudishname.text-left"));

                for(int nod=0;nod<=5;nod++){
                    reporter.MenuReport(kk2.get(nod).getText());}

                System.out.println(kk2.size());
                /*for (int i = 0; i < kk2.size(); i++) {

                    System.out.println("dise name========>:" + kk2.get(i).getText() + "\n");
                    kk2.get(i).click();

                    WebElement guan = driver.findElement(By.className("fa-times"));
                    System.out.println("gunnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn :" + "\n");
                    guan.click();
                }*/


            }
        }
    }
}