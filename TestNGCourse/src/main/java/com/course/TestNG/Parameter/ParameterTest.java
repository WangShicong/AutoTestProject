package com.course.TestNG.Parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

// TestNG参数化测试————xml文件参数化
// 通过xml文件来执行
public class ParameterTest {

    @Test
    @Parameters({"name","age"}) // 接收两个参数
    public void paramTest1(String name,int age){

        System.out.println("name=" + name + ";  " + "age=" + age);
    }
}
