package com.po.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * @description
 * @author:yujie
 * @Created on 2020/6/10
 */
public class LoginPage {

    //定义email文本框的定位方式
    public static By emailInput = By.name("email");

    //定义密码输入框的定位方式
    public static By pwdInput = By.name("password");

    //定义登录按钮的定位方式
    public static By loginButton = By.id("dologin");


    @Test
    public static void loginPO(WebDriver driver,String email, String pwd){
        driver.switchTo().frame("");
        driver.findElement(LoginPage.emailInput).sendKeys(email);
        driver.findElement(LoginPage.pwdInput).sendKeys(pwd);
        driver.findElement(LoginPage.loginButton).click();
    }
}
