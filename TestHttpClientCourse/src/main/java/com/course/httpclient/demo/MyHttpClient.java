package com.course.httpclient.demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
//学习httpclient
public class MyHttpClient {

    @Test
    public void test1() throws IOException {
        //用result存储返回结果
        String result;
        //定义get方法
        HttpGet get = new HttpGet("http://www.baidu.com");
        //用httpclient执行get方法
        HttpClient client = new DefaultHttpClient();
        //用response对象接住返回方法
        HttpResponse response = client.execute(get);
        //getEntity为获取到响应的全体的内容，并转化为字符串类型
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }
}
