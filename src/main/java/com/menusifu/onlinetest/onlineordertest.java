
        package com.menusifu.onlinetest;

        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.firefox.FirefoxDriver;

        import java.sql.ResultSet;
        import java.util.List;
        import java.util.Random;

        public class onlineordertest {
            @Test

            public void startingTest(String s) throws Exception {

                menu b = new menu();
                menu.test(s);

                System.out.println("menu is ok");
                int count = 0;

                //how many times have been run;

                //do {

                    database db = new database();
                    ResultSet rs = database.connectdase();
                    System.out.println("database start success");

                    if (rs != null) {
                        while (rs.next()) {
                            System.out.println("how many times have been run:"+ count);
                            WebDriver driver = new FirefoxDriver();
                            System.out.println("fire fox start success");
                            String name = rs.getString("first_name");
                            driver.navigate().to(s);


                            //random choose a category and random choose a dise;

                            List<WebElement> group = driver.findElements(By.cssSelector("ul.nav-tabs"));
                            List<WebElement> categorygroup = group.get(0).findElements(By.className("ng-binding"));
                            System.out.println("groupname is :" + categorygroup.get(0).getTagName());
                            System.out.println("groupname is :" + categorygroup.get(1).getTagName());
                            System.out.println("groupname is :"+categorygroup.get(2).getTagName());
                            System.out.println("groupname size :" + categorygroup.size());


                                List<WebElement> kk = driver.findElements(By.cssSelector("h4.ng-binding"));
                                System.out.println("kk size is :" + kk.size() + "\n");

                                int k;
                                Random random = new Random();
                                int num = random.nextInt(5)+1;
                                System.out.println("random num is :"+num);
                                if(num==2){num=3;}
                                switch(num) {
                                    case 1:

                                        for (k = 0; k < 6; k++) {
                                        System.out.println("k is: " + k);
                                        System.out.println("category size  " + kk.size());
                                        System.out.print("category name========>:" + kk.get(k).getText() + "\n");
                                        kk.get(k).click();
                                            Thread.sleep(1000);
                                            List<WebElement> item = driver.findElements(By.className("menudishprice"));
                                            int num1 = random.nextInt(item.size());
                                            item.get(num1).click();
                                            List<WebElement> button = driver.findElements(By.className("btn-cart"));
                                            button.get(2).click();
                                            break;
                                            }
                                            break;
                                    case 2:
                                    categorygroup.get(1).click();
                                    for (k = 6; k < 7; k++) {
                                        System.out.println("k is: " + k);
                                        System.out.println("category size  " + kk.size());
                                        System.out.print("category name========>:" + kk.get(k).getText() + "\n");
                                        Thread.sleep(2000);
                                        kk.get(6).click();
                                        List<WebElement> item = driver.findElements(By.className("menudishprice"));
                                        item.get(0).click();
                                        List<WebElement> button = driver.findElements(By.className("btn-cart"));
                                        button.get(2).click();
                                        break;
                                    }break;

                                    case 3:
                                        categorygroup.get(2).click();
                                    for (k = 7; k < 11; k++) {
                                        System.out.println("k is: " + k);
                                        System.out.println("category size  " + kk.size());
                                        System.out.print("category name========>:" + kk.get(k).getText() + "\n");
                                        kk.get(k).click();
                                        Thread.sleep(1000);
                                        List<WebElement> item = driver.findElements(By.className("menudishprice"));
                                        int num1 = random.nextInt(item.size());
                                        System.out.println("************"+num1);
                                        item.get(num1).click();
                                        List<WebElement> button = driver.findElements(By.className("btn-cart"));
                                        button.get(2).click();
                                        break;

                                    } break;

                                    case 4:
                                        categorygroup.get(3).click();
                                        for (k = 11; k < 18; k++) {
                                        System.out.println("k is: " + k);
                                        System.out.println("category size  " + kk.size());
                                        System.out.print("category name========>:" + kk.get(k).getText() + "\n");
                                        kk.get(k).click();
                                        Thread.sleep(1000);
                                            List<WebElement> item = driver.findElements(By.className("menudishprice"));
                                            int num1 = random.nextInt(item.size());
                                            item.get(num1).click();
                                            List<WebElement> button = driver.findElements(By.className("btn-cart"));
                                            button.get(2).click();
                                            break;

                                    } break;

                                    case 5:
                                        categorygroup.get(4).click();
                                        for (k = 18; k < 21; k++) {
                                        System.out.println("k is: " + k);
                                        System.out.println("category size  " + kk.size());
                                        System.out.print("category name========>:" + kk.get(k).getText() + "\n");
                                        kk.get(k).click();
                                        Thread.sleep(1000);
                                            List<WebElement> item = driver.findElements(By.className("menudishprice"));
                                            int num1 = random.nextInt(item.size());
                                            item.get(num1).click();
                                            List<WebElement> button = driver.findElements(By.className("btn-cart"));
                                            button.get(2).click();
                                            break;

                                    } break;
                                }
                                System.out.println("the restaurant has "+kk.size()+"category"+"\n");



                                    //List<WebElement> button = driver.findElements(By.className("btn-cart"));

                                    WebElement tolldiseinchart = driver.findElement(By.className("carttotalnumber "));
                                    System.out.println("****dises in the shopping cart***** :" + tolldiseinchart.getText() + "\n");
                                    System.out.println(tolldiseinchart.getText());

                                    int tollnumber = Integer.parseInt(tolldiseinchart.getText());
                                    List<WebElement> button = driver.findElements(By.className("btn-cart"));
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
                                            firstname.sendKeys(rs.getString("first_name"));
                                        }

                                        WebElement lastname = driver.findElement(By.id("billing:lastname"));
                                        lastname.sendKeys(rs.getString("last_name"));
                                        if (rs.getString("last_name") == null) {
                                            lastname.sendKeys("nolastname");
                                        } else {
                                            lastname.sendKeys(rs.getString("last_name"));
                                        }

                                        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! EMAIL ADDRESS MUST BE MENUSIFU@MENUSIFU.COM//
                                        WebElement email = driver.findElement(By.id("billing:email"));
                                        email.sendKeys("menusifu@menusifu.com");
                                        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! EMAIL ADDRESS MUST BE MENUSIFU@MENUSIFU.COM//

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

                                        Thread.sleep(4000);


                                        WebElement placeorder = driver.findElement(By.className("btn-checkout"));
                                        System.out.println(placeorder.getText());

                                        Thread.sleep(3000);


                                        placeorder.click();
                                        System.out.println("**************");
                                        System.out.println("**************");

                                        Thread.sleep(20000);

                                    }

                            //如果 没有下单成功 发送邮件
                            /*WebElement errorpage= driver.findElement(By.className());

                            if(errorpage.getText()=="not in "){
                                    simplegmail mailutils = new simplegmail();
                                    simplegmail.sendMail("test", "test", "kangkai@menusifu.com", "kai233kang@hotmail.com");}*/


                                    count++;
                                    driver.close();

                                }
                            }

                        //}
                        //while (1 == 1) ;
                    }
                }
