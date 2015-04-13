
        package com.menusifu.onlinetest;

        import org.junit.Assert;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.firefox.FirefoxDriver;

        import java.util.List;
        import java.sql.*;


public class onlineordertest {
    @Test

    public void startingTest() throws Exception {
        ResultSet rs = database.connectdase();
        do {


            ResultSet rs2 = menu.test();
            System.out.println("menu is ok");
            System.out.println("database start success");

            System.out.println("fire fox start success");
            while (rs.next()) {

                WebDriver driver = new FirefoxDriver();
                String name = rs.getString("first_name");
                driver.navigate().to("http://nytest.menusifu.com:8666/test-demonyc#/store");

                List<WebElement> category = driver.findElements(By.cssSelector("h4.ng-binding"));
                System.out.print("xxxxxxxxxxxxxxxxx==>" + "category has open"  + "\n");

                // random choose a category and random choose a dise;

                    System.out.println("category name:" + category.get(0).getText());
                    category.get(0).click();
                    Thread.sleep(3000);
                    //System.out.println("category name:" + category.get(i).getText() + "\n");
                    Thread.sleep(1000);
                    List<WebElement> dise = driver.findElements(By.className("menudishname "));
                    List<WebElement> item = driver.findElements(By.className("menudishprice"));
                    System.out.println("item name "+item.get(0).getText());

                    item.get(0).click();
                    System.out.println("iiiiiiiiiiiiiii");

                    System.out.println("dise name :" + dise.get(0).getText() + "\n");
                    System.out.println("dise price :" + item.get(0).getText() + "\n");

                    Thread.sleep(1000);


                    List<WebElement> button = driver.findElements(By.className("btn-cart"));
                    System.out.println("**** button name***** :" + button.get(0).getText() + "\n");
                    System.out.println("**** button name***** :" + button.get(1).getText() + "\n");
                    System.out.println("**** button name***** :" + button.get(2).getText() + "\n");
                    System.out.println("**** number of button***** :" + button.size() + "\n");
                    button.get(2).click();

                WebElement tolldiseinchart = driver.findElement(By.className("carttotalnumber "));
                System.out.println("****dises in the shopping cart***** :" + tolldiseinchart.getText() + "\n");
                System.out.println(tolldiseinchart.getText());

                int tollnumber = Integer.parseInt(tolldiseinchart.getText());

                    //if there are 1 dises in shopping cart ,then go to the next page
                    if (tollnumber == 1) {
                        System.out.println("222222222222222222222222222=====> checkout page");
                        System.out.println("&&&& button name&&&& :" + button.get(0).getText() + "\n");
                        System.out.println("&&&& button name&&&& :" + button.get(1).getText() + "\n");
                        System.out.println("&&&& number of button&&& :" + button.size() + "\n");
                        button.get(1).click();
                        Thread.sleep(3000);

                        WebElement firstname = driver.findElement(By.id("billing:firstname"));
                        firstname.sendKeys(rs.getString("first_name"));
                        if (rs.getString("first_name") == null) {
                            firstname.sendKeys("nofirestname");
                        } else {
                            firstname.sendKeys(rs.getString("last_name"));
                        }

                        WebElement lastname = driver.findElement(By.id("billing:lastname"));

                        if (rs.getString("last_name") == null) {
                            lastname.sendKeys("nolastname");
                        } else {
                            lastname.sendKeys(rs.getString("last_name"));
                        }

                        //WebElement company = driver.findElement(By.id("billing:company"));
                        //company.sendKeys("menusifu");

                        WebElement email = driver.findElement(By.id("billing:email"));
                        email.sendKeys("menusifu@menusifu.com");


                        WebElement address = driver.findElement(By.id("billing:street1"));
                        if (rs.getString("address1") == null) {
                            address.sendKeys("no address");
                        } else {
                            address.sendKeys(rs.getString("address1"));
                        }

                        WebElement city = driver.findElement(By.id("billing:city"));
                        if (rs.getString("city") == null) {
                            city.sendKeys("no address");
                        } else {
                            city.sendKeys(rs.getString("city"));
                        }
                        System.out.println(rs.getString("city"));

                        WebElement state = driver.findElement(By.id("billing:region_id"));

                        List<WebElement> stateoption = driver.findElements(By.tagName("option"));
                        stateoption.get(43).click();


                        WebElement zip = driver.findElement(By.id("billing:postcode"));

                        if (rs.getString("zipcode") == null) {
                            zip.sendKeys("11355");
                        } else {
                            zip.sendKeys(rs.getString("zipcode"));
                        }

                        //WebElement country = driver.findElement(By.id("billing:conuntry_id"));
                        //List<WebElement> countryus=driver.findElements(By.tagName("option"));
                        //countryus.get(1).click();
                        try {

                            Thread.sleep(2000);
                        } catch (Exception exc) {
                        }

                        WebElement phone_num = driver.findElement(By.id("billing:telephone"));
                        if (rs.getString("phone_num") == null) {
                            phone_num.sendKeys("88888888");
                        } else {
                            phone_num.sendKeys(rs.getString("phone_num"));
                        }

                        WebElement fax = driver.findElement(By.id("billing:fax"));
                        fax.sendKeys("123456789");

                        Thread.sleep(3000);


                        WebElement placeorder = driver.findElement(By.className("btn-checkout"));
                        System.out.println(placeorder.getText());

                        Thread.sleep(3000);


                        placeorder.click();
                        System.out.println("**************");
                        reporter wrongreport = new reporter();
                        System.out.println(wrongreport);
                        System.out.println("**************");


                            Thread.sleep(20000);


                        WebElement buttoncontion = driver.findElement(By.className("button"));
                        System.out.println(buttoncontion.getText());
                        buttoncontion.click();

                    }

                    driver.close();
                }


            } while (rs.next()) ;
        }
}

