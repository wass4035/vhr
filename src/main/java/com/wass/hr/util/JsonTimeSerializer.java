package com.wass.hr.util;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * Json Time 时间序列化
 * @author david
 *
 */
public class JsonTimeSerializer extends JsonSerializer<Date> {
	@Override
	public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
	     jsonGenerator.writeString(DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss"));  
	}
}