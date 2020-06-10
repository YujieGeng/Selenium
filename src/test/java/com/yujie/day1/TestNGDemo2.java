package com.yujie.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @description
 * @author:yujie
 * @Created on 2020/5/28
 */
public class TestNGDemo2 {
    //校验a == a？
    @Test
    public void assertEqualTest(){
        String a = "asdf";
        String b = "asdf1";
        /*if(a.equals(b)){
            System.out.println("equal");
        }else
            System.out.println("not equal");

         */

        //该语句执行成功后才会执行下面的语句，如果失败，则后面的语句不会执行
        Assert.assertEquals(a==b, true);
        System.out.println("++++++++++++++");
    }


    @Test
    public void assertNullTest(){
        String a = null;
        Assert.assertNull(a);

        String b = "";
        Assert.assertNull(b);
    }
}
