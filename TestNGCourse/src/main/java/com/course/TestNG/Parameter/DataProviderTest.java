package com.course.TestNG.Parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

// TestNG参数化测试————DataProvider参数化
public class DataProviderTest {

    //第一种
    @Test(dataProvider = "data")
    public void testDataProvider(String name,int age){
        System.out.println("name=" + name + ";  " + "age=" + age);
    }

    //将这个方法里的数据传入上面的testDataProvider中，用name和age接入
    //通过"data"找到需要传的数据
    @DataProvider(name = "data")
    public Object[][] providerData(){
        Object[][] obj= new Object[][]{
                {"zhangsan",10},
                {"lisi",20},
                {"wangwu",30}
        };
        return obj;
    }

    //第二种
    //DataProvider支持根据方法名来进行参数传递
    @Test(dataProvider = "MethodData")
    public void test1(String name,int age){
        System.out.println("test111方法的name=" +name +"; age=" +age);
    }

    @Test(dataProvider = "MethodData")
    public void test2(String name,int age){
        System.out.println("test222方法的name=" +name +"; age=" +age);
    }

    @DataProvider(name = "MethodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result = null;

        if(method.getName().equals("test1")){
            result = new Object[][]{
                    {"zhangsan",11},
                    {"lisi",22}
            };
        }else if(method.getName().equals("test2")){
            result = new Object[][]{
                    {"wangwu",55},
                    {"zhaoliu",66}
            };
        }
        return result;
    }
}
