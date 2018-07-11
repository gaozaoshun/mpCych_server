package com.mtty.igood.util;

import okhttp3.*;
import org.springframework.util.StringUtils;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class OkhttpUtil {

	private static OkHttpClient client = new OkHttpClient();
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	public static final String METHOD_GET = "GET";
	public static final String METHOD_POST = "POST";
	public static final String METHOD_DELETE = "DELETE";
	public static final String METHOD_PUT = "PUT";
	
	// HTTP common
	public static String execute(String url, String method, Map<String, Object> json) throws Exception {
		Request request = null;
		Response response = null;
		if (METHOD_GET.equalsIgnoreCase(method)) {
			if (json!=null && json.size()>0) {
				StringBuffer urlBuffer = new StringBuffer(url+"?");
				for (String key : json.keySet()) {
					urlBuffer.append(key+"="+json.get(key)+"&");
				}
				url = urlBuffer.deleteCharAt(urlBuffer.lastIndexOf("&")).toString();
			}
			request = new Request.Builder().url(url).build();
		} else if (METHOD_POST.equalsIgnoreCase(method)) {
			request = new Request.Builder().url(url).post(parseToRequestBody(json)).build();
		} else if (METHOD_DELETE.equalsIgnoreCase(method)) {
			request = new Request.Builder().url(url).delete(parseToRequestBody(json)).build();
		} else if (METHOD_PUT.equalsIgnoreCase(method)) {
			request = new Request.Builder().url(url).put(parseToRequestBody(json)).build();
		} else {
			throw new Exception("method is error");
		}
		
		try {
			response = client.newCall(request).execute();
		} catch (Exception e) {
			/**
			 * appear the exceptions:
			 * 1. WARNING: A connection to http://nansha.huatugz.com:23000/ was leaked.Did you forget to close a response body?
			 * 2. error:java.net.SocketException: Too many open files
			 * 3. error:java.lang.NullPointerException
			 */
			if (response!=null) {
				response.close();
			}
			throw e;
		}
		if (response.isSuccessful()) {
			ResponseBody body = response.body();
			return body.string();
		} else {
			/**
			 * appear the exceptions:
			 * 1. WARNING: A connection to http://nansha.huatugz.com:23000/ was leaked.Did you forget to close a response body?
			 * 2. error:java.net.SocketException: Too many open files
			 * 3. error:java.lang.NullPointerException
			 */
			response.body().close();
			if (response!=null) {
				response.close();
			}
			throw new IOException("Unexpected code " + response);
		}
	}
	// 解析Map参数成RequestBody
	private static RequestBody parseToRequestBody(Map<String, Object> json){
		FormBody.Builder builder = new FormBody.Builder();
		Iterator<Entry<String, Object>> iterator = json.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, Object> entry = iterator.next();
			String value = StringUtils.isEmpty(entry.getKey())?"":entry.getValue().toString();
			builder.add(entry.getKey(), value);
		}
		RequestBody body = builder.build();
		return body;
	}
}
