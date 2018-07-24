package com.company.ship.util;


import java.io.IOException;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.FormBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpClient {
	
	
	private static OkHttpClient client = new OkHttpClient();
	
	/**
	 * get提交
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String doGet(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();
	    Response response = client.newCall(request).execute();
	    if (response.isSuccessful()) {
	    	 return response.body().string();
	    } else {
	    	 throw new IOException("Unexpected code " + response);
	    }
	}
	
	/**
	 * get提交携带参数
	 * @param url
	 * @param map
	 * @return
	 * @throws IOException
	 */
	public static String doGet(String url,Map<String,String> map) throws IOException {
		if(map!=null) {
			StringBuilder sb = new StringBuilder();
			sb.append(url+"?");
			for (String key : map.keySet()) {
				sb.append(key + "=" + map.get(key)+"&");
			}
			url = sb.toString();
		}
		Request request = new Request.Builder().url(url).build();
	    Response response = client.newCall(request).execute();
	    if (response.isSuccessful()) {
	    	 return response.body().string();
	    } else {
	    	 throw new IOException("Unexpected code " + response);
	    }
	}
	
	
	/**
	 * post 请求提交表单
	 * @param url
	 * @param map
	 * @return
	 * @throws IOException
	 */
	public static String doFromPost(String url,Map<String,String> map) throws IOException {
		Builder builder = new FormBody.Builder();
		if(map!=null) {
			for (String key : map.keySet()) {
				builder.add(key, map.get(key));
			}
		}
		RequestBody body = builder.build();
		Request request = new Request.Builder().url(url).post(body).build();  
		Response response = client.newCall(request).execute();  
	    if (response.isSuccessful()) {
	    	 return response.body().string();
	    } else {
	    	 throw new IOException("Unexpected code " + response);
	    }
	}
	
	
	
	

}
