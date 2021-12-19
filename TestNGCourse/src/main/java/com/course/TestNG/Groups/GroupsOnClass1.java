package com.course.TestNG.Groups;

import org.testng.annotations.Test;
// 组测试————类分组
// 通过xml文件统一执行
@Test(groups = "stu")
public class GroupsOnClass1 {
    public void stu1(){
        System.out.println("GroupsOnClass1中的stu1运行");
    }
    public void stu2(){
        System.out.println("GroupsOnClass1中的stu2运行");
    }
}
