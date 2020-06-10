package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @description
 * @author:yujie
 * @Created on 2020/6/9
 */
public class RegisterTest {

    WebDriver webDriver = null;
   @BeforeMethod
   public void openBrowser(){
       System.setProperty("webdriver.chrome.driver","/Users/yujie/IdeaProjects/Selenium/drivers/chromedriver");
       webDriver = new ChromeDriver();


       webDriver.get("https://mail.163.com/");
   }

   @Test
   public void regTest() throws InterruptedException {
       WebElement reg = webDriver.findElement(By.xpath("//*[@id=\"normalLoginTab\"]/div[1]/div[2]/a[1]"));
       reg.click();

       //current page
       String windowHandle = webDriver.getWindowHandle();
        //  switch to the new page
       for(String handle:webDriver.getWindowHandles()){
           if(handle.equals(windowHandle)){
               continue;
           }else{
               webDriver.switchTo().window(handle);
           }
       }


       webDriver.findElement(By.id("username")).sendKeys("vcdvda3cs3");
       webDriver.findElement(By.id("password")).sendKeys("AsAs123ASdd");
       webDriver.findElement(By.id("phone")).sendKeys("18587886888");


       //立即注册
       WebElement button = webDriver.findElement(By.linkText("立即注册"));
       button.click();


       //勾选同意

       WebDriverWait webDriverWait1 = new WebDriverWait(webDriver, 3000);
       webDriverWait1.until(ExpectedConditions.presenceOfElementLocated(
               By.xpath("/html/body/div[2]/div/div/div[2]/div[4]/span"))).click();


   }



   @AfterMethod
    public void closeBrowser() throws InterruptedException {
       Thread.sleep(5000);
       webDriver.quit();
   }

}
