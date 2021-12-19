package com.course.TestNG;

import org.testng.annotations.Test;

//依赖测试（被依赖的方法执行失败了，则依赖的方法就会被忽略，即不执行
public class DependTest {
    //test1先执行，执行成功才能执行test2（直接运行test2时，test1也会被执行）
    @Test
    public void test1(){
        System.out.println("test1 run");
       throw new RuntimeException();
    }

    @Test(dependsOnMethods = "test1")
    public void test2(){
        System.out.println("test2 run");
    }
}
