package com.yujie.day1;

//import org.apache.tools.ant.util.FileUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

/**
 * @description
 * @author:yujie
 * @Created on 2020/5/29
 */
public class FindElementsTest{
    /*
    打开百度页面
    定位搜索文本框

     */

    WebDriver webDriver = null;


    @BeforeMethod
    public void OpenBrowser(){
        System.setProperty("webdriver.gecko.driver", "/Users/yujie/IdeaProjects/Selenium/drivers/geckodriver");
        webDriver = new FirefoxDriver();
    }

    @Test
    public void byIDTest(){
        webDriver.get("http://www.baidu.com");
        WebElement kw = webDriver.findElement(By.id("wrapper"));
        System.out.println(kw.getText());
    }

    @Test
    public void byNameTest(){
        webDriver.get("http://www.baidu.com");
        WebElement kw = webDriver.findElement(By.name("referrer"));
    }

    @Test
    public void byClassTest(){
        webDriver.get("http://www.baidu.com");
        WebElement kw = webDriver.findElement(By.className(" s-manhattan-index"));
    }

    @Test
    public void byLinkTextTest(){
        webDriver.get("http://news.baidu.com/");
        WebElement kw = webDriver.findElement(By.linkText("搜索"));
    }

    @Test
    public void byTagNameTest(){
        webDriver.get("http://news.baidu.com/");
        List<WebElement> input = webDriver.findElements(By.tagName("input"));
    }

    @Test
    public void byXPathTest(){
        webDriver.get("http://news.baidu.com/");
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"goTop\"]"));
    }

    @Test
    public void byCssTest(){
        webDriver.get("http://news.baidu.com/");
        WebElement element = webDriver.findElement(By.cssSelector("li.item:nth-child(1)"));
    }


    @Test
    public void sendKeysTest() throws InterruptedException{

        //打开百度页面
        webDriver.get("http://www.baidu.com");

        //定位百度搜索框
        WebElement kw = webDriver.findElement(By.id("kw"));

        //在搜索框输入selenium
        kw.sendKeys("selenium");

        //定位百度按钮
        WebElement su = webDriver.findElement(By.id("su"));

        //点击这个按钮
        su.click();

        //笨办法，休眠一会，等待页面加载完
        Thread.sleep(3000);

        //获取页面的title
        String title = webDriver.getTitle();

        //判断获取的title是不是和预想的一样
        Assert.assertEquals(title, "selenium_百度搜索");

    }

    @Test
    public void getTextTest(){
        webDriver.get("http://www.baidu.com");

       // WebElement kw = webDriver.findElement(By.id("kw"));

       // kw.sendKeys("selenium");

        //String text = kw.getText();//获得的是标签中间的值<a>值</a>

        String tj_trnews = webDriver.findElement(By.id("tj_trnews")).getText();
        Assert.assertEquals(tj_trnews, "新闻");

    }

    @Test
    public void getTagNameTest(){
        webDriver.get("http://www.baidu.com");
        String kw = webDriver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(kw, "input");
    }

    @Test
    public void getAttributeTest(){
        webDriver.get("http://www.baidu.com");

        //找到百度一下这个按钮
        String attribute = webDriver.findElement(By.id("su")).getAttribute("value");

        Assert.assertEquals(attribute, "百度一下");
    }

    @Test
    public void isDisplayedTest(){
        webDriver.get("http://www.baidu.com");

        //找到百度一下这个按钮,判断这个按钮是否能正常展示
        boolean su = webDriver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(su);
    }



    //截图
    @Test
    public void screenShotTest(){
        webDriver.get("http://www.baidu.com");
        File screenshotFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFile(screenshotFile ,new File("/Users/yujie/Desktop/截图测试.jpg"));

        }catch (Exception e){
            e.printStackTrace();
        }

    }




    //打开UI自动化测试界面，点击alert按钮，在alert警告框点击确定按钮
    @Test
    public void alertTest() throws InterruptedException{
        webDriver.get("file:///Users/yujie/Downloads/index.html");
        webDriver.findElement(By.className("alert")).click();
        Thread.sleep(3000);
        //把控制权转交给alert
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
    }


    @Test
    public void confirmTest() throws InterruptedException{
        webDriver.get("file:///Users/yujie/Downloads/index.html");
        webDriver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        //控制权转交
        Alert alert = webDriver.switchTo().alert();
        //弹窗点击取消
        alert.dismiss();
        Thread.sleep(3000);
        //弹窗点击确定
        alert.accept();
    }


    @Test
    public void promptTest() throws InterruptedException{
        webDriver.get("file:///Users/yujie/Downloads/index.html");
        webDriver.findElement(By.className("prompt")).click();

        Alert alert = webDriver.switchTo().alert();
        alert.sendKeys("this is prompt");

        Thread.sleep(2000);
        alert.accept();

        Thread.sleep(3000);
        alert.accept();
    }

    @Test
    public void iframeTest() throws InterruptedException {
        webDriver.get("file:///Users/yujie/Downloads/index.html");
        //option 1， 通过ID或者name转移控制权
        //webDriver.switchTo().frame("aa");

        //option 2 通过WebElement
        WebElement iframe = webDriver.findElement(By.tagName("iframe"));
        webDriver.switchTo().frame(iframe);
        webDriver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);

        //再把控制权交回给默认content
        webDriver.switchTo().defaultContent();
        webDriver.findElement(By.linkText("登陆界面")).click();
    }

    @Test
    public void selectTest() throws  InterruptedException{
        webDriver.get("file:///Users/yujie/Downloads/index.html");
        WebElement wb = webDriver.findElement(By.id("moreSelect"));

        //实例化elect类
        Select select = new Select(wb);

        //通过idnex
        select.selectByIndex(2);
        Thread.sleep(3000);
        //通过value
        select.selectByValue("huawei");
        Thread.sleep(2000);
        //通过下拉框可见的文本
        select.selectByVisibleText("iphone");


    }


    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }
}
