package com.course.IVR;

import com.course.config.TestConfig;
import com.course.model.IVR_API;
import com.course.utils.ConfigFile;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

//5.5 最新还款信息查询接口，调用地址： /info/ivr/repayInfo
public class I55repayInfo {
    private String url;
    @BeforeTest(groups = "loginTrue",description = "测试准备工作,获取Authorization对象")
    public void beforeTest(){
        TestConfig.strIVR_URL = ConfigFile.getProp(IVR_API.IVR_URL);
        String jiekou_url="/info/ivr/repayInfo";
        url= TestConfig.strIVR_URL+jiekou_url;
    }
    @Test(groups = "I55repayInfo")//合法数据，result=1代收成功
    public void s1() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"13810381202\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I55repayInfo")//result=2代收失败，failCode=1原因是“余额不足”
    public void s2() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"13810381202\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I55repayInfo")//result=2代收失败，failCode=1原因不是“余额不足”
    public void s3() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"13810381202\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I55repayInfo")//result=3中间态
    public void s4() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"13810381202\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I55repayInfo")//sign非法  正确为 1d1cfe35bb3df977223bf934e5a1ef08
    public void f1() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"14587385111\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"6af9ced89dde03633d2d20d79c734a05\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I55repayInfo")//sign为空串
    public void f2() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"14587385111\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I55repayInfo")//没有sign
    public void f3() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"14587385111\"},\"appid\":\"kg1u9xn5gdrtolfq\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I55repayInfo")//appid非法 正确值为 kg1u9xn5gdrtolfq
    public void f4() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"14587385111\"},\"appid\":\"kg1u9xn5gdrtolf1\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I55repayInfo")//appid为空串
    public void f5() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"14587385111\"},\"appid\":\"\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I55repayInfo")//没有appid参数
    public void f6() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"14587385111\"},\"sign\":\"\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I55repayInfo")//businessLine 为空串
    public void f7() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"\",\"mobile\":\"14587385111\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I55repayInfo")//无businessLine 参数
    public void f8() throws IOException {
        String number = "{\"param\":{\"mobile\":\"14587385111\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I55repayInfo")//businessLine非法  正确为haohuan
    public void f9() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan2\",\"mobile\":\"14587385111\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I55repayInfo")// mobile非法
    public void f10() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"14587385111aa\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I55repayInfo")// mobile为空串
    public void f11() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
    @Test(groups = "I55repayInfo")// 没有mobile参数
    public void f12() throws IOException {
        String number = "{\"param\":{\"businessLine\":\"haohuan\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"1d1cfe35bb3df977223bf934e5a1ef08\"}\n";
        String result = IVRUtils.gongyong(url,number);
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }
}
