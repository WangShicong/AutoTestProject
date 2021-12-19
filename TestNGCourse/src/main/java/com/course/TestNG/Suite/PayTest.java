package com.course.TestNG.Suite;

import org.testng.annotations.Test;
// 套件测试
// 通过xml文件统一执行
public class PayTest {
    @Test
    public void PaySuccess(){
        System.out.println("支付宝支付成功");
    }
}
