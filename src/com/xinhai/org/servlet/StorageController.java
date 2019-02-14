package com.xinhai.org.servlet;

import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import com.alibaba.fastjson.JSONObject;



/**
* @author Tony
* @version 创建时间：2018年5月28日 上午11:09:35
* @ClassName 类名称
* @Description 类描述
*/
public class StorageController {

	public static void main(String[] args) {
		String timestamp = Integer.toString((int)(System.currentTimeMillis() / 1000));	
		String url="http://msg.umeng.com"+"/api/send";
		 String expire_time="2018-5-31 15:32:00";
		String postBody="{\"appkey\":\"5af66f93f29d983848000205\""
	
		+",\"timestamp\":\""+timestamp+"\""
				+",\"type\":\"unicast\""
				+",\"production_mode\":\"false\""
		+",\"device_tokens\":\"Ap1z1SXkuLxBCYMapVNAczSz3jgN24E_-pcBK0b1s1qY\""
				+",\"payload\":{"+"\"display_type\":\"message\","
				+"\"body\":{"+"\"custom\":{"+"\"type\":2"+",\"text\":\"dsdasd\""+"}"+"}}"
				+",\"policy\":{"+"\"expire_time\":\""+expire_time+"\""+"}"+",\"description\":\"test-Android\""
				+"}";
		JSONObject json = JSONObject.parseObject(postBody); 
		System.out.println(postBody);
		String AppMasterSecret="2yfovec0sdqllwipzwv82y5o74udhdh9";
							
		String a="POST" + url + postBody +AppMasterSecret;
		String sign = DigestUtils.md5Hex(a);
		System.out.println(sign);
		System.out.println(timestamp);
		String unicast=null;
		unicast=json.getString("type");
		System.out.println(unicast);
	}
	
}
