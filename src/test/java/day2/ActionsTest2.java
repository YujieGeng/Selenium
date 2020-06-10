package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * @description
 * @author:yujie
 * @Created on 2020/6/6
 */
public class ActionsTest2 {

    WebDriver webDriver = null;


    @BeforeMethod
    public void OpenBrowser(){
        System.setProperty("webdriver.chrome.driver","/Users/yujie/IdeaProjects/Selenium/drivers/chromedriver");
        webDriver = new ChromeDriver();
    }

    @Test
    public void rightClickTest(){
        webDriver.get("http://www.baidu.com");
        WebElement ButtonElement = webDriver.findElement(By.id("su"));

        //实例化Actions
        Actions actions = new Actions(webDriver);

        //在百度一下这个按钮上右键
        actions.contextClick(ButtonElement).perform();


    }

    @Test
    public void doubleClickTest() throws InterruptedException{
        webDriver.get("http://www.baidu.com");
        WebElement ButtonElement = webDriver.findElement(By.id("su"));

        //实例化Actions
        Actions actions = new Actions(webDriver);

        //在百度一下这个按钮上右键
        actions.doubleClick(ButtonElement).perform();



    }


    /**
     * 打开测试界面，鼠标移动到action按钮，那么显式hello world
     */

    @Test
    public void moveTo() throws InterruptedException{
        webDriver.get("file:///Users/yujie/Downloads/index.html");

        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"action\"]/input"));


        Actions actions = new Actions(webDriver);

        actions.moveToElement(element).perform();
        Thread.sleep(5000);

        String text = webDriver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();
        Assert.assertEquals(text, "Hello World!");

    }


    @Test
    public void testDragAndDrop(){
        webDriver.get("file:///Users/yujie/Downloads/dragAndDrop.html");
        WebElement element = webDriver.findElement(By.id("drag"));
        Actions builder = new Actions(webDriver);

        builder.dragAndDropBy(element, 500, 500).perform();
    }


    @Test
    public void dropTest() throws InterruptedException{
        webDriver.get("file:///Users/yujie/Downloads/dragAndDrop.html");
        WebElement element1 = webDriver.findElement(By.id("drag"));
        WebElement element2 = webDriver.findElement(By.xpath("/html/body/h1"));
        Actions actions = new Actions(webDriver);

        Thread.sleep(3000);

        actions.clickAndHold(element1) //按住元素1
                .moveToElement(element2) //移到元素2
                .release(element1).perform(); //放下元素1

        Thread.sleep(5000);
    }

    @Test
    public void multiSelectTest() throws InterruptedException{
        webDriver.get("file:///Users/yujie/Downloads/index.html");
        WebElement select = webDriver.findElement(By.id("selectWithMultipleEqualsMultiple"));

        //通过option这个标签，可以选择多个选项，故为list类型
        List<WebElement> options = select.findElements(By.tagName("option"));

        Actions actions = new Actions(webDriver);

        actions.keyDown(Keys.SHIFT) //按下shift
                .click(options.get(0))
                .click(options.get(2))
                .keyUp(Keys.SHIFT)  //按上shift
                .perform();

        Thread.sleep(5000);

    }

    @Test
    public void saveHtml() throws AWTException {
        webDriver.get("http://www.baidu.com");

        Robot robot = new Robot();

        //KeyEvent保存了每个字符的ASCII码值
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);


    }

    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }

}
