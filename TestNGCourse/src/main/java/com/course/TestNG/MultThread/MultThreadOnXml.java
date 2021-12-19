package com.course.TestNG.MultThread;

import org.testng.annotations.Test;

//多线程测试————通过xml文件实现
public class MultThreadOnXml {

    @Test
    public void test1(){
        System.out.printf("Thread Id: %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.printf("Thread Id: %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.printf("Thread Id: %s%n",Thread.currentThread().getId());
    }
}
