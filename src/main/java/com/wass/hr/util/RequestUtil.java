package com.wass.hr.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 请求工具类
 * @ClassName: RequestUtil
 * @author wass
 *
 */
public class RequestUtil {
	
	public static String getString(HttpServletRequest request, String key) {
		return getString(request, key, "");
	}
	public static String getString(HttpServletRequest request, String key,String defaultValue) {
		String value = defaultValue;
		if(request!=null) {
			value = request.getParameter(key);
		}
		return value;
	}
	
	public static Boolean getBoolean(HttpServletRequest request, String key) {
		return getBoolean(request, key, false);
	}
	
	public static Boolean getBoolean(HttpServletRequest request, String key,Boolean defaultValue) {
		Boolean value = defaultValue;
		if(request!=null) {
			String v = request.getParameter(key);
			value = Boolean.valueOf(v);
		}
		return value;
	}
	
	public static Integer getInteger(HttpServletRequest request, String key,
			Integer defaultValue) {
		String str = request.getParameter(key);
		if (StringUtils.isEmpty(str))
			return defaultValue;
		return Integer.parseInt(str.trim());
	}
	
	public static Integer getInteger(HttpServletRequest request, String key) {
		return getInteger(request, key, null);
	}
	
	public static long getLong(HttpServletRequest request, String key,
			long defaultValue) {
		String str = request.getParameter(key);
		if (StringUtils.isEmpty(str))
			return defaultValue;
		return Long.parseLong(str.trim());
	}
	
	public static long getLong(HttpServletRequest request, String key) {
		return getLong(request, key, 0L);
	}
	
	public static List<Long> getLongListByStr(HttpServletRequest request,String key) {
		String str = request.getParameter(key);
		if (StringUtils.isEmpty(str))
			return null;
		String[] aryId = str.split(",");
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < aryId.length; i++) {
			String strValue = aryId[i];
			try {
				Long value = Long.parseLong(strValue);
				list.add(value);
			} catch (NumberFormatException e) {
			}
		}
		return list;
	}
	
	/**
	 * 获取请求报文
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		return request;
	}
	
	/**
	 * 获取根URL
	 * @return
	 */
	public static String getBaseURL() {
		HttpServletRequest request = getRequest();
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		String nurl = url.replaceAll(uri, "");
		return nurl;
	}
	
	/**
	 * 获取IP
	 * @Title: getIpAddr 
	 * @param @param request
	 * @param @return 
	 * @return String 
	 * @throws
	 */
	public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if("0:0:0:0:0:0:0:1".equals(ip)) {
        	ip = "127.0.0.1";
        }
        return ip;
    }
	/**
	 * 获取当前登录客户端是否是 手机端  如果是手机端  则返回true  不是 则返回false
	 * @param request
	 * @return
	 */
	public static boolean getClient(HttpServletRequest request){
		String path=request.getHeader("User-Agent").toLowerCase();
		if(path.contains("android") || path.contains("iphone") || path.contains("ios")){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 判断是否Ajax请求
	 * @param request
	 * @return
	 */
	public static boolean isAjax(HttpServletRequest request) {
		String requestType = request.getHeader("X-Requested-With");
		return "XMLHttpRequest".equalsIgnoreCase(requestType);
	}
}
