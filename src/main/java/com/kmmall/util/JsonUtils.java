package com.kmmall.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * 
 * @ 解析json字符串类，将json字符串解析为对应的java对象
 *
 *
 */

public class JsonUtils {

	public static String getJson(Object object) throws JsonProcessingException {
		return getJson(object, "yyyy-MM-dd HH:mm:ss");

	}

	public static String getJson(Object object, String dataFormat) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		// 配置时间的解析格式
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dataFormat);
		mapper.setDateFormat(simpleDateFormat);
		return mapper.writeValueAsString(object);

	}

	/**
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException          将json字符串集合解析为java对象集合
	 */
	public static <T> List<T> jsonToObject(ArrayList<String> json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<T> arrayList = new ArrayList<T>();
		for (String str : json) {
			T Value = mapper.readValue(str, clazz);
			arrayList.add(Value);
		}
		return arrayList;

	}

	public static <T> T jsonToObject(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		return mapper.readValue(json, clazz);
	}
}
