
        package com.menusifu.onlinetest;

        import org.junit.Assert;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.firefox.FirefoxDriver;

        import java.util.List;
        import java.sql.*;


public class onlineordertest
{
    @Test

    public void startingTest() throws Exception {
        int kk=10;

        do{
            ResultSet rs = database.connectdase();
            System.out.println("database set up ");

            System.out.println("fire fox set up");
            while (rs.next())
            {
                WebDriver driver = new FirefoxDriver();
                String name = rs.getString("first_name");
                System.out.println("jin ru xi tong ");
                driver.navigate().to("http://nytest.menusifu.com:8666/test-demonyc#/store");

                List<WebElement> category = driver.findElements(By.cssSelector("h4.ng-binding"));
                System.out.print("xxxxxxxxxxx==>" + category.size() + "\n");
                int k = 0;
                System.out.print("*****" + k + "\n");
                for (int i = 0; i < category.size(); i++)
                {

                    System.out.println("category size():" + category.size());

                    System.out.println("$$$$$$$$$i de shi shi: "+i+"\n");
                    category = driver.findElements(By.cssSelector("h4.ng-binding"));

                    category.get(i).click();
                    System.out.println("category name:" + category.get(i).getText() + "\n");
                    Thread.sleep(5000);
                    List<WebElement> dise = driver.findElements(By.className("menudishname "));
                    List<WebElement> item = driver.findElements(By.className("menudishprice"));


                    System.out.println("dise size :" + dise.size() + "\n");
                    Thread.sleep(1000);
                    System.out.println("k de shi shi  :" + k + "\n");
                    Thread.sleep(1000);

                    WebElement tolldiseinchart = driver.findElement(By.className("carttotalnumber "));
                    System.out.println("****dise in cart***** :" + tolldiseinchart.getText() + "\n");
                    System.out.println(tolldiseinchart.getText());
                    int tollnumber = Integer.parseInt(tolldiseinchart.getText());
                    List<WebElement> button = driver.findElements(By.className("btn-cart"));


                    //if there are 3 dises in shopping cart ,go to the next page
                    if (tollnumber == 1)
                    {
                        System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
                        button.get(1).click();
                        Thread.sleep(5000);



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

                        //System.out.println();



                /*check eamil address aganin;
                WebElement wrongemail = driver.findElement(By.id("advice-validate-email-billing:email"));
                System.out.println("test stop ,please enter a valid eamill address "+wrongemail.getText());
                email.sendKeys(rs.getString("menusifu@menusifu.com"));*
                try {
                    Thread.sleep(10000);
                } catch (Exception exc) {
                }*/ try {

                        Thread.sleep(3000);
                    } catch (Exception exc) {
                    }

                        WebElement placeorder = driver.findElement(By.className("btn-checkout"));
                        System.out.println(placeorder.getText());
                        try {

                            Thread.sleep(3000);
                        } catch (Exception exc) {
                        }



                        placeorder.click();
                        System.out.println("**************");
                        reporter wrongreport = new reporter();
                        System.out.println(wrongreport);
                        System.out.println("**************");
                        try {

                            Thread.sleep(20000);
                        } catch (Exception exc) {
                        }


                        WebElement buttoncontion = driver.findElement(By.className("button"));
                        System.out.println(buttoncontion.getText());
                        buttoncontion.click();




                    }
                    else
                    {

                        for (int j = k; j < dise.size(); j++) {
                            System.out.print("dishname:" + dise.get(j).getText() + "\n");

                            Thread.sleep(1000);

                            item.get(j).click();
                            System.out.println("iiiiiiiiiiiiiii");
                            if (j == k) {
                                Thread.sleep(1000);
                                button = driver.findElements(By.className("btn-cart"));
                                System.out.println("**** number of button***** :" + button.size() + "\n");

                                System.out.println("**** clearn button***** :" + button.get(0).getText() + "\n");

                                System.out.println("**** checkoutbutton***** :" + button.get(1).getText() + "\n");
                                System.out.println("**** add to cart ***** :" + button.get(2).getText() + "\n");

                                button.get(2).click();

                                Thread.sleep(3000);
                            }

                            int buttonsize = button.size();
                            if (j != k) {

                                Thread.sleep(2000);
                                WebElement guan = driver.findElement(By.className("fa-times"));
                                guan.click();
                            }
                            // x dian diao hou  cha kan total shifou wei 3 ruguo bushi jixuxunhuan


                            Thread.sleep(2000);

                            k = dise.size();
                            System.out.print("after 1 time: " + dise.size() + "k is :" + k + "\n");

                        }

                    }
                }

                /*for (int j = 0; j < dise.size(); j++) {
                    System.out.println("****************");
                    System.out.println("number of item:" + dise.size());
                    System.out.println("j  is " + j);
                    if(dise.get(j).getText()!=null){
                    dise.get(j).click();}
                    if (dise.get(1).getText().indexOf("$") != -1) {
                        System.out.print(dise.get(1).getText());
                        dise.get(1).click();
                        System.out.println("&&&&&&&&");
                    }*/


                System.out.println("fffffffff");
                Thread.sleep(3000);
                System.out.println("ggggggg");


                Thread.sleep(3000);

                driver.close();
            }


        }while(kk==10);
    }
}


