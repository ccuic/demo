package com.daihou.BCJ.pingfenka;

import com.daihou.config.TheAuth;
import com.daihou.model.ceres.In_Pingfenka;
import com.daihou.utils.DHConfigFile;
import com.daihou.utils.DHHttpUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class kuaizhao {
	private String url;
	Map<String, String> headers;
	@BeforeTest(groups = "loginTrue",description = "测试准备工作,获取Authorization对象")
	public void beforeTest() throws IOException {
		url=DHConfigFile.getUrl(In_Pingfenka.KUAIZHAO.toString());
		headers=new HashMap<>();
		//设置请求头中的Authorization
		headers.put("Authorization", TheAuth.getAuth());
	}

	@Test(groups = "pingfen")//合法数据，验证可用额度
	public void s1() throws IOException {
		String strBody = "{\"logId\":177}";
		String result = DHHttpUtil.post_with_String(url,strBody,headers).toJSONString();
		System.out.println("================ "+result);
		if(result.contains("\"message\":\"操作成功\",\"status\":\"0\""))
			{
				Assert.assertEquals(1,1);
			}
		else
			{
				Assert.assertEquals(0,1);
			}
	}
}