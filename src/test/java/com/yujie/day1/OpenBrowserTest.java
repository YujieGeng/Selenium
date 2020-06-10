package com.yujie.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


/**
 * @description
 * @author:yujie
 * @Created on 2020/5/28
 *
 *
 * @BeforeTest 只会执行一次，后面所有的test都不会再去执行这个beforetest，
 * 而beforemethod会在每个test之前执行一次
 */
public class OpenBrowserTest {

    WebDriver webDriver = null;

    @Test
    public void OpenFireFox() throws InterruptedException {
        //打开浏览器
        System.setProperty("webdriver.gecko.driver", "/Users/yujie/IdeaProjects/Selenium/drivers/geckodriver");
        webDriver = new FirefoxDriver();

        //打开某个界面
        webDriver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.141.59");
        Thread.sleep(2000);

        webDriver.get("http://www.baidu.com");
        //浏览器后退
        webDriver.navigate().back();
        Thread.sleep(3000);

        //浏览器前进
        webDriver.navigate().forward();
        Thread.sleep(3000);
        //webDriver.close();
    }

    @Test
    public void OpenChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/yujie/IdeaProjects/Selenium/drivers/chromedriver");
        webDriver = new ChromeDriver();
        Thread.sleep(1000);
        //关闭当前窗口
       // webDriver.close();
        //关闭所有窗口
        // webDriver.quit();
    }


    //设置浏览器窗口大小
    @Test
    public void winTest() throws InterruptedException{
        System.setProperty("webdriver.gecko.driver", "/Users/yujie/IdeaProjects/Selenium/drivers/geckodriver");
         webDriver = new FirefoxDriver();

        Dimension dimension = new Dimension(500, 300);
        webDriver.manage().window().setSize(dimension);

        Thread.sleep(3000);
        webDriver.manage().window().maximize();

        Thread.sleep(2000);



    }


    /*
    获取当前页面URL
     */

    @Test
    public void getURL(){
        System.setProperty("webdriver.gecko.driver","/Users/yujie/IdeaProjects/Selenium/drivers/geckodriver");
          webDriver = new FirefoxDriver();

         webDriver.get("https://www.baidu.com");
        String currentUrl = webDriver.getCurrentUrl();

        System.out.println(currentUrl);

        Assert.assertEquals(currentUrl, "https://www.baidu.com/");


    }
    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }

}
