package com.course.TestNG.Parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest2 {

    @Test(dataProvider = "data1")
    public void testDataProvider(String name,int age){
        System.out.println("name:" + name + ";  age:" + age);
    }

    @DataProvider(name = "data1")
    public Object[][] providerData(){
        Object[][] obj = new Object[][]{
                {"wang1",27},
                {"wang2",10},
                {"wang3",3}
        };
        return obj;
    }



}
