package com.wass.hr.util;

import javax.servlet.http.HttpServletRequest;

import com.wass.hr.cache.EHCacheUtil;
import com.wass.hr.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;


/**
 * 会话工具类
 * @author david
 *
 */
public class SessionUtil {
	/**登录会话超时*/
	public static final String user_login_timeout = "user_login_timeout";
	/**登录会话*/
	public static final String cookie_login_session = "clouddisk_login_session";
	/**
	 * 获取用户会话 无会话 视为登录超时
	 * @return
	 */
	public static LoginContext getSession() {
		String token = getToken();
		LoginContext context = (LoginContext)EHCacheUtil.get("sessionCache", token);
		if(context == null) {
			throw new ServiceException(user_login_timeout);
		}
		return context;
	}
	
	public static LoginContext getSession(String token) {
		LoginContext context = (LoginContext)EHCacheUtil.get("sessionCache", token);
		if(context == null) {
			throw new ServiceException(user_login_timeout);
		}
		return context;
	}
	
	/**
	 * 获取用户会话 无会话 返回null
	 * @return
	 */
	public static LoginContext getSessionNoRequre() {
		String token = getToken();
		LoginContext context = (LoginContext)EHCacheUtil.get("sessionCache", token);
		return context;
	}
	
	public static void removeSession(String token) {
		if(StringUtils.isNotBlank(token)) {
			EHCacheUtil.remove("sessionCache", token);
		}
	}
	
	/**
	 * 获取TOKEN
	 * @return
	 */
	public static String getToken() {
		HttpServletRequest request = RequestUtil.getRequest();
		String token = (String)request.getAttribute("token");
		if(StringUtils.isBlank(token)){
			token = request.getParameter("token");
		}
		if(StringUtils.isBlank(token)) {
			token = CookieUtil.getCookie(request, cookie_login_session);
		}
		return StringUtils.trim(token);
	}
	
	/**
	 * 设置会话
	 * @param token
	 * @param context
	 */
	public static void setSession(String token,LoginContext context) {
		EHCacheUtil.put("sessionCache",token,context);  
	}
	
	/**
	 * 获取登录错误次数
	 * @param account
	 * @return
	 */
	public static int getLoginErrorNum(String account) {
		int errorCnt = 0;
		Object o = EHCacheUtil.get("sessionCache", account);
		if(o == null) {
			return 0;
		} else {
			errorCnt = (int)o;
		}
		
		return errorCnt;
	}
	
	/**
	 * 添加登录错误次数
	 * @param account
	 */
	public static void addLoginErrorNum(String account) {
		Object o = EHCacheUtil.get("sessionCache", account);
		if(o==null) {
			EHCacheUtil.put("sessionCache", account,1);
		} else {
			int cnt = (int)o;
			EHCacheUtil.put("sessionCache", account,cnt+1);
		}
	}
	/**
	 * 清空登录错误次数
	 * @param account
	 */
	public static void cleanLoginErrorNum(String account) {
		EHCacheUtil.remove("sessionCache", account);
	}
}
