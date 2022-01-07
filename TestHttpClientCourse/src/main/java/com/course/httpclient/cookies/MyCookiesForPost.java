package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
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
    public void testPostWithCookies() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        String AllUrl = this.url + uri;
        //声明一个方法，这个方法就是post
        HttpPost post = new HttpPost(AllUrl);

        //声明一个Client对象，用来进行方法执行
        DefaultHttpClient client = new DefaultHttpClient();

        //*添加参数(json格式）声明json对象
        JSONObject param = new JSONObject();
        param.put("name","zhangsan");
        param.put("age","18");

        //设置请求头信息 设置header
        post.setHeader("content-type","application/json");

        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        //声明一个对象来进行响应结果的存储
        String result;

        //设置cookies信息
        client.setCookieStore(this.store);

        //执行post方法
        HttpResponse response = client.execute(post);

        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //处理结果，就是判断返回结果是否符合预期
        //1.将返回的响应结果字符串转化为json对象
        JSONObject resultJson = new JSONObject(result);
        //2.获取到结果值
        String success = (String) resultJson.get("zhangsan");
        String status = (String) resultJson.get("status");
        //3.具体的判断返回结果的值
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);
    }

}

