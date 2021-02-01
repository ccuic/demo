package com.daihou.config;

import com.daihou.model.DHInterfaceAuth;
import com.daihou.model.DHInterfaceName;
import com.daihou.utils.DHConfigFile;
import com.daihou.utils.DHHttpUtil;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TheAuth {
	private static Map<String, String> headers;
	private static String result;
	//获取Authorization
	public static String getAuth() throws IOException {
		//获取
		headers = new HashMap<>();
		String urlAuth=DHConfigFile.getUrl(DHInterfaceAuth.AUTH);
		String strBody = "{\"code\":\"111111\"}";
		headers.put("X-UserName", "admin");
		result = DHHttpUtil.post_getAuth(urlAuth,strBody,headers);
		headers.clear();
		//String result = OKClientUtil.httpPost(url);
		return result;
	}
}