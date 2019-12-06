package com.wass.hr.util;

import java.io.IOException;

import com.wass.hr.exception.ServiceException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {

	private static  final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

	public static JsonNode parseJson(String str) {
		ObjectMapper mapper = new ObjectMapper();  
        JsonNode json = null;
		try {
			json = mapper.readTree(str);
		} catch (JsonProcessingException e) {
			logger.error("json process error",e);
		} catch (IOException e) {
			logger.error("json conver io error",e);
		}
        return json;
	}
	
	public static String toJson(Object o) {
		ObjectMapper mapper = new ObjectMapper();
		String json=null;
		try {
			json = mapper.writeValueAsString(o);
		} catch (Exception e) {
			throw new ServiceException("JSON格式转换失败",e);
		}
		return json;
	}
}
