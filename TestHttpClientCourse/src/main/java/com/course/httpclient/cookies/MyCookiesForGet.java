package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    //工具类
    private String url;
    //ResourceBundle将配置文件的信息读取出来
    private ResourceBundle bundle;
    //用来存储cookies信息的变量
    private CookieStore store;

    //在测试方法执行前将配置文件加载出来
    @BeforeTest
    public void beforeTest(){
        //ResourceBundle对象默认识别properties文件，所以只需要写前面部分配置文件名即可
        //加载配置文件信息
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        //提取url信息
        url = bundle.getString("test.url");
    }
    //从接口中获取cookie信息并存储起来
    @Test
    public void testGetCooikes() throws IOException {
        String result;
        //地址不要写死到代码里，需要抽出来写到配置文件中（如application.properties)
        //从配置文件中 拼接测试url
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url + uri;
        //测试逻辑代码
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        //获取Cookies信息(用CookieStore存储cookie信息）
        //HttpClient方法本身是不会获取Cookies信息的，需修改为DefaultHttpClient
        //将上方测试逻辑代码中的HttpClient 变为 DefaultHttpClient
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();

        //读取cookies
        for(Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("Cookie name = "+name
                    + "; Cookie value = " + value);
        }
    }
    //
    @Test(dependsOnMethods = "testGetCooikes")
    public void testGetWithCooikes() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String AllUrl = this.url + uri;

        HttpGet get = new HttpGet(AllUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        //设置cookies信息
        client.setCookieStore(this.store);
        //访问get请求
        HttpResponse response = client.execute(get);

        //获取响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("StatusCode = " +statusCode);

        if(statusCode == 200){
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(result);
        }else
            System.out.println("接口状态码不为200，失败！");
    }
}
