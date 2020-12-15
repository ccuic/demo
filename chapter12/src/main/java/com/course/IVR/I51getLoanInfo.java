package com.course.IVR;

import com.alibaba.fastjson.JSONObject;
import com.course.config.TestConfig;
import com.course.model.IVR_API;
import com.course.utils.ConfigFile;
import com.course.utils.HttpUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
//5.1 放款银行卡及金额查询接口
public class I51getLoanInfo {

    @BeforeTest(groups = "loginTrue",description = "测试准备工作,获取Authorization对象")
    public void beforeTest(){
        TestConfig.strIVR_URL = ConfigFile.getProp(IVR_API.IVR_URL);
    }
    //
    @Test
    public void getLoanInfo() throws IOException {
        String jiekou_url="/info/ivr/getLoanInfo";
        String url= TestConfig.strIVR_URL+jiekou_url;
        String number = "{\"param\":{\"businessLine\":\"haohuan\",\"mobile\":\"13810381202\"},\"appid\":\"kg1u9xn5gdrtolfq\",\"sign\":\"6af9ced89dde03633d2d20d79c734a04\"}\n";
        String result = IVRUtils.gongyong(url,number);
        System.out.println("================ "+result);
        //处理结果，就是判断返回结果是否符合预期
        if(result.contains("success"))
        {Assert.assertEquals(1,1);}
        else {Assert.assertEquals(0,1);}
    }

}
