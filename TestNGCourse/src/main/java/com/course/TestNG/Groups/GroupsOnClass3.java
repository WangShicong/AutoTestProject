package com.course.TestNG.Groups;

import org.testng.annotations.Test;
// 组测试————类分组
// 通过xml文件统一执行
@Test(groups = "teacher")
public class GroupsOnClass3 {

    public void teacher1(){
        System.out.println("GroupsOnClass333中的teacher1运行");
    }
    public void teacher2(){
        System.out.println("GroupsOnClass333中的teacher2运行");
    }
}
