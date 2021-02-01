package com.daihou.utils;

import okhttp3.*;
import org.apache.http.Header;

import java.io.IOException;

public class OKClientUtil {
	public static String httpPost(String url) throws IOException {
		OkHttpClient httpClient = new OkHttpClient();
		RequestBody requestBody = new FormBody.Builder()
				.add("code", "111111")
				.build();
		Request request = new Request.Builder()
				.url(url)
				.post(requestBody)
				.build();
		Response response = httpClient.newCall(request).execute();
		Headers headers=response.headers();
		return response.body().string();
	}
}