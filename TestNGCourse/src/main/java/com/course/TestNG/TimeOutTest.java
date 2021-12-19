package com.course.TestNG;

import org.testng.annotations.Test;

public class TimeOutTest {
//线程睡眠时间为2s，但线程超时时间为3s，则成功。
    @Test(timeOut = 3000) // 单位为毫秒。
    public void TestSuccess() throws InterruptedException {
        Thread.sleep(2000); //线程睡眠2s
        System.out.println("成功了");
    }

    //线程休眠时间为4s，但线程超时时间为3s，则失败。
    @Test(timeOut = 3000)
    public void TestFailed() throws InterruptedException {
        Thread.sleep(4000);// 线程休眠4s
    }
}
