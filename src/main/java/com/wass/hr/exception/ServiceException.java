package com.wass.hr.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统异常
 * @author wass
 *
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	/**异常代码*/
	private String code;
	
	private Map<String, Object> data = new HashMap<String, Object>();
	
	public ServiceException(String code){
		super(code);
		this.code = code;
	}
	
	public ServiceException(String code,String message){
		super(message);
		this.code = code;
	}
	
	public ServiceException(Throwable cause)
	{
		super(cause);
		this.code = "system_error";
	}
	
	public ServiceException(String message,Throwable cause)
	{
		super(message,cause);
		this.code = "system_error";
	}
	
	public void addDateItem(String key,Object value) {
		data.put(key, value);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
