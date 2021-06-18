package com.honeybae.project.util;

import java.util.HashMap;
import java.util.Map;

public class ReturnData {
	// return 데이터셋 진행중
	public static Map<String,Object> returnData(Object obj){
		Map<String,Object> data = new HashMap<String,Object>();
		System.out.println(obj.getClass());
		System.out.println(obj.toString());
		if(obj.getClass().isArray()) {
			data.put("list", obj);
		}else {
			data.put("data", obj);
		}
		return data;
	}

}
