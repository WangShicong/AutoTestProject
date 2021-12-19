package com.course.TestNG.Suite;

import org.testng.annotations.Test;

// 套件测试
// 通过xml文件统一执行
//测试主要的test标签下面需要的方法
public class LoginTest {
    @Test
    public void loginTaoBap(){
        System.out.println("淘宝登录成功");
    }
}
