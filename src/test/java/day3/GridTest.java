package day3;

import org.apache.tools.ant.types.selectors.SelectSelector;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @description
 * @author:yujie
 * @Created on 2020/6/9
 */
public class GridTest {

    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {
        //创建一个 DesiredCapabilities 类型
        DesiredCapabilities dc = DesiredCapabilities.chrome();

        //dc.setCapability("webdriver.chrome.driver","/Users/yujie/IdeaProjects/Selenium/drivers/chromedriver.exe");
        WebDriver webDriver = new RemoteWebDriver(new URL("http://192.168.1.6:3456/wd/hub"), dc);

        webDriver.get("http://www.baidu.com");
        Thread.sleep(3000);
        webDriver.quit();
    }

    @DataProvider(name = "data4")
    public Object[][] data(){
        return new Object[][]{
                {"firefox"},
                {"chrome"}
        };
    }

    @Test(dataProvider = "data4")
    public void testGrid2(String browser) throws InterruptedException, MalformedURLException {
        DesiredCapabilities dc = null;
        if(browser.equals("firefox")){
            dc = DesiredCapabilities.firefox();
        }else if(browser.equals("chrome")){
            dc = DesiredCapabilities.chrome();
        }else
            System.out.println("error");

        WebDriver webDriver = new RemoteWebDriver(new URL("http://192.168.1.6:3456/wd/hub"), dc);

        webDriver.get("http://www.baidu.com");
        Thread.sleep(3000);
        webDriver.quit();
    }
}
