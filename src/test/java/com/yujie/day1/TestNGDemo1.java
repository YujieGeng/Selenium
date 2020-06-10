package com.yujie.day1;

import org.testng.annotations.*;


/**
 * @description TestNG
 * @author:yujie
 * @Created on 2020/5/28
 *
 *
 * 每个test执行顺序是根据方法名的ASCII码值来定的，越小的先执行，比如a()就比b()先执行
 */
public class TestNGDemo1 {

    @BeforeTest
    public void beforeTest01(){
        System.out.println("this is before test");
    }


    @BeforeMethod
    public void beforeMethod(){
        System.out.println("this is before method");
    }
    @Test
    public void testCase1(){
        System.out.println("this is testng 1");
    }

    @Test
    public void testCase2(){
        System.out.println("this is testng 2");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("this is after method");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("this is after test");
    }
}
