package com.Tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodsDemo {

    @Test
    public void test1(){
        //加断言
        Assert.assertEquals(1,2);
    }

    @Test
    public void test2(){

        Assert.assertEquals(1,1);
    }

    @Test
    public void test3(){

        Assert.assertEquals("aaa","aaa" );
    }

    @Test
    public void logDemo(){
        //添加日志
        Reporter.log("这是我自己写的日志");
        throw new RuntimeException("这是我自己的运行时异常");
    }
}
