package com.course.TestNG.Suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

//写测试套件之前需要运行的方法（一些共有的东西）
public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite运行啦");
    }
    @AfterSuite
    public void aftersuite(){
        System.out.println("aftersuite运行啦");
    }
    @BeforeTest
    public void beforetest(){
        System.out.println("BeforeTest");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("AfterTest");
    }
}
