package com.course.TestNG;

import org.testng.annotations.Test;

// 异常测试
public class ExpectedException {
    /**
     * 什么时候会用到异常测试？
     * 在我们期望结果为某一个异常的时候
     * 比如：我们传入了某些不合法的参数，程序抛出了异常。
     */

    // 这是一个测试结果会失败的异常测试
    //期望的是抛出RuntimeException异常，但实际结果并没有抛出这个异常，因此这个用例测试结果应为失败
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }

     // 这是一个成功的异常测试
    // 期望的就是抛出这个RuntimeException异常，实际结果就是这个异常，因此这个用例测试结果应为成功
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是我的异常测试");
        throw new RuntimeException(); // 抛异常，所以后面的都不会执行
    }
}
