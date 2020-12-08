package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class CuiShouFindTest {

//    @BeforeTest(groups = "loginTrue",description = "测试准备工作,获取HttpClient对象")
//    public void beforeTest(){
//        TestConfig.defaultHttpClient = new DefaultHttpClient();
//        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
//        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
//        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
//        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
//        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
//    }

    @Test(groups = "CuiShouFind",description = "催收系统查询接口")
    public void loginTrue2() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase",1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

        //下边的代码为写完接口的测试代码
        String result = getResult(loginCase);
        //处理结果，就是判断返回结果是否符合预期
        if(result.contains("操作成功"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }

//    @Test(groups = "loginFailed",description = "用户登陆失败接口")
//    public void loginFalse() throws IOException {
//        SqlSession session = DatabaseUtil.getSqlSession();
//        LoginCase loginCase = session.selectOne("loginCase",2);
//        System.out.println(loginCase.toString());
//        System.out.println(TestConfig.loginUrl);
//
//        //下边的代码为写完接口的测试代码
//        String result = getResult(loginCase);
//        //处理结果，就是判断返回结果是否符合预期
//        Assert.assertEquals(loginCase.getExpected(),result);
//    }

    private String getResult(LoginCase loginCase) throws IOException {
        //下边的代码为写完接口的测试代码
        HttpPost post = new HttpPost("http://172.16.1.83:30002/api/clock/remind/list");
        //String jsonStr = "{\"pageNum\":1,\"pageSize\":20,\"order\":null,\"remindType\":\"\",\"acctNo\":\"3_18071017A3D01B97475041E58B6D0BE6F13F20A5\",\"startTime\":\"\",\"endTime\":\"\"}";
        JSONObject param = new JSONObject();
        param.put("pageNum",1);
        param.put("pageSize",20);
        param.put("order","");
        param.put("remindType","");
        param.put("acctNo","3_18071017A3D01B97475041E58B6D0BE6F13F20A5");
        param.put("startTime","");
        param.put("endTime","");
        //设置请求头信息 设置header
        post.setHeader("content-type","application/json");
        post.setHeader("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjdXJyZW50VGltZU1pbGxpcyI6IjE2MDY4NzgzNzQ1OTEiLCJleHAiOjE2MDY5MjE1NzQsImFjY291bnQiOiJhZG1pbiJ9.e-o-GYs6dVsFkT8_6sNzqZiLlZj1hJwpMKLizIFAOjA");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象来进行响应结果的存储
        String result;
        //执行post方法
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //TestConfig.store = TestConfig.defaultHttpClient.getCookieStore();
        return result;
    }


}
