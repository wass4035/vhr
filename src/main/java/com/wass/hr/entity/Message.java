package com.wass.hr.entity;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


/**
 * 消息类
 * 
 */
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	/**类型*/
	public enum Type {
		success,
		warn,
		error
	}

	/** 类型 */
	private Type type;
	/**业务代码*/
	private String code;
	/** 内容 */
	private String content;
	private Map<String, Object> body = new HashMap<>();

	/**
	 * 初始化一个新创建的 Message 对象，使其表示一个空消息。
	 */
	public Message() {
		//ingore
	}

	public Message(Type type, String code, HashMap<String, Object> body) {
		this.type = type;
		setCode(code);
		this.body = body;
	}

	/**
	 * 初始化一个新创建的 Message 对象
	 * 
	 * @param type
	 *            类型
	 * @param code
	 *            代码
	 */
	public Message(Type type, String code) {
		this.type = type;
		setCode(code);
	}

	/**
	 * @param type
	 *            类型
	 * @param code
	 *            代码
	 * @param args
	 *            参数
	 */
	public Message(Type type, String code, Object... args) {
		this.type = type;
		setCode(code,args);
	}

	/**
	 * 返回成功消息
	 * 
	 * @param code
	 *            代码
	 * @param args
	 *            参数
	 * @return 成功消息
	 */
	public static Message success(String code, Object... args) {
		return new Message(Type.success, code, args);
	}

	/**
	 * 返回警告消息
	 * 
	 * @param code
	 *            代码
	 * @param args
	 *            参数
	 * @return 警告消息
	 */
	public static Message warn(String code, Object... args) {
		return new Message(Type.warn, code, args);
	}

	/**
	 * 返回错误消息
	 * 
	 * @param code
	 *            代码
	 * @param args
	 *            参数
	 * @return 错误消息
	 */
	public static Message error(String code, Object... args) {
		return new Message(Type.error, code, args);
	}

	/**
	 * 获取类型
	 * 
	 * @return 类型
	 */
	public Type getType() {
		return type;
	}

	/**
	 * 设置类型
	 * 
	 * @param type
	 *            类型
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * 获取内容
	 * 
	 * @return 内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置内容
	 * 
	 * @param content
	 *            内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	public void putBody(String key, Object value) {
		this.body.put(key, value);
	}

	public Map<String, Object> getBody() {
		return body;
	}

	public void setBody(Map<String, Object> body) {
		this.body = body;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code,Object... args) {
		this.code = code;
		this.content = content;
	}
	
	public String toJson() {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(this);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

}