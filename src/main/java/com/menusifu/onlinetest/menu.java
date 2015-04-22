package com.menusifu.onlinetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by kai on 4/13/2015.
 */
public class menu {

    public static void test(String s2) throws Exception {

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("diaoyongle  gmail");


        WebDriver driver = new FirefoxDriver();
        driver.navigate().to(s2);

        List<WebElement> group = driver.findElements(By.cssSelector("ul.nav-tabs"));
        List<WebElement> categorygroup = group.get(0).findElements(By.className("ng-binding"));
        System.out.println("groupname is :" + categorygroup.get(0).getTagName());
        System.out.println("groupname is :" + categorygroup.get(1).getTagName());
        System.out.println("groupname is :"+categorygroup.get(2).getTagName());
        System.out.println("groupname size :"+categorygroup.size());

        {
            List<WebElement> kk = driver.findElements(By.cssSelector("h4.ng-binding"));
            System.out.println("kk size is :" + kk.size() + "\n");
            int k;
            for (k = 0; k <6; k++) {
                System.out.println("k is: " + k);
                System.out.println("category size  " + kk.size());
                System.out.print("category name========>:" + kk.get(k).getText() + "\n");
                kk.get(k).click();
            }
            categorygroup.get(1).click();
            for (; k <7;k++) {
                System.out.println("k is: " + k);
                System.out.println("category size  " + kk.size());
                System.out.print("category name========>:" + kk.get(k).getText() + "\n");
                kk.get(k).click();
            }
            categorygroup.get(2).click();
            for (; k <11;k++) {
                System.out.println("k is: " + k);
                System.out.println("category size  " + kk.size());
                System.out.print("category name========>:" + kk.get(k).getText() + "\n");
                kk.get(k).click();
            }
            categorygroup.get(3).click();
            for (; k <18;k++) {
                System.out.println("k is: " + k);
                System.out.println("category size  " + kk.size());
                System.out.print("category name========>:" + kk.get(k).getText() + "\n");
                kk.get(k).click();
            }
            categorygroup.get(4).click();
            for (; k <21;k++) {
                System.out.println("k is: " + k);
                System.out.println("category size  " + kk.size());
                System.out.print("category name========>:" + kk.get(k).getText() + "\n");
                kk.get(k).click();
            }
            System.out.println("the restaurant has "+kk.size()+"category"+"\n");

        }
        driver.close();
    }
}