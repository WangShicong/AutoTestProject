package com.course.TestNG.MultThread;

import org.testng.annotations.Test;

// 多线程测试————通过注解方式实现
public class MultThreadOnAnnotion {
    //invocationCount：调用次数；threadPoolSize：线程池
    @Test(invocationCount = 10,threadPoolSize = 3) // 用10个线程执行,线城池是3（线城池里面有3个线程，但不一定都会用上）
    //多线程的执行顺序无法控制（不要有跨线程的变量去关联）
    public void test(){
        System.out.println(1);
        //把线程id打印出来
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }
}
