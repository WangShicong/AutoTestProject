package com.course.TestNG.Groups;

import org.testng.annotations.Test;
// 组测试————类分组，将多个类归到某个组中
// 通过xml文件统一执行
//@Test不在写在方法上，而是写在类上（即类上也可以写Test标签的，即类的测试方法）

@Test(groups = "teacher")
public class GroupsOnClass3 {

    public void teacher1(){
        System.out.println("GroupsOnClass333中的teacher1运行");
    }
    public void teacher2(){
        System.out.println("GroupsOnClass333中的teacher2运行");
    }
}
