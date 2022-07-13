package com.course.TestNG.Parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

//DataProvider支持通过方法进行参数传递
//即：执行每个方法都传递相对应的参数
public class MethodDataProvider {

    @Test(dataProvider = "methoddata")
    public void methodTest1(String name,int age){
        System.out.println("methodTest1的方法~~name:" + name + ";  age:" + age);
    }

    @Test(dataProvider = "methoddata")
    public void methodTest2(String name,int age){
        System.out.println("methodTest2的方法~~name:" + name + ";  age:" + age);
    }


    @DataProvider(name = "methoddata")
    public Object[][] methodData(Method method){
        Object[][] result = null;

        if(method.getName().equals("methodTest1")){
            result = new Object[][]{
                    {"xiaowang1",10},
                    {"xiaowang2",20}
            };
        }else if(method.getName().equals("methodTest2")){
            result = new Object[][]{
                    {"dawang1",40},
                    {"dawang2",50}
            };
        }
        return result;
    }
}
