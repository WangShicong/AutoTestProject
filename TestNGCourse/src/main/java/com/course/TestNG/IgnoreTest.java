package com.course.TestNG;

import org.testng.annotations.Test;

public class IgnoreTest {
    @Test
    public void ignore1(){
        System.out.println("ignore1执行！");
    }

    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2不要执行！");
    }
    @Test(enabled = true)
    public void ignore3(){
        System.out.println("ignore3要执行！");
    }
}
