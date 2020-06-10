package day4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @description
 * @author:yujie
 * @Created on 2020/6/10
 */
public class DataProviderTest {
    @DataProvider(name = "loginUser")
    public Object[][] data1(){
        return new Object[][]{
                {"user1","pwd1"},
                {"user2","pwd2"}
        };
    }


    @Test(dataProvider = "loginUser")
    public void loginTest(String user, String pwd){
        System.out.println("用户："+ user);
        System.out.println("密码："+pwd);
    }
}
