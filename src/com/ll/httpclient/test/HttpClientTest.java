package com.ll.httpclient.test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.junit.Test;

import com.ll.httpclient.util.HttpClientUtil;

public class HttpClientTest {

	@Test
	public void testPost(){
		try {
			Map<String,Object> p = new HashMap<String,Object>();
			p.put("iu_code", "10000000");
			p.put("status", "活动");
			p.put("iu_fullname", "中节能");
			p.put("iu_unit_level", "1");
			p.put("u_time", "2014-09-30 16:03:58.0");
			p.put("sortList", "10000211:0;10001550:1;10004006:2;10001432:3;10000933:4;10000999:5;10003704:6;10001009:7;10003352:8;10001181:9;10001198:10;10000071:11;10000001:12;10001606:13;10001678:14;10001731:15;10003456:16;10001937:17;10002599:18;10003109:19;10000224:20;10003449:21;10002613:22;10003662:23;10002748:24;10002754:25;10003516:26;10003526:27;10000587:28;10002606:29;10003243:30;10003528:31;10003571:32;10002951:33;10003660:34;10003840:35;10000876:36;10003724:37");
			p.put("disType", "1");
			
			String content = JSONObject.fromObject(p).toString();
			System.out.println(content);
			HttpEntity httpEntity = new StringEntity(content, "UTF-8");
			InputStream in = HttpClientUtil.post("http://localhost:8080/Card/webservice/org?wsdl",httpEntity);
			IOUtils.copy(in, System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testGet(){
		try {
			
			String content = HttpClientUtil.get("http://webftcn.hermes.hexun.com/shf/kline?code=SHFE2AG1612&start=20160902210000&number=-1000&type=5");
			System.out.println(content);
			JSONObject jsonObject = JSONObject.fromObject(content.substring(1, content.length()-2));
			Object o =  JSONObject.toBean(jsonObject);
			System.out.println(o);
//			IOUtils.copy(in, System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
