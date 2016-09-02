package com.ll.httpclient.util;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientUtil {

	public static String get(String url) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse response = httpclient.execute(httpget);
		try {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream in = entity.getContent();
				byte[] bs = IOUtils.toByteArray(in);
				return new String(bs,"utf-8");
			}
		} finally {
			response.close();
		}
		return null;
	}
	
	public static InputStream post(String url,HttpEntity httpEntity) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		if(httpEntity!=null){
			httpPost.setEntity(httpEntity);
		}
		CloseableHttpResponse response = httpclient.execute(httpPost);
		try {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				return entity.getContent();
			}
		} finally {
			response.close();
		}
		return null;
	}
}
