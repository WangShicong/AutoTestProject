package com.course.TestNG.Parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest2 {

    @Test
    @Parameters({"name","age"})
    public void testParameter(String name,int age){
        System.out.println("name:" + name + ";  age:" + age);
    }

}
