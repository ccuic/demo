package com.course.IVR;

import com.course.config.TestConfig;
import com.course.model.IVR_API;
import com.course.utils.ConfigFile;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

//5.4智能 ivr 发送短信  调用地址： /ivr/sendSms
public class I54sendSms {
    private String url;
    @BeforeTest(groups = "loginTrue",description = "测试准备工作,获取Authorization对象")
    public void beforeTest(){
        TestConfig.strIVR_URL = ConfigFile.getProp(IVR_API.IVR_URL);
        String jiekou_url="/ivr/sendSms";
        url= TestConfig.strIVR_URL+jiekou_url;
    }
    //type=email
    @Test(groups = "I54sendSms")//合法数据，type=email
    public void s1() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"13810381202\",\"type\":\"email\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I54sendSms")//合法数据，type=bankCard
    public void s2() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"13810381202\",\"type\":\"bankCard\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I54sendSms")//合法数据，type=repay
    public void s3() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"13810381202\",\"type\":\"repay\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I54sendSms")//合法数据，type=cancel
    public void s4() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"13810381202\",\"type\":\"cancel\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I54sendSms")//sign非法  正确为 1d1cfe35bb3df977223bf934e5a1ef08
    public void f1() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"14587385111\",\"type\":\"email\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"6af9ced89dde03633d2d20d79c734a05\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("签名校验失败"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I54sendSms")//sign为空串
    public void f2() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"14587385111\",\"type\":\"email\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("签名校验失败"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I54sendSms")//没有sign
    public void f3() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"14587385111\",\"type\":\"email\"},\"appid\":\"kg1u9xn5gdrtolfq\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("签名校验失败"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I54sendSms")//appid非法 正确值为 kg1u9xn5gdrtolfq
    public void f4() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"14587385111\",\"type\":\"email\"},\"appid\":\"kg1u9xn5gdrtolf1\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I54sendSms")//appid为空串
    public void f5() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"14587385111\",\"type\":\"email\"},\"appid\":\"\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I54sendSms")//没有appid参数
    public void f6() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"14587385111\",\"type\":\"email\"},\"sign\":\"\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I54sendSms")//businessLine 为空串
    public void f7() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"\",\"mobile\":\"14587385111\",\"type\":\"email\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I54sendSms")//无businessLine 参数
    public void f8() throws IOException {
        String number = "{\"param\":{\"mobile\":\"14587385111\",\"type\":\"email\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I54sendSms")//businessLine非法  正确为haohuan
    public void f9() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan2\",\"mobile\":\"14587385111\",\"type\":\"email\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I54sendSms")// mobile非法
    public void f10() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"14587385111aa\",\"type\":\"email\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I54sendSms")// mobile为空串
    public void f11() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"\",\"type\":\"email\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I54sendSms")// 没有mobile参数
    public void f12() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"type\":\"email\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I54sendSms")// type非法  正确为 email
    public void f13() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"14587385111aa\",\"type\":\"email2\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I54sendSms")// type为空串
    public void f14() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"\",\"type\":\"\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I54sendSms")// 没有type参数
    public void f15() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
}
