package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @description
 * @author:yujie
 * @Created on 2020/6/4
 */
public class WindowSelectTest {
    /*
    打开测试界面
    点击open new window
    点击baidu
     */

    WebDriver webDriver = null;


    @BeforeMethod
    public void OpenBrowser(){
        System.setProperty("webdriver.gecko.driver", "/Users/yujie/IdeaProjects/Selenium/drivers/geckodriver");
        webDriver = new FirefoxDriver();
    }

    @Test
    public void testWin() throws InterruptedException{
        webDriver.get("file:///Users/yujie/Downloads/index.html");
        webDriver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);

        //获取当前页面的句柄值
        String windowHandle = webDriver.getWindowHandle();

        for(String handle:webDriver.getWindowHandles()){
            if(windowHandle.equals(handle)){
                continue;
            }else
                webDriver.switchTo().window(handle);
        }


        webDriver.findElement(By.linkText("baidu")).click();
    }


    @Test
    public void waitTest(){
        webDriver.get("file:///Users/yujie/Downloads/index.html");
        webDriver.findElement(By.xpath("/html/body/div/table/tbody/tr[13]/td[2]/div[1]/input")).click();



        //全局等待
        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //显式等待
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 30);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/table/tbody/tr[13]/td[2]/div[2]/div[1]")));



        String text = webDriver.findElement(By.xpath("/html/body/div/table/tbody/tr[13]/td[2]/div[2]/div[1]")).getText();

        Assert.assertEquals(text, "wait for display");
    }
    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }
}
