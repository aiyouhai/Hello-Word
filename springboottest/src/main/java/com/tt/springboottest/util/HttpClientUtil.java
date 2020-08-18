package com.tt.springboottest.util;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: hyj
 * Date: 2017/8/24
 * Time: 10:24
 * email: hyj18216353675@sina,com
 */
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

/*
 * 利用HttpClient进行post请求的工具类
 */
@SuppressWarnings("deprecation")
public class HttpClientUtil {
	private static final String CONTENT_TYPE_TEXT_JSON = "text/json";

	private static final CloseableHttpClient httpClient = HttpClients.createDefault();

	private static final RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(200000)
			.setConnectionRequestTimeout(100000).setSocketTimeout(100000).build();

	public static String sendPost(String url, Map<String, Object> map) {
		String paramString = JSON.toJSONString(map);
		String result = null;
		try {
			HttpPost httpPost = new HttpPost(url);
			httpPost.setConfig(requestConfig);
			httpPost.addHeader("Content-type", "application/json; charset=utf-8");
			httpPost.setHeader("Accept", "application/json");
			httpPost.setEntity(new StringEntity(paramString, Charset.forName("UTF-8")));
			CloseableHttpResponse response = httpClient.execute(httpPost);
			HttpEntity httpEntity = response.getEntity();
			result = EntityUtils.toString(httpEntity, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String sendPostAndToken(String url, Map<String, Object> map, String token) {
		String paramString = JSON.toJSONString(map);
		String result = null;
		try {
			HttpPost httpPost = new HttpPost(url);
			httpPost.setConfig(requestConfig);
			httpPost.addHeader("Content-type", "application/json; charset=utf-8");
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("token", token);
			httpPost.setEntity(new StringEntity(paramString, Charset.forName("UTF-8")));
			CloseableHttpResponse response = httpClient.execute(httpPost);
			HttpEntity httpEntity = response.getEntity();
			result = EntityUtils.toString(httpEntity, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}